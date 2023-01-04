package au.com.tgg.apps.foundation.service.impl;

import au.com.tgg.apps.foundation.model.Brand;
import au.com.tgg.apps.foundation.repository.BrandRepository;
import au.com.tgg.apps.foundation.service.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.util.MultiValueMap;

import java.util.List;
import java.util.Objects;

@Service
public class BrandServiceImpl implements BrandService {

    private final BrandRepository brandRepository;

    @Autowired
    public BrandServiceImpl(BrandRepository brandRepository) {
        this.brandRepository = brandRepository;
    }


    @Override
    public Brand getBrand(String brandCode) {
//        Brand brand = brandRepository.findBrandEntitiesByBrandName(brandCode);
//        if(brand==null){
//            throw new TggApiRuntimeException("No brand found");
//        }
        return null;
    }

    @Override
    public List<Brand> getAllBrands() {
        return null;
    }

    @Override
    public Page<Brand> getPageableBrands(Pageable pageable) {
        return null;
    }

    @Override
    public Page<Brand> getBrandPage(Pageable pageable, MultiValueMap<String, String> parameters) {

        return null;
    }
}
