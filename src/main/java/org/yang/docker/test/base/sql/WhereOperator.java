package org.yang.docker.test.base.sql;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * org.yang.docker.test.base.WhereOperator
 *
 * @author eleven
 * @date 2019/07/16
 */
@Getter
@AllArgsConstructor
public enum WhereOperator {
    EQ(" = "),
    NE(" != "),
    LT(" < "),
    LE(" <= "),
    GT(" > "),
    GE(" >=");

    private String operator;
}
