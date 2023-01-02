package au.com.tgg.apps.foundation.service.impl;


import au.com.tgg.apps.foundation.dto.ResponseDTO;
import au.com.tgg.apps.foundation.model.json.StoreInfo;
import au.com.tgg.apps.foundation.model.tggcsodr.LocationEntity;
import au.com.tgg.apps.foundation.repository.LocationRepository;
import au.com.tgg.apps.foundation.service.CrudService;
import au.com.tgg.apps.foundation.util.FoundationJatClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
public class StoreInfoCrudServiceImpl implements CrudService<StoreInfo> {

    private final LocationRepository locationRepository;
    private final FoundationJatClient foundationJatClient;

    @Autowired
    public StoreInfoCrudServiceImpl(LocationRepository locationRepository, FoundationJatClient foundationJatClient) {
        this.locationRepository = locationRepository;
        this.foundationJatClient = foundationJatClient;
    }

    @Override
    public ResponseDTO insert(StoreInfo storeInfo) throws Exception {
        return update(storeInfo);
    }

    @Override
    public ResponseDTO update(StoreInfo storeInfo) throws Exception {

        System.out.println(storeInfo.getLocnName());
        LocationEntity locationEntity = locationRepository.findLocationEntitiesByLocnName(storeInfo.getLocnName()).get(0);
        if (storeInfo.getWhouseLocnInd().equalsIgnoreCase("N")) {
            locationEntity.setStoreType("SS");
        } else if (storeInfo.getWhouseLocnInd().equalsIgnoreCase("Y")) {
            locationEntity.setStoreType("CW");
        }
        locationEntity.setLocationLongitude(storeInfo.getLocnLon());
        locationEntity.setLocationLatitude(storeInfo.getLocnLat());
        locationEntity.setLocnBusinessNbr(storeInfo.getLocnBusinessNbr().replaceAll(" ", ""));
        if (locationEntity.getLocationId() != null) {
            locationRepository.save(locationEntity);
            foundationJatClient.refreshCache("location",
                    locationEntity.getLocnNbr().toString(),
                    String.format("location/locn-nbr/%s", locationEntity.getLocnNbr())).subscribe();
            foundationJatClient.evictCache("location", "ALL").subscribe();
            return new ResponseDTO("StoreInfo was Inserted/Updated Successfully", HttpStatus.OK, null);
        } else {
            return new ResponseDTO("Exception encountered Inserting/Updating: StoreInfo", HttpStatus.INTERNAL_SERVER_ERROR, storeInfo);
        }
    }

    @Override
    public ResponseDTO delete(StoreInfo storeInfo) throws Exception {
        return null;
    }
}
