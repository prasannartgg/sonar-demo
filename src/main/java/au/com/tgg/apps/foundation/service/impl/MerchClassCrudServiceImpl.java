package au.com.tgg.apps.foundation.service.impl;

import au.com.tgg.apps.foundation.dto.ResponseDTO;
import au.com.tgg.apps.foundation.model.json.MerchClass;
import au.com.tgg.apps.foundation.model.tggcsodr.MerchClassEntity;
import au.com.tgg.apps.foundation.repository.MerchClassRepository;
import au.com.tgg.apps.foundation.repository.MerchDepsRepository;
import au.com.tgg.apps.foundation.service.CrudService;
import au.com.tgg.apps.foundation.util.CopyBeanUtils;
import au.com.tgg.apps.foundation.util.FoundationJatClient;
import au.com.tgg.apps.foundation.util.FoundationUtil;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.math.BigInteger;

@Service
public class MerchClassCrudServiceImpl implements CrudService<MerchClass> {
    private final Logger logger = LogManager.getLogger(MerchClassCrudServiceImpl.class);
    private final MerchClassRepository merchClassRepository;
    private final MerchDepsRepository merchDepsRepository;
    private final FoundationJatClient foundationJatClient;

    @Autowired
    public MerchClassCrudServiceImpl(MerchClassRepository merchClassRepository, MerchDepsRepository merchDepsRepository, FoundationJatClient foundationJatClient) {
        this.merchClassRepository = merchClassRepository;
        this.merchDepsRepository = merchDepsRepository;
        this.foundationJatClient = foundationJatClient;
    }

    @Override
    public ResponseDTO insert(MerchClass merchClass) throws Exception {
        return update(merchClass);
    }

    @Override
    public ResponseDTO update(MerchClass merchClass) throws Exception {
        MerchClassEntity merchClassEntity = null;
        String deleted = String.valueOf('N');
        if (!merchClassRepository.findMerchClassEntityByClazzAndDeleted(merchClass.getClassCode(), deleted).isEmpty() && merchClassRepository.findMerchClassEntityByClazzAndDeleted(merchClass.getClassCode(), deleted) != null) {
            merchClassEntity = merchClassRepository.findMerchClassEntityByClazzAndDeleted(merchClass.getClassCode(), deleted).get(0);
        } else {
            merchClassEntity = new MerchClassEntity();
            merchClassEntity.setCreatedBy(FoundationUtil.USER);
            merchClassEntity.setCreatedDate(FoundationUtil.localDateTime());
        }
        CopyBeanUtils.myCopyProperties(merchClass, merchClassEntity);

        if (merchDepsRepository.findMerchDepsEntityByDeptAndDeleted(merchClass.getDepId(), deleted).isEmpty() && merchDepsRepository.findMerchDepsEntityByDeptAndDeleted(merchClass.getDepId(), deleted) == null) {
            return new ResponseDTO("Exception encountered: No MerchDeps exists for the MerchClass to be inserted", HttpStatus.I_AM_A_TEAPOT, merchClass);
        }
        merchClassEntity.setLastModifiedDate(FoundationUtil.localDateTime());
        merchClassEntity.setLastModifiedBy(FoundationUtil.USER);
        merchClassEntity.setclazz(merchClass.getClassCode());
        merchClassEntity.setDept(merchClass.getDepId());
        merchClassEntity.setMerchDeps(merchDepsRepository.findMerchDepsEntityByDeptAndDeleted(merchClass.getDepId(), deleted).get(0));

        if (merchClassEntity != null) {
            merchClassRepository.save(merchClassEntity);
            foundationJatClient.refreshCache("merchClass",
                    merchClass.getClassCode().toString(),
                    String.format("merch-class/class/%s", merchClass.getClassCode())).subscribe();
            return new ResponseDTO("MerchClass was Inserted/Updated Successfully", HttpStatus.OK, null);
        } else {
            return new ResponseDTO("Exception encountered Inserting/Updating: MerchClass", HttpStatus.INTERNAL_SERVER_ERROR, merchClass);
        }

    }

    @Override
    public ResponseDTO delete(MerchClass merchClass) throws Exception {
        MerchClassEntity merchClassEntity = new MerchClassEntity();
        merchClassEntity.setLastModifiedDate(FoundationUtil.localDateTime());
        merchClassEntity.setLastModifiedBy(FoundationUtil.USER);
        BeanUtils.copyProperties(merchClass, merchClassEntity);
        String deleted = String.valueOf('N');
        BigInteger classId = merchClassRepository.findMerchClassEntityByClazzAndDeleted(merchClass.getClassCode(), deleted).get(0).getClassId();

        if (classId != null) {
            merchClassEntity.setClassId(classId);
            merchClassEntity.setDeleted("Y");
            merchClassRepository.save(merchClassEntity);
            foundationJatClient.evictCache("merchClass", merchClassEntity.getClassId().toString()).subscribe();
            return new ResponseDTO("MerchClass was Deleted Successfully", HttpStatus.OK, null);
        } else {
            return new ResponseDTO("Exception encountered Deleting: MerchClass", HttpStatus.INTERNAL_SERVER_ERROR, merchClass);
        }
    }
}
