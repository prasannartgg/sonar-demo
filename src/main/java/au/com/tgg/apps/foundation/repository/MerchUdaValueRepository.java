package au.com.tgg.apps.foundation.repository;


import au.com.tgg.apps.foundation.model.tggcsodr.MerchUdaEntity;
import au.com.tgg.apps.foundation.model.tggcsodr.MerchUdaValueEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.math.BigInteger;
import java.util.List;

public interface MerchUdaValueRepository extends CrudRepository<MerchUdaValueEntity, Long> {

    List<MerchUdaValueEntity> findMerchUdaValueEntitiesByUdaValueCodeAndSourceUdaValueId(@Param("uda_value_code") String uda_value_code, @Param("source_uda_value_id") BigInteger source_uda_value_id);

    @Query(value = "select * from tggcsodr.merch_uda_value where uda_id = ?1 and source_uda_value_id = ?2", nativeQuery = true)
    List<MerchUdaValueEntity> findMerchUdaValueEntitiesByUdaIdAndSourceUdaValueId(@Param("uda_id") BigInteger uda_id, @Param("source_uda_value_id") BigInteger source_uda_value_id);


    List<MerchUdaValueEntity> findMerchUdaValueEntitiesByMerchUdaEntityAndSourceUdaValueId(@Param("uda_id") MerchUdaEntity merchUdaEntity, @Param("source_uda_value_id") BigInteger source_uda_value_id);

    @Query(value = "select uda_value_code from tggcsodr.merch_uda_value where uda_id = (select uda_id from tggcsodr.merch_uda where source_uda_id = ?1) and source_uda_value_id = ?2 and deleted = 'N'", nativeQuery = true)
    String findUdaValueCodeByMerchUdaSourceUdaIdAndSourceUdaValueId(@Param("source_uda_id")BigInteger source_uda_id, @Param("source_uda_value_id") BigInteger source_uda_value_id);

    List<MerchUdaValueEntity> findMerchUdaValueEntitiesBySourceUdaIdAndSourceUdaValueId(BigInteger sourceUdaId, BigInteger sourceUdaValueId);

}
