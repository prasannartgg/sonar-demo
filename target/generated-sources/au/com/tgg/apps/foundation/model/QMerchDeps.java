package au.com.tgg.apps.foundation.model;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QMerchDeps is a Querydsl query type for MerchDeps
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QMerchDeps extends EntityPathBase<MerchDeps> {

    private static final long serialVersionUID = 323189886L;

    public static final QMerchDeps merchDeps = new QMerchDeps("merchDeps");

    public final StringPath createdBy = createString("createdBy");

    public final TimePath<java.sql.Time> createdDate = createTime("createdDate", java.sql.Time.class);

    public final StringPath deleted = createString("deleted");

    public final NumberPath<Long> depId = createNumber("depId", Long.class);

    public final NumberPath<Long> dept = createNumber("dept", Long.class);

    public final StringPath deptName = createString("deptName");

    public final StringPath lastModifiedBy = createString("lastModifiedBy");

    public final TimePath<java.sql.Time> lastModifiedDate = createTime("lastModifiedDate", java.sql.Time.class);

    public QMerchDeps(String variable) {
        super(MerchDeps.class, forVariable(variable));
    }

    public QMerchDeps(Path<? extends MerchDeps> path) {
        super(path.getType(), path.getMetadata());
    }

    public QMerchDeps(PathMetadata metadata) {
        super(MerchDeps.class, metadata);
    }

}

