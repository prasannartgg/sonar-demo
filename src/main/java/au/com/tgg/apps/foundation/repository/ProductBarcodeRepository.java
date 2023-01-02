package au.com.tgg.apps.foundation.repository;

import au.com.tgg.apps.foundation.model.tggcsodr.ProductBarcodeEntity;
import au.com.tgg.apps.foundation.model.tggcsodr.ProductBarcodeId;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigInteger;
import java.time.LocalDateTime;
import java.util.List;

public interface ProductBarcodeRepository extends CrudRepository<ProductBarcodeEntity, ProductBarcodeId> {

    @Query(value = "select * from tggcsodr.product_barcode where prod_nbr = ?1 and barcode = ?2 and deleted = ?3", nativeQuery = true)
    ProductBarcodeEntity findProductBarcodeEntityByProdNbrAndBarcodeAndDeleted(String prod_nbr, String barcode, String deleted);

    ProductBarcodeEntity findProductBarcodeEntityByProdNbrAndBarcode(String prod_nbr, String barcode);

    @Query(value = "select * from tggcsodr.product_barcode where prod_nbr = ?1 and deleted = ?2", nativeQuery = true)
    List<ProductBarcodeEntity> findProductBarcodeEntityByProdNbrAndDeleted(String prod_nbr, String deleted);

    List<ProductBarcodeEntity> findProductBarcodeEntityByProdNbr(String prodNbr);

    @Transactional
    @Modifying
    @Query(value = "update tggcsodr.product_barcode set primary_ind='N' where prod_nbr = ?1", nativeQuery = true)
    void updatePimaryIndByProdNbr(String prod_nbr);

    @Transactional
    @Modifying
    @Query(value = "insert into tggcsodr.product_barcode (barcode, barcode_type, primary_ind, deleted, created_by, created_date, last_modified_by, last_modified_date, prod_nbr, product_id, inv_name) VALUES (?1, ?2, ?3, ?4, ?5, ?6, ?7, ?8, ?9, ?10, ?11)", nativeQuery = true)
    void insertProductBarcodeEntity(String barcode, String barcode_type,
                                    String primary_ind, String deleted, String created_by, LocalDateTime created_date,
                                    String last_modified_by, LocalDateTime last_modified_date, String prod_nbr, BigInteger product_id, String inv_name);

    @Transactional
    @Modifying
    @Query(value = "update tggcsodr.product_barcode SET barcode_type=?3, primary_ind=?4, deleted=?5, created_by=?6, created_date=?7, last_modified_by=?8, last_modified_date=?9 where prod_nbr = ?1 and barcode=?2", nativeQuery = true)
    void modifyBarcodeEntity(String prod_nbr, String barcode, String barcode_type, String primary_ind,String deleted, String created_by, LocalDateTime created_date,
                                   String last_modified_by, LocalDateTime last_modified_date);


}
