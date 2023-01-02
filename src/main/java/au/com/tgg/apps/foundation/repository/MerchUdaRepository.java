package au.com.tgg.apps.foundation.repository;

import au.com.tgg.apps.foundation.model.tggcsodr.MerchUdaEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.math.BigInteger;
import java.util.List;

public interface MerchUdaRepository extends CrudRepository<MerchUdaEntity, Long> {
    List<MerchUdaEntity> findMerchUdaEntitiesBySourceUdaId(BigInteger uda_id);

    @Query(value = "SELECT * FROM tggcsodr.merch_uda where source_uda_id = ?1", nativeQuery = true)
    MerchUdaEntity findMerchUdaBySourceUdaId(BigInteger source_uda_id);

    @Query(value = "SELECT uda_code FROM tggcsodr.merch_uda where source_uda_id = ?1", nativeQuery = true)
    String getMerchUdaCodeBySourceUdaId(@Param("source_uda_id") BigInteger source_uda_id);
}
