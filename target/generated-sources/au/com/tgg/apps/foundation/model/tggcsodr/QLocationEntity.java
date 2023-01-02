package au.com.tgg.apps.foundation.model.tggcsodr;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QLocationEntity is a Querydsl query type for LocationEntity
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QLocationEntity extends EntityPathBase<LocationEntity> {

    private static final long serialVersionUID = -1466477976L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QLocationEntity locationEntity = new QLocationEntity("locationEntity");

    public final StringPath contactEmailAddr = createString("contactEmailAddr");

    public final StringPath contactFirstName = createString("contactFirstName");

    public final StringPath contactLastName = createString("contactLastName");

    public final StringPath contactTitle = createString("contactTitle");

    public final StringPath crcInd = createString("crcInd");

    public final DateTimePath<java.sql.Timestamp> createdDate = createDateTime("createdDate", java.sql.Timestamp.class);

    public final StringPath createdUser = createString("createdUser");

    public final StringPath invName = createString("invName");

    public final DateTimePath<java.sql.Timestamp> lastUpdateDate = createDateTime("lastUpdateDate", java.sql.Timestamp.class);

    public final StringPath lastUpdateUser = createString("lastUpdateUser");

    public final NumberPath<java.math.BigInteger> legacyCatalogueId = createNumber("legacyCatalogueId", java.math.BigInteger.class);

    public final NumberPath<java.math.BigInteger> locationId = createNumber("locationId", java.math.BigInteger.class);

    public final NumberPath<Double> locationLatitude = createNumber("locationLatitude", Double.class);

    public final NumberPath<Double> locationLongitude = createNumber("locationLongitude", Double.class);

    public final QLocationStateEntity locationStateEntity;

    public final StringPath locnAcctDescr1 = createString("locnAcctDescr1");

    public final StringPath locnActiveInd = createString("locnActiveInd");

    public final StringPath locnAddr1 = createString("locnAddr1");

    public final StringPath locnAddr2 = createString("locnAddr2");

    public final StringPath locnBusinessNbr = createString("locnBusinessNbr");

    public final StringPath locnCompanyName = createString("locnCompanyName");

    public final StringPath locnCompanyNbr = createString("locnCompanyNbr");

    public final StringPath locnDescr = createString("locnDescr");

    public final StringPath locnFax = createString("locnFax");

    public final StringPath locnName = createString("locnName");

    public final NumberPath<java.math.BigInteger> locnNbr = createNumber("locnNbr", java.math.BigInteger.class);

    public final StringPath locnPhone = createString("locnPhone");

    public final StringPath locnPostCode = createString("locnPostCode");

    public final StringPath locnSecurityGroup = createString("locnSecurityGroup");

    public final StringPath locnSecurityGroupName = createString("locnSecurityGroupName");

    public final NumberPath<java.math.BigInteger> locnSeekId = createNumber("locnSeekId", java.math.BigInteger.class);

    public final StringPath locnSuburb = createString("locnSuburb");

    public final StringPath mapUrl = createString("mapUrl");

    public final StringPath propEmailAddr = createString("propEmailAddr");

    public final NumberPath<java.math.BigInteger> regionalManagerId = createNumber("regionalManagerId", java.math.BigInteger.class);

    public final StringPath replacementStore = createString("replacementStore");

    public final DatePath<java.sql.Date> storeCloseDate = createDate("storeCloseDate", java.sql.Date.class);

    public final DatePath<java.sql.Date> storeOpenDate = createDate("storeOpenDate", java.sql.Date.class);

    public final StringPath storeType = createString("storeType");

    public final StringPath timezoneName = createString("timezoneName");

    public final StringPath webContactEmailAddr = createString("webContactEmailAddr");

    public final StringPath wscStatus = createString("wscStatus");

    public QLocationEntity(String variable) {
        this(LocationEntity.class, forVariable(variable), INITS);
    }

    public QLocationEntity(Path<? extends LocationEntity> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QLocationEntity(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QLocationEntity(PathMetadata metadata, PathInits inits) {
        this(LocationEntity.class, metadata, inits);
    }

    public QLocationEntity(Class<? extends LocationEntity> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.locationStateEntity = inits.isInitialized("locationStateEntity") ? new QLocationStateEntity(forProperty("locationStateEntity"), inits.get("locationStateEntity")) : null;
    }

}

