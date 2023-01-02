package au.com.tgg.apps.foundation.repository;

import au.com.tgg.apps.foundation.model.tggcsodr.LocationSetDtlEntity;
import org.springframework.data.repository.CrudRepository;

import java.math.BigInteger;
import java.util.List;

public interface LocationSetDtlRepository extends CrudRepository<LocationSetDtlEntity, Long> {
    List<LocationSetDtlEntity> findLocationSetDtlEntityByLocationIdAndAndLocationSetId(BigInteger locationId, BigInteger locationSetId);
}
