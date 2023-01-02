package au.com.tgg.apps.foundation.model.tggcsodr;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QMerchUdaEntity is a Querydsl query type for MerchUdaEntity
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QMerchUdaEntity extends EntityPathBase<MerchUdaEntity> {

    private static final long serialVersionUID = -1486813274L;

    public static final QMerchUdaEntity merchUdaEntity = new QMerchUdaEntity("merchUdaEntity");

    public final StringPath createdBy = createString("createdBy");

    public final DateTimePath<java.time.LocalDateTime> createdDate = createDateTime("createdDate", java.time.LocalDateTime.class);

    public final NumberPath<java.math.BigInteger> dataLength = createNumber("dataLength", java.math.BigInteger.class);

    public final StringPath dataType = createString("dataType");

    public final DateTimePath<java.time.LocalDateTime> date = createDateTime("date", java.time.LocalDateTime.class);

    public final StringPath deleted = createString("deleted");

    public final StringPath lastModifiedBy = createString("lastModifiedBy");

    public final DateTimePath<java.time.LocalDateTime> lastModifiedDate = createDateTime("lastModifiedDate", java.time.LocalDateTime.class);

    public final StringPath manuallyMaintained = createString("manuallyMaintained");

    public final ListPath<MerchUdaValueEntity, QMerchUdaValueEntity> merchUdaValueEntityList = this.<MerchUdaValueEntity, QMerchUdaValueEntity>createList("merchUdaValueEntityList", MerchUdaValueEntity.class, QMerchUdaValueEntity.class, PathInits.DIRECT2);

    public final StringPath sourceSystem = createString("sourceSystem");

    public final NumberPath<java.math.BigInteger> sourceUdaId = createNumber("sourceUdaId", java.math.BigInteger.class);

    public final StringPath udaCode = createString("udaCode");

    public final StringPath udaDesc = createString("udaDesc");

    public final NumberPath<java.math.BigInteger> udaId = createNumber("udaId", java.math.BigInteger.class);

    public QMerchUdaEntity(String variable) {
        super(MerchUdaEntity.class, forVariable(variable));
    }

    public QMerchUdaEntity(Path<? extends MerchUdaEntity> path) {
        super(path.getType(), path.getMetadata());
    }

    public QMerchUdaEntity(PathMetadata metadata) {
        super(MerchUdaEntity.class, metadata);
    }

}

