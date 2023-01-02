package au.com.tgg.apps.foundation.service.impl;

import au.com.tgg.apps.foundation.dto.ResponseDTO;
import au.com.tgg.apps.foundation.model.json.LocationStateMapping;
import au.com.tgg.apps.foundation.model.tggcsodr.LocationEntity;
import au.com.tgg.apps.foundation.model.tggcsodr.LocationStateEntity;
import au.com.tgg.apps.foundation.model.tggcsodr.LocationStateMappingEntity;
import au.com.tgg.apps.foundation.repository.LocationRepository;
import au.com.tgg.apps.foundation.repository.LocationStateMappingRepository;
import au.com.tgg.apps.foundation.repository.LocationStateRepository;
import au.com.tgg.apps.foundation.service.CrudService;
import au.com.tgg.apps.foundation.util.CopyBeanUtils;
import au.com.tgg.apps.foundation.util.FoundationUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.List;

@Service
public class LocationStateMappingCrudServiceImpl implements CrudService<LocationStateMapping> {
    /* Manually Maintained */

    private final LocationRepository locationRepository;
    private final LocationStateRepository locationStateRepository;
    private final LocationStateMappingRepository locationStateMappingRepository;

    @Autowired
    public LocationStateMappingCrudServiceImpl(LocationRepository locationRepository, LocationStateRepository locationStateRepository, LocationStateMappingRepository locationStateMappingRepository) {
        this.locationRepository = locationRepository;
        this.locationStateRepository = locationStateRepository;
        this.locationStateMappingRepository = locationStateMappingRepository;
    }

    @Override
    public ResponseDTO insert(LocationStateMapping locationStateMapping) throws Exception {
        return update(locationStateMapping);
    }

    @Override
    public ResponseDTO update(LocationStateMapping locationStateMapping) throws Exception {
        locationStateMapping.setLocationStateMappingId(null);
        LocationEntity locationEntity = null;
        LocationStateEntity locationStateEntity = null;
        LocationStateMappingEntity locationStateMappingEntity;

        if (!locationRepository.findLocationEntitiesByLocnName(locationStateMapping.getLocationXX()).isEmpty()) {
            locationEntity = locationRepository.findLocationEntitiesByLocnName(locationStateMapping.getLocationXX()).get(0);
        }
        if (!locationStateRepository.findLocationStateEntitiesByStateCode(locationStateMapping.getStateXX()).isEmpty()) {
            locationStateEntity = locationStateRepository.findLocationStateEntitiesByStateCode(locationStateMapping.getStateXX()).get(0);
        }

        List<LocationStateMappingEntity> locationStateMappingEntityList = locationStateMappingRepository.findLocationStateMappingEntityByLocationIdAndAndLocationStateId(locationEntity.getLocationId(), locationStateEntity.getLocationStateId());


        if (!locationStateMappingEntityList.isEmpty() && locationStateMappingEntityList != null) {
            locationStateMappingEntity = locationStateMappingEntityList.get(0);
        } else {
            locationStateMappingEntity = new LocationStateMappingEntity();
            locationStateMappingEntity.setCreatedDate(FoundationUtil.localDateTime());
            locationStateMappingEntity.setCreatedUser(FoundationUtil.USER);
        }

        CopyBeanUtils.myCopyProperties(locationStateMapping, locationStateMappingEntity);

        if (locationEntity != null) {
            locationStateMappingEntity.setLocationId(locationEntity.getLocationId());
            locationStateMappingEntity.setLocnName(locationEntity.getLocnName());
        }
        if (locationStateEntity != null) {
            locationStateMappingEntity.setLocationStateId(locationStateEntity.getLocationStateId());
        }

        locationStateMappingRepository.save(locationStateMappingEntity);
        return new ResponseDTO("LocationStateMapping was Inserted/Updated Successfully", HttpStatus.OK, null);
    }

    @Override
    public ResponseDTO delete(LocationStateMapping locationStateMapping) throws Exception {
        LocationStateMappingEntity locationStateMappingEntity = new LocationStateMappingEntity();
        BeanUtils.copyProperties(locationStateMapping, locationStateMappingEntity);
        BigInteger location_state_mapping_id = locationStateMappingRepository.findLocationStateMappingEntityByLocationIdAndAndLocationStateId(locationStateMapping.getLocationId(), locationStateMapping.getLocationStateId()).get(0).getLocationStateMappingId();
        if (location_state_mapping_id != null) {
            locationStateMappingEntity.setLocationStateMappingId(location_state_mapping_id);
            locationStateMappingRepository.delete(locationStateMappingEntity);
            return new ResponseDTO("LocationStateMapping was Deleted Successfully", HttpStatus.OK, null);
        } else {
            return new ResponseDTO("Exception encountered Deleting: LocationStateMapping", HttpStatus.INTERNAL_SERVER_ERROR, locationStateMapping);
        }
    }
}
