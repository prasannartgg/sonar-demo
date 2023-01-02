package au.com.tgg.apps.foundation.service.impl;

import au.com.tgg.apps.foundation.dto.ResponseDTO;
import au.com.tgg.apps.foundation.model.json.LocationSetDtl;
import au.com.tgg.apps.foundation.model.tggcsodr.LocationEntity;
import au.com.tgg.apps.foundation.model.tggcsodr.LocationSetCtlEntity;
import au.com.tgg.apps.foundation.model.tggcsodr.LocationSetDtlEntity;
import au.com.tgg.apps.foundation.repository.LocationRepository;
import au.com.tgg.apps.foundation.repository.LocationSetCtlRepository;
import au.com.tgg.apps.foundation.repository.LocationSetDtlRepository;
import au.com.tgg.apps.foundation.service.CrudService;
import au.com.tgg.apps.foundation.util.CopyBeanUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.List;

@Service
public class LocationSetDtlCrudServiceImpl implements CrudService<LocationSetDtl> {
    /* Manually Maintained */

    private final LocationSetCtlRepository locationSetCtlRepository;
    private final LocationRepository locationRepository;
    private final LocationSetDtlRepository locationSetDtlRepository;

    @Autowired
    public LocationSetDtlCrudServiceImpl(LocationSetCtlRepository locationSetCtlRepository, LocationRepository locationRepository, LocationSetDtlRepository locationSetDtlRepository) {
        this.locationSetCtlRepository = locationSetCtlRepository;
        this.locationRepository = locationRepository;
        this.locationSetDtlRepository = locationSetDtlRepository;
    }

    @Override
    public ResponseDTO insert(LocationSetDtl locationSetDtl) throws Exception {
        return update(locationSetDtl);
    }

    @Override
    public ResponseDTO update(LocationSetDtl locationSetDtl) throws Exception {
        LocationSetCtlEntity locationSetCtlEntity = new LocationSetCtlEntity();
        LocationEntity locationEntity = new LocationEntity();
        LocationSetDtlEntity locationSetDtlEntity;


        if (!locationSetCtlRepository.findLocationSetCtlEntityByLocnSetName(locationSetDtl.getLocationSetXX()).isEmpty()) {
            locationSetCtlEntity = locationSetCtlRepository.findLocationSetCtlEntityByLocnSetName(locationSetDtl.getLocationSetXX()).get(0);
        }
        if (!locationRepository.findLocationEntitiesByLocnName(locationSetDtl.getLocnName()).isEmpty()) {
            locationEntity = locationRepository.findLocationEntitiesByLocnName(locationSetDtl.getLocnName()).get(0);
        }


        List<LocationSetDtlEntity> locationSetDtlEntities = locationSetDtlRepository.findLocationSetDtlEntityByLocationIdAndAndLocationSetId(locationEntity.getLocationId(), locationSetCtlEntity.getLocationSetId());
        if (locationSetDtlEntities.size() > 0 && !locationSetDtlEntities.isEmpty()) {
            locationSetDtlEntity = locationSetDtlEntities.get(0);
        } else {
            locationSetDtlEntity = new LocationSetDtlEntity();
        }
        if (locationEntity != null && locationSetCtlEntity != null) {
            CopyBeanUtils.myCopyProperties(locationSetDtl, locationSetDtlEntity);
            locationSetDtlEntity.setLocationId(locationEntity.getLocationId());
            locationSetDtlEntity.setLocationSetId(locationSetCtlEntity.getLocationSetId());

            locationSetDtlRepository.save(locationSetDtlEntity);
            return new ResponseDTO("LocationSetDtl was Inserted/Updated Successfully", HttpStatus.OK, null);
        }
        return new ResponseDTO("Exception encountered Inserting/Updating: LocationSetDtl", HttpStatus.INTERNAL_SERVER_ERROR, locationSetDtl);
    }

    @Override
    public ResponseDTO delete(LocationSetDtl locationSetDtl) throws Exception {
        LocationSetDtlEntity locationSetDtlEntity = new LocationSetDtlEntity();
        BeanUtils.copyProperties(locationSetDtl, locationSetDtlEntity);
        BigInteger locationSetDtlId = locationSetDtlRepository.findLocationSetDtlEntityByLocationIdAndAndLocationSetId(locationSetDtl.getLocationId(), locationSetDtl.getLocationSetDtlId()).get(0).getLocationSetId();
        if (locationSetDtlId != null) {
            locationSetDtlEntity.setLocationSetId(locationSetDtlId);
            locationSetDtlRepository.delete(locationSetDtlEntity);
            return new ResponseDTO("LocationSetDtl was Deleted Successfully", HttpStatus.OK, null);
        } else {
            return new ResponseDTO("Exception encountered Deleting: LocationSetDtl", HttpStatus.INTERNAL_SERVER_ERROR, locationSetDtl);
        }
    }
}
