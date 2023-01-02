package au.com.tgg.apps.foundation.model.tggcsodr;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QMerchSubclassEntity is a Querydsl query type for MerchSubclassEntity
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QMerchSubclassEntity extends EntityPathBase<MerchSubclassEntity> {

    private static final long serialVersionUID = 95229546L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QMerchSubclassEntity merchSubclassEntity = new QMerchSubclassEntity("merchSubclassEntity");

    public final NumberPath<java.math.BigInteger> clazz = createNumber("clazz", java.math.BigInteger.class);

    public final StringPath createdBy = createString("createdBy");

    public final DateTimePath<java.time.LocalDateTime> createdDate = createDateTime("createdDate", java.time.LocalDateTime.class);

    public final StringPath deleted = createString("deleted");

    public final StringPath lastModifiedBy = createString("lastModifiedBy");

    public final DateTimePath<java.time.LocalDateTime> lastModifiedDate = createDateTime("lastModifiedDate", java.time.LocalDateTime.class);

    public final QMerchClassEntity merchClassEntity;

    public final NumberPath<java.math.BigInteger> subclass = createNumber("subclass", java.math.BigInteger.class);

    public final NumberPath<java.math.BigInteger> subclassId = createNumber("subclassId", java.math.BigInteger.class);

    public final StringPath subclassName = createString("subclassName");

    public QMerchSubclassEntity(String variable) {
        this(MerchSubclassEntity.class, forVariable(variable), INITS);
    }

    public QMerchSubclassEntity(Path<? extends MerchSubclassEntity> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QMerchSubclassEntity(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QMerchSubclassEntity(PathMetadata metadata, PathInits inits) {
        this(MerchSubclassEntity.class, metadata, inits);
    }

    public QMerchSubclassEntity(Class<? extends MerchSubclassEntity> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.merchClassEntity = inits.isInitialized("merchClassEntity") ? new QMerchClassEntity(forProperty("merchClassEntity"), inits.get("merchClassEntity")) : null;
    }

}

