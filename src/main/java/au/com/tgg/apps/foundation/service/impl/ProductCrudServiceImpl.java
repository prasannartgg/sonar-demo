package au.com.tgg.apps.foundation.service.impl;

import au.com.tgg.apps.foundation.dto.ResponseDTO;
import au.com.tgg.apps.foundation.model.json.Product;
import au.com.tgg.apps.foundation.model.json.ProductUdaMap;
import au.com.tgg.apps.foundation.model.json.TggUDA;
import au.com.tgg.apps.foundation.model.tggcsodr.*;
import au.com.tgg.apps.foundation.repository.*;
import au.com.tgg.apps.foundation.service.CrudService;
import au.com.tgg.apps.foundation.util.CopyBeanUtils;
import au.com.tgg.apps.foundation.util.FoundationJatClient;
import au.com.tgg.apps.foundation.util.FoundationUtil;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.List;

@Service
public class ProductCrudServiceImpl implements CrudService<Product> {

    private static final Logger LOGGER = LogManager.getLogger(ProductCrudServiceImpl.class);
    private final FoundationJatClient foundationJatClient;
    private final ProductRepository productRepository;
    private final BrandRepository brandRepository;
    private final SupplierAccountRepository supplierAccountRepository;
    private final SupplierAccountProductRepository supplierAccountProductRepository;
    private final MerchClassRepository merchClassRepository;
    private final MerchSubclassRepository merchSubclassRepository;
    private final CountryRepository countryRepository;
    private final MerchUdaRepository merchUdaRepository;
    private final MerchUdaValueRepository merchUdaValueRepository;
    private final ProductBarcodeRepository productBarcodeRepository;
    private final ProductVolumetricsRepository productVolumetricsRepository;
    private final ProductUdaMapServiceImpl productUdaMapService;


    @Autowired
    public ProductCrudServiceImpl(ProductRepository productRepository, BrandRepository brandRepository, SupplierAccountRepository supplierAccountRepository, SupplierAccountProductRepository supplierAccountProductRepository, MerchClassRepository merchClassRepository, MerchSubclassRepository merchSubclassRepository, CountryRepository countryRepository, MerchUdaRepository merchUdaRepository, MerchUdaValueRepository merchUdaValueRepository, ProductBarcodeRepository productBarcodeRepository, ProductVolumetricsRepository productVolumetricsRepository, ProductUdaMapServiceImpl productUdaMapService,FoundationJatClient foundationJatClient) {
        this.productRepository = productRepository;
        this.brandRepository = brandRepository;
        this.supplierAccountRepository = supplierAccountRepository;
        this.supplierAccountProductRepository = supplierAccountProductRepository;
        this.merchClassRepository = merchClassRepository;
        this.merchSubclassRepository = merchSubclassRepository;
        this.countryRepository = countryRepository;
        this.merchUdaRepository = merchUdaRepository;
        this.merchUdaValueRepository = merchUdaValueRepository;
        this.productBarcodeRepository = productBarcodeRepository;
        this.productVolumetricsRepository = productVolumetricsRepository;
        this.productUdaMapService = productUdaMapService;
        this.foundationJatClient = foundationJatClient;
    }

    @Override
    public ResponseDTO insert(Product product) throws Exception {
        return update(product);
    }

