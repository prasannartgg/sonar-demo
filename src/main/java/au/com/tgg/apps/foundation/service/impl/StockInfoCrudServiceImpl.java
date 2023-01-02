package au.com.tgg.apps.foundation.service.impl;

import au.com.tgg.apps.foundation.dto.ResponseDTO;
import au.com.tgg.apps.foundation.model.json.StockInfo;
import au.com.tgg.apps.foundation.model.tggcsodr.R1PosProdLoclEntity;
import au.com.tgg.apps.foundation.repository.R1PosProdLoclRepository;
import au.com.tgg.apps.foundation.service.CrudService;
import au.com.tgg.apps.foundation.util.CopyBeanUtils;
import au.com.tgg.apps.foundation.util.FoundationJatClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;

@Service
public class StockInfoCrudServiceImpl implements CrudService<StockInfo> {

    private final FoundationJatClient foundationJatClient;
    private final R1PosProdLoclRepository r1PosProdLoclRepository;


    @Autowired
    public StockInfoCrudServiceImpl(R1PosProdLoclRepository r1PosProdLoclRepository, FoundationJatClient foundationJatClient) {
        this.r1PosProdLoclRepository = r1PosProdLoclRepository;
        this.foundationJatClient = foundationJatClient;
    }

    @Override
    public ResponseDTO insert(StockInfo stockInfo) throws Exception {
        return null;
    }

    @Override
    public ResponseDTO update(StockInfo stockInfo) throws Exception {
        R1PosProdLoclEntity r1PosProdLoclEntity;

        r1PosProdLoclEntity = r1PosProdLoclRepository.findR1PosProdLoclEntityByProdNbrAndLocnNbr(stockInfo.getProdNbr(), stockInfo.getLocnNbr());
        //update
        if (r1PosProdLoclEntity == null) {
            r1PosProdLoclEntity = new R1PosProdLoclEntity();
        }
        if (r1PosProdLoclEntity.getVers() == null || (r1PosProdLoclEntity.getVers() != null && r1PosProdLoclEntity.getVers().intValue() <= stockInfo.getVers().intValue())) {
            CopyBeanUtils.myCopyProperties(stockInfo, r1PosProdLoclEntity);
            r1PosProdLoclEntity.setLastModDatei(new Timestamp(System.currentTimeMillis()));
            if (stockInfo.getWebReady().isEmpty() || stockInfo.getWebReady() == "") {
                r1PosProdLoclEntity.setWebReady("N");
            }
            if (stockInfo.getOrideAcctInd().isEmpty() || stockInfo.getOrideAcctInd() == "") {
                r1PosProdLoclEntity.setOrideAcctInd("N");
            }
            r1PosProdLoclRepository.save(r1PosProdLoclEntity);
            foundationJatClient.refreshCache("r1PosProdLocl",
                    String.format("%s:%s", r1PosProdLoclEntity.getLocnNbr(), r1PosProdLoclEntity.getProdNbr()),
                    String.format("/r1-pos-prod-locl/locn-nbr/%s/prod-nbr/%s", r1PosProdLoclEntity.getLocnNbr(), r1PosProdLoclEntity.getProdNbr())).subscribe();
            foundationJatClient.refreshCache("r1PosProdLoclProdNbr",
                    String.format("%s", r1PosProdLoclEntity.getProdNbr()),
                    String.format("/r1-pos-prod-locl/prod-nbr/%s", r1PosProdLoclEntity.getProdNbr())).subscribe();

            return new ResponseDTO("StockInfo was Inserted/Updated Successfully", HttpStatus.OK, null);
        } else if (r1PosProdLoclEntity.getVers() == null || (r1PosProdLoclEntity.getVers() != null && r1PosProdLoclEntity.getVers().intValue() > stockInfo.getVers().intValue())) {
            return new ResponseDTO("StockInfoVersNoGreaterException: new versNo: " + stockInfo.getVers() + " < postgres versNo: " + r1PosProdLoclEntity.getVers() + " ; prodNbr" + stockInfo.getProdNbr(), HttpStatus.I_AM_A_TEAPOT, stockInfo);
        }
        else {
            return new ResponseDTO("Exception encountered Updating: StockInfo", HttpStatus.INTERNAL_SERVER_ERROR, stockInfo);
        }
    }

    @Override
    public ResponseDTO delete(StockInfo stockInfo) throws Exception {
        return null;
    }
}
