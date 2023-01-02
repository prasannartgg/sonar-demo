package au.com.tgg.apps.foundation.model.tggcsodr;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QLocationStateEntity is a Querydsl query type for LocationStateEntity
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QLocationStateEntity extends EntityPathBase<LocationStateEntity> {

    private static final long serialVersionUID = -1534984081L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QLocationStateEntity locationStateEntity = new QLocationStateEntity("locationStateEntity");

    public final QCountryEntity countryEntity;

    public final DateTimePath<java.time.LocalDateTime> createdDate = createDateTime("createdDate", java.time.LocalDateTime.class);

    public final StringPath createdUser = createString("createdUser");

    public final DateTimePath<java.time.LocalDateTime> lastUpdateDate = createDateTime("lastUpdateDate", java.time.LocalDateTime.class);

    public final StringPath lastUpdateUser = createString("lastUpdateUser");

    public final ListPath<LocationEntity, QLocationEntity> locationEntityList = this.<LocationEntity, QLocationEntity>createList("locationEntityList", LocationEntity.class, QLocationEntity.class, PathInits.DIRECT2);

    public final NumberPath<java.math.BigInteger> locationStateId = createNumber("locationStateId", java.math.BigInteger.class);

    public final StringPath stateCode = createString("stateCode");

    public final StringPath stateName = createString("stateName");

    public QLocationStateEntity(String variable) {
        this(LocationStateEntity.class, forVariable(variable), INITS);
    }

    public QLocationStateEntity(Path<? extends LocationStateEntity> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QLocationStateEntity(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QLocationStateEntity(PathMetadata metadata, PathInits inits) {
        this(LocationStateEntity.class, metadata, inits);
    }

    public QLocationStateEntity(Class<? extends LocationStateEntity> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.countryEntity = inits.isInitialized("countryEntity") ? new QCountryEntity(forProperty("countryEntity")) : null;
    }

}

