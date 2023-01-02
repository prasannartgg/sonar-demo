package au.com.tgg.apps.foundation.model.tggcsodr;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QProductVolumetricsEntity is a Querydsl query type for ProductVolumetricsEntity
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QProductVolumetricsEntity extends EntityPathBase<ProductVolumetricsEntity> {

    private static final long serialVersionUID = 130495749L;

    public static final QProductVolumetricsEntity productVolumetricsEntity = new QProductVolumetricsEntity("productVolumetricsEntity");

    public final DateTimePath<java.time.LocalDateTime> createDate = createDateTime("createDate", java.time.LocalDateTime.class);

    public final NumberPath<Double> height = createNumber("height", Double.class);

    public final StringPath invName = createString("invName");

    public final DateTimePath<java.time.LocalDateTime> lastModifiedDate = createDateTime("lastModifiedDate", java.time.LocalDateTime.class);

    public final NumberPath<Double> length = createNumber("length", Double.class);

    public final StringPath lwhUom = createString("lwhUom");

    public final NumberPath<Double> netWeight = createNumber("netWeight", Double.class);

    public final StringPath prodNbr = createString("prodNbr");

    public final NumberPath<java.math.BigInteger> productId = createNumber("productId", java.math.BigInteger.class);

    public final NumberPath<Double> vmWeight = createNumber("vmWeight", Double.class);

    public final NumberPath<Double> weight = createNumber("weight", Double.class);

    public final StringPath weightUom = createString("weightUom");

    public final NumberPath<Double> width = createNumber("width", Double.class);

    public QProductVolumetricsEntity(String variable) {
        super(ProductVolumetricsEntity.class, forVariable(variable));
    }

    public QProductVolumetricsEntity(Path<? extends ProductVolumetricsEntity> path) {
        super(path.getType(), path.getMetadata());
    }

    public QProductVolumetricsEntity(PathMetadata metadata) {
        super(ProductVolumetricsEntity.class, metadata);
    }

}

