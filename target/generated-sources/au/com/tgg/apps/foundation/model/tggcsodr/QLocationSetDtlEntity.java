package au.com.tgg.apps.foundation.model.tggcsodr;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QLocationSetDtlEntity is a Querydsl query type for LocationSetDtlEntity
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QLocationSetDtlEntity extends EntityPathBase<LocationSetDtlEntity> {

    private static final long serialVersionUID = 1710516578L;

    public static final QLocationSetDtlEntity locationSetDtlEntity = new QLocationSetDtlEntity("locationSetDtlEntity");

    public final NumberPath<java.math.BigInteger> locationId = createNumber("locationId", java.math.BigInteger.class);

    public final NumberPath<java.math.BigInteger> locationSetDtlId = createNumber("locationSetDtlId", java.math.BigInteger.class);

    public final NumberPath<java.math.BigInteger> locationSetId = createNumber("locationSetId", java.math.BigInteger.class);

    public final StringPath locnName = createString("locnName");

    public QLocationSetDtlEntity(String variable) {
        super(LocationSetDtlEntity.class, forVariable(variable));
    }

    public QLocationSetDtlEntity(Path<? extends LocationSetDtlEntity> path) {
        super(path.getType(), path.getMetadata());
    }

    public QLocationSetDtlEntity(PathMetadata metadata) {
        super(LocationSetDtlEntity.class, metadata);
    }

}

