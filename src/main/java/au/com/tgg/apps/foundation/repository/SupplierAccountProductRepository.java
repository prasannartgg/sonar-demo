package au.com.tgg.apps.foundation.repository;

import au.com.tgg.apps.foundation.model.tggcsodr.SupplierAccountProductEntity;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigInteger;
import java.util.List;

public interface SupplierAccountProductRepository extends CrudRepository<SupplierAccountProductEntity, Long> {
    List<SupplierAccountProductEntity> findSupplierAccountProductEntitiesByProdNbr(String prodNbr);
    List<SupplierAccountProductEntity> findSupplierAccountProductEntitiesByProdNbrAndInvName( String prodNbr, String invName);
    List<SupplierAccountProductEntity> findSupplierAccountProductEntitiesByProdNbrAndProdActiveInd( String prodNbr, String prodActiveInd);
    List<SupplierAccountProductEntity> findSupplierAccountProductEntitiesByProdNbrAndInvNameAndSupplierAccountIdIsNot(String prodNbr, String invName, BigInteger supplierAccountId);
    List<SupplierAccountProductEntity> findSupplierAccountProductEntitiesByProdNbrAndSupplierAccountIdIsNot(String prodNbr, BigInteger supplierAccountId);

    @Query(value = "select * from tggcsodr.supplier_account_product where prod_nbr = ?1 and inv_name = ?2 and supplier_account_id = ?3", nativeQuery = true)
    SupplierAccountProductEntity findSupplierAccountProductEntitiesByProdNbrAndInvNameAndSupplierAccountId(String prodNbr, String invName, BigInteger supplierAccountId);

    @Modifying
    @Transactional
    @Query(value = "update tggcsodr.supplier_account_product set  last_update_date = current_timestamp, prod_active_ind = 'N', prod_purch_active_ind = 'N' where prod_nbr = ?1", nativeQuery = true)
    void updateActiveIndByProdNbr(String prodNbr);


    @Query(value = "select * from tggcsodr.supplier_account_product where prod_nbr = ?1 and primary_supp_ind = ?2", nativeQuery = true)
    List<SupplierAccountProductEntity> findSupplierAccountProductEntitiesByProNbrAndPrimarySuppInd(String prodNbr, String primary_supp_ind);

    @Modifying
    @Transactional
    @Query(value = "update tggcsodr.supplier_account_product set last_update_date = current_timestamp, gtin = ?1 where prod_nbr = ?2 and primary_supp_ind = ?3 and inv_name = ?4", nativeQuery = true)
    void updateSupplierAccountProductGtinByProductBarcode(String barcode, String prod_nbr, String primaryInd, String invName);

    @Modifying
    @Transactional
    @Query(value = "update tggcsodr.supplier_account_product set last_update_date = current_timestamp, gtin = null, primary_supp_ind = ?1  where prod_nbr = ?2 and gtin = ?3 and inv_name = ?4", nativeQuery = true)
    void updateSupplierAccountProductGtinByProductBarcodeAndGtinAndInvname(String primaryInd, String prod_nbr, String barcode, String invName);

    @Modifying
    @Transactional
    @Query(value = "update tggcsodr.supplier_account_product set last_update_date = current_timestamp, gtin = null  where prod_nbr = ?1 and primary_supp_ind = ?2 and inv_name = ?3", nativeQuery = true)
    void updateSupplierAccountProductGtinByProdNbrAndPrimarySuppInd(String prod_nbr,  String primary_supp_ind);

}
