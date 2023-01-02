package au.com.tgg.apps.foundation.service.impl;

import au.com.tgg.apps.foundation.dto.ResponseDTO;
import au.com.tgg.apps.foundation.model.json.MerchUdaHierDefault;
import au.com.tgg.apps.foundation.model.tggcsodr.MerchUdaHierDefaultEntity;
import au.com.tgg.apps.foundation.repository.MerchUdaHierDefaultRepository;
import au.com.tgg.apps.foundation.service.CrudService;
import au.com.tgg.apps.foundation.util.CopyBeanUtils;
import au.com.tgg.apps.foundation.util.FoundationUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.math.BigInteger;

@Service
public class MerchUdaHierDefaultCrudServiceImpl implements CrudService<MerchUdaHierDefault> {
    /* Manually Maintained */

    private final MerchUdaHierDefaultRepository merchUdaHierDefaultRepository;

    @Autowired
    public MerchUdaHierDefaultCrudServiceImpl(MerchUdaHierDefaultRepository merchUdaHierDefaultRepository) {
        this.merchUdaHierDefaultRepository = merchUdaHierDefaultRepository;
    }

    @Override
    public ResponseDTO insert(MerchUdaHierDefault merchUdaHierDefault) throws Exception {
        MerchUdaHierDefaultEntity merchUdaHierDefaultEntity = new MerchUdaHierDefaultEntity();
        CopyBeanUtils.myCopyProperties(merchUdaHierDefault, merchUdaHierDefaultEntity);
        merchUdaHierDefaultEntity.setCreatedDate(FoundationUtil.localDateTime());
        merchUdaHierDefaultEntity.setLastModifiedDate(FoundationUtil.localDateTime());
        merchUdaHierDefaultEntity.setCreatedBy(FoundationUtil.USER);
        merchUdaHierDefaultEntity.setLastModifiedBy(FoundationUtil.USER);
        if (merchUdaHierDefaultRepository.findMerchUdaHierDefaultEntityBySubclassIdAndClassIdAndDepIdAndUdaValueId(merchUdaHierDefault.getSubclassId(),
                merchUdaHierDefault.getClassId(), merchUdaHierDefault.getClassId(), merchUdaHierDefault.getUdaValueId()).size() == 0) {
            merchUdaHierDefaultRepository.save(merchUdaHierDefaultEntity);
            return new ResponseDTO("MerchUdaHierDefault was inserted Successfully", HttpStatus.OK, null);
        } else {
            return new ResponseDTO("Exception encountered Inserted: MerchUdaHierDefault", HttpStatus.INTERNAL_SERVER_ERROR, merchUdaHierDefault);
        }
    }

    @Override
    public ResponseDTO update(MerchUdaHierDefault merchUdaHierDefault) throws Exception {
        merchUdaHierDefault.setUdaHierDefId(null);
        MerchUdaHierDefaultEntity merchUdaHierDefaultEntity = merchUdaHierDefaultRepository.findMerchUdaHierDefaultEntityBySubclassIdAndClassIdAndDepIdAndUdaValueId(merchUdaHierDefault.getSubclassId(),
                merchUdaHierDefault.getClassId(), merchUdaHierDefault.getClassId(), merchUdaHierDefault.getUdaValueId()).get(0);
        CopyBeanUtils.myCopyProperties(merchUdaHierDefault, merchUdaHierDefaultEntity);
        merchUdaHierDefaultEntity.setLastModifiedDate(FoundationUtil.localDateTime());
        merchUdaHierDefaultEntity.setLastModifiedBy(FoundationUtil.USER);
        BigInteger merchUdaHierDefaultId = merchUdaHierDefaultEntity.getUdaHierDefId();
        if (merchUdaHierDefaultId != null) {
            merchUdaHierDefaultEntity.setUdaHierDefId(merchUdaHierDefaultId);
            merchUdaHierDefaultRepository.save(merchUdaHierDefaultEntity);
            return new ResponseDTO("MerchUdaHierDefault was updated Successfully", HttpStatus.OK, null);
        } else {
            return new ResponseDTO("Exception encountered Updating: MerchUdaHierDefault", HttpStatus.INTERNAL_SERVER_ERROR, merchUdaHierDefault);
        }
    }

    @Override
    public ResponseDTO delete(MerchUdaHierDefault merchUdaHierDefault) throws Exception {
        MerchUdaHierDefaultEntity merchUdaHierDefaultEntity = new MerchUdaHierDefaultEntity();
        merchUdaHierDefaultEntity.setLastModifiedDate(FoundationUtil.localDateTime());
        merchUdaHierDefaultEntity.setLastModifiedBy(FoundationUtil.USER);
        BeanUtils.copyProperties(merchUdaHierDefault, merchUdaHierDefaultEntity);
        BigInteger merchUdaHierDefaultId = merchUdaHierDefaultRepository.findMerchUdaHierDefaultEntityBySubclassIdAndClassIdAndDepIdAndUdaValueId(merchUdaHierDefault.getSubclassId(),
                merchUdaHierDefault.getClassId(), merchUdaHierDefault.getClassId(), merchUdaHierDefault.getUdaValueId()).get(0).getUdaHierDefId();
        if (merchUdaHierDefaultId != null) {
            merchUdaHierDefaultEntity.setUdaHierDefId(merchUdaHierDefaultId);
            merchUdaHierDefaultEntity.setDeleted("Y");
            merchUdaHierDefaultRepository.save(merchUdaHierDefaultEntity);
            return new ResponseDTO("MerchUdaHierDefault was Deleted Successfully", HttpStatus.OK, null);
        } else {
            return new ResponseDTO("Exception encountered Deleting: MerchUdaHierDefault", HttpStatus.INTERNAL_SERVER_ERROR, merchUdaHierDefault);
        }
    }
}
