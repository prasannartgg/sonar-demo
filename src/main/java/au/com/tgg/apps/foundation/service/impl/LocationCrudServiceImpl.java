package au.com.tgg.apps.foundation.service.impl;


import au.com.tgg.apps.foundation.dto.ResponseDTO;
import au.com.tgg.apps.foundation.model.json.Location;
import au.com.tgg.apps.foundation.model.json.StoreAddress;
import au.com.tgg.apps.foundation.model.tggcsodr.LocationEntity;
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
import java.sql.Date;
import java.sql.Timestamp;

@Service
public class LocationCrudServiceImpl implements CrudService<Location> {

    private final LocationStateRepository locationStateRepository;
    private final LocationRepository locationRepository;
    private final FoundationJatClient foundationJatClient;


    @Autowired
    public LocationCrudServiceImpl(LocationStateRepository locationStateRepository, LocationRepository locationRepository, FoundationJatClient foundationJatClient) {
        this.locationStateRepository = locationStateRepository;
        this.locationRepository = locationRepository;
        this.foundationJatClient = foundationJatClient;
    }

    @Override
    public ResponseDTO insert(Location location) throws Exception {
        return update(location);
    }

    @Override
    public ResponseDTO update(Location location) throws Exception {
        LocationEntity locationEntity = null;
        String formated = String.format("%03d", location.getLocnNbr());

        if (!locationRepository.findLocationEntitiesByLocnName(location.getLocnName()).isEmpty()) {
            locationEntity = locationRepository.findLocationEntitiesByLocnName(location.getLocnName()).get(0);

        } else {
            locationEntity = new LocationEntity();
            locationEntity.setCreatedDate(new Timestamp(System.currentTimeMillis()));
            locationEntity.setCreatedUser(FoundationUtil.USER);
            locationEntity.setInvName(FoundationUtil.INV_NAME);
//           if (!locationEntity.getLocnName().equalsIgnoreCase("902")) {
            locationEntity.setCrcInd("N");
//            }
//            else if (locationEntity.getLocnName().equalsIgnoreCase("902")) {
//                locationEntity.setCrcInd("Y");
//            }

        }
        CopyBeanUtils.myCopyProperties(location, locationEntity);
        locationEntity.setLastUpdateDate(new Timestamp(System.currentTimeMillis()));
        locationEntity.setLastUpdateUser(FoundationUtil.USER);
        locationEntity.setWscStatus("READY");
        locationEntity.setInvName(FoundationUtil.INV_NAME);
        if (location.getStoreOpenDate() != null) {
            locationEntity.setStoreOpenDate(Date.valueOf(location.getStoreOpenDate().toLocalDateTime().toLocalDate()));
        }
        if (location.getStoreCloseDate() != null) {
            locationEntity.setStoreCloseDate(Date.valueOf(location.getStoreCloseDate().toLocalDateTime().toLocalDate()));
        }
        if (location.getStoreAddressList() != null) {
            if (!location.getStoreAddressList().isEmpty()) {
                for (StoreAddress address : location.getStoreAddressList()) {
                    if (address.getAddrType().equalsIgnoreCase("01") && address.getPrimaryAddrInd().equalsIgnoreCase("Y")) {
                        locationEntity.setLocationStateEntity(locationStateRepository.findLocationStateEntityByStateName(address.getStateName()));
                        locationEntity.setLocnAddr1(address.getAdd1());
                        locationEntity.setLocnAddr2(address.getAdd2());
                        locationEntity.setLocnSuburb(address.getCity());
                        locationEntity.setLocnPostCode(address.getPost());
                        locationEntity.setLocnPhone(address.getContactPhone());
                        locationEntity.setContactEmailAddr(address.getContactEmail());
                    }
                }
            }
        }

        locationEntity.setCreatedUser("foundation");
        location.setLastUpdateUser("foundation");
        if (locationEntity.getLocnName() != null) {
            locationRepository.save(locationEntity);
            foundationJatClient.refreshCache("location",
                    locationEntity.getLocnNbr().toString(),
                    String.format("location/locn-nbr/%s", locationEntity.getLocnNbr())).subscribe();
            foundationJatClient.evictCache("location", "ALL").subscribe();
            return new ResponseDTO("Location was Inserted/Updated Successfully", HttpStatus.OK, null);
        } else {
            return new ResponseDTO("Exception encountered Inserting/Updating: Location", HttpStatus.INTERNAL_SERVER_ERROR, location);
        }
    }

    @Override
    public ResponseDTO delete(Location location) throws Exception {
        LocationEntity locationEntity = new LocationEntity();
        locationEntity.setLastUpdateDate(new Timestamp(System.currentTimeMillis()));
        locationEntity.setLastUpdateUser(FoundationUtil.USER);
        BeanUtils.copyProperties(location, locationEntity);
        BigInteger locationId = locationRepository.findLocationEntitiesByLocnName(locationEntity.getLocnName()).get(0).getLocationId();
        if (locationId != null) {
            locationEntity.setLocationId(locationId);
            locationEntity.setLocnActiveInd("N");
            locationRepository.save(locationEntity);
            foundationJatClient.refreshCache("location",
                    locationEntity.getLocnNbr().toString(),
                    String.format("location/locn-nbr/%s", locationEntity.getLocnNbr())).subscribe();
            return new ResponseDTO("Location was deleted Successfully", HttpStatus.OK, null);
        } else {
            return new ResponseDTO("Exception encountered Deleting: Location", HttpStatus.INTERNAL_SERVER_ERROR, location);
        }
    }
}
