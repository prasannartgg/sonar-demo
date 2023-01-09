package au.com.tgg.apps.foundation.repository;

import au.com.tgg.apps.foundation.model.tggcsodr.BrandEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.math.BigInteger;
import java.util.List;


public interface BrandRepository extends CrudRepository<BrandEntity, String> {
    BrandEntity findBrandEntityByBrandName(String brand);
    List<BrandEntity> findBrandEntitiesByBrandName(String brand_name);
    List<BrandEntity> findBrandEntitiesByBrandCode(String brandCode);
    BrandEntity findBrandEntityByBrandCode(String brand_code);

    @Query(value = "SELECT nextval('tggcsodr.seq_brand_id')", nativeQuery = true)
    BigInteger getBrandIdNexSeq();
}
