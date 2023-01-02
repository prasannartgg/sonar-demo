package au.com.tgg.apps.foundation.model.tggcsodr;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QProductUdaMapEntity is a Querydsl query type for ProductUdaMapEntity
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QProductUdaMapEntity extends EntityPathBase<ProductUdaMapEntity> {

    private static final long serialVersionUID = 1224597228L;

    public static final QProductUdaMapEntity productUdaMapEntity = new QProductUdaMapEntity("productUdaMapEntity");

    public final StringPath createdBy = createString("createdBy");

    public final DateTimePath<java.time.LocalDateTime> createdDate = createDateTime("createdDate", java.time.LocalDateTime.class);

    public final StringPath deleted = createString("deleted");

    public final StringPath modifiedBy = createString("modifiedBy");

    public final DateTimePath<java.time.LocalDateTime> modifiedDate = createDateTime("modifiedDate", java.time.LocalDateTime.class);

    public final StringPath prodNbr = createString("prodNbr");

    public final NumberPath<java.math.BigInteger> productUdaMapId = createNumber("productUdaMapId", java.math.BigInteger.class);

    public final NumberPath<java.math.BigInteger> udaId = createNumber("udaId", java.math.BigInteger.class);

    public final NumberPath<java.math.BigInteger> udaValue = createNumber("udaValue", java.math.BigInteger.class);

    public QProductUdaMapEntity(String variable) {
        super(ProductUdaMapEntity.class, forVariable(variable));
    }

    public QProductUdaMapEntity(Path<? extends ProductUdaMapEntity> path) {
        super(path.getType(), path.getMetadata());
    }

    public QProductUdaMapEntity(PathMetadata metadata) {
        super(ProductUdaMapEntity.class, metadata);
    }

}

