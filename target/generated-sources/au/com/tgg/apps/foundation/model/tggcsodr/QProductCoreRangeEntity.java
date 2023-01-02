package au.com.tgg.apps.foundation.model.tggcsodr;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QProductCoreRangeEntity is a Querydsl query type for ProductCoreRangeEntity
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QProductCoreRangeEntity extends EntityPathBase<ProductCoreRangeEntity> {

    private static final long serialVersionUID = -1736043550L;

    public static final QProductCoreRangeEntity productCoreRangeEntity = new QProductCoreRangeEntity("productCoreRangeEntity");

    public final StringPath description = createString("description");

    public final DateTimePath<java.time.LocalDateTime> lastUpdateDate = createDateTime("lastUpdateDate", java.time.LocalDateTime.class);

    public final StringPath lastUpdateUser = createString("lastUpdateUser");

    public final StringPath prodCoreRange = createString("prodCoreRange");

    public QProductCoreRangeEntity(String variable) {
        super(ProductCoreRangeEntity.class, forVariable(variable));
    }

    public QProductCoreRangeEntity(Path<? extends ProductCoreRangeEntity> path) {
        super(path.getType(), path.getMetadata());
    }

    public QProductCoreRangeEntity(PathMetadata metadata) {
        super(ProductCoreRangeEntity.class, metadata);
    }

}

