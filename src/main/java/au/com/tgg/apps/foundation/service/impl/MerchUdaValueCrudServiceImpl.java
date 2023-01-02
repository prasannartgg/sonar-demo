package au.com.tgg.apps.foundation.service.impl;

import au.com.tgg.apps.foundation.dto.ResponseDTO;
import au.com.tgg.apps.foundation.model.json.MerchUdaValue;
import au.com.tgg.apps.foundation.model.tggcsodr.MerchUdaEntity;
import au.com.tgg.apps.foundation.model.tggcsodr.MerchUdaValueEntity;
import au.com.tgg.apps.foundation.model.tggcsodr.ProductCoreRangeEntity;
import au.com.tgg.apps.foundation.repository.MerchUdaRepository;
import au.com.tgg.apps.foundation.repository.MerchUdaValueRepository;
import au.com.tgg.apps.foundation.repository.ProductCoreRangeRepository;
import au.com.tgg.apps.foundation.service.CrudService;
import au.com.tgg.apps.foundation.util.CopyBeanUtils;
import au.com.tgg.apps.foundation.util.FoundationUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MerchUdaValueCrudServiceImpl implements CrudService<MerchUdaValue> {

    private final MerchUdaValueRepository merchUdaValueRepository;
    private final MerchUdaRepository merchUdaRepository;
    private final ProductCoreRangeRepository productCoreRangeRepository;

    @Autowired
    public MerchUdaValueCrudServiceImpl(MerchUdaValueRepository merchUdaValueRepository, MerchUdaRepository merchUdaRepository, ProductCoreRangeRepository productCoreRangeRepository) {
        this.merchUdaValueRepository = merchUdaValueRepository;
        this.merchUdaRepository = merchUdaRepository;
        this.productCoreRangeRepository = productCoreRangeRepository;
    }

    @Override
    public ResponseDTO insert(MerchUdaValue merchUdaValue) throws Exception {
        return update(merchUdaValue);
    }

    @Override
    public ResponseDTO update(MerchUdaValue merchUdaValue) throws Exception {
        MerchUdaValueEntity merchUdaValueEntity;
        MerchUdaEntity merchUdaEntity = merchUdaRepository.findMerchUdaBySourceUdaId(merchUdaValue.getUdaId());

        //PRODUCT_CORE_RANGE Insert
        if (merchUdaEntity.getSourceUdaId() != null && merchUdaEntity.getUdaCode().equalsIgnoreCase("RANGING_FLAG_AUS")) {
            ProductCoreRangeEntity productCoreRangeEntity;
            productCoreRangeEntity = productCoreRangeRepository.findProductCoreRangeEntityByProdCoreRange(merchUdaValue.getUdaValueCode());
            if (productCoreRangeEntity == null) {
                productCoreRangeEntity = new ProductCoreRangeEntity();
            }
            productCoreRangeEntity.setProdCoreRange(merchUdaValue.getUdaValueCode());
            productCoreRangeEntity.setDescription(merchUdaValue.getUdaValueDesc());
            productCoreRangeEntity.setLastUpdateDate(FoundationUtil.localDateTime());
            productCoreRangeEntity.setLastUpdateUser(FoundationUtil.USER);
            productCoreRangeRepository.save(productCoreRangeEntity);
            return new ResponseDTO("ProductCoreRange was Inserted/Updated Successfully", HttpStatus.OK, null);
        }

        List<MerchUdaValueEntity> merchUdaValueEntityList = merchUdaValueRepository.findMerchUdaValueEntitiesByMerchUdaEntityAndSourceUdaValueId(merchUdaEntity, merchUdaValue.getSourceUdaValueId());
        if (merchUdaValueEntityList.size() == 0) {
            merchUdaValueEntity = new MerchUdaValueEntity();
            merchUdaValueEntity.setCreatedDate(FoundationUtil.localDateTime());
            merchUdaValueEntity.setCreatedBy(FoundationUtil.USER);
        } else {
            merchUdaValueEntity = merchUdaValueEntityList.get(0);
        }
        CopyBeanUtils.myCopyProperties(merchUdaValue, merchUdaValueEntity);
        merchUdaValueEntity.setSourceUdaId(merchUdaValue.getUdaId());
        merchUdaValueEntity.setLastModifiedDate(FoundationUtil.localDateTime());
        merchUdaValueEntity.setLastModifiedBy(FoundationUtil.USER);
        merchUdaValueEntity.setMerchUdaEntity(merchUdaEntity);
        merchUdaValueRepository.save(merchUdaValueEntity);
        return new ResponseDTO("MerchUdaValue was Inserted/Updated Successfully", HttpStatus.OK, null);
    }

    @Override
    public ResponseDTO delete(MerchUdaValue merchUdaValue) throws Exception {
        MerchUdaEntity merchUdaEntity = merchUdaRepository.findMerchUdaBySourceUdaId(merchUdaValue.getUdaId());
        MerchUdaValueEntity merchUdaValueEntity = new MerchUdaValueEntity();
        merchUdaValueEntity.setLastModifiedDate(FoundationUtil.localDateTime());
        merchUdaValueEntity.setLastModifiedBy(FoundationUtil.USER);
        BeanUtils.copyProperties(merchUdaValue, merchUdaValueEntity);
        merchUdaValueEntity.setDeleted("Y");
        List<MerchUdaValueEntity> merchUdaValueEntityList = merchUdaValueRepository.findMerchUdaValueEntitiesByUdaIdAndSourceUdaValueId(merchUdaEntity.getUdaId(), merchUdaValue.getSourceUdaValueId());
        if (merchUdaEntity == null || merchUdaValueEntityList == null || merchUdaValueEntityList.size() == 0) {
            return new ResponseDTO("Exception encountered Deleting: MerchUdaValue", HttpStatus.INTERNAL_SERVER_ERROR, merchUdaValue);
        } else {
            merchUdaValueEntityList.forEach(a -> {
                merchUdaValueRepository.save(a);
            });
            return new ResponseDTO("MerchUdaValue was Deleted Successfully", HttpStatus.OK, null);
        }
    }
}