    @Override
    public ResponseDTO update(Product product) throws Exception {
        List<TggUDA> tggUDAList = product.getTggUDAList();
        SupplierAccountEntity supplierAccountEntity = null;
        ProductEntity productEntity;
        List<ProductEntity> productEntityList = productRepository.findProductEntityByProdNbrAndInvName(product.getProdNbr(), FoundationUtil.INV_NAME);
        if (productEntityList != null && !productEntityList.isEmpty()) {
            productEntity = productEntityList.get(0);
        }
        else if (productEntityList.isEmpty() && product.getOperation().getAction().equalsIgnoreCase("update") && !productRepository.findProductEntityByProdNbrAndInvName(product.getProdNbr(),"NZGINV").isEmpty()) {
            return new ResponseDTO("Could not insert/update Product " +product.getProdNbr() + " as it only exist in NZ", HttpStatus.INTERNAL_SERVER_ERROR, product);
        } else {
            productEntity = new ProductEntity();
            productEntity.setCreatedDate(FoundationUtil.localDateTime());
            productEntity.setCreatedUser(FoundationUtil.USER);
        }
        productEntity.setLastUpdateDate(FoundationUtil.localDateTime());
        productEntity.setLastUpdateUser(FoundationUtil.USER);
        productEntity.setGroupCode(String.valueOf(product.getSubclass()));
        CopyBeanUtils.myCopyProperties(product, productEntity);

        //supplier account
        SupplierAccountProductEntity supplierAccountProductEntity = new SupplierAccountProductEntity();
        if (product.getAccount_number() != null) {
            supplierAccountEntity = supplierAccountRepository.findSupplierAccountEntityByAccountNumber(
                    product.getAccount_number().substring(0, 5)).get(0);
            productEntity.setSupplierAccountEntity(supplierAccountEntity);
            productEntity.setAccountNumber(product.getAccount_number().substring(0, 5));
        }
        else if (productEntity != null && productEntity.getSupplierAccountEntity() != null) {
            supplierAccountEntity = productEntity.getSupplierAccountEntity();
        }
        supplierAccountProductEntity = supplierAccountProductRepository.findSupplierAccountProductEntitiesByProdNbrAndInvNameAndSupplierAccountId(product.getProdNbr(), FoundationUtil.INV_NAME, supplierAccountEntity.getSupplierAccountId());
        if (supplierAccountProductEntity == null) {
            supplierAccountProductEntity = new SupplierAccountProductEntity();
        }
        CopyBeanUtils.myCopyProperties(product, supplierAccountProductEntity);

        BrandEntity brandEntity = brandRepository.findBrandEntityByBrandCode(product.getBrandCode());
        if (brandEntity != null) {
            productEntity.setBrandEntity(brandEntity);
        }

        List<MerchClassEntity> merchClassEntities = merchClassRepository.findMerchClassEntityByClazzAndDeleted(BigInteger.valueOf(product.getClazz()), "N");
        if (merchClassEntities != null && merchClassEntities.size() != 0) {
            MerchClassEntity merchClassEntity = merchClassEntities.get(0);
            MerchSubclassEntity merchSubclassEntity = merchSubclassRepository.findUniqueSubclassByClassAndSubclassAndDeletedAndDept(BigInteger.valueOf(product.getSubclass()), BigInteger.valueOf(product.getClazz()), String.valueOf('N'), merchClassEntity.getDept());
            productEntity.setSubclass(merchSubclassEntity.getSubclass());
            productEntity.setGroupId(merchSubclassEntity.getSubclassId());
            productEntity.setSubclassId(merchSubclassEntity.getSubclassId());
        }

        BigInteger gst_rate = countryRepository.findGstRateByInvName(FoundationUtil.INV_NAME);
        productEntity.setGstRate(gst_rate);
        if (tggUDAList != null && tggUDAList.size() != 0) {
            tggUDAList.stream().forEach(a -> {
                ProductUdaMap productUdaMap = new ProductUdaMap();
                productUdaMap.setUdaId(a.getUda_id_xx());
                productUdaMap.setUdaValueId(a.getUda_value_xx());
                productUdaMap.setProdNbr(product.getProdNbr());
                try {
                    productUdaMapService.update(productUdaMap);
                } catch (Exception e) {
                    LOGGER.error("Exception encountered when inserting UDA for PRODUCT: " + product.getProdNbr());
                    e.printStackTrace();
                }

            });
        }

        if (productEntityList.size() == 0 && product.getPrimarySuppInd().equalsIgnoreCase("Y")) {
            if (productEntity.getProductId() == null) {
                productEntity.setProductId(productRepository.getProductIdNexSeq());
            }
            if (productEntity.getTggExclusiveInd() == null) {
                productEntity.setTggExclusiveInd("N");
            }
            if (productEntity.getConcierge() == null) {
                productEntity.setConcierge("N");
            }
            if (productEntity.getProdActiveInd() == null) {
                productEntity.setProdActiveInd("N");
            }
            if (productEntity.getProdPurchActiveInd() == null) {
                productEntity.setProdPurchActiveInd("N");
            }
            if (productEntity.getProdWebReadyInd() == null) {
                productEntity.setProdWebReadyInd("N");
            }
        }
        productRepository.save(productEntity);
        CopyBeanUtils.myCopyProperties(productEntity, supplierAccountProductEntity);
        supplierAccountProductEntity.setSupplierAccountId(supplierAccountEntity.getSupplierAccountId());
        if (supplierAccountProductEntity.getPrimarySuppInd()==null) {
            supplierAccountProductEntity.setPrimarySuppInd("Y");
        }

        //deactivate old supplieraccountproduct records
        List<SupplierAccountProductEntity> supplierAccountProductEntities = supplierAccountProductRepository.findSupplierAccountProductEntitiesByProdNbrAndInvNameAndSupplierAccountIdIsNot(product.getProdNbr(), FoundationUtil.INV_NAME, supplierAccountEntity.getSupplierAccountId());
        if (supplierAccountProductEntity != null && supplierAccountProductEntity.getPrimarySuppInd().equalsIgnoreCase("Y") && (supplierAccountProductEntities != null && supplierAccountProductEntities.size() != 0)) {
            supplierAccountProductEntities.forEach(sap -> {
                sap.setPrimarySuppInd("N");
//                supplierAccountProductRepository.save(sap);
            });
            supplierAccountProductRepository.saveAll(supplierAccountProductEntities);
        }
        supplierAccountProductRepository.save(supplierAccountProductEntity);

        foundationJatClient.refreshCache("supplierAccountProduct",
                productEntity.getProductId().toString(),
                String.format("supplier-account-product/prod-nbr/%s", productEntity.getProdNbr())).subscribe();
        foundationJatClient.refreshCache("product",
                productEntity.getProdNbr(),
                String.format("product/prod-nbr/%s", productEntity.getProdNbr())).subscribe();
        return new ResponseDTO("Product was Inserted/Updated Successfully", HttpStatus.OK, null);
    }

