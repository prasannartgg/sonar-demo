package au.com.tgg.apps.foundation.model.tggcsodr;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QProductEntity is a Querydsl query type for ProductEntity
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QProductEntity extends EntityPathBase<ProductEntity> {

    private static final long serialVersionUID = 332341570L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QProductEntity productEntity = new QProductEntity("productEntity");

    public final StringPath accountNumber = createString("accountNumber");

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

    public final StringPath longProdDesc = createString("longProdDesc");

    public final NumberPath<Integer> maxWtyPrdMths = createNumber("maxWtyPrdMths", Integer.class);

    public final StringPath mskuProdNbr = createString("mskuProdNbr");

    public final StringPath prodActiveInd = createString("prodActiveInd");

    public final StringPath prodCoreRange = createString("prodCoreRange");

    public final StringPath prodNbr = createString("prodNbr");

    public final StringPath prodPurchActiveInd = createString("prodPurchActiveInd");

    public final StringPath prodPwrSkuInd = createString("prodPwrSkuInd");

    public final StringPath prodType = createString("prodType");

    public final StringPath productCallout = createString("productCallout");

    public final StringPath productHeading = createString("productHeading");

    public final NumberPath<java.math.BigInteger> productId = createNumber("productId", java.math.BigInteger.class);

    public final StringPath prodWebReadyInd = createString("prodWebReadyInd");

    public final StringPath serviceGroup = createString("serviceGroup");

    public final StringPath shortCopy = createString("shortCopy");

    public final StringPath shortProdDesc = createString("shortProdDesc");

    public final NumberPath<java.math.BigInteger> subclass = createNumber("subclass", java.math.BigInteger.class);

    public final NumberPath<java.math.BigInteger> subclassId = createNumber("subclassId", java.math.BigInteger.class);

    public final QSupplierAccountEntity supplierAccountEntity;

    public final NumberPath<java.math.BigInteger> supplierId = createNumber("supplierId", java.math.BigInteger.class);

    public final StringPath supProdDescr = createString("supProdDescr");

    public final StringPath supProdNbr = createString("supProdNbr");

    public final StringPath tggExclusiveInd = createString("tggExclusiveInd");

    public final StringPath uomPurchasing = createString("uomPurchasing");

    public final StringPath uomSelling = createString("uomSelling");

    public final NumberPath<Integer> wtyPrdMths = createNumber("wtyPrdMths", Integer.class);

    public QProductEntity(String variable) {
        this(ProductEntity.class, forVariable(variable), INITS);
    }

    public QProductEntity(Path<? extends ProductEntity> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QProductEntity(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QProductEntity(PathMetadata metadata, PathInits inits) {
        this(ProductEntity.class, metadata, inits);
    }

    public QProductEntity(Class<? extends ProductEntity> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.brandEntity = inits.isInitialized("brandEntity") ? new QBrandEntity(forProperty("brandEntity")) : null;
        this.supplierAccountEntity = inits.isInitialized("supplierAccountEntity") ? new QSupplierAccountEntity(forProperty("supplierAccountEntity")) : null;
    }

}

