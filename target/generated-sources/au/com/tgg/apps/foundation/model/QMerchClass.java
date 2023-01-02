package au.com.tgg.apps.foundation.model;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QMerchClass is a Querydsl query type for MerchClass
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QMerchClass extends EntityPathBase<MerchClass> {

    private static final long serialVersionUID = 1428222590L;

    public static final QMerchClass merchClass = new QMerchClass("merchClass");

    public final NumberPath<Long> classId = createNumber("classId", Long.class);

    public final StringPath className = createString("className");

    public final NumberPath<Long> clazz = createNumber("clazz", Long.class);

    public final StringPath createdBy = createString("createdBy");

    public final TimePath<java.sql.Time> createdDate = createTime("createdDate", java.sql.Time.class);

    public final StringPath deleted = createString("deleted");

    public final NumberPath<Long> depId = createNumber("depId", Long.class);

    public final StringPath lastModifiedBy = createString("lastModifiedBy");

    public final TimePath<java.sql.Time> lastModifiedDate = createTime("lastModifiedDate", java.sql.Time.class);

    public QMerchClass(String variable) {
        super(MerchClass.class, forVariable(variable));
    }

    public QMerchClass(Path<? extends MerchClass> path) {
        super(path.getType(), path.getMetadata());
    }

    public QMerchClass(PathMetadata metadata) {
        super(MerchClass.class, metadata);
    }

}

