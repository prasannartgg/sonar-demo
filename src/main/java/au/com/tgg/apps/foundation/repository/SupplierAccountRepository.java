package au.com.tgg.apps.foundation.repository;

import au.com.tgg.apps.foundation.model.tggcsodr.SupplierAccountEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface SupplierAccountRepository extends CrudRepository<SupplierAccountEntity, Long> {
    List<SupplierAccountEntity> findSupplierAccountEntityByAccountNumber(@Param("account_number") String account_number);

}
