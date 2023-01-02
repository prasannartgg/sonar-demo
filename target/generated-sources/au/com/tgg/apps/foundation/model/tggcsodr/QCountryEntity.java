package au.com.tgg.apps.foundation.model.tggcsodr;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QCountryEntity is a Querydsl query type for CountryEntity
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QCountryEntity extends EntityPathBase<CountryEntity> {

    private static final long serialVersionUID = 1924780713L;

    public static final QCountryEntity countryEntity = new QCountryEntity("countryEntity");

    public final NumberPath<java.math.BigInteger> automatonCountryId = createNumber("automatonCountryId", java.math.BigInteger.class);

    public final StringPath clgCode = createString("clgCode");

    public final StringPath countryCode = createString("countryCode");

    public final StringPath countryDescription = createString("countryDescription");

    public final StringPath currencyCode = createString("currencyCode");

    public final NumberPath<Double> gstRate = createNumber("gstRate", Double.class);

    public final NumberPath<Double> gstRatio = createNumber("gstRatio", Double.class);

    public final StringPath invName = createString("invName");

    public final ListPath<LocationStateEntity, QLocationStateEntity> locationStateEntities = this.<LocationStateEntity, QLocationStateEntity>createList("locationStateEntities", LocationStateEntity.class, QLocationStateEntity.class, PathInits.DIRECT2);

    public QCountryEntity(String variable) {
        super(CountryEntity.class, forVariable(variable));
    }

    public QCountryEntity(Path<? extends CountryEntity> path) {
        super(path.getType(), path.getMetadata());
    }

    public QCountryEntity(PathMetadata metadata) {
        super(CountryEntity.class, metadata);
    }

}

