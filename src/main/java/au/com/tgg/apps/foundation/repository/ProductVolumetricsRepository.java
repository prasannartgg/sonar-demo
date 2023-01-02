package au.com.tgg.apps.foundation.repository;

import au.com.tgg.apps.foundation.model.tggcsodr.ProductVolumetricsEntity;
import au.com.tgg.apps.foundation.model.tggcsodr.ProductVolumetricsId;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface ProductVolumetricsRepository extends CrudRepository<ProductVolumetricsEntity, ProductVolumetricsId> {

    List<ProductVolumetricsEntity> findProductVolumetricsEntityByProdNbr(String prod_nbr);
    @Transactional
    void deleteByProdNbr( String prod_nbr);

}
