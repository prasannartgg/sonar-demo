package au.com.tgg.apps.foundation.model.tggcsodr;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QMerchClassEntity is a Querydsl query type for MerchClassEntity
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QMerchClassEntity extends EntityPathBase<MerchClassEntity> {

    private static final long serialVersionUID = -528717652L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QMerchClassEntity merchClassEntity = new QMerchClassEntity("merchClassEntity");

    public final NumberPath<java.math.BigInteger> classId = createNumber("classId", java.math.BigInteger.class);

    public final StringPath className = createString("className");

    public final NumberPath<java.math.BigInteger> clazz = createNumber("clazz", java.math.BigInteger.class);

    public final StringPath createdBy = createString("createdBy");

    public final DateTimePath<java.time.LocalDateTime> createdDate = createDateTime("createdDate", java.time.LocalDateTime.class);

    public final StringPath deleted = createString("deleted");

    public final NumberPath<java.math.BigInteger> dept = createNumber("dept", java.math.BigInteger.class);

    public final StringPath lastModifiedBy = createString("lastModifiedBy");

    public final DateTimePath<java.time.LocalDateTime> lastModifiedDate = createDateTime("lastModifiedDate", java.time.LocalDateTime.class);

    public final QMerchDepsEntity merchDepsEntity;

    public final ListPath<MerchSubclassEntity, QMerchSubclassEntity> merchSubclassEntities = this.<MerchSubclassEntity, QMerchSubclassEntity>createList("merchSubclassEntities", MerchSubclassEntity.class, QMerchSubclassEntity.class, PathInits.DIRECT2);

    public QMerchClassEntity(String variable) {
        this(MerchClassEntity.class, forVariable(variable), INITS);
    }

    public QMerchClassEntity(Path<? extends MerchClassEntity> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QMerchClassEntity(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QMerchClassEntity(PathMetadata metadata, PathInits inits) {
        this(MerchClassEntity.class, metadata, inits);
    }

    public QMerchClassEntity(Class<? extends MerchClassEntity> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.merchDepsEntity = inits.isInitialized("merchDepsEntity") ? new QMerchDepsEntity(forProperty("merchDepsEntity")) : null;
    }

}

