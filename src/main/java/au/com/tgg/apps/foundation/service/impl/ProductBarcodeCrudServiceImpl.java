package au.com.tgg.apps.foundation.service.impl;

import au.com.tgg.apps.foundation.dto.ResponseDTO;
import au.com.tgg.apps.foundation.model.json.ProductBarcode;
import au.com.tgg.apps.foundation.model.tggcsodr.ProductBarcodeEntity;
import au.com.tgg.apps.foundation.model.tggcsodr.ProductEntity;
import au.com.tgg.apps.foundation.repository.ProductBarcodeRepository;
import au.com.tgg.apps.foundation.repository.ProductRepository;
import au.com.tgg.apps.foundation.repository.SupplierAccountProductRepository;
import au.com.tgg.apps.foundation.service.CrudService;
import au.com.tgg.apps.foundation.util.CopyBeanUtils;
import au.com.tgg.apps.foundation.util.FoundationJatClient;
import au.com.tgg.apps.foundation.util.FoundationUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
public class ProductBarcodeCrudServiceImpl implements CrudService<ProductBarcode> {

    private final ProductRepository productRepository;
    private final ProductBarcodeRepository productBarcodeRepository;
    private final SupplierAccountProductRepository supplierAccountProductRepository;
    private final FoundationJatClient foundationJatClient;

    @Autowired
    public ProductBarcodeCrudServiceImpl(ProductRepository productRepository, ProductBarcodeRepository productBarcodeRepository, SupplierAccountProductRepository supplierAccountProductRepository, FoundationJatClient foundationJatClient) {
        this.productRepository = productRepository;
        this.productBarcodeRepository = productBarcodeRepository;
        this.supplierAccountProductRepository = supplierAccountProductRepository;
        this.foundationJatClient = foundationJatClient;
    }

    @Override
    public ResponseDTO insert(ProductBarcode productBarcode) throws Exception {
        return update(productBarcode);
    }

    @Override
    public ResponseDTO update(ProductBarcode productBarcode) throws Exception {
        if (productRepository.findProductEntityByProdNbrAndInvName(productBarcode.getProdNbr(), FoundationUtil.INV_NAME).size() == 0) {
            return new ResponseDTO("Exception Encountered Product does not exist for ProductBarcode: " + productBarcode.getProdNbr(), HttpStatus.I_AM_A_TEAPOT, productBarcode);
        }
        ProductEntity productEntity = productRepository.findProductEntityByProdNbrAndInvName(productBarcode.getProdNbr(), FoundationUtil.INV_NAME).get(0);
        ProductBarcodeEntity productBarcodeEntity = null;

        if (productBarcodeRepository.findProductBarcodeEntityByProdNbrAndBarcode(productBarcode.getProdNbr(), productBarcode.getBarcode()) != null) {
            productBarcodeEntity = productBarcodeRepository.findProductBarcodeEntityByProdNbrAndBarcode(productBarcode.getProdNbr(), productBarcode.getBarcode());
        } else {
            productBarcodeEntity = new ProductBarcodeEntity();
            productBarcodeEntity.setCreatedDate(FoundationUtil.localDateTime());
            productBarcodeEntity.setCreatedBy(FoundationUtil.USER);
        }

        CopyBeanUtils.myCopyProperties(productBarcode, productBarcodeEntity);
        productBarcodeEntity.setLastModifiedDate(FoundationUtil.localDateTime());
        productBarcodeEntity.setLastModifiedBy(FoundationUtil.USER);

        if (productEntity != null) {
            productBarcodeEntity.setProductId(productEntity.getProductId());
            if (productBarcodeEntity.getPrimaryInd().equalsIgnoreCase("Y")) {


                productBarcodeEntity.setPrimaryInd("N");
                productRepository.updateProductGtinByProductBarcode(productBarcodeEntity.getBarcode(), productBarcodeEntity.getProdNbr());
                supplierAccountProductRepository.updateSupplierAccountProductGtinByProductBarcode(productBarcodeEntity.getBarcode(), productBarcodeEntity.getProdNbr(), "Y", FoundationUtil.INV_NAME);
                foundationJatClient.refreshCache("supplierAccountProduct",
                        productBarcodeEntity.getProdNbr(),
                        String.format("supplier-account-product/prod-nbr/%s", productBarcodeEntity.getProdNbr())).subscribe();
            }
            else if (productBarcodeEntity.getPrimaryInd() == null && productBarcode.getPrimaryInd() == null && productBarcodeRepository.findProductBarcodeEntityByProdNbr(productBarcode.getProdNbr()).isEmpty()) {
                productBarcodeEntity.setPrimaryInd("Y");
            }
//            productBarcodeRepository.modifyBarcodeEntity(productEntity.getProdNbr(), productBarcodeEntity.getBarcode(), productBarcodeEntity.getBarcodeType(),
//                    productBarcodeEntity.getPrimaryInd(), productBarcodeEntity.getDeleted(), productBarcodeEntity.getCreatedBy(), productBarcodeEntity.getCreatedDate(),
//                    productBarcodeEntity.getLastModifiedBy(), productBarcodeEntity.getLastModifiedDate());
            foundationJatClient.refreshCache("product",
                    productBarcodeEntity.getProdNbr(),
                    String.format("product/prod-nbr/%s", productBarcodeEntity.getProdNbr())).subscribe();
            productBarcodeRepository.save(productBarcodeEntity);
            return new ResponseDTO("ProductBarcode was Inserted/Updated Successfully", HttpStatus.OK, null);
        } else {
            return new ResponseDTO("Exception encountered Inserting/Updating: ProductBarcode", HttpStatus.INTERNAL_SERVER_ERROR, productBarcode);
        }
    }

    @Override
    public ResponseDTO delete(ProductBarcode productBarcode) throws Exception {
        ProductBarcodeEntity productBarcodeEntity = productBarcodeRepository.findProductBarcodeEntityByProdNbrAndBarcode(productBarcode.getProdNbr(), productBarcode.getBarcode());
        if (productBarcodeEntity != null) {
            productBarcodeEntity.setLastModifiedDate(FoundationUtil.localDateTime());
            productBarcodeEntity.setLastModifiedBy(FoundationUtil.USER);
            productBarcodeEntity.setDeleted("Y");
            productBarcodeEntity.setPrimaryInd("N");
            productRepository.updateProductGtinToNullByProductNbrAndGtin(productBarcodeEntity.getProdNbr(), productBarcodeEntity.getBarcode());
            supplierAccountProductRepository.updateSupplierAccountProductGtinByProductBarcodeAndGtinAndInvname("N", productBarcodeEntity.getProdNbr(), productBarcodeEntity.getBarcode(), FoundationUtil.INV_NAME);
            foundationJatClient.refreshCache("supplierAccountProduct",
                    productBarcodeEntity.getProdNbr(),
                    String.format("supplier-account-product/prod-nbr/%s", productBarcodeEntity.getProdNbr())).subscribe();
            foundationJatClient.refreshCache("product",
                    productBarcodeEntity.getProdNbr(),
                    String.format("product/prod-nbr/%s", productBarcodeEntity.getProdNbr())).subscribe();
            productBarcodeRepository.save(productBarcodeEntity);
            return new ResponseDTO("ProductBarcode was Deleted Successfully", HttpStatus.OK, null);
        } else {
            return new ResponseDTO("Exception encountered Deleting: ProductBarcode", HttpStatus.INTERNAL_SERVER_ERROR, productBarcode);
        }
    }
}
