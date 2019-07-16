package org.yang.docker.test.util;

import com.google.common.base.CaseFormat;
import com.google.common.collect.Lists;
import org.yang.docker.test.base.sql.WhereCondition;
import org.yang.docker.test.base.sql.WhereOperator;

import java.util.ArrayList;

/**
 * org.yang.docker.test.util.StringUtil
 *
 * @author eleven
 * @date 2019/07/16
 */
public class StringUtil {

    public static void main(String[] args) {
        ArrayList<WhereCondition> whereConditions = Lists.newArrayList();

        whereConditions.add(new WhereCondition("id", 2, WhereOperator.GT));
        whereConditions.add(new WhereCondition("temp_hi", "51", WhereOperator.NE));

        conditionListToString(whereConditions);
    }

    public static String conditionListToString(ArrayList<WhereCondition> whereConditions) {
        StringBuilder stringBuilder = new StringBuilder(256);

        for (WhereCondition whereCondition : whereConditions) {
            stringBuilder.append(whereCondition.toString());

            if (null != whereCondition.getUnion()) {
                stringBuilder.append(whereCondition.getUnion().getUnion());
            }
        }

        return stringBuilder.toString();
    }

    public static String upperCamelToUnderscore(String string) {
        return CaseFormat.UPPER_CAMEL.to(CaseFormat.LOWER_UNDERSCORE, string);
    }

    public static String lowerCamelToUnderscore(String string) {
        return CaseFormat.LOWER_CAMEL.to(CaseFormat.LOWER_UNDERSCORE, string);
    }

    public static boolean isNotEmpty(String string) {
        return !isEmpty(string);
    }

    public static boolean isEmpty(String string) {
        return null == string || string.trim().length() == 0;
    }
}
