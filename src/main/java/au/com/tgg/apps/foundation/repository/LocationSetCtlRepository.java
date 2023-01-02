package au.com.tgg.apps.foundation.repository;

import au.com.tgg.apps.foundation.model.tggcsodr.LocationSetCtlEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface LocationSetCtlRepository extends CrudRepository<LocationSetCtlEntity, Long> {
    List<LocationSetCtlEntity> findLocationSetCtlEntityByLocnSetName(String locnSetName);
}
