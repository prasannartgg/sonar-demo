package au.com.tgg.apps.foundation.model.tggcsodr;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QProductBarcodeEntity is a Querydsl query type for ProductBarcodeEntity
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QProductBarcodeEntity extends EntityPathBase<ProductBarcodeEntity> {

    private static final long serialVersionUID = -2128600508L;

    public static final QProductBarcodeEntity productBarcodeEntity = new QProductBarcodeEntity("productBarcodeEntity");

    public final StringPath barcode = createString("barcode");

    public final StringPath barcodeType = createString("barcodeType");

    public final StringPath createdBy = createString("createdBy");

    public final DateTimePath<java.time.LocalDateTime> createdDate = createDateTime("createdDate", java.time.LocalDateTime.class);

    public final StringPath deleted = createString("deleted");

    public final StringPath invName = createString("invName");

    public final StringPath lastModifiedBy = createString("lastModifiedBy");

    public final DateTimePath<java.time.LocalDateTime> lastModifiedDate = createDateTime("lastModifiedDate", java.time.LocalDateTime.class);

    public final StringPath primaryInd = createString("primaryInd");

    public final StringPath prodNbr = createString("prodNbr");

    public final NumberPath<java.math.BigInteger> productId = createNumber("productId", java.math.BigInteger.class);

    public QProductBarcodeEntity(String variable) {
        super(ProductBarcodeEntity.class, forVariable(variable));
    }

    public QProductBarcodeEntity(Path<? extends ProductBarcodeEntity> path) {
        super(path.getType(), path.getMetadata());
    }

    public QProductBarcodeEntity(PathMetadata metadata) {
        super(ProductBarcodeEntity.class, metadata);
    }

}

