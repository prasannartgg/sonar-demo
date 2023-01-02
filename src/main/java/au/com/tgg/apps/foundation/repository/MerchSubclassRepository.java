package au.com.tgg.apps.foundation.repository;

import au.com.tgg.apps.foundation.model.tggcsodr.MerchSubclassEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.math.BigInteger;
import java.util.List;

public interface MerchSubclassRepository extends CrudRepository<MerchSubclassEntity, Long> {
    List<MerchSubclassEntity> findMerchSubclassEntitiesBySubclass(BigInteger subclass);
    MerchSubclassEntity findMerchSubclassEntitiesBySubclassAndDeleted(BigInteger subclass, String deleted);
    List<MerchSubclassEntity> findMerchSubclassesEntitiesBySubclassAndDeleted(BigInteger subclass, String deleted);
    @Query(value = "SELECT * FROM tggcsodr.merch_subclass s, tggcsodr.merch_class c where s.class = c.class and s.subclass = ?1 and c.class = ?2 and s.deleted = ?3 and c.dept = ?4", nativeQuery = true)
    MerchSubclassEntity findUniqueSubclassByClassAndSubclassAndDeletedAndDept(BigInteger subclass, BigInteger clazz, String deleted, BigInteger dept);
}
