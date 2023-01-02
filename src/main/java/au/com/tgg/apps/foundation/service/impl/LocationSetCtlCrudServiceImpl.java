package au.com.tgg.apps.foundation.service.impl;

import au.com.tgg.apps.foundation.dto.ResponseDTO;
import au.com.tgg.apps.foundation.model.json.LocationSetCtl;
import au.com.tgg.apps.foundation.model.tggcsodr.LocationSetCtlEntity;
import au.com.tgg.apps.foundation.repository.LocationSetCtlRepository;
import au.com.tgg.apps.foundation.service.CrudService;
import au.com.tgg.apps.foundation.util.CopyBeanUtils;
import au.com.tgg.apps.foundation.util.FoundationUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LocationSetCtlCrudServiceImpl implements CrudService<LocationSetCtl> {
    /* Manually Maintained */

    private final LocationSetCtlRepository locationSetCtlRepository;

    @Autowired
    public LocationSetCtlCrudServiceImpl(LocationSetCtlRepository locationSetCtlRepository) {
        this.locationSetCtlRepository = locationSetCtlRepository;
    }

    @Override
    public ResponseDTO insert(LocationSetCtl locationSetCtl) throws Exception {
        return update(locationSetCtl);
    }

    @Override
    public ResponseDTO update(LocationSetCtl locationSetCtl) throws Exception {
        LocationSetCtlEntity locationSetCtlEntity;
        if (!locationSetCtlRepository.findLocationSetCtlEntityByLocnSetName(locationSetCtl.getLocnSetName()).isEmpty() && locationSetCtlRepository.findLocationSetCtlEntityByLocnSetName(locationSetCtl.getLocnSetName()) != null) {
            locationSetCtlEntity = locationSetCtlRepository.findLocationSetCtlEntityByLocnSetName(locationSetCtl.getLocnSetName()).get(0);
        } else {
            locationSetCtlEntity = new LocationSetCtlEntity();
            locationSetCtlEntity.setCreatedDate(FoundationUtil.localDateTime());
            locationSetCtlEntity.setCreatedUser(FoundationUtil.USER);
        }
        CopyBeanUtils.myCopyProperties(locationSetCtl, locationSetCtlEntity);
        locationSetCtlEntity.setLastUpdateDate(FoundationUtil.localDateTime());
        locationSetCtlEntity.setLastUpdateUser(FoundationUtil.USER);

        locationSetCtlRepository.save(locationSetCtlEntity);
        return new ResponseDTO("LocationSetCtl was Inserted/Updated Successfully", HttpStatus.OK, null);

    }

    @Override
    public ResponseDTO delete(LocationSetCtl locationSetCtl) throws Exception {
        List<LocationSetCtlEntity> locationSetCtlEntity = locationSetCtlRepository.findLocationSetCtlEntityByLocnSetName(locationSetCtl.getLocnSetName());
        if (!locationSetCtlEntity.isEmpty()) {
            locationSetCtlRepository.delete(locationSetCtlEntity.get(0));
            return new ResponseDTO("LocationSetCtl was Deleted Successfully", HttpStatus.OK, null);
        } else {
            return new ResponseDTO("Exception encountered Deleting: LocationSetCtl", HttpStatus.INTERNAL_SERVER_ERROR, locationSetCtl);
        }
    }
}
