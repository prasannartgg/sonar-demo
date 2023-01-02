package au.com.tgg.apps.foundation.repository;

import au.com.tgg.apps.foundation.model.tggcsodr.ProductUdaMapEntity;
import org.springframework.data.repository.CrudRepository;

import java.math.BigInteger;
import java.util.List;

public interface ProductUdaMapRepository extends CrudRepository<ProductUdaMapEntity, Long> {
    List<ProductUdaMapEntity> findProductUdaMapEntitiesByProdNbrAndUdaIdAndUdaValue(String prodNbr, BigInteger udaId, BigInteger udaValueId);

    List<ProductUdaMapEntity> findProductUdaMapEntitiesByProdNbrAndUdaIdAndUdaValueAndDeleted(String prodNbr, BigInteger udaId, BigInteger udaValueId, String deleted);
    ProductUdaMapEntity findProductUdaMapEntityByProdNbrAndUdaIdAndUdaValueAndDeleted(String prodNbr, BigInteger udaId, BigInteger udaValueId, String deleted);

//    List<ProductUdaMapEntity> findProductUdaMapEntitiesByProdNbrAndUdaIdAndUdaValueId(String prodNbr, BigInteger udaId, BigInteger udaValueId);
//    List<ProductUdaMapEntity> findProductUdaMapEntitiesByProdNbrAndUdaIdAndUdaValueIdAndDeleted(String prodNbr, BigInteger udaId, BigInteger udaValueId, String deleted);

}
