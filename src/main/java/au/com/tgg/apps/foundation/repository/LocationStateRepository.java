package au.com.tgg.apps.foundation.repository;

import au.com.tgg.apps.foundation.model.tggcsodr.LocationStateEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface LocationStateRepository extends CrudRepository<LocationStateEntity, Long> {
    List<LocationStateEntity> findLocationStateEntitiesByStateCode(String stateCode);
    LocationStateEntity findLocationStateEntityByStateCode(String stateCode);
    LocationStateEntity findLocationStateEntityByStateName(String stateName);
}
