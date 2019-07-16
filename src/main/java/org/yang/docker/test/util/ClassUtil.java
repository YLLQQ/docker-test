package org.yang.docker.test.util;

import org.yang.docker.test.base.BaseDO;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.StringJoiner;
import java.util.concurrent.ConcurrentHashMap;

import static org.yang.docker.test.util.StringUtil.*;

/**
 * org.yang.docker.test.util.ClassUtil
 *
 * @author eleven
 * @date 2019/07/16
 */
public class ClassUtil {
    private static final ConcurrentHashMap<Class, String> TABLE_NAME_CLASS_MAP = new ConcurrentHashMap();

    private static final ConcurrentHashMap<Class, String> FULL_COLUMN_STRING_CLASS_MAP = new ConcurrentHashMap();

    public static <T extends BaseDO> String getTableNameByDOClass(Class<T> tClass) {
        String tableName = TABLE_NAME_CLASS_MAP.get(tClass);

        if (isNotEmpty(tableName)) {
            return tableName;
        }

        String classSimpleName = tClass.getSimpleName();

        tableName = upperCamelToUnderscore(classSimpleName.substring(0, classSimpleName.length() - 2));

        TABLE_NAME_CLASS_MAP.put(tClass, tableName);

        return tableName;
    }

    public static <T> String getFullColumnStringByDOClass(Class<T> tClass) {
        String fullColumnString = FULL_COLUMN_STRING_CLASS_MAP.get(tClass);

        if (isNotEmpty(fullColumnString)) {
            return fullColumnString;
        }

        Field[] fields = tClass.getDeclaredFields();

        StringJoiner stringJoiner = new StringJoiner(",", "", "");

        for (int i = 0; i < fields.length; i++) {
            Field field = fields[i];
            int modifier = field.getModifiers();
            boolean isPrivateNotStaticOrFinal = Modifier.isPrivate(modifier) && !(Modifier.isStatic(
                    modifier) || Modifier.isFinal(modifier));

            if (isPrivateNotStaticOrFinal) {
                stringJoiner.add(lowerCamelToUnderscore(field.getName()));
            }
        }

        fullColumnString = stringJoiner.toString();

        FULL_COLUMN_STRING_CLASS_MAP.put(tClass, fullColumnString);

        return fullColumnString;
    }
}
