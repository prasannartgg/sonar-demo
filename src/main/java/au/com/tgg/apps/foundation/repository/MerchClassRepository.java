package au.com.tgg.apps.foundation.repository;

import au.com.tgg.apps.foundation.model.tggcsodr.MerchClassEntity;
import org.springframework.data.repository.CrudRepository;

import java.math.BigInteger;
import java.util.List;

public interface MerchClassRepository extends CrudRepository<MerchClassEntity, Long> {
    List<MerchClassEntity> findMerchClassEntityByClazz(BigInteger clazz);
    List<MerchClassEntity> findMerchClassEntityByClazzAndDeleted(BigInteger clazz, String deleted);
}
