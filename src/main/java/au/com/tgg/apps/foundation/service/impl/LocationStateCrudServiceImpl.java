package au.com.tgg.apps.foundation.service.impl;

import au.com.tgg.apps.foundation.dto.ResponseDTO;
import au.com.tgg.apps.foundation.model.json.LocationState;
import au.com.tgg.apps.foundation.model.tggcsodr.LocationStateEntity;
import au.com.tgg.apps.foundation.repository.CountryRepository;
import au.com.tgg.apps.foundation.repository.LocationRepository;
import au.com.tgg.apps.foundation.repository.LocationStateRepository;
import au.com.tgg.apps.foundation.service.CrudService;
import au.com.tgg.apps.foundation.util.CopyBeanUtils;
import au.com.tgg.apps.foundation.util.FoundationJatClient;
import au.com.tgg.apps.foundation.util.FoundationUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.math.BigInteger;

@Service
public class LocationStateCrudServiceImpl implements CrudService<LocationState> {
    /* Manually Maintained */

    private final LocationStateRepository locationStateRepository;
    private final CountryRepository countryRepository;
    private final FoundationJatClient foundationJatClient;
    private LocationRepository locationRepository;

    @Autowired
    public LocationStateCrudServiceImpl(LocationStateRepository locationStateRepository, CountryRepository countryRepository, FoundationJatClient foundationJatClient) {
        this.locationStateRepository = locationStateRepository;
        this.countryRepository = countryRepository;
        this.foundationJatClient = foundationJatClient;
    }

    @Override
    public ResponseDTO insert(LocationState locationState) throws Exception {
        return update(locationState);
    }

    @Override
    public ResponseDTO update(LocationState locationState) throws Exception {
        LocationStateEntity locationStateEntity;
        if (locationStateRepository.findLocationStateEntityByStateCode(locationState.getStateCode()) != null) {
            locationStateEntity = locationStateRepository.findLocationStateEntitiesByStateCode(locationState.getStateCode()).get(0);
        } else {
            locationStateEntity = new LocationStateEntity();
            locationStateEntity.setCreatedDate(FoundationUtil.localDateTime());
            locationStateEntity.setCreatedUser(FoundationUtil.USER);
        }

        CopyBeanUtils.myCopyProperties(locationState, locationStateEntity);
        locationStateEntity.setCountryEntity(countryRepository.findCountryEntityByCountryCode(locationState.getCountryCode()));
        locationStateEntity.setLastUpdateDate(FoundationUtil.localDateTime());
        locationStateEntity.setLastUpdateUser(FoundationUtil.USER);

        if (locationStateEntity != null) {
            locationStateRepository.save(locationStateEntity);
            foundationJatClient.refreshCache("locationState",
                    locationStateEntity.getStateCode(),
                    String.format("/api/location-state/state-code/%s", locationStateEntity.getStateCode())).subscribe();
            return new ResponseDTO("LocationState was Inserted/Updated Successfully", HttpStatus.OK, null);
        } else {
            return new ResponseDTO("Exception encountered Inserting/Updating: LocationState", HttpStatus.INTERNAL_SERVER_ERROR, locationState);
        }
    }

    @Override
    public ResponseDTO delete(LocationState locationState) throws Exception {
        LocationStateEntity locationStateEntity = new LocationStateEntity();
        locationStateEntity.setCreatedDate(FoundationUtil.localDateTime());
        locationStateEntity.setLastUpdateDate(FoundationUtil.localDateTime());
        locationStateEntity.setCreatedUser(FoundationUtil.USER);
        locationStateEntity.setLastUpdateUser(FoundationUtil.USER);
        BeanUtils.copyProperties(locationState, locationStateEntity);
        BigInteger location_state_id = locationStateRepository.findLocationStateEntitiesByStateCode(locationStateEntity.getStateCode()).get(0).getLocationStateId();
        if (location_state_id != null) {
            locationStateEntity.setLocationStateId(location_state_id);
            locationStateRepository.delete(locationStateEntity);
            return new ResponseDTO("LocationState was Deleted Successfully", HttpStatus.OK, null);
        } else {
            return new ResponseDTO("Exception encountered Deleting: LocationState", HttpStatus.INTERNAL_SERVER_ERROR, locationState);
        }
    }
}
