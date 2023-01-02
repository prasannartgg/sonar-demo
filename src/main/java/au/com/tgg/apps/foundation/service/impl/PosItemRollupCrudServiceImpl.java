package au.com.tgg.apps.foundation.service.impl;

import au.com.tgg.apps.foundation.dto.ResponseDTO;
import au.com.tgg.apps.foundation.model.json.PosItemRollup;
import au.com.tgg.apps.foundation.model.tggcsodr.PosItemRollupEntity;
import au.com.tgg.apps.foundation.model.tggcsodr.ProductEntity;
import au.com.tgg.apps.foundation.repository.PosItemRollupRepository;
import au.com.tgg.apps.foundation.repository.ProductRepository;
import au.com.tgg.apps.foundation.service.CrudService;
import au.com.tgg.apps.foundation.util.CopyBeanUtils;
import au.com.tgg.apps.foundation.util.FoundationUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
public class PosItemRollupCrudServiceImpl implements CrudService<PosItemRollup> {
    /* Manually Maintained */

    private final ProductRepository productRepository;
    private final PosItemRollupRepository posItemRollupRepository;

    @Autowired
    public PosItemRollupCrudServiceImpl(ProductRepository productRepository, PosItemRollupRepository posItemRollupRepository) {
        this.productRepository = productRepository;
        this.posItemRollupRepository = posItemRollupRepository;
    }

    @Override
    public ResponseDTO insert(PosItemRollup posItemRollup) throws Exception {
        PosItemRollupEntity posItemRollupEntity = new PosItemRollupEntity();
        CopyBeanUtils.myCopyProperties(posItemRollup, posItemRollupEntity);
        posItemRollupEntity.setCreatedDatetime(FoundationUtil.localDateTime());
        posItemRollupEntity.setLastModifiedDatetime(FoundationUtil.localDateTime());
        ProductEntity productEntity = productRepository.findProductEntityByProdNbr(posItemRollupEntity.getProd_nbr()).get(0);

        if (posItemRollup.getProductId() != null) {
//                posItemRollupRepository.insertPostItemRollUpEntity(productEntity.getProductId(), posItemRollupEntity.getWebReady(),
//                        posItemRollupEntity.getWebReadyB2B(),
//                        posItemRollupEntity.getOnhandQty(),
//                        posItemRollupEntity.getPickComQty(),
//                        posItemRollupEntity.getBkordComQty(),
//                        posItemRollupEntity.getHoldComQty(),
//                        posItemRollupEntity.getOutboundQty(),
//                        posItemRollupEntity.getWebMinQty(),
//                        posItemRollupEntity.getLastRecptDatei(),
//                        posItemRollupEntity.getNatWebOnhandQty(),
//                        posItemRollupEntity.getVicWebOnhandQuantity(),
//                        posItemRollupEntity.getTasWebOnhandQuantity(),
//                        posItemRollupEntity.getQldWebOnhandQuantity(),
//                        posItemRollupEntity.getNswWebOnhandQuantity(),
//                        posItemRollupEntity.getActWebOnhandQuantity(),
//                        posItemRollupEntity.getWaWebOnhandQuantity(),
//                        posItemRollupEntity.getSaWebOnhandQuantity(),
//                        posItemRollupEntity.getNtWebOnhandQuantity(),
//                        posItemRollupEntity.getCreatedDatetime(),
//                        posItemRollupEntity.getLastModifiedDatetime(),
//                        posItemRollupEntity.getOnhandVal(),
//                        posItemRollupEntity.getOnorderQty(),
//                        posItemRollupEntity.getOnorderVal(),
//                        posItemRollupEntity.getOnhandAvgVal(),
//                        posItemRollupEntity.getLastSaleDatei(),
//                        posItemRollupEntity.getOnhandMedianVal(),
//                        posItemRollupEntity.getProd_nbr(), "inv_name");
            return new ResponseDTO("PosItemRollup was Inserted/Updated Successfully", HttpStatus.OK, null);
        } else {
            return new ResponseDTO("Exception encountered Inserting/Updating: PosItemRollup", HttpStatus.INTERNAL_SERVER_ERROR, posItemRollup);
        }
    }

    @Override
    public ResponseDTO update(PosItemRollup posItemRollup) throws Exception {
        PosItemRollupEntity posItemRollupEntity = new PosItemRollupEntity();
        CopyBeanUtils.myCopyProperties(posItemRollup, posItemRollupEntity);
        posItemRollupEntity.setLastModifiedDatetime(FoundationUtil.localDateTime());
        if (posItemRollup.getProductId() != null) {
            posItemRollupRepository.save(posItemRollupEntity);
            return new ResponseDTO("PosItemRollup was Inserted/Updated Successfully", HttpStatus.OK, null);
        } else {
            return new ResponseDTO("Exception encountered Inserting/Updating: PosItemRollup", HttpStatus.INTERNAL_SERVER_ERROR, posItemRollup);
        }
    }

    @Override
    public ResponseDTO delete(PosItemRollup posItemRollup) throws Exception {
        PosItemRollupEntity posItemRollupEntity = new PosItemRollupEntity();
        posItemRollupEntity.setLastModifiedDatetime(FoundationUtil.localDateTime());
        BeanUtils.copyProperties(posItemRollup, posItemRollupEntity);
        if (posItemRollup.getProductId() != null) {
            posItemRollupRepository.delete(posItemRollupEntity);
            return new ResponseDTO("PosItemRollup was Deleted Successfully", HttpStatus.OK, null);
        } else {
            return new ResponseDTO("Delete PosItemRollup - Exception", HttpStatus.INTERNAL_SERVER_ERROR, posItemRollup);
        }
    }
}
