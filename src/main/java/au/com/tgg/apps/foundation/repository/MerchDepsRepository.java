package au.com.tgg.apps.foundation.repository;

import au.com.tgg.apps.foundation.model.tggcsodr.MerchDepsEntity;
import org.springframework.data.repository.CrudRepository;

import java.math.BigInteger;
import java.util.List;

public interface MerchDepsRepository extends CrudRepository<MerchDepsEntity, Long> {
    List<MerchDepsEntity> findMerchDepsEntityByDept(BigInteger dept);
    List<MerchDepsEntity> findMerchDepsEntityByDeptAndDeleted(BigInteger dept, String  deleted);
}
