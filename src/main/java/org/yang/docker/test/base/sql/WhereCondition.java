package org.yang.docker.test.base.sql;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * org.yang.docker.test.base.sql.WhereCondition
 *
 * @author eleven
 * @date 2019/07/16
 */
@Getter
@AllArgsConstructor
public class WhereCondition {

    private String columnName;

    private Object value;

    private WhereOperator operator;

    private WhereUnion union;

    public WhereCondition(String columnName, Object value, WhereOperator operator) {
        this.columnName = columnName;
        this.value = value;
        this.operator = operator;
    }

    @Override
    public String toString() {
        boolean isNumber = value instanceof Number;

        if (!isNumber) {
            value = "'" + value + "'";
        }

        return columnName + operator.getOperator() + value;
    }
}
