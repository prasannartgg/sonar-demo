package au.com.tgg.apps.foundation.model;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QCodeHead is a Querydsl query type for CodeHead
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QCodeHead extends EntityPathBase<CodeHead> {

    private static final long serialVersionUID = 201600050L;

    public static final QCodeHead codeHead1 = new QCodeHead("codeHead1");

    public final StringPath active = createString("active");

    public final StringPath codeHead = createString("codeHead");

    public final StringPath codeHeadDesc = createString("codeHeadDesc");

    public final NumberPath<Long> codeHeadId = createNumber("codeHeadId", Long.class);

    public final StringPath codeHeadLabel = createString("codeHeadLabel");

    public final StringPath createdBy = createString("createdBy");

    public final TimePath<java.sql.Time> createdDate = createTime("createdDate", java.sql.Time.class);

    public final StringPath modifiedBy = createString("modifiedBy");

    public final TimePath<java.sql.Time> modifiedDate = createTime("modifiedDate", java.sql.Time.class);

    public QCodeHead(String variable) {
        super(CodeHead.class, forVariable(variable));
    }

    public QCodeHead(Path<? extends CodeHead> path) {
        super(path.getType(), path.getMetadata());
    }

    public QCodeHead(PathMetadata metadata) {
        super(CodeHead.class, metadata);
    }

}

