package au.com.tgg.apps.foundation.model;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QCaseItem is a Querydsl query type for CaseItem
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QCaseItem extends EntityPathBase<CaseItem> {

    private static final long serialVersionUID = 1090932008L;

    public static final QCaseItem caseItem = new QCaseItem("caseItem");

    public final NumberPath<Long> caseItemId = createNumber("caseItemId", Long.class);

    public final NumberPath<Long> caseReasonCodeId = createNumber("caseReasonCodeId", Long.class);

    public final NumberPath<Long> caseStatusCodeId = createNumber("caseStatusCodeId", Long.class);

    public final StringPath comments = createString("comments");

    public final StringPath createdBy = createString("createdBy");

    public final TimePath<java.sql.Time> createdDate = createTime("createdDate", java.sql.Time.class);

    public final NumberPath<Long> dktLneNbr = createNumber("dktLneNbr", Long.class);

    public final StringPath dktNbr = createString("dktNbr");

    public final NumberPath<Long> locationId = createNumber("locationId", Long.class);

    public final StringPath mfrSerialNo = createString("mfrSerialNo");

    public final StringPath modifiedBy = createString("modifiedBy");

    public final TimePath<java.sql.Time> modifiedDate = createTime("modifiedDate", java.sql.Time.class);

    public final StringPath preProcessed = createString("preProcessed");

    public final NumberPath<Long> solvupCaseNbr = createNumber("solvupCaseNbr", Long.class);

    public final NumberPath<Long> supplierAccountProductId = createNumber("supplierAccountProductId", Long.class);

    public final NumberPath<Long> typeId = createNumber("typeId", Long.class);

    public QCaseItem(String variable) {
        super(CaseItem.class, forVariable(variable));
    }

    public QCaseItem(Path<? extends CaseItem> path) {
        super(path.getType(), path.getMetadata());
    }

    public QCaseItem(PathMetadata metadata) {
        super(CaseItem.class, metadata);
    }

}

