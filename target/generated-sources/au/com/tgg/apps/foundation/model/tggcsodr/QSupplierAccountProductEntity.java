package au.com.tgg.apps.foundation.model.tggcsodr;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QSupplierAccountProductEntity is a Querydsl query type for SupplierAccountProductEntity
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QSupplierAccountProductEntity extends EntityPathBase<SupplierAccountProductEntity> {

    private static final long serialVersionUID = 130666209L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QSupplierAccountProductEntity supplierAccountProductEntity = new QSupplierAccountProductEntity("supplierAccountProductEntity");

    public final StringPath brandCode = createString("brandCode");

    public final QBrandEntity brandEntity;

    public final StringPath concierge = createString("concierge");

    public final StringPath consumerProdNbr = createString("consumerProdNbr");

    public final NumberPath<Double> costExPrice = createNumber("costExPrice", Double.class);

    public final DateTimePath<java.time.LocalDateTime> createdDate = createDateTime("createdDate", java.time.LocalDateTime.class);

    public final StringPath createdUser = createString("createdUser");

    public final DatePath<java.sql.Date> embargoDate = createDate("embargoDate", java.sql.Date.class);

    public final StringPath extWtyType = createString("extWtyType");

    public final StringPath groupCode = createString("groupCode");

    public final NumberPath<java.math.BigInteger> groupId = createNumber("groupId", java.math.BigInteger.class);

    public final NumberPath<java.math.BigInteger> gstRate = createNumber("gstRate", java.math.BigInteger.class);

    public final StringPath gtin = createString("gtin");

    public final StringPath invName = createString("invName");

    public final DateTimePath<java.time.LocalDateTime> lastUpdateDate = createDateTime("lastUpdateDate", java.time.LocalDateTime.class);

    public final StringPath lastUpdateUser = createString("lastUpdateUser");

    public final NumberPath<java.math.BigInteger> leadTime = createNumber("leadTime", java.math.BigInteger.class);

    public final StringPath longProdDesc = createString("longProdDesc");

    public final NumberPath<Integer> maxWtyPrdMths = createNumber("maxWtyPrdMths", Integer.class);

    public final StringPath mskuProdNbr = createString("mskuProdNbr");

    public final StringPath primarySuppInd = createString("primarySuppInd");

    public final StringPath prodActiveInd = createString("prodActiveInd");

    public final StringPath prodCoreRange = createString("prodCoreRange");

    public final StringPath prodNbr = createString("prodNbr");

    public final StringPath prodPurchActiveInd = createString("prodPurchActiveInd");

    public final StringPath prodPwrSkuInd = createString("prodPwrSkuInd");

    public final StringPath prodType = createString("prodType");

    public final StringPath productCallout = createString("productCallout");

    public final StringPath productHeading = createString("productHeading");

    public final StringPath prodWebReadyInd = createString("prodWebReadyInd");

    public final StringPath serviceGroup = createString("serviceGroup");

    public final StringPath shortCopy = createString("shortCopy");

    public final StringPath shortProdDesc = createString("shortProdDesc");

    public final NumberPath<java.math.BigInteger> subclass = createNumber("subclass", java.math.BigInteger.class);

    public final NumberPath<java.math.BigInteger> subclassId = createNumber("subclassId", java.math.BigInteger.class);

    public final StringPath suppLabel = createString("suppLabel");

    public final NumberPath<java.math.BigInteger> supplierAccountId = createNumber("supplierAccountId", java.math.BigInteger.class);

    public final NumberPath<java.math.BigInteger> supplierAccountProductId = createNumber("supplierAccountProductId", java.math.BigInteger.class);

    public final StringPath supProdDescr = createString("supProdDescr");

    public final StringPath supProdNbr = createString("supProdNbr");

    public final StringPath tggExclusiveInd = createString("tggExclusiveInd");

    public final StringPath uomPurchasing = createString("uomPurchasing");

    public final StringPath uomSelling = createString("uomSelling");

    public final NumberPath<Integer> wtyPrdMths = createNumber("wtyPrdMths", Integer.class);

    public QSupplierAccountProductEntity(String variable) {
        this(SupplierAccountProductEntity.class, forVariable(variable), INITS);
    }

    public QSupplierAccountProductEntity(Path<? extends SupplierAccountProductEntity> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QSupplierAccountProductEntity(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QSupplierAccountProductEntity(PathMetadata metadata, PathInits inits) {
        this(SupplierAccountProductEntity.class, metadata, inits);
    }

    public QSupplierAccountProductEntity(Class<? extends SupplierAccountProductEntity> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.brandEntity = inits.isInitialized("brandEntity") ? new QBrandEntity(forProperty("brandEntity")) : null;
    }

}

