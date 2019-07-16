package org.yang.docker.test.base.sql;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * org.yang.docker.test.base.sql.WhereUnion
 *
 * @author eleven
 * @date 2019/07/16
 */
@Getter
@AllArgsConstructor
public enum WhereUnion {

    AND(" and "),
    OR(" or ");

    private String union;
}
