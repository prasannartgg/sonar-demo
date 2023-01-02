package au.com.tgg.apps.foundation.model;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QMerchSubclass is a Querydsl query type for MerchSubclass
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QMerchSubclass extends EntityPathBase<MerchSubclass> {

    private static final long serialVersionUID = -535321486L;

    public static final QMerchSubclass merchSubclass = new QMerchSubclass("merchSubclass");

    public final NumberPath<Long> classId = createNumber("classId", Long.class);

    public final StringPath createdBy = createString("createdBy");

    public final TimePath<java.sql.Time> createdDate = createTime("createdDate", java.sql.Time.class);

    public final StringPath deleted = createString("deleted");

    public final StringPath lastModifiedBy = createString("lastModifiedBy");

    public final TimePath<java.sql.Time> lastModifiedDate = createTime("lastModifiedDate", java.sql.Time.class);

    public final NumberPath<Long> subclass = createNumber("subclass", Long.class);

    public final NumberPath<Long> subclassId = createNumber("subclassId", Long.class);

    public final StringPath subclassName = createString("subclassName");

    public QMerchSubclass(String variable) {
        super(MerchSubclass.class, forVariable(variable));
    }

    public QMerchSubclass(Path<? extends MerchSubclass> path) {
        super(path.getType(), path.getMetadata());
    }

    public QMerchSubclass(PathMetadata metadata) {
        super(MerchSubclass.class, metadata);
    }

}

