package au.com.tgg.apps.foundation.service.impl;

import au.com.tgg.apps.foundation.dto.ResponseDTO;
import au.com.tgg.apps.foundation.model.json.MerchSubclass;
import au.com.tgg.apps.foundation.model.tggcsodr.MerchSubclassEntity;
import au.com.tgg.apps.foundation.repository.MerchClassRepository;
import au.com.tgg.apps.foundation.repository.MerchSubclassRepository;
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
public class MerchSubclassCrudServiceImpl implements CrudService<MerchSubclass> {

    private final FoundationJatClient foundationJatClient;
    private final MerchSubclassRepository merchSubclassRepository;
    private final MerchClassRepository merchClassRepository;


    @Autowired
    public MerchSubclassCrudServiceImpl(MerchSubclassRepository merchSubclassRepository, MerchClassRepository merchClassRepository, FoundationJatClient foundationJatClient) {
        this.merchSubclassRepository = merchSubclassRepository;
        this.merchClassRepository = merchClassRepository;
        this.foundationJatClient = foundationJatClient;
    }

    @Override
    public ResponseDTO insert(MerchSubclass merchSubclass) throws Exception {
        return update(merchSubclass);
    }

    @Override
    public ResponseDTO update(MerchSubclass merchSubclass) throws Exception {
        MerchSubclassEntity merchSubclassEntity = null;
        String deleted = String.valueOf('N');
        if (!merchSubclassRepository.findMerchSubclassesEntitiesBySubclassAndDeleted(merchSubclass.getSubclass(), deleted).isEmpty() && merchSubclassRepository.findMerchSubclassesEntitiesBySubclassAndDeleted(merchSubclass.getSubclass(), deleted) != null) {
            merchSubclassEntity = merchSubclassRepository.findMerchSubclassesEntitiesBySubclassAndDeleted(merchSubclass.getSubclass(), deleted).get(0);
        } else {
            merchSubclassEntity = new MerchSubclassEntity();
            merchSubclassEntity.setCreatedBy(FoundationUtil.USER);
            merchSubclassEntity.setCreatedDate(FoundationUtil.localDateTime());
        }
        CopyBeanUtils.myCopyProperties(merchSubclass, merchSubclassEntity);
        if (merchClassRepository.findMerchClassEntityByClazzAndDeleted(merchSubclass.getClassId(), deleted).isEmpty() && merchClassRepository.findMerchClassEntityByClazzAndDeleted(merchSubclass.getClassId(), deleted) == null) {
            return new ResponseDTO("Exception encountered: No MerchClass exists for the MerchSubClass to be inserted", HttpStatus.I_AM_A_TEAPOT, merchSubclass);
        }
        merchSubclassEntity.setMerchClass(merchClassRepository.findMerchClassEntityByClazzAndDeleted(merchSubclass.getClassId(), deleted).get(0));
        merchSubclassEntity.setClazz(merchSubclass.getClassId());
        merchSubclassEntity.setLastModifiedDate(FoundationUtil.localDateTime());
        merchSubclassEntity.setLastModifiedBy(FoundationUtil.USER);

        if (merchSubclassEntity != null) {
            merchSubclassRepository.save(merchSubclassEntity);
            foundationJatClient.refreshCache("merchSubclass",
                    merchSubclassEntity.getSubclass().toString(),
                    String.format("merch-subclass/subclass/%s", merchSubclassEntity.getSubclass())).subscribe();
            return new ResponseDTO("MerchSubclass was Inserted/Updated Successfully", HttpStatus.OK, null);
        } else {
            return new ResponseDTO("Exception encountered Inserting/Updating: MerchSubclass", HttpStatus.INTERNAL_SERVER_ERROR, merchSubclass);
        }
    }

    @Override
    public ResponseDTO delete(MerchSubclass merchSubclass) throws Exception {
        MerchSubclassEntity merchSubclassEntity = new MerchSubclassEntity();
        merchSubclassEntity.setLastModifiedDate(FoundationUtil.localDateTime());
        merchSubclassEntity.setLastModifiedBy(FoundationUtil.USER);
        BeanUtils.copyProperties(merchSubclass, merchSubclassEntity);
        String deleted = String.valueOf('N');
        BigInteger subclass = merchSubclassRepository.findMerchSubclassesEntitiesBySubclassAndDeleted(merchSubclass.getSubclass(), deleted).get(0).getSubclass();
        if (subclass != null) {
            merchSubclassEntity.setSubclass(subclass);
            merchSubclassEntity.setDeleted("Y");
            merchSubclassRepository.save(merchSubclassEntity);
            foundationJatClient.evictCache("merchSubclass", merchSubclassEntity.getSubclassId().toString()).subscribe();
            return new ResponseDTO("MerchSubclass was Deleted Successfully", HttpStatus.OK, null);
        } else {
            return new ResponseDTO("Exception encountered Deleting: MerchSubclass", HttpStatus.INTERNAL_SERVER_ERROR, merchSubclass);
        }
    }
}
