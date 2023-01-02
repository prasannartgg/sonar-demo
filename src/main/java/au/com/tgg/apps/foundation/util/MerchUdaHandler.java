package au.com.tgg.apps.foundation.util;

import au.com.tgg.apps.foundation.model.MerchUdaFieldMap;

import java.lang.reflect.Field;
import java.math.BigInteger;

public class MerchUdaHandler {
    public static <T> void populateEntityByUda(T t, String udaCodeName, String filedValue) {
        String fieldName = "column";
        if (udaCodeName == null || udaCodeName.isEmpty()) {
            return;
        }
        try {
            for (MerchUdaFieldMap merchUdaFieldMap : MerchUdaFieldMap.values()) {
                if (merchUdaFieldMap.getUda_code_name().equalsIgnoreCase(udaCodeName)) {
                    fieldName = merchUdaFieldMap.getFieldName();
                    break;
                }
            }
            Field field = t.getClass().getDeclaredField(fieldName);
            if (field != null) {
                field.setAccessible(true);
                final Class<?> type = field.getType();
                if (BigInteger.class.isAssignableFrom(type)) {
                    field.set(t, new BigInteger(filedValue));
                } else if (Integer.class.isAssignableFrom(type)) {
                    field.set(t, Integer.valueOf(filedValue));
                } else {
                    field.set(t, filedValue);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            return;
        }
    }

}
