package au.com.tgg.apps.foundation.repository;


import au.com.tgg.apps.foundation.model.tggcsodr.ProductEntity;
import au.com.tgg.apps.foundation.model.tggcsodr.ProductId;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigInteger;
import java.util.List;

public interface ProductRepository extends CrudRepository<ProductEntity, ProductId> {
    List<ProductEntity> findProductEntityByProdNbr(String prodNbr);

    List<ProductEntity> findProductEntityByProdNbrAndInvName(String prodNbr, String invName);

    @Query(value = "SELECT nextval('tggcsodr.seq_product_id')", nativeQuery = true)
    BigInteger getProductIdNexSeq();

    @Modifying
    @Transactional
    @Query(value = "update tggcsodr.product set last_update_date = current_timestamp, gtin = ?1 where prod_nbr = ?2", nativeQuery = true)
    void updateProductGtinByProductBarcode(String barcode, String prod_nbr);


    @Modifying
    @Transactional
    @Query(value = "update tggcsodr.product set last_update_date = current_timestamp, supplier_account_id = ?1 where prod_nbr = ?2", nativeQuery = true)
    void updateProductSupIdByProductNbr(BigInteger supplier_account_id, String prod_nbr);

    @Modifying
    @Transactional
    @Query(value = "update tggcsodr.product set last_update_date = current_timestamp, supplier_account_id = ?1, sup_prod_nbr = ?2, consumer_prod_nbr = ?3, account_number =?4, cost_ex_price = ?5 where prod_nbr = ?6", nativeQuery = true)
    void updateProductPrimaryRelateFieldsByPrimarySupDetail(BigInteger supplier_account_id, String sup_prod_nbr, String consumer_prod_nbr, String account_number, Double cost_ex_price, String prod_nbr);

    @Modifying
    @Transactional
    @Query(value = "update tggcsodr.product set last_update_date = current_timestamp, gtin = null where prod_nbr = ?1 and gtin = ?2", nativeQuery = true)
    void updateProductGtinToNullByProductNbrAndGtin(String prod_nbr, String gtin);
}
