package au.com.tgg.apps.foundation.model.tggcsodr;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QMerchDepsEntity is a Querydsl query type for MerchDepsEntity
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QMerchDepsEntity extends EntityPathBase<MerchDepsEntity> {

    private static final long serialVersionUID = -244467722L;

    public static final QMerchDepsEntity merchDepsEntity = new QMerchDepsEntity("merchDepsEntity");

    public final StringPath createdBy = createString("createdBy");

    public final DateTimePath<java.time.LocalDateTime> createdDate = createDateTime("createdDate", java.time.LocalDateTime.class);

    public final StringPath deleted = createString("deleted");

    public final NumberPath<java.math.BigInteger> depId = createNumber("depId", java.math.BigInteger.class);

    public final NumberPath<java.math.BigInteger> dept = createNumber("dept", java.math.BigInteger.class);

    public final StringPath deptName = createString("deptName");

    public final StringPath lastModifiedBy = createString("lastModifiedBy");

    public final DateTimePath<java.time.LocalDateTime> lastModifiedDate = createDateTime("lastModifiedDate", java.time.LocalDateTime.class);

    public final ListPath<MerchClassEntity, QMerchClassEntity> merchClassEntityList = this.<MerchClassEntity, QMerchClassEntity>createList("merchClassEntityList", MerchClassEntity.class, QMerchClassEntity.class, PathInits.DIRECT2);

    public QMerchDepsEntity(String variable) {
        super(MerchDepsEntity.class, forVariable(variable));
    }

    public QMerchDepsEntity(Path<? extends MerchDepsEntity> path) {
        super(path.getType(), path.getMetadata());
    }

    public QMerchDepsEntity(PathMetadata metadata) {
        super(MerchDepsEntity.class, metadata);
    }

}

