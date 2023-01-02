package au.com.tgg.apps.foundation.model.tggcsodr;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QMerchUdaValueEntity is a Querydsl query type for MerchUdaValueEntity
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QMerchUdaValueEntity extends EntityPathBase<MerchUdaValueEntity> {

    private static final long serialVersionUID = 643466961L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QMerchUdaValueEntity merchUdaValueEntity = new QMerchUdaValueEntity("merchUdaValueEntity");

    public final StringPath createdBy = createString("createdBy");

    public final DateTimePath<java.time.LocalDateTime> createdDate = createDateTime("createdDate", java.time.LocalDateTime.class);

    public final StringPath deleted = createString("deleted");

    public final StringPath isdefault = createString("isdefault");

    public final StringPath lastModifiedBy = createString("lastModifiedBy");

    public final DateTimePath<java.time.LocalDateTime> lastModifiedDate = createDateTime("lastModifiedDate", java.time.LocalDateTime.class);

    public final QMerchUdaEntity merchUdaEntity;

    public final NumberPath<java.math.BigInteger> sourceUdaId = createNumber("sourceUdaId", java.math.BigInteger.class);

    public final NumberPath<java.math.BigInteger> sourceUdaValueId = createNumber("sourceUdaValueId", java.math.BigInteger.class);

    public final StringPath udaValueCode = createString("udaValueCode");

    public final StringPath udaValueDesc = createString("udaValueDesc");

    public final NumberPath<java.math.BigInteger> udaValueId = createNumber("udaValueId", java.math.BigInteger.class);

    public QMerchUdaValueEntity(String variable) {
        this(MerchUdaValueEntity.class, forVariable(variable), INITS);
    }

    public QMerchUdaValueEntity(Path<? extends MerchUdaValueEntity> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QMerchUdaValueEntity(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QMerchUdaValueEntity(PathMetadata metadata, PathInits inits) {
        this(MerchUdaValueEntity.class, metadata, inits);
    }

    public QMerchUdaValueEntity(Class<? extends MerchUdaValueEntity> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.merchUdaEntity = inits.isInitialized("merchUdaEntity") ? new QMerchUdaEntity(forProperty("merchUdaEntity")) : null;
    }

}

