package au.com.tgg.apps.foundation.repository;

import au.com.tgg.apps.foundation.model.tggcsodr.ProductCoreRangeEntity;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

public interface ProductCoreRangeRepository extends CrudRepository<ProductCoreRangeEntity, Long> {
    ProductCoreRangeEntity findProductCoreRangeEntityByProdCoreRange(String description);
    @Modifying
    @Transactional
    @Query(value = "INSERT INTO tggcsodr.product_core_range(\n" +
            "\tprod_core_range, description, last_update_date, last_update_user)\n" +
            "\tVALUES (?, ?, ?, ?)", nativeQuery = true)
    void insertProductCodeRangeBySourceUdaValueDesc(@Param("prod_core_range") String prod_core_range,
                                                    @Param("description") String description,
                                                    @Param("last_update_date") LocalDateTime last_update_date,  @Param("last_update_user") String last_update_user);
    @Modifying
    @Transactional
    @Query(value = "update tggcsodr.product_core_range set description = ?1, last_update_date = ?2, last_update_user=?3 where prod_core_range = ?4", nativeQuery = true)
    void updateProductCodeRangeBySourceUdaValueDesc(@Param("description") String description,
                                                    @Param("last_update_date") LocalDateTime last_update_date,  @Param("last_update_user") String last_update_user,@Param("prod_core_range") String prod_core_range);


}
