package au.com.tgg.apps.foundation.service.impl;

import au.com.tgg.apps.foundation.dto.ResponseDTO;
import au.com.tgg.apps.foundation.model.json.MerchDeps;
import au.com.tgg.apps.foundation.model.tggcsodr.MerchDepsEntity;
import au.com.tgg.apps.foundation.repository.MerchDepsRepository;
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
public class MerchDepsCrudServiceImpl implements CrudService<MerchDeps> {

    private final MerchDepsRepository merchDepsRepository;
    private final FoundationJatClient foundationJatClient;


    @Autowired
    public MerchDepsCrudServiceImpl(MerchDepsRepository merchDepsRepository, FoundationJatClient foundationJatClient) {
        this.merchDepsRepository = merchDepsRepository;
        this.foundationJatClient = foundationJatClient;
    }


    @Override
    public ResponseDTO insert(MerchDeps merchDeps) throws Exception {
        return update(merchDeps);
    }

    @Override
    public ResponseDTO update(MerchDeps merchDeps) throws Exception {
        MerchDepsEntity merchDepsEntity = null;
        String deleted = String.valueOf('N');
        if (!merchDepsRepository.findMerchDepsEntityByDeptAndDeleted(merchDeps.getDept(), deleted).isEmpty() && merchDepsRepository.findMerchDepsEntityByDeptAndDeleted(merchDeps.getDept(), deleted) != null) {
            merchDepsEntity = merchDepsRepository.findMerchDepsEntityByDeptAndDeleted(merchDeps.getDept(), deleted).get(0);
        } else {
            merchDepsEntity = new MerchDepsEntity();
            merchDepsEntity.setCreatedBy(FoundationUtil.USER);
            merchDepsEntity.setCreatedDate(FoundationUtil.localDateTime());

        }
        CopyBeanUtils.myCopyProperties(merchDeps, merchDepsEntity);
        merchDepsEntity.setLastModifiedDate(FoundationUtil.localDateTime());
        merchDepsEntity.setLastModifiedBy(FoundationUtil.USER);
        if (merchDepsEntity != null) {
            merchDepsRepository.save(merchDepsEntity);
            foundationJatClient.refreshCache("merchDeps",
                    merchDepsEntity.getDept().toString(),
                    String.format("merch-deps/dept/%s", merchDepsEntity.getDept())).subscribe();
            return new ResponseDTO("MerchDeps was Inserted/Updated Successfully", HttpStatus.OK, null);
        } else {
            return new ResponseDTO("Exception encountered Inserting/Updating: MerchDeps", HttpStatus.INTERNAL_SERVER_ERROR, merchDeps);
        }
    }

    @Override
    public ResponseDTO delete(MerchDeps merchDeps) throws Exception {
        MerchDepsEntity merchDepsEntity = new MerchDepsEntity();
        merchDepsEntity.setLastModifiedDate(FoundationUtil.localDateTime());
        merchDepsEntity.setLastModifiedBy(FoundationUtil.USER);
        BeanUtils.copyProperties(merchDeps, merchDepsEntity);
        String deleted = String.valueOf('N');
        BigInteger depId = merchDepsRepository.findMerchDepsEntityByDeptAndDeleted(merchDeps.getDept(), deleted).get(0).getDepId();
        if (depId != null) {
            merchDepsEntity.setDepId(depId);
            merchDepsEntity.setDeleted("Y");
            merchDepsRepository.save(merchDepsEntity);
            foundationJatClient.evictCache("merchDeps", merchDepsEntity.getDepId().toString()).subscribe();
            return new ResponseDTO("MerchDeps was Deleted Successfully", HttpStatus.OK, null);
        } else {
            return new ResponseDTO("Exception encountered Deleting: MerchDeps", HttpStatus.INTERNAL_SERVER_ERROR, merchDeps);
        }
    }
}
