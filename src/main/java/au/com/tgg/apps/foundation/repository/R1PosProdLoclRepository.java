package au.com.tgg.apps.foundation.repository;

import au.com.tgg.apps.foundation.model.tggcsodr.R1PosProdLoclEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface R1PosProdLoclRepository extends CrudRepository<R1PosProdLoclEntity, Long> {
    List<R1PosProdLoclEntity> findR1PosProdLoclEntitiesByProdNbrAndLocnNbr(String prodNbr, Long locnNbr);
    R1PosProdLoclEntity findR1PosProdLoclEntityByProdNbrAndLocnNbr(String prodNbr, Long locnNbr);
}
