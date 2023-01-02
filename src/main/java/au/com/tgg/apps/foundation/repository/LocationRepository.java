package au.com.tgg.apps.foundation.repository;

import au.com.tgg.apps.foundation.model.tggcsodr.LocationEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface LocationRepository extends CrudRepository<LocationEntity, Long> {
    List<LocationEntity> findLocationEntitiesByLocnName(String locnName);
}
