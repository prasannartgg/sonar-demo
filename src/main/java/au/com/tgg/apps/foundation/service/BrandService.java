package au.com.tgg.apps.foundation.service;

import au.com.tgg.apps.foundation.model.Brand;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.util.MultiValueMap;

import java.util.List;

public interface BrandService {

    Brand getBrand(String brandCode);

    List<Brand> getAllBrands();

    Page<Brand> getPageableBrands(Pageable pageable);

    Page<Brand> getBrandPage(Pageable pageable, MultiValueMap<String, String> parameters);
}
