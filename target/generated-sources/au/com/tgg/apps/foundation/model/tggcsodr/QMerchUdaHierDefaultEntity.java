package au.com.tgg.apps.foundation.model.tggcsodr;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QMerchUdaHierDefaultEntity is a Querydsl query type for MerchUdaHierDefaultEntity
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QMerchUdaHierDefaultEntity extends EntityPathBase<MerchUdaHierDefaultEntity> {

    private static final long serialVersionUID = 1290222355L;

    public static final QMerchUdaHierDefaultEntity merchUdaHierDefaultEntity = new QMerchUdaHierDefaultEntity("merchUdaHierDefaultEntity");

    public final NumberPath<java.math.BigInteger> classId = createNumber("classId", java.math.BigInteger.class);

    public final StringPath createdBy = createString("createdBy");

    public final DateTimePath<java.time.LocalDateTime> createdDate = createDateTime("createdDate", java.time.LocalDateTime.class);

    public final StringPath deleted = createString("deleted");

    public final NumberPath<java.math.BigInteger> depId = createNumber("depId", java.math.BigInteger.class);

    public final StringPath lastModifiedBy = createString("lastModifiedBy");

    public final DateTimePath<java.time.LocalDateTime> lastModifiedDate = createDateTime("lastModifiedDate", java.time.LocalDateTime.class);

    public final NumberPath<Short> merchLevel = createNumber("merchLevel", Short.class);

    public final NumberPath<java.math.BigInteger> subclassId = createNumber("subclassId", java.math.BigInteger.class);

    public final NumberPath<java.math.BigInteger> udaHierDefId = createNumber("udaHierDefId", java.math.BigInteger.class);

    public final NumberPath<java.math.BigInteger> udaValueId = createNumber("udaValueId", java.math.BigInteger.class);

    public QMerchUdaHierDefaultEntity(String variable) {
        super(MerchUdaHierDefaultEntity.class, forVariable(variable));
    }

    public QMerchUdaHierDefaultEntity(Path<? extends MerchUdaHierDefaultEntity> path) {
        super(path.getType(), path.getMetadata());
    }

    public QMerchUdaHierDefaultEntity(PathMetadata metadata) {
        super(MerchUdaHierDefaultEntity.class, metadata);
    }

}

