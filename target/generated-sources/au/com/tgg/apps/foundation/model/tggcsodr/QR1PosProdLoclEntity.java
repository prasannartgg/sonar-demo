package au.com.tgg.apps.foundation.model.tggcsodr;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QR1PosProdLoclEntity is a Querydsl query type for R1PosProdLoclEntity
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QR1PosProdLoclEntity extends EntityPathBase<R1PosProdLoclEntity> {

    private static final long serialVersionUID = -15944277L;

    public static final QR1PosProdLoclEntity r1PosProdLoclEntity = new QR1PosProdLoclEntity("r1PosProdLoclEntity");

    public final StringPath abcClass = createString("abcClass");

    public final StringPath accnbri = createString("accnbri");

    public final StringPath activeIssInd = createString("activeIssInd");

    public final StringPath activeProdInd = createString("activeProdInd");

    public final StringPath activePurchInd = createString("activePurchInd");

    public final StringPath activeReplenInd = createString("activeReplenInd");

    public final StringPath activeSalInd = createString("activeSalInd");

    public final StringPath activeTrsfrInd = createString("activeTrsfrInd");

    public final NumberPath<java.math.BigDecimal> bkordComQty = createNumber("bkordComQty", java.math.BigDecimal.class);

    public final DateTimePath<java.sql.Timestamp> crdatei = createDateTime("crdatei", java.sql.Timestamp.class);

    public final StringPath crterm = createString("crterm");

    public final NumberPath<java.math.BigDecimal> crtime = createNumber("crtime", java.math.BigDecimal.class);

    public final StringPath cruser = createString("cruser");

    public final StringPath crwindow = createString("crwindow");

    public final StringPath custMsgText = createString("custMsgText");

    public final StringPath custMsgType = createString("custMsgType");

    public final NumberPath<java.math.BigDecimal> fulfillQty = createNumber("fulfillQty", java.math.BigDecimal.class);

    public final NumberPath<java.math.BigDecimal> holdComQty = createNumber("holdComQty", java.math.BigDecimal.class);

    public final NumberPath<java.math.BigDecimal> inboundQty = createNumber("inboundQty", java.math.BigDecimal.class);

    public final NumberPath<Double> inboundVal = createNumber("inboundVal", Double.class);

    public final NumberPath<java.math.BigDecimal> inPendComQty = createNumber("inPendComQty", java.math.BigDecimal.class);

    public final DateTimePath<java.sql.Timestamp> lastModDatei = createDateTime("lastModDatei", java.sql.Timestamp.class);

    public final StringPath lastModTerm = createString("lastModTerm");

    public final NumberPath<Long> lastModTime = createNumber("lastModTime", Long.class);

    public final StringPath lastModUser = createString("lastModUser");

    public final StringPath lastModWindow = createString("lastModWindow");

    public final DatePath<java.time.LocalDate> lastRecptDatei = createDate("lastRecptDatei", java.time.LocalDate.class);

    public final NumberPath<java.math.BigDecimal> lastRecptQty = createNumber("lastRecptQty", java.math.BigDecimal.class);

    public final NumberPath<Double> lastRecptVal = createNumber("lastRecptVal", Double.class);

    public final DatePath<java.time.LocalDate> lastSaleDatei = createDate("lastSaleDatei", java.time.LocalDate.class);

    public final NumberPath<java.math.BigDecimal> lastSaleQty = createNumber("lastSaleQty", java.math.BigDecimal.class);

    public final NumberPath<Double> lastSaleVal = createNumber("lastSaleVal", Double.class);

    public final DatePath<java.time.LocalDate> lastTrsfrInDate = createDate("lastTrsfrInDate", java.time.LocalDate.class);

    public final NumberPath<java.math.BigDecimal> lastTrsfrInQty = createNumber("lastTrsfrInQty", java.math.BigDecimal.class);

    public final NumberPath<Double> lastTrsfrInVal = createNumber("lastTrsfrInVal", Double.class);

    public final StringPath ldgCode = createString("ldgCode");

    public final NumberPath<java.math.BigDecimal> lockedQty = createNumber("lockedQty", java.math.BigDecimal.class);

    public final NumberPath<java.math.BigDecimal> loclProdId = createNumber("loclProdId", java.math.BigDecimal.class);

    public final NumberPath<Long> locnNbr = createNumber("locnNbr", Long.class);

    public final NumberPath<java.math.BigDecimal> maxLvlQty = createNumber("maxLvlQty", java.math.BigDecimal.class);

    public final NumberPath<java.math.BigDecimal> minLvlQty = createNumber("minLvlQty", java.math.BigDecimal.class);

    public final NumberPath<java.math.BigDecimal> onhandAvgVal = createNumber("onhandAvgVal", java.math.BigDecimal.class);

    public final NumberPath<java.math.BigDecimal> onhandQty = createNumber("onhandQty", java.math.BigDecimal.class);

    public final NumberPath<Double> onhandVal = createNumber("onhandVal", Double.class);

    public final StringPath orideAcctInd = createString("orideAcctInd");

    public final NumberPath<java.math.BigDecimal> outboundQty = createNumber("outboundQty", java.math.BigDecimal.class);

    public final NumberPath<Double> outboundVal = createNumber("outboundVal", Double.class);

    public final NumberPath<java.math.BigDecimal> pickComQty = createNumber("pickComQty", java.math.BigDecimal.class);

    public final NumberPath<java.math.BigDecimal> plpcPrc = createNumber("plpcPrc", java.math.BigDecimal.class);

    public final NumberPath<java.math.BigDecimal> pordComQty = createNumber("pordComQty", java.math.BigDecimal.class);

    public final NumberPath<Double> pordComVal = createNumber("pordComVal", Double.class);

    public final StringPath prodNbr = createString("prodNbr");

    public final NumberPath<java.math.BigDecimal> rebateValue = createNumber("rebateValue", java.math.BigDecimal.class);

    public final NumberPath<java.math.BigDecimal> reordLvlQty = createNumber("reordLvlQty", java.math.BigDecimal.class);

    public final NumberPath<java.math.BigDecimal> semPrc = createNumber("semPrc", java.math.BigDecimal.class);

    public final NumberPath<java.math.BigDecimal> supCode = createNumber("supCode", java.math.BigDecimal.class);

    public final StringPath supProdNbr = createString("supProdNbr");

    public final NumberPath<java.math.BigDecimal> sysTid = createNumber("sysTid", java.math.BigDecimal.class);

    public final StringPath techoneFld1 = createString("techoneFld1");

    public final StringPath techoneFld2 = createString("techoneFld2");

    public final NumberPath<java.math.BigDecimal> techoneFld3 = createNumber("techoneFld3", java.math.BigDecimal.class);

    public final NumberPath<java.math.BigDecimal> techoneFld4 = createNumber("techoneFld4", java.math.BigDecimal.class);

    public final DateTimePath<java.sql.Timestamp> techoneFld5 = createDateTime("techoneFld5", java.sql.Timestamp.class);

    public final NumberPath<java.math.BigDecimal> ticketPrc = createNumber("ticketPrc", java.math.BigDecimal.class);

    public final NumberPath<java.math.BigDecimal> vers = createNumber("vers", java.math.BigDecimal.class);

    public final NumberPath<java.math.BigDecimal> webComQty = createNumber("webComQty", java.math.BigDecimal.class);

    public final NumberPath<java.math.BigDecimal> webMinQty = createNumber("webMinQty", java.math.BigDecimal.class);

    public final StringPath webReady = createString("webReady");

    public final NumberPath<Long> workorderTmplId = createNumber("workorderTmplId", Long.class);

    public QR1PosProdLoclEntity(String variable) {
        super(R1PosProdLoclEntity.class, forVariable(variable));
    }

    public QR1PosProdLoclEntity(Path<? extends R1PosProdLoclEntity> path) {
        super(path.getType(), path.getMetadata());
    }

    public QR1PosProdLoclEntity(PathMetadata metadata) {
        super(R1PosProdLoclEntity.class, metadata);
    }

}

