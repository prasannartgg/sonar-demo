package au.com.tgg.apps.foundation.service.impl;

import au.com.tgg.apps.foundation.dto.ResponseDTO;
import au.com.tgg.apps.foundation.model.json.Country;
import au.com.tgg.apps.foundation.model.tggcsodr.CountryEntity;
import au.com.tgg.apps.foundation.repository.CountryRepository;
import au.com.tgg.apps.foundation.service.CrudService;
import au.com.tgg.apps.foundation.util.CopyBeanUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
public class CountryCrudServiceImpl implements CrudService<Country> {


    private final CountryRepository countryRepository;

    @Autowired
    public CountryCrudServiceImpl(CountryRepository countryRepository) {
        this.countryRepository = countryRepository;
    }

    @Override
    public ResponseDTO insert(Country country) throws Exception {
        return update(country);
    }

    @Override
    public ResponseDTO update(Country country) throws Exception {
        CountryEntity countryEntity = new CountryEntity();
        CopyBeanUtils.myCopyProperties(country, countryEntity);
        countryRepository.save(countryEntity);
        return new ResponseDTO("Country was Inserted/Updated Successfully", HttpStatus.OK, null);
    }

    @Override
    public ResponseDTO delete(Country country) throws Exception {
        CountryEntity countryEntity = new CountryEntity();
        BeanUtils.copyProperties(country, countryEntity);
        countryRepository.delete(countryEntity);
        return new ResponseDTO("Country was deleted Successfully", HttpStatus.OK, null);
    }
}
