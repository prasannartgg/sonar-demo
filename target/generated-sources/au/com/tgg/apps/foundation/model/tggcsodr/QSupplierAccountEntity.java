package au.com.tgg.apps.foundation.model.tggcsodr;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QSupplierAccountEntity is a Querydsl query type for SupplierAccountEntity
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QSupplierAccountEntity extends EntityPathBase<SupplierAccountEntity> {

    private static final long serialVersionUID = -1192400492L;

    public static final QSupplierAccountEntity supplierAccountEntity = new QSupplierAccountEntity("supplierAccountEntity");

    public final StringPath accountName = createString("accountName");

    public final StringPath accountNumber = createString("accountNumber");

    public final StringPath countryCode = createString("countryCode");

    public final DateTimePath<java.time.LocalDateTime> createdDate = createDateTime("createdDate", java.time.LocalDateTime.class);

    public final StringPath createdUser = createString("createdUser");

    public final DateTimePath<java.time.LocalDateTime> lastUpdateDate = createDateTime("lastUpdateDate", java.time.LocalDateTime.class);

    public final StringPath lastUpdateUser = createString("lastUpdateUser");

    public final NumberPath<java.math.BigInteger> ppAgeOfStock = createNumber("ppAgeOfStock", java.math.BigInteger.class);

    public final StringPath ppDealParityInd = createString("ppDealParityInd");

    public final ListPath<ProductEntity, QProductEntity> productEntityList = this.<ProductEntity, QProductEntity>createList("productEntityList", ProductEntity.class, QProductEntity.class, PathInits.DIRECT2);

    public final StringPath supAccActiveInd = createString("supAccActiveInd");

    public final StringPath supLdgCode = createString("supLdgCode");

    public final NumberPath<java.math.BigInteger> supplierAccountId = createNumber("supplierAccountId", java.math.BigInteger.class);

    public final StringPath tggUrl = createString("tggUrl");

    public QSupplierAccountEntity(String variable) {
        super(SupplierAccountEntity.class, forVariable(variable));
    }

    public QSupplierAccountEntity(Path<? extends SupplierAccountEntity> path) {
        super(path.getType(), path.getMetadata());
    }

    public QSupplierAccountEntity(PathMetadata metadata) {
        super(SupplierAccountEntity.class, metadata);
    }

}

