package au.com.tgg.apps.foundation.model.tggcsodr;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QLocationStateMappingEntity is a Querydsl query type for LocationStateMappingEntity
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QLocationStateMappingEntity extends EntityPathBase<LocationStateMappingEntity> {

    private static final long serialVersionUID = 157910085L;

    public static final QLocationStateMappingEntity locationStateMappingEntity = new QLocationStateMappingEntity("locationStateMappingEntity");

    public final DateTimePath<java.time.LocalDateTime> createdDate = createDateTime("createdDate", java.time.LocalDateTime.class);

    public final StringPath createdUser = createString("createdUser");

    public final DateTimePath<java.time.LocalDateTime> lastUpdateDate = createDateTime("lastUpdateDate", java.time.LocalDateTime.class);

    public final StringPath lastUpdateUser = createString("lastUpdateUser");

    public final NumberPath<java.math.BigInteger> locationId = createNumber("locationId", java.math.BigInteger.class);

    public final NumberPath<java.math.BigInteger> locationStateId = createNumber("locationStateId", java.math.BigInteger.class);

    public final NumberPath<java.math.BigInteger> locationStateMappingId = createNumber("locationStateMappingId", java.math.BigInteger.class);

    public final StringPath locnName = createString("locnName");

    public QLocationStateMappingEntity(String variable) {
        super(LocationStateMappingEntity.class, forVariable(variable));
    }

    public QLocationStateMappingEntity(Path<? extends LocationStateMappingEntity> path) {
        super(path.getType(), path.getMetadata());
    }

    public QLocationStateMappingEntity(PathMetadata metadata) {
        super(LocationStateMappingEntity.class, metadata);
    }

}

