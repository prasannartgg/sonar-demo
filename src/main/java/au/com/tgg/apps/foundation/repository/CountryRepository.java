package au.com.tgg.apps.foundation.repository;

import au.com.tgg.apps.foundation.model.tggcsodr.CountryEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.math.BigInteger;

public interface CountryRepository extends CrudRepository<CountryEntity, Long> {
    CountryEntity findCountryEntityByCountryCode(String countryCode);
    @Query(value = "SELECT gst_rate FROM tggcsodr.country where inv_name = ?1", nativeQuery = true)
    BigInteger findGstRateByInvName(String inv_name);
}
