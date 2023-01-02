package au.com.tgg.apps.foundation.util;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;

public class FoundationUtil {

    public static final String USER = "foundation";
    public static final String INV_NAME = "TGGINV";
    public static final String CRUD_ACTION_UPDATE = "update";
    public static final String CRUD_ACTION_INSERT = "insert";
    public static final String CRUD_ACTION_DELETE = "delete";

    public static final String JSON_NODE_TABLE_NAME = "table_name";
    public static final String JSON_NODE_EXECUTE_COUNT = "execute_count";
    public static final String JSON_NODE_ACTION = "action";
    public static final String JSON_NODE_FAIL_INFO = "fail_info";

    public static final String JSON_TABLE_NAME_MERCH_UDA = "merchuda";
    public static final String JSON_TABLE_NAME_MERCH_UDA_VALUE = "merchudavalue";
    public static final String JSON_TABLE_NAME_MERCH_UDA_HIER_DEFAULT = "merchudahierdefault";
    public static final String JSON_TABLE_NAME_MERCH_CLASS = "merchclass";
    public static final String JSON_TABLE_NAME_MERCH_DEPS = "merchdeps";
    public static final String JSON_TABLE_NAME_MERCH_SUBCLASS = "merchsubclass";
    public static final String JSON_TABLE_NAME_BRAND = "brand";
    public static final String JSON_TABLE_NAME_PRODUCT = "product";
    public static final String JSON_TABLE_NAME_PRODUCT_BARCODE = "ProductBarcode";
    public static final String JSON_TABLE_NAME_PRODUCT_CORE_RANGE = "productcorerange";
    public static final String JSON_TABLE_NAME_PRODUCT_VOLUMETRICS = "ProductVolumeMetrics";
    public static final String JSON_TABLE_NAME_SUPPLIER_ACCOUNT_PRODUCT = "SupplierAccountProduct";
    public static final String JSON_TABLE_NAME_SUPPLIER_ACCOUNT = "supplieraccount";
    public static final String JSON_TABLE_NAME_COUNTRY = "country";
    public static final String JSON_TABLE_NAME_LOCATION = "location";
    public static final String JSON_TABLE_NAME_LOCATION_STATE = "locationstate";
    public static final String JSON_TABLE_NAME_LOCATION_STATE_MAPPING = "locationstatemapping";
    public static final String JSON_TABLE_NAME_LOCATION_SET_CTL = "locationsetctl";
    public static final String JSON_TABLE_NAME_LOCATION_SET_DTL = "locationsetdtl";
    public static final String JSON_TABLE_NAME_POS_ITEM_ROLLUP = "positemrollup";
    public static final String JSON_TABLE_NAME_STOCK_INFO = "StockInfo";
    public static final String JSON_TABLE_NAME_STORE_INFO = "storeInfo";
    public static final String JSON_TABLE_NAME_PRODUCT_UDA_MAP = "ProductUdaMap";
    public static final String JSON_TABLE_NAME_PRODUCT_UDA_DATE = "ProductUdaDate";



    public static LocalDateTime localDateTime() {
        ZoneId zoneId = ZoneId.of("UTC");  //Do we really need this? Isn't by default zone is already in UTC?
        LocalDateTime localDateTime = LocalDateTime.now(zoneId).truncatedTo(ChronoUnit.SECONDS);
        return localDateTime;
    }
}
