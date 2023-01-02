package au.com.tgg.apps.foundation.repository;

import au.com.tgg.apps.foundation.model.tggcsodr.MerchUdaHierDefaultEntity;
import org.springframework.data.repository.CrudRepository;

import java.math.BigInteger;
import java.util.List;

public interface MerchUdaHierDefaultRepository extends CrudRepository<MerchUdaHierDefaultEntity, Long> {
    List<MerchUdaHierDefaultEntity> findMerchUdaHierDefaultEntityBySubclassIdAndClassIdAndDepIdAndUdaValueId(BigInteger subclassId, BigInteger classId, BigInteger depId, BigInteger udaValueId);
}
