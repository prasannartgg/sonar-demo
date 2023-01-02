package au.com.tgg.apps.foundation.model;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QCodeDetail is a Querydsl query type for CodeDetail
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QCodeDetail extends EntityPathBase<CodeDetail> {

    private static final long serialVersionUID = 350169635L;

    public static final QCodeDetail codeDetail = new QCodeDetail("codeDetail");

    public final StringPath active = createString("active");

    public final StringPath code = createString("code");

    public final StringPath codeDesc = createString("codeDesc");

    public final NumberPath<Long> codeHeadId = createNumber("codeHeadId", Long.class);

    public final NumberPath<Long> codeId = createNumber("codeId", Long.class);

    public final StringPath codeLabel = createString("codeLabel");

    public final StringPath createdBy = createString("createdBy");

    public final TimePath<java.sql.Time> createdDate = createTime("createdDate", java.sql.Time.class);

    public final StringPath modifiedBy = createString("modifiedBy");

    public final TimePath<java.sql.Time> modifiedDate = createTime("modifiedDate", java.sql.Time.class);

    public QCodeDetail(String variable) {
        super(CodeDetail.class, forVariable(variable));
    }

    public QCodeDetail(Path<? extends CodeDetail> path) {
        super(path.getType(), path.getMetadata());
    }

    public QCodeDetail(PathMetadata metadata) {
        super(CodeDetail.class, metadata);
    }

}

