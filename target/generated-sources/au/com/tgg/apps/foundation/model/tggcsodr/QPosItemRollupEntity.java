package au.com.tgg.apps.foundation.model.tggcsodr;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QPosItemRollupEntity is a Querydsl query type for PosItemRollupEntity
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QPosItemRollupEntity extends EntityPathBase<PosItemRollupEntity> {

    private static final long serialVersionUID = 933221010L;

    public static final QPosItemRollupEntity posItemRollupEntity = new QPosItemRollupEntity("posItemRollupEntity");

    public final NumberPath<java.math.BigInteger> actWebOnhandQuantity = createNumber("actWebOnhandQuantity", java.math.BigInteger.class);

    public final NumberPath<java.math.BigInteger> bkordComQty = createNumber("bkordComQty", java.math.BigInteger.class);

    public final DateTimePath<java.time.LocalDateTime> createdDatetime = createDateTime("createdDatetime", java.time.LocalDateTime.class);

    public final NumberPath<java.math.BigInteger> holdComQty = createNumber("holdComQty", java.math.BigInteger.class);

    public final DateTimePath<java.time.LocalDateTime> lastModifiedDatetime = createDateTime("lastModifiedDatetime", java.time.LocalDateTime.class);

    public final DateTimePath<java.time.LocalDateTime> lastRecptDatei = createDateTime("lastRecptDatei", java.time.LocalDateTime.class);

    public final DateTimePath<java.time.LocalDateTime> lastSaleDatei = createDateTime("lastSaleDatei", java.time.LocalDateTime.class);

    public final NumberPath<java.math.BigInteger> natWebOnhandQty = createNumber("natWebOnhandQty", java.math.BigInteger.class);

    public final NumberPath<java.math.BigInteger> nswWebOnhandQuantity = createNumber("nswWebOnhandQuantity", java.math.BigInteger.class);

    public final NumberPath<java.math.BigInteger> ntWebOnhandQuantity = createNumber("ntWebOnhandQuantity", java.math.BigInteger.class);

    public final NumberPath<java.math.BigInteger> onhandAvgVal = createNumber("onhandAvgVal", java.math.BigInteger.class);

    public final NumberPath<java.math.BigInteger> onhandMedianVal = createNumber("onhandMedianVal", java.math.BigInteger.class);

    public final NumberPath<java.math.BigInteger> onhandQty = createNumber("onhandQty", java.math.BigInteger.class);

    public final NumberPath<java.math.BigInteger> onhandVal = createNumber("onhandVal", java.math.BigInteger.class);

    public final NumberPath<java.math.BigInteger> onorderQty = createNumber("onorderQty", java.math.BigInteger.class);

    public final NumberPath<java.math.BigInteger> onorderVal = createNumber("onorderVal", java.math.BigInteger.class);

    public final NumberPath<java.math.BigInteger> outboundQty = createNumber("outboundQty", java.math.BigInteger.class);

    public final NumberPath<java.math.BigInteger> pickComQty = createNumber("pickComQty", java.math.BigInteger.class);

    public final StringPath prod_nbr = createString("prod_nbr");

    public final NumberPath<java.math.BigInteger> productId = createNumber("productId", java.math.BigInteger.class);

    public final NumberPath<java.math.BigInteger> qldWebOnhandQuantity = createNumber("qldWebOnhandQuantity", java.math.BigInteger.class);

    public final NumberPath<java.math.BigInteger> saWebOnhandQuantity = createNumber("saWebOnhandQuantity", java.math.BigInteger.class);

    public final NumberPath<java.math.BigInteger> tasWebOnhandQuantity = createNumber("tasWebOnhandQuantity", java.math.BigInteger.class);

    public final NumberPath<java.math.BigInteger> vicWebOnhandQuantity = createNumber("vicWebOnhandQuantity", java.math.BigInteger.class);

    public final NumberPath<java.math.BigInteger> waWebOnhandQuantity = createNumber("waWebOnhandQuantity", java.math.BigInteger.class);

    public final NumberPath<java.math.BigInteger> webMinQty = createNumber("webMinQty", java.math.BigInteger.class);

    public final StringPath webReady = createString("webReady");

    public final StringPath webReadyB2B = createString("webReadyB2B");

    public QPosItemRollupEntity(String variable) {
        super(PosItemRollupEntity.class, forVariable(variable));
    }

    public QPosItemRollupEntity(Path<? extends PosItemRollupEntity> path) {
        super(path.getType(), path.getMetadata());
    }

    public QPosItemRollupEntity(PathMetadata metadata) {
        super(PosItemRollupEntity.class, metadata);
    }

}

