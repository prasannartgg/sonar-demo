package au.com.tgg.apps.foundation.repository;

import au.com.tgg.apps.foundation.model.tggcsodr.LocationStateMappingEntity;
import org.springframework.data.repository.CrudRepository;

import java.math.BigInteger;
import java.util.List;

public interface LocationStateMappingRepository extends CrudRepository<LocationStateMappingEntity, Long> {
    List<LocationStateMappingEntity> findLocationStateMappingEntityByLocationIdAndAndLocationStateId(BigInteger locationId, BigInteger stateId);
}
