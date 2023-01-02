package au.com.tgg.apps.foundation.service.impl;


import au.com.tgg.apps.foundation.dto.ResponseDTO;
import au.com.tgg.apps.foundation.model.json.ProductVolumetrics;
import au.com.tgg.apps.foundation.model.tggcsodr.ProductEntity;
import au.com.tgg.apps.foundation.model.tggcsodr.ProductVolumetricsEntity;
import au.com.tgg.apps.foundation.model.tggcsodr.SupplierAccountEntity;
import au.com.tgg.apps.foundation.model.tggcsodr.SupplierAccountProductEntity;
import au.com.tgg.apps.foundation.repository.ProductRepository;
import au.com.tgg.apps.foundation.repository.ProductVolumetricsRepository;
import au.com.tgg.apps.foundation.repository.SupplierAccountProductRepository;
import au.com.tgg.apps.foundation.repository.SupplierAccountRepository;
import au.com.tgg.apps.foundation.service.CrudService;
import au.com.tgg.apps.foundation.util.CopyBeanUtils;
import au.com.tgg.apps.foundation.util.FoundationJatClient;
import au.com.tgg.apps.foundation.util.FoundationUtil;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.decimal4j.util.DoubleRounder;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductVolumetricsCrudServiceImpl implements CrudService<ProductVolumetrics> {

    private final Logger logger = LogManager.getLogger(ProductVolumetricsCrudServiceImpl.class);

    private final ProductRepository productRepository;
    private final SupplierAccountRepository supplierAccountRepository;
    private final SupplierAccountProductRepository supplierAccountProductRepository;
    private final ProductVolumetricsRepository productVolumetricsRepository;
    private final FoundationJatClient foundationJatClient;

    @Autowired
    public ProductVolumetricsCrudServiceImpl(ProductRepository productRepository, SupplierAccountRepository supplierAccountRepository, SupplierAccountProductRepository supplierAccountProductRepository, ProductVolumetricsRepository productVolumetricsRepository, FoundationJatClient foundationJatClient) {
        this.productRepository = productRepository;
        this.supplierAccountRepository = supplierAccountRepository;
        this.supplierAccountProductRepository = supplierAccountProductRepository;
        this.productVolumetricsRepository = productVolumetricsRepository;
        this.foundationJatClient = foundationJatClient;
    }

    @Override
    public ResponseDTO insert(ProductVolumetrics productVolumetrics) throws Exception {
        return update(productVolumetrics);
    }

    @Override
    public ResponseDTO update(ProductVolumetrics productVolumetrics) throws Exception {
        List<ProductVolumetricsEntity> productVolumeMetricsEntities;
        ProductVolumetricsEntity productVolumetricsEntity;
        String account_number = productVolumetrics.getSupplier_account().substring(0, 5);

        //check product exists
        ProductEntity productEntity;
        List<ProductEntity> productEntities = productRepository.
                findProductEntityByProdNbrAndInvName(productVolumetrics.getProdNbr(),
                        FoundationUtil.INV_NAME);
        if (productEntities != null && productEntities.size() != 0) {
            productEntity = productEntities.get(0);
        } else {
            return new ResponseDTO("Exception encountered: Product does not exist for Volumetric: " + productVolumetrics.getProdNbr(), HttpStatus.I_AM_A_TEAPOT, productVolumetrics);
        }

        // check insert/update
        productVolumeMetricsEntities = productVolumetricsRepository.findProductVolumetricsEntityByProdNbr(productVolumetrics.getProdNbr());
        if (productVolumeMetricsEntities == null || productVolumeMetricsEntities.size() == 0) {
            productVolumetricsEntity = new ProductVolumetricsEntity();
            productVolumetricsEntity.setCreateDate(FoundationUtil.localDateTime());
            productVolumetricsEntity.setInvName(FoundationUtil.INV_NAME);
            productVolumetricsEntity.setProductId(productEntity.getProductId());
        } else {
            productVolumetricsEntity = productVolumeMetricsEntities.get(0);
        }

        CopyBeanUtils.myCopyProperties(productVolumetrics, productVolumetricsEntity);
        productVolumetricsEntity.setLastModifiedDate(FoundationUtil.localDateTime());
        if (productVolumetrics.getLength() != null && productVolumetrics.getHeight() != null && productVolumetrics.getWidth() != null) {
            productVolumetricsEntity.setVmWeight(DoubleRounder.round((productVolumetrics.getLength() * productVolumetrics.getWidth() * productVolumetrics.getHeight() * 0.00025), 4));
        }
        SupplierAccountEntity supplierAccountEntity = supplierAccountRepository.findSupplierAccountEntityByAccountNumber(account_number).get(0);
        SupplierAccountProductEntity supplierAccountProductEntity = supplierAccountProductRepository
                .findSupplierAccountProductEntitiesByProdNbrAndInvNameAndSupplierAccountId(productVolumetrics.getProdNbr(), FoundationUtil.INV_NAME, supplierAccountEntity.getSupplierAccountId());
        if ("ItemCre".equalsIgnoreCase(productVolumetrics.getSource()) || (productEntity != null && supplierAccountProductEntity != null)) {
            productVolumetricsRepository.save(productVolumetricsEntity);
            foundationJatClient.refreshCache("productVolumetrics",
                    productVolumetricsEntity.getProdNbr(),
                    String.format("product-volumetrics/prod-nbr/%s", productVolumetricsEntity.getProdNbr())).subscribe();
            return new ResponseDTO("ProductVolumetrics was Inserted/Updated Successfully", HttpStatus.OK, null);
        } else {
            return new ResponseDTO("Exception encountered Inserting/Updating: ProductVolumetrics", HttpStatus.INTERNAL_SERVER_ERROR, productVolumetrics);
        }
    }

    @Override
    public ResponseDTO delete(ProductVolumetrics productVolumetrics) throws Exception {
        ProductVolumetricsEntity productVolumetricsEntity = new ProductVolumetricsEntity();
        productVolumetricsEntity.setCreateDate(FoundationUtil.localDateTime());
        productVolumetricsEntity.setLastModifiedDate(FoundationUtil.localDateTime());
        BeanUtils.copyProperties(productVolumetrics, productVolumetricsEntity);
        String account_number = productVolumetrics.getSupplier_account().substring(0, 5);
        SupplierAccountEntity supplierAccountEntity = supplierAccountRepository.findSupplierAccountEntityByAccountNumber(account_number).get(0);
        SupplierAccountProductEntity supplierAccountProductEntity = supplierAccountProductRepository.findSupplierAccountProductEntitiesByProdNbrAndInvNameAndSupplierAccountId(productVolumetrics.getProdNbr(), FoundationUtil.INV_NAME, supplierAccountEntity.getSupplierAccountId());
        if (productVolumetrics.getProdNbr() != null && supplierAccountProductEntity.getPrimarySuppInd().equalsIgnoreCase("Y")) {
            productVolumetricsRepository.deleteByProdNbr(productVolumetricsEntity.getProdNbr());
            foundationJatClient.evictCache("productVolumetrics", productVolumetricsEntity.getProdNbr()).subscribe();
            return new ResponseDTO("ProductVolumetrics was Deleted Successfully", HttpStatus.OK, null);
        } else {
            return new ResponseDTO("Exception encountered Deleting: ProductVolumetrics", HttpStatus.INTERNAL_SERVER_ERROR, productVolumetrics);
        }
    }
}
