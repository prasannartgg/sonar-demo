package au.com.tgg.apps.foundation.service.impl;

import au.com.tgg.apps.foundation.dto.ResponseDTO;
import au.com.tgg.apps.foundation.model.json.Brand;
import au.com.tgg.apps.foundation.model.tggcsodr.BrandEntity;
import au.com.tgg.apps.foundation.repository.BrandRepository;
import au.com.tgg.apps.foundation.service.CrudService;
import au.com.tgg.apps.foundation.util.CopyBeanUtils;
import au.com.tgg.apps.foundation.util.FoundationJatClient;
import au.com.tgg.apps.foundation.util.FoundationUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
public class BrandCrudServiceImpl implements CrudService<Brand> {

    private final BrandRepository brandRepository;
    private final FoundationJatClient foundationJatClient;


    @Autowired
    public BrandCrudServiceImpl(BrandRepository brandRepository, FoundationJatClient foundationJatClient) {
        this.brandRepository = brandRepository;
        this.foundationJatClient = foundationJatClient;
    }

    @Override
    public ResponseDTO insert(Brand brand) throws Exception {
        return update(brand);
    }


    @Override
    public ResponseDTO update(Brand brand) throws Exception {
        BrandEntity brandEntity;
        if (brandRepository.findBrandEntitiesByBrandCode(brand.getBrandName()).isEmpty()) {
            brandEntity = new BrandEntity();
            brandEntity.setCreatedUser(brandEntity.getCreatedUser());
            brandEntity.setCreatedDate(FoundationUtil.localDateTime());
            brandEntity.setCreatedId(brandEntity.getCreatedId());
        } else {
            brandEntity = brandRepository.findBrandEntitiesByBrandCode(brand.getBrandName()).get(0);
        }
        CopyBeanUtils.myCopyProperties(brand, brandEntity);
        brandEntity.setBrandCode(brand.getBrandName().toUpperCase());
        brandEntity.setLastUpdateDate(FoundationUtil.localDateTime());
        brandEntity.setLastUpdateUser(brand.getLastUpdateUser());
        brandRepository.save(brandEntity);
        brandRepository.save(brandEntity);
        foundationJatClient.refreshCache("brand",
                brandEntity.getBrandCode(),
                String.format("brand/brand-code/%s", brandEntity.getBrandCode())).subscribe();
        return new ResponseDTO("Brand was Inserted/Updated Successfully", HttpStatus.OK, null);
    }

    @Override
    public ResponseDTO delete(Brand brand) throws Exception {
        return null;
    }
}