    @Override
    public ResponseDTO delete(Product product) throws Exception {
        List<ProductEntity> productEntities = productRepository.findProductEntityByProdNbrAndInvName(product.getProdNbr(), FoundationUtil.INV_NAME);
        List<SupplierAccountProductEntity> supplierAccountProductEntities = supplierAccountProductRepository.findSupplierAccountProductEntitiesByProdNbrAndProdActiveInd(product.getProdNbr(), "Y");
        if (productEntities == null || productEntities.size() == 0) {
            return new ResponseDTO(product.getProdNbr() + " does not exist to be deleted", HttpStatus.INTERNAL_SERVER_ERROR, product);
        }
        ProductEntity productEntity = productEntities.get(0);
        productEntity.setLastUpdateDate(FoundationUtil.localDateTime());
        productEntity.setLastUpdateUser(FoundationUtil.USER);
        productEntity.setProdActiveInd("N");
        productEntity.setProdPurchActiveInd("N");
        String prodNbr = productEntity.getProdNbr();
        if (prodNbr != null) {
            List<ProductBarcodeEntity> productBarcodeEntityList = productBarcodeRepository.findProductBarcodeEntityByProdNbrAndDeleted(prodNbr, "N");
            if (productBarcodeEntityList != null) {
                productBarcodeEntityList.forEach(productBarcodeEntity -> {
                    productBarcodeEntity.setDeleted("Y");
                    productBarcodeEntity.setLastModifiedDate(FoundationUtil.localDateTime());
                    productBarcodeRepository.save(productBarcodeEntity);
                });
            }
        }
        if (prodNbr != null) {
            productRepository.save(productEntity);
            productVolumetricsRepository.deleteByProdNbr(prodNbr);
            if (supplierAccountProductEntities != null || supplierAccountProductEntities.size() != 0) {
                supplierAccountProductEntities.forEach(a -> {
                    a.setLastUpdateDate(FoundationUtil.localDateTime());
                    a.setLastUpdateUser(FoundationUtil.USER);
                    a.setProdActiveInd("N");
                    a.setProdPurchActiveInd("N");
//                    supplierAccountProductRepository.save(a);
                });
                supplierAccountProductRepository.saveAll(supplierAccountProductEntities);
            }
            foundationJatClient.evictCache("product", productEntity.getProdNbr()).subscribe();
            foundationJatClient.evictCache("productVolumetrics", productEntity.getProdNbr()).subscribe();
            return new ResponseDTO("Product was Deleted Successfully", HttpStatus.OK, null);
        } else {
            return new ResponseDTO("Exception encountered Deleting: Product", HttpStatus.INTERNAL_SERVER_ERROR, product);
        }
    }
}
