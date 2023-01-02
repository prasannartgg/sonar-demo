package au.com.tgg.apps.foundation.service.impl;

import au.com.tgg.apps.foundation.dto.ResponseDTO;
import au.com.tgg.apps.foundation.model.json.MerchUda;
import au.com.tgg.apps.foundation.model.tggcsodr.MerchUdaEntity;
import au.com.tgg.apps.foundation.repository.MerchUdaRepository;
import au.com.tgg.apps.foundation.service.CrudService;
import au.com.tgg.apps.foundation.util.CopyBeanUtils;
import au.com.tgg.apps.foundation.util.FoundationUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.List;

@Service
public class MerchUdaCrudServiceImpl implements CrudService<MerchUda> {

    private final MerchUdaRepository merchUdaRepository;

    @Autowired
    public MerchUdaCrudServiceImpl(MerchUdaRepository merchUdaRepository) {
        this.merchUdaRepository = merchUdaRepository;
    }

    @Override
    public ResponseDTO insert(MerchUda merchUda) throws Exception {
        return update(merchUda);
    }

    @Override
    public ResponseDTO update(MerchUda merchUda) throws Exception {
        MerchUdaEntity merchUdaEntity;
        List<MerchUdaEntity> merchUdaEntityList = merchUdaRepository.findMerchUdaEntitiesBySourceUdaId(merchUda.getSourceUdaId());
        if (merchUdaEntityList.size() == 0) {
            merchUdaEntity = new MerchUdaEntity();
            merchUdaEntity.setCreatedBy(FoundationUtil.USER);
            merchUdaEntity.setCreatedDate(FoundationUtil.localDateTime());
        } else {
            merchUdaEntity = merchUdaEntityList.get(0);
        }
        CopyBeanUtils.myCopyProperties(merchUda, merchUdaEntity);
        merchUdaEntity.setLastModifiedDate(FoundationUtil.localDateTime());
        merchUdaEntity.setLastModifiedBy(FoundationUtil.USER);
        merchUdaEntity.setDate(FoundationUtil.localDateTime());
        if (merchUda.getUdaCode() != null) {
            merchUdaEntity.setUdaCode(merchUda.getUdaCode().toUpperCase().replace(" ", "_"));
        }
        merchUdaRepository.save(merchUdaEntity);
        return new ResponseDTO("MerchUda was Inserted/Updated Successfully", HttpStatus.OK, null);
    }

    @Override
    public ResponseDTO delete(MerchUda merchUda) throws Exception {
        MerchUdaEntity merchUdaEntity = new MerchUdaEntity();
        BigInteger merchUdaId = merchUdaRepository.findMerchUdaEntitiesBySourceUdaId(merchUda.getSourceUdaId()).get(0).getUdaId();
        BeanUtils.copyProperties(merchUda, merchUdaEntity);
        merchUdaEntity.setLastModifiedDate(FoundationUtil.localDateTime());
        merchUdaEntity.setLastModifiedBy(FoundationUtil.USER);
        merchUdaEntity.setDeleted("Y");
        if (merchUdaId != null) {
            merchUdaEntity.setUdaId(merchUdaId);
            merchUdaRepository.save(merchUdaEntity);
            return new ResponseDTO("MerchUda was Deleted Successfully", HttpStatus.OK, null);
        } else {
            return new ResponseDTO("Exception encountered Deleting: MerchUda", HttpStatus.INTERNAL_SERVER_ERROR, merchUda);
        }
    }
}
