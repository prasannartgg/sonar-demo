package au.com.tgg.apps.foundation.service.impl;


import au.com.tgg.apps.foundation.dto.ResponseDTO;
import au.com.tgg.apps.foundation.model.json.SupplierAccountProduct;
import au.com.tgg.apps.foundation.model.tggcsodr.ProductEntity;
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
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SupplierAccountProductCrudServiceImpl implements CrudService<SupplierAccountProduct> {

    private final SupplierAccountProductRepository supplierAccountProductRepository;
    private final ProductRepository productRepository;
    private final SupplierAccountRepository supplierAccountRepository;
    private final ProductVolumetricsRepository productVolumetricsRepository;
    private final FoundationJatClient foundationJatClient;

    public SupplierAccountProductCrudServiceImpl(SupplierAccountProductRepository supplierAccountProductRepository, ProductRepository productRepository, SupplierAccountRepository supplierAccountRepository, ProductVolumetricsRepository productVolumetricsRepository, FoundationJatClient foundationJatClient) {
        this.supplierAccountProductRepository = supplierAccountProductRepository;
        this.productRepository = productRepository;
        this.supplierAccountRepository = supplierAccountRepository;
        this.productVolumetricsRepository = productVolumetricsRepository;
        this.foundationJatClient = foundationJatClient;
    }

    @Override
    public ResponseDTO insert(SupplierAccountProduct supplierAccountProduct) throws Exception {
        return update(supplierAccountProduct);
    }

    @Override
    public ResponseDTO update(SupplierAccountProduct supplierAccountProduct) throws Exception {
        if (supplierAccountProduct.getSupplier_account_xx() != null && supplierAccountProduct.getSupplier_account_xx().length() >= 5) {
            String accountNumber = supplierAccountProduct.getSupplier_account_xx().substring(0, supplierAccountProduct.getSupplier_account_xx().length()-2);
            SupplierAccountEntity supplierAccountEntity = supplierAccountRepository.findSupplierAccountEntityByAccountNumber(accountNumber).get(0);
            SupplierAccountProductEntity supplierAccountProductEntity = supplierAccountProductRepository.findSupplierAccountProductEntitiesByProdNbrAndInvNameAndSupplierAccountId(supplierAccountProduct.getProdNbr(), FoundationUtil.INV_NAME, supplierAccountEntity.getSupplierAccountId());
            List<ProductEntity> productEntityList = productRepository.findProductEntityByProdNbrAndInvName(supplierAccountProduct.getProdNbr(), FoundationUtil.INV_NAME);
            if (productEntityList.isEmpty() && !supplierAccountEntity.getCountryCode().isEmpty() && !supplierAccountEntity.getCountryCode().equalsIgnoreCase("NZ")) {
                productEntityList = productRepository.findProductEntityByProdNbrAndInvName(supplierAccountProduct.getProdNbr(), "NZGINV");
                if (!productEntityList.isEmpty() ) {
                    ProductEntity productEntity = productEntityList.get(0);
                    productEntity.setProductId(productRepository.getProductIdNexSeq());
                    productEntity.setInvName(FoundationUtil.INV_NAME);
                    if (!supplierAccountProduct.getCostExPrice().isEmpty()) {
                        productEntity.setCostExPrice(Double.valueOf(supplierAccountProduct.getCostExPrice()));
                    }
                    productRepository.save(productEntity);
                    productEntityList = productRepository.findProductEntityByProdNbrAndInvName(supplierAccountProduct.getProdNbr(), FoundationUtil.INV_NAME);
                } else {
                    return new ResponseDTO("Exception encountered Inserting/Updating: SupplierAccountProduct - No Product exist for " + supplierAccountProduct.getProdNbr(), HttpStatus.I_AM_A_TEAPOT, supplierAccountProduct);
                }
            }
            if (supplierAccountProductEntity == null && productEntityList != null && productEntityList.size() != 0) {
                supplierAccountProductEntity = new SupplierAccountProductEntity();
                supplierAccountProductEntity.setCreatedDate(FoundationUtil.localDateTime());
                supplierAccountProductEntity.setCreatedUser(FoundationUtil.USER);
            }
            CopyBeanUtils.myCopyProperties(productEntityList.get(0), supplierAccountProductEntity);
            supplierAccountProductEntity.setLastUpdateUser(FoundationUtil.USER);
            supplierAccountProductEntity.setLastUpdateDate(FoundationUtil.localDateTime());
            supplierAccountProductEntity.setSupplierAccountId(supplierAccountEntity.getSupplierAccountId());
            if (supplierAccountProduct.getSupProdNbr() != null) {
                supplierAccountProductEntity.setConsumerProdNbr(supplierAccountProduct.getSupProdNbr());
                supplierAccountProductEntity.setSupProdNbr(supplierAccountProduct.getSupProdNbr());
            }
            if (supplierAccountProduct.getCostExPrice() != null) {
                supplierAccountProductEntity.setCostExPrice(new Double(supplierAccountProduct.getCostExPrice()));
            }
            if (supplierAccountProductEntity.getSupplierAccountProductId() == null && supplierAccountProduct.getPrimarySuppInd() == null && supplierAccountProductEntity.getPrimarySuppInd() == null) {
                supplierAccountProductEntity.setPrimarySuppInd("Y");
            }
            supplierAccountProductRepository.save(supplierAccountProductEntity);
//            if (supplierAccountProductEntity.getPrimarySuppInd().equalsIgnoreCase("Y") && supplierAccountProductEntity.getSupplierAccountId() != null) {
//                productRepository.updateProductSupIdByProductNbr(supplierAccountProductEntity.getSupplierAccountId(), supplierAccountProductEntity.getProdNbr());
//            }
            foundationJatClient.refreshCache("supplierAccountProduct",
                    supplierAccountProductEntity.getProdNbr(),
                    String.format("supplier-account-product/prod-nbr/%s", supplierAccountProductEntity.getProdNbr())).subscribe();
            foundationJatClient.refreshCache("product",
                    supplierAccountProductEntity.getProdNbr(),
                    String.format("product/prod-nbr/%s", supplierAccountProductEntity.getProdNbr())).subscribe();
            return new ResponseDTO("SupplierAccountProduct was Inserted/Updated Successfully", HttpStatus.OK, null);
        }
        return new ResponseDTO("Exception encountered Inserting/Updating: SupplierAccountProduct", HttpStatus.INTERNAL_SERVER_ERROR, supplierAccountProduct);
    }

    @Override
    public ResponseDTO delete(SupplierAccountProduct supplierAccountProduct) throws Exception {
        if (supplierAccountProduct.getSupplier_account_xx() != null) {
            SupplierAccountEntity supplierAccountEntity = supplierAccountRepository.findSupplierAccountEntityByAccountNumber(
                    supplierAccountProduct.getSupplier_account_xx().substring(0, 5)).get(0);
            SupplierAccountProductEntity supplierAccountProductEntity = supplierAccountProductRepository.findSupplierAccountProductEntitiesByProdNbrAndInvNameAndSupplierAccountId(supplierAccountProduct.getProdNbr(), FoundationUtil.INV_NAME, supplierAccountEntity.getSupplierAccountId());
            supplierAccountProductEntity.setLastUpdateDate(FoundationUtil.localDateTime());
            supplierAccountProductEntity.setLastUpdateUser(FoundationUtil.USER);
            supplierAccountProductEntity.setProdActiveInd("N");
            supplierAccountProductEntity.setProdPurchActiveInd("N");
            supplierAccountProductRepository.save(supplierAccountProductEntity);
            if (supplierAccountProductEntity.getPrimarySuppInd().equalsIgnoreCase("Y")) {
                productVolumetricsRepository.deleteByProdNbr(supplierAccountProductEntity.getProdNbr());
                foundationJatClient.evictCache("productVolumetrics", supplierAccountProductEntity.getProdNbr());
            }
            foundationJatClient.evictCache("supplierAccountProduct", supplierAccountProduct.getProdNbr()).subscribe();
            return new ResponseDTO("SupplierAccountProduct was Deleted Successfully", HttpStatus.OK, null);
        } else {
            return new ResponseDTO("Exception encountered Deleting: SupplierAccountProduct", HttpStatus.INTERNAL_SERVER_ERROR, supplierAccountProduct);
        }
    }
}
