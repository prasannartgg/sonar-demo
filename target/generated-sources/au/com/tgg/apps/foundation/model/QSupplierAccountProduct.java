package au.com.tgg.apps.foundation.model;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QSupplierAccountProduct is a Querydsl query type for SupplierAccountProduct
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QSupplierAccountProduct extends EntityPathBase<SupplierAccountProduct> {

    private static final long serialVersionUID = -1844613901L;

    public static final QSupplierAccountProduct supplierAccountProduct = new QSupplierAccountProduct("supplierAccountProduct");

    public final NumberPath<Long> brandId = createNumber("brandId", Long.class);

    public final StringPath concierge = createString("concierge");

    public final StringPath consumerProdNbr = createString("consumerProdNbr");

    public final NumberPath<Long> costExPrice = createNumber("costExPrice", Long.class);

    public final TimePath<java.sql.Time> createdDate = createTime("createdDate", java.sql.Time.class);

    public final StringPath createdUser = createString("createdUser");

    public final StringPath extWtyType = createString("extWtyType");

    public final NumberPath<Long> groupId = createNumber("groupId", Long.class);

    public final NumberPath<Long> gstRate = createNumber("gstRate", Long.class);

    public final StringPath gtin = createString("gtin");

    public final StringPath invName = createString("invName");

    public final TimePath<java.sql.Time> lastUpdateDate = createTime("lastUpdateDate", java.sql.Time.class);

    public final StringPath lastUpdateUser = createString("lastUpdateUser");

    public final NumberPath<Long> leadTime = createNumber("leadTime", Long.class);

    public final StringPath longProdDesc = createString("longProdDesc");

    public final NumberPath<Long> maxWtyPrdMths = createNumber("maxWtyPrdMths", Long.class);

    public final StringPath mskuProdNbr = createString("mskuProdNbr");

    public final StringPath primarySuppInd = createString("primarySuppInd");

    public final StringPath prodActiveInd = createString("prodActiveInd");

    public final StringPath prodCoreRange = createString("prodCoreRange");

    public final StringPath prodNbr = createString("prodNbr");

    public final StringPath prodPurchActiveInd = createString("prodPurchActiveInd");

    public final StringPath prodPwrSkuInd = createString("prodPwrSkuInd");

    public final StringPath prodType = createString("prodType");

    public final StringPath productCallout = createString("productCallout");

    public final StringPath productHeading = createString("productHeading");

    public final StringPath prodWebReadyInd = createString("prodWebReadyInd");

    public final StringPath serviceGroup = createString("serviceGroup");

    public final StringPath shortCopy = createString("shortCopy");

    public final StringPath shortProdDesc = createString("shortProdDesc");

    public final NumberPath<Long> subclassId = createNumber("subclassId", Long.class);

    public final StringPath suppLabel = createString("suppLabel");

    public final NumberPath<Long> supplierAccountId = createNumber("supplierAccountId", Long.class);

    public final NumberPath<Long> supplierAccountProductId = createNumber("supplierAccountProductId", Long.class);

    public final StringPath supProdDescr = createString("supProdDescr");

    public final StringPath supProdNbr = createString("supProdNbr");

    public final StringPath tggExclusiveInd = createString("tggExclusiveInd");

    public final StringPath uomPurchasing = createString("uomPurchasing");

    public final StringPath uomSelling = createString("uomSelling");

    public final NumberPath<Long> wtyPrdMths = createNumber("wtyPrdMths", Long.class);

    public QSupplierAccountProduct(String variable) {
        super(SupplierAccountProduct.class, forVariable(variable));
    }

    public QSupplierAccountProduct(Path<? extends SupplierAccountProduct> path) {
        super(path.getType(), path.getMetadata());
    }

    public QSupplierAccountProduct(PathMetadata metadata) {
        super(SupplierAccountProduct.class, metadata);
    }

}

