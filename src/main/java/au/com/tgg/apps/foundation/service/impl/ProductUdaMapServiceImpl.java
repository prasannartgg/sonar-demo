package au.com.tgg.apps.foundation.service.impl;

import au.com.tgg.apps.foundation.dto.ResponseDTO;
import au.com.tgg.apps.foundation.model.json.ProductUdaMap;
import au.com.tgg.apps.foundation.model.tggcsodr.*;
import au.com.tgg.apps.foundation.repository.*;
import au.com.tgg.apps.foundation.service.CrudService;
import au.com.tgg.apps.foundation.util.CopyBeanUtils;
import au.com.tgg.apps.foundation.util.FoundationJatClient;
import au.com.tgg.apps.foundation.util.FoundationUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductUdaMapServiceImpl implements CrudService<ProductUdaMap> {

    private final FoundationJatClient foundationJatClient;
    ProductUdaMapRepository productUdaMapRepository;
    ProductRepository productRepository;
    MerchUdaRepository merchUdaRepository;
    MerchUdaValueRepository merchUdaValueRepository;
    SupplierAccountProductRepository supplierAccountProductRepository;

    @Autowired
    public ProductUdaMapServiceImpl(FoundationJatClient foundationJatClient, ProductUdaMapRepository productUdaMapRepository, ProductRepository productRepository, MerchUdaRepository merchUdaRepository, MerchUdaValueRepository merchUdaValueRepository, SupplierAccountProductRepository supplierAccountProductRepository) {
        this.foundationJatClient = foundationJatClient;
        this.productUdaMapRepository = productUdaMapRepository;
        this.productRepository = productRepository;
        this.merchUdaRepository = merchUdaRepository;
        this.merchUdaValueRepository = merchUdaValueRepository;
        this.supplierAccountProductRepository = supplierAccountProductRepository;
    }


    @Override
    public ResponseDTO insert(ProductUdaMap productUdaMap) throws Exception {
        return update(productUdaMap);
    }

    @Override
    public ResponseDTO update(ProductUdaMap productUdaMap) throws Exception {
        List<ProductEntity> productEntityList = productRepository.findProductEntityByProdNbrAndInvName(productUdaMap.getProdNbr(), FoundationUtil.INV_NAME);
        if (productEntityList.isEmpty()) {
            return new ResponseDTO("Exception: Product does not exist for ProductUdaMap " + productUdaMap.getProdNbr(), HttpStatus.I_AM_A_TEAPOT, productUdaMap);
        }
        ProductEntity productEntity = productEntityList.get(0);

        String udaCode = merchUdaRepository.findMerchUdaBySourceUdaId(productUdaMap.getUdaId()).getUdaCode();
        if (udaCode.equalsIgnoreCase("PRODUCT_TYPE") || udaCode.equalsIgnoreCase("SERVICE_GROUP") || udaCode.equalsIgnoreCase("RANGING_FLAG_AUS")
                || udaCode.equalsIgnoreCase("MANUFACTURERS_WARRANTY_AUS") || udaCode.equalsIgnoreCase("EXTENDED_WARRANTY_AUS")
                || udaCode.equalsIgnoreCase("ACL") || udaCode.equalsIgnoreCase("TGG_EXCLUSIVE") || udaCode.equalsIgnoreCase("CONCIERGE")
                || udaCode.equalsIgnoreCase("AU_POWER_SKU")) {
             productUdaUpdate(productEntity, productUdaMap);
        }

        List<ProductUdaMapEntity> productUdaMapList = productUdaMapRepository.findProductUdaMapEntitiesByProdNbrAndUdaIdAndUdaValueAndDeleted(productUdaMap.getProdNbr(), productUdaMap.getUdaId(), productUdaMap.getUdaValueId(), "N");
        ProductUdaMapEntity productUdaMapEntity;

        if (productUdaMapList.isEmpty()) {
            productUdaMapEntity = new ProductUdaMapEntity();
            productUdaMapEntity.setCreatedBy(FoundationUtil.USER);
            productUdaMapEntity.setCreatedDate(FoundationUtil.localDateTime());
        } else {
            productUdaMapEntity = productUdaMapList.get(0);
        }
        CopyBeanUtils.myCopyProperties(productUdaMap, productUdaMapEntity);
        productUdaMapEntity.setProdNbr(productEntity.getProdNbr());
        productUdaMapEntity.setDeleted("N");
        productUdaMapEntity.setUdaValue(productUdaMap.getUdaValueId());

        productUdaMapEntity.setModifiedBy(FoundationUtil.USER);
        productUdaMapEntity.setModifiedDate(FoundationUtil.localDateTime());



        productUdaMapRepository.save(productUdaMapEntity);

        foundationJatClient.refreshCache("supplierAccountProduct",
                productEntity.getProductId().toString(),
                String.format("supplier-account-product/prod-nbr/%s", productEntity.getProdNbr())).subscribe();
        foundationJatClient.refreshCache("product",
                productEntity.getProdNbr(),
                String.format("product/prod-nbr/%s", productEntity.getProdNbr())).subscribe();

        return new ResponseDTO("ProductUdaMap was Inserted/Updated Successfully", HttpStatus.OK, null);
    }

    public ResponseDTO productUdaUpdate(ProductEntity productEntity, ProductUdaMap productUdaMap) {
        MerchUdaEntity merchUdaEntity = merchUdaRepository.findMerchUdaBySourceUdaId(productUdaMap.getUdaId());
        List<MerchUdaValueEntity> merchUdaValueEntitylist = merchUdaValueRepository.findMerchUdaValueEntitiesBySourceUdaIdAndSourceUdaValueId(productUdaMap.getUdaId(), productUdaMap.getUdaValueId());
        if (!merchUdaValueEntitylist.isEmpty()) {
            MerchUdaValueEntity merchUdaValueEntity = merchUdaValueEntitylist.get(0);
            switch (merchUdaEntity.getUdaCode()) {
                case "PRODUCT_TYPE":
                    productEntity.setProdType(merchUdaValueEntity.getUdaValueCode());
                    break;
                case "SERVICE_GROUP":
                    productEntity.setServiceGroup(merchUdaValueEntity.getUdaValueCode());
                    break;
                case "RANGING_FLAG_AUS":
                    productEntity.setProdCoreRange(merchUdaValueEntity.getUdaValueCode());
                    break;
                case "MANUFACTURERS_WARRANTY_AUS":
                    productEntity.setWtyPrdMths(Integer.valueOf(merchUdaValueEntity.getUdaValueCode()));
                    productEntity.setMaxWtyPrdMths(Integer.valueOf(merchUdaValueEntity.getUdaValueCode()));
                    break;
                case "EXTENDED_WARRANTY_AUS":
                    productEntity.setExtWtyType(merchUdaValueEntity.getUdaValueCode());
                    break;
                case "ACL":
                    productEntity.setMaxWtyPrdMths(Integer.valueOf(merchUdaValueEntity.getUdaValueCode()));
                    break;
                case "TGG_EXCLUSIVE":
                    productEntity.setTggExclusiveInd(merchUdaValueEntity.getUdaValueCode());
                    break;
                case "CONCIERGE":
                    productEntity.setConcierge(merchUdaValueEntity.getUdaValueCode());
                    break;
                case "AU_POWER_SKU":
                    productEntity.setProdPwrSkuInd(merchUdaValueEntity.getUdaValueCode());
                    break;
            }
            productEntity.setLastUpdateDate(FoundationUtil.localDateTime());
            productEntity.setLastUpdateUser(FoundationUtil.USER);
            productRepository.save(productEntity);
            foundationJatClient.refreshCache("product",
                    productEntity.getProdNbr(),
                    String.format("product/prod-nbr/%s", productEntity.getProdNbr())).subscribe();


            List<SupplierAccountProductEntity> supplierAccountProductEntityList = supplierAccountProductRepository.findSupplierAccountProductEntitiesByProdNbrAndInvName(productEntity.getProdNbr(), FoundationUtil.INV_NAME);
            if (!supplierAccountProductEntityList.isEmpty()) {
                for (SupplierAccountProductEntity supplierAccountProduct : supplierAccountProductEntityList) {
                    switch (merchUdaEntity.getUdaCode()) {
                        case "PRODUCT_TYPE":
                            supplierAccountProduct.setProdType(merchUdaValueEntity.getUdaValueCode());
                            break;
                        case "SERVICE_GROUP":
                            supplierAccountProduct.setServiceGroup(merchUdaValueEntity.getUdaValueCode());
                            break;
                        case "RANGING_FLAG_AUS":
                            supplierAccountProduct.setProdCoreRange(merchUdaValueEntity.getUdaValueCode());
                            break;
                        case "MANUFACTURERS_WARRANTY_AUS":
                            supplierAccountProduct.setWtyPrdMths(Integer.valueOf(merchUdaValueEntity.getUdaValueCode()));
                            break;
                        case "EXTENDED_WARRANTY_AUS":
                            supplierAccountProduct.setExtWtyType(merchUdaValueEntity.getUdaValueCode());
                            break;
                        case "ACL":
                            supplierAccountProduct.setMaxWtyPrdMths(Integer.valueOf(merchUdaValueEntity.getUdaValueCode()));
                            break;
                        case "TGG_EXCLUSIVE":
                            supplierAccountProduct.setTggExclusiveInd(merchUdaValueEntity.getUdaValueCode());
                            break;
                        case "CONCIERGE":
                            supplierAccountProduct.setConcierge(merchUdaValueEntity.getUdaValueCode());
                            break;
                        case "AU_POWER_SKU":
                            supplierAccountProduct.setProdPwrSkuInd(merchUdaValueEntity.getUdaValueCode());
                            break;
                    }
                    supplierAccountProduct.setLastUpdateDate(FoundationUtil.localDateTime());
                    supplierAccountProduct.setLastUpdateUser(FoundationUtil.USER);
                }
                supplierAccountProductRepository.saveAll(supplierAccountProductEntityList);
                foundationJatClient.refreshCache("supplierAccountProduct",
                        productEntity.getProdNbr(),
                        String.format("supplier-account-product/prod-nbr/%s", productEntity.getProdNbr())).subscribe();
            }

            return new ResponseDTO("ProductUdaMap was Inserted/Updated Successfully", HttpStatus.OK, null);
        }
        return new ResponseDTO("Insert/Update ProductUdaMap - Exception", HttpStatus.INTERNAL_SERVER_ERROR, productUdaMap);
    }

    /*public void productCoreRangeUpdate(ProductEntity productEntity, ProductUdaMapEntity productUdaMapEntity) {
        if (merchUdaRepository.findMerchUdaBySourceUdaId(productUdaMapEntity.getUdaId()).getUdaCode().equalsIgnoreCase("RANGING_FLAG_AUS")) {
            productEntity.setLastUpdateUser(FoundationUtil.USER);
            productEntity.setLastUpdateDate(FoundationUtil.localDateTime());
            productEntity.setProdCoreRange(merchUdaValueRepository.findUdaValueCodeByMerchUdaSourceUdaIdAndSourceUdaValueId(productUdaMapEntity.getUdaId(), productUdaMapEntity.getUdaValue()));
            productRepository.save(productEntity);
            foundationJatClient.refreshCache("supplierAccountProduct",
                    productEntity.getProductId().toString(),
                    String.format("supplier-account-product/prod-nbr/%s", productEntity.getProdNbr())).subscribe();
            foundationJatClient.refreshCache("product",
                    productEntity.getProdNbr(),
                    String.format("product/prod-nbr/%s", productEntity.getProdNbr())).subscribe();
            List<SupplierAccountProductEntity> supplierAccountProductEntities = supplierAccountProductRepository.findSupplierAccountProductEntitiesByProdNbrAndInvName(productUdaMapEntity.getProdNbr(), FoundationUtil.INV_NAME);
            if (supplierAccountProductEntities != null && supplierAccountProductEntities.size() != 0) {
                supplierAccountProductEntities.forEach(supplierAccountProductEntity -> {
                    supplierAccountProductEntity.setLastUpdateDate(FoundationUtil.localDateTime());
                    supplierAccountProductEntity.setLastUpdateUser(FoundationUtil.USER);
                    supplierAccountProductEntity.setProdCoreRange(merchUdaValueRepository.findUdaValueCodeByMerchUdaSourceUdaIdAndSourceUdaValueId(productUdaMapEntity.getUdaId(), productUdaMapEntity.getUdaValue()));
                    supplierAccountProductRepository.save(supplierAccountProductEntity);
                    foundationJatClient.refreshCache("supplierAccountProduct",
                            supplierAccountProductEntity.getProdNbr(),
                            String.format("supplier-account-product/prod-nbr/%s", supplierAccountProductEntity.getProdNbr())).subscribe();
                    foundationJatClient.refreshCache("product",
                            supplierAccountProductEntity.getProdNbr(),
                            String.format("product/prod-nbr/%s", supplierAccountProductEntity.getProdNbr())).subscribe();
//                        foundationJatClient.refreshCache("supplierAccountProduct",
//                                productEntity.getProdNbr(),
//                                String.format("supplier-account-product/prod-nbr/%s", productEntity.getProdNbr())).subscribe();
                });
            }
        }
    } */

    @Override
    public ResponseDTO delete(ProductUdaMap productUdaMap) throws Exception {
        ProductEntity productEntity = productRepository.findProductEntityByProdNbrAndInvName(productUdaMap.getProdNbr(), "TGGINV").get(0);
        List<ProductUdaMapEntity> productUdaMapList = productUdaMapRepository.findProductUdaMapEntitiesByProdNbrAndUdaIdAndUdaValue(productEntity.getProdNbr(), productUdaMap.getUdaId(), productUdaMap.getUdaValueId());
        if (!productUdaMapList.isEmpty()) {
            for (ProductUdaMapEntity productUdaMapEntity : productUdaMapList) {
                CopyBeanUtils.myCopyProperties(productUdaMap, productUdaMapEntity);
                productUdaMapEntity.setDeleted("Y");
                productUdaMapEntity.setModifiedDate(FoundationUtil.localDateTime());
                productUdaMapEntity.setModifiedBy(FoundationUtil.USER);
            }
            productUdaMapRepository.saveAll(productUdaMapList);
            foundationJatClient.refreshCache("supplierAccountProduct",
                    productEntity.getProductId().toString(),
                    String.format("supplier-account-product/prod-nbr/%s", productEntity.getProdNbr())).subscribe();
            foundationJatClient.refreshCache("product",
                    productEntity.getProdNbr(),
                    String.format("product/prod-nbr/%s", productEntity.getProdNbr())).subscribe();
            return new ResponseDTO("ProductUdaMap was Deleted Successfully", HttpStatus.OK, null);
        } else {
            return new ResponseDTO("Exception encountered Deleting: ProductUdaMap", HttpStatus.INTERNAL_SERVER_ERROR, productUdaMap);
        }
    }
}
