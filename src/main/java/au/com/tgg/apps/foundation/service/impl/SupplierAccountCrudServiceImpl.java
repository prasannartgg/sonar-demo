package au.com.tgg.apps.foundation.service.impl;

import au.com.tgg.apps.foundation.dto.ResponseDTO;
import au.com.tgg.apps.foundation.model.json.SupplierAccount;
import au.com.tgg.apps.foundation.model.tggcsodr.SupplierAccountEntity;
import au.com.tgg.apps.foundation.repository.SupplierAccountRepository;
import au.com.tgg.apps.foundation.service.CrudService;
import au.com.tgg.apps.foundation.util.CopyBeanUtils;
import au.com.tgg.apps.foundation.util.FoundationJatClient;
import au.com.tgg.apps.foundation.util.FoundationUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.math.BigInteger;

@Service
public class SupplierAccountCrudServiceImpl implements CrudService<SupplierAccount> {

    private final SupplierAccountRepository supplierAccountRepository;
    private final FoundationJatClient foundationJatClient;

    @Autowired
    public SupplierAccountCrudServiceImpl(SupplierAccountRepository supplierAccountRepository, FoundationJatClient foundationJatClient) {
        this.supplierAccountRepository = supplierAccountRepository;
        this.foundationJatClient = foundationJatClient;
    }

    @Override
    public ResponseDTO insert(SupplierAccount supplierAccount) throws Exception {
        return update(supplierAccount);
    }

    @Override
    public ResponseDTO update(SupplierAccount supplierAccount) throws Exception {
        SupplierAccountEntity supplierAccountEntity;
        String accountNumber = supplierAccount.getAccountNumber().substring(0, supplierAccount.getAccountNumber().length()-2);
        if (supplierAccountRepository.findSupplierAccountEntityByAccountNumber(accountNumber) != null && !supplierAccountRepository.findSupplierAccountEntityByAccountNumber(accountNumber).isEmpty()) {
            supplierAccountEntity = supplierAccountRepository.findSupplierAccountEntityByAccountNumber(accountNumber).get(0);
        } else {
            supplierAccountEntity = new SupplierAccountEntity();
            supplierAccountEntity.setCreatedDate(FoundationUtil.localDateTime());
            supplierAccountEntity.setCreatedUser(FoundationUtil.USER);
        }
        CopyBeanUtils.myCopyProperties(supplierAccount, supplierAccountEntity);
        if (supplierAccount.getAccountNumber() != null && supplierAccount.getAccountNumber().substring(0, 3).startsWith("399")) {
            supplierAccountEntity.setSupLdgCode("GL");
        } else {
            supplierAccountEntity.setSupLdgCode("AP");
        }
        if (supplierAccount.getSupStatus() != null && supplierAccount.getSupStatus().equalsIgnoreCase("A")) {
            supplierAccountEntity.setSupAccActiveInd("Y");
        } else if (supplierAccount.getSupStatus() != null && supplierAccount.getSupStatus().equalsIgnoreCase("I")) {
            supplierAccountEntity.setSupAccActiveInd("N");
        }
        supplierAccountEntity.setLastUpdateDate(FoundationUtil.localDateTime());
        supplierAccountEntity.setLastUpdateUser(FoundationUtil.USER);
        if (supplierAccountEntity.getSupplierAccountId() == null) {
            supplierAccountEntity.setPpAgeOfStock(new BigInteger("1"));
            supplierAccountEntity.setPpDealParityInd("N");
        }
        supplierAccountEntity.setAccountNumber(accountNumber);
        if (supplierAccountEntity != null) {
            supplierAccountRepository.save(supplierAccountEntity);
            foundationJatClient.refreshCache("supplierAccount",
                    supplierAccountEntity.getAccountNumber(),
                    String.format("supplier-account/account-number/%s", supplierAccountEntity.getAccountNumber())).subscribe();
            return new ResponseDTO("SupplierAccount was Inserted/Updated Successfully", HttpStatus.OK, null);
        } else {
            return new ResponseDTO("Exception encountered Inserting/Updating: SupplierAccount", HttpStatus.INTERNAL_SERVER_ERROR, supplierAccount);
        }
    }

    @Override
    public ResponseDTO delete(SupplierAccount supplierAccount) throws Exception {
        SupplierAccountEntity supplierAccountEntity = new SupplierAccountEntity();
        supplierAccountEntity.setLastUpdateDate(FoundationUtil.localDateTime());
        supplierAccountEntity.setLastUpdateUser(FoundationUtil.USER);
        BeanUtils.copyProperties(supplierAccount, supplierAccountEntity);
        BigInteger supplierAccountId = supplierAccountRepository.findSupplierAccountEntityByAccountNumber(supplierAccountEntity.getAccountNumber()).get(0).getSupplierAccountId();
        if (supplierAccount != null) {
            supplierAccountEntity.setSupplierAccountId(supplierAccountId);
            supplierAccount.setSupAccActiveInd("N");
            supplierAccountRepository.save(supplierAccountEntity);
            foundationJatClient.evictCache("supplierAccount", supplierAccountEntity.getSupplierAccountId().toString()).subscribe();
            return new ResponseDTO("SupplierAccount was Deleted Successfully", HttpStatus.OK, null);
        } else {
            return new ResponseDTO("Exception encountered Deleting: SupplierAccount", HttpStatus.INTERNAL_SERVER_ERROR, supplierAccount);
        }
    }
}
