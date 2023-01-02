package au.com.tgg.apps.foundation.model.tggcsodr;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QLocationSetCtlEntity is a Querydsl query type for LocationSetCtlEntity
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QLocationSetCtlEntity extends EntityPathBase<LocationSetCtlEntity> {

    private static final long serialVersionUID = -776996255L;

    public static final QLocationSetCtlEntity locationSetCtlEntity = new QLocationSetCtlEntity("locationSetCtlEntity");

    public final DateTimePath<java.time.LocalDateTime> createdDate = createDateTime("createdDate", java.time.LocalDateTime.class);

    public final StringPath createdUser = createString("createdUser");

    public final StringPath invName = createString("invName");

    public final DateTimePath<java.time.LocalDateTime> lastUpdateDate = createDateTime("lastUpdateDate", java.time.LocalDateTime.class);

    public final StringPath lastUpdateUser = createString("lastUpdateUser");

    public final NumberPath<java.math.BigInteger> locationSetId = createNumber("locationSetId", java.math.BigInteger.class);

    public final StringPath locnSetDescr = createString("locnSetDescr");

    public final StringPath locnSetLongDescr = createString("locnSetLongDescr");

    public final StringPath locnSetName = createString("locnSetName");

    public QLocationSetCtlEntity(String variable) {
        super(LocationSetCtlEntity.class, forVariable(variable));
    }

    public QLocationSetCtlEntity(Path<? extends LocationSetCtlEntity> path) {
        super(path.getType(), path.getMetadata());
    }

    public QLocationSetCtlEntity(PathMetadata metadata) {
        super(LocationSetCtlEntity.class, metadata);
    }

}

