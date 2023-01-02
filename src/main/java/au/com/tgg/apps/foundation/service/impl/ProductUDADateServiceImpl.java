package au.com.tgg.apps.foundation.service.impl;

import au.com.tgg.apps.foundation.dto.ResponseDTO;
import au.com.tgg.apps.foundation.model.json.ProductUdaDate;
import au.com.tgg.apps.foundation.model.tggcsodr.ProductEntity;
import au.com.tgg.apps.foundation.model.tggcsodr.SupplierAccountProductEntity;
import au.com.tgg.apps.foundation.repository.MerchUdaRepository;
import au.com.tgg.apps.foundation.repository.ProductRepository;
import au.com.tgg.apps.foundation.repository.SupplierAccountProductRepository;
import au.com.tgg.apps.foundation.service.CrudService;
import au.com.tgg.apps.foundation.util.FoundationJatClient;
import au.com.tgg.apps.foundation.util.FoundationUtil;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

@Service
public class ProductUDADateServiceImpl implements CrudService<ProductUdaDate> {
    private static final Logger LOGGER = LogManager.getLogger(ProductUDADateServiceImpl.class);
    private final FoundationJatClient foundationJatClient;
    private final ProductRepository productRepository;
    private final SupplierAccountProductRepository supplierAccountProductRepository;
    private final MerchUdaRepository merchUdaRepository;


    @Autowired
    public ProductUDADateServiceImpl(FoundationJatClient foundationJatClient, ProductRepository productRepository, SupplierAccountProductRepository supplierAccountProductRepository, MerchUdaRepository merchUdaRepository) {
        this.foundationJatClient = foundationJatClient;
        this.productRepository = productRepository;
        this.supplierAccountProductRepository = supplierAccountProductRepository;
        this.merchUdaRepository = merchUdaRepository;
    }


    @Override
    public ResponseDTO insert(ProductUdaDate productUdaDate) throws Exception {
        return update(productUdaDate);
    }

    @Override
    public ResponseDTO update(ProductUdaDate productUdaDate) throws Exception {

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
        java.util.Date date = new java.util.Date();
        try {
            date = sdf.parse(productUdaDate.getUdaDate());
        } catch (ParseException e) {
            e.printStackTrace();
        }

        if (productUdaDate.udaId != null && merchUdaRepository.findMerchUdaBySourceUdaId(productUdaDate.udaId).getUdaCode().equalsIgnoreCase("PRE-ORDER_DATE")) {
            List<ProductEntity> productEntityList = productRepository.findProductEntityByProdNbrAndInvName(productUdaDate.getProdNbr(), FoundationUtil.INV_NAME);
            if (!productEntityList.isEmpty()) {
                ProductEntity productEntity = productEntityList.get(0);
                productEntity.setEmbargoDate(new java.sql.Date(date.getTime()));
                productRepository.save(productEntity);
            }
            List<SupplierAccountProductEntity> supplierAccountProductEntityList = supplierAccountProductRepository.findSupplierAccountProductEntitiesByProdNbrAndInvName(productUdaDate.getProdNbr(), FoundationUtil.INV_NAME);
            if (!supplierAccountProductEntityList.isEmpty()) {
                for (SupplierAccountProductEntity supplierAccountProductEntity: supplierAccountProductEntityList) {
                    supplierAccountProductEntity.setEmbargoDate(new java.sql.Date(date.getTime()));
                }
                supplierAccountProductRepository.saveAll(supplierAccountProductEntityList);
            }
            foundationJatClient.refreshCache("supplierAccountProduct",
                    productUdaDate.getProdNbr(),
                    String.format("supplier-account-product/prod-nbr/%s", productUdaDate.getProdNbr())).subscribe();
            foundationJatClient.refreshCache("product",
                    productUdaDate.getProdNbr(),
                    String.format("product/prod-nbr/%s", productUdaDate.getProdNbr())).subscribe();
            if (productEntityList.isEmpty() && supplierAccountProductEntityList.isEmpty()) {
                return new ResponseDTO("Insert/Update ProductUdaDate - Exception", HttpStatus.INTERNAL_SERVER_ERROR, productUdaDate);
            }
            return new ResponseDTO("ProductUdaDate was Inserted/Updated Successfully", HttpStatus.OK, null);
        }
        return new ResponseDTO("Exception encountered could not find Product to add ProductUdaDate " + productUdaDate.getProdNbr(), HttpStatus.INTERNAL_SERVER_ERROR, productUdaDate);
    }

    @Override
    public ResponseDTO delete(ProductUdaDate productUdaDate) throws Exception {
        if (productUdaDate.udaId != null && merchUdaRepository.findMerchUdaBySourceUdaId(productUdaDate.udaId).getUdaCode().equalsIgnoreCase("EMBARGO_DATE")) {
            List<ProductEntity> productEntityList = productRepository.findProductEntityByProdNbrAndInvName(productUdaDate.getProdNbr(), FoundationUtil.INV_NAME);
            if (!productEntityList.isEmpty()) {
                ProductEntity productEntity = productEntityList.get(0);
                productEntity.setEmbargoDate(null);
                productRepository.save(productEntity);
            }
            List<SupplierAccountProductEntity> supplierAccountProductEntityList = supplierAccountProductRepository.findSupplierAccountProductEntitiesByProdNbrAndInvName(productUdaDate.getProdNbr(), FoundationUtil.INV_NAME);
            if (!supplierAccountProductEntityList.isEmpty()) {
                for (SupplierAccountProductEntity supplierAccountProductEntity: supplierAccountProductEntityList) {
                    supplierAccountProductEntity.setEmbargoDate(null);
                }
                supplierAccountProductRepository.saveAll(supplierAccountProductEntityList);
            }
            foundationJatClient.refreshCache("supplierAccountProduct",
                    productUdaDate.getProdNbr(),
                    String.format("supplier-account-product/prod-nbr/%s", productUdaDate.getProdNbr())).subscribe();
            foundationJatClient.refreshCache("product",
                    productUdaDate.getProdNbr(),
                    String.format("product/prod-nbr/%s", productUdaDate.getProdNbr())).subscribe();
            return new ResponseDTO("ProductUdaDate was Deleted Successfully", HttpStatus.OK, null);
        }
        return new ResponseDTO("Exception encountered Deleting: ProductUdaDate", HttpStatus.INTERNAL_SERVER_ERROR, productUdaDate);
    }
}
