package org.yang.docker.test.base;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.jn.persists.model.BaseDO;
import com.jn.persists.select.WhereCondition;
import com.jn.utils.ClassUtil;
import com.jn.utils.SqlUtil;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.ArrayList;
import java.util.List;

/**
 * org.yang.docker.test.base.BaseMapper
 *
 * @author eleven
 * @date 2019/07/16
 */
public interface BaseMapper<T extends BaseDO> {

    /**
     * 根据条件分页从数据库中查询所有数据
     *
     * @param tClass
     * @param whereConditionList
     * @param pageNum
     * @param pageSize
     * @return
     */
    default Page<T> findWithColumnByConditionListAndPage(
            Class<T> tClass,
            ArrayList<WhereCondition> whereConditionList,
            int pageNum,
            int pageSize
    ) {
        PageHelper.startPage(pageNum, pageSize);
        String condition = SqlUtil.conditionListToString(whereConditionList);

        return selectWithColumnByConditionAndPageFromDB(
                ClassUtil.getFullColumnStringByDOClass(tClass),
                ClassUtil.getTableNameByDOClass(tClass),
                condition
        );
    }

    /**
     * 根据条件从数据库中查询所有数据
     *
     * @param tClass
     * @param condition
     * @param pageNum
     * @param pageSize
     * @return
     */
    default Page<T> findWithColumnByConditionAndPage(
            Class<T> tClass,
            String condition,
            int pageNum,
            int pageSize
    ) {
        PageHelper.startPage(pageNum, pageSize);

        return selectWithColumnByConditionAndPageFromDB(
                ClassUtil.getFullColumnStringByDOClass(tClass),
                ClassUtil.getTableNameByDOClass(tClass),
                condition
        );
    }

    /**
     * 根据条件分页从数据库中查询数据
     *
     * @param columnString
     * @param tableName
     * @param condition
     * @return
     */
    @Select("select ${columnString} from ${tableName} where ${condition}")
    Page<T> selectWithColumnByConditionAndPageFromDB(
            @Param("columnString") String columnString,
            @Param("tableName") String tableName,
            @Param("condition") String condition
    );

    /**
     * 根据条件从数据库中查询所有数据
     *
     * @param tClass
     * @param whereConditionList
     * @return
     */
    default List<T> findWithColumnByConditionList(
            Class<T> tClass,
            ArrayList<WhereCondition> whereConditionList
    ) {
        String condition = SqlUtil.conditionListToString(whereConditionList);

        return selectWithColumnByConditionFromDB(
                ClassUtil.getFullColumnStringByDOClass(tClass),
                ClassUtil.getTableNameByDOClass(tClass),
                condition
        );
    }

    /**
     * 根据条件从数据库中查询所有数据
     *
     * @param tClass
     * @param condition
     * @return
     */
    default List<T> findWithColumnByCondition(
            Class<T> tClass,
            String condition
    ) {
        return selectWithColumnByConditionFromDB(
                ClassUtil.getFullColumnStringByDOClass(tClass),
                ClassUtil.getTableNameByDOClass(tClass),
                condition
        );
    }


    /**
     * 根据条件从数据库中查询所有数据
     *
     * @param columnString
     * @param tableName
     * @param condition
     * @return
     */
    @Select("select ${columnString} from ${tableName} where ${condition}")
    List<T> selectWithColumnByConditionFromDB(
            @Param("columnString") String columnString,
            @Param("tableName") String tableName,
            @Param("condition") String condition
    );

    /**
     * 通过主键id获取有效数据
     *
     * @param tClass
     * @param id
     * @return
     */
    default T findWithColumnById(Class<T> tClass, int id) {
        return selectWithColumnByIdFromDB(
                ClassUtil.getFullColumnStringByDOClass(tClass),
                ClassUtil.getTableNameByDOClass(tClass),
                id
        );
    }

    /**
     * 通过ID获取有效数据
     *
     * @param columnString
     * @param tableName
     * @param id
     * @return
     */
    @Select("select ${columnString} from ${tableName} where id=#{id}")
    T selectWithColumnByIdFromDB(
            @Param("columnString") String columnString,
            @Param("tableName") String tableName,
            @Param("id") int id
    );

    /**
     * 通过DO Class获取分页所有数据
     *
     * @param tClass
     * @param pageNum
     * @param pageSize
     * @return
     */
    default Page<T> findWithColumnByPage(Class<T> tClass, int pageNum, int pageSize) {

        PageHelper.startPage(pageNum, pageSize);

        return selectWithColumnByPageFromDB(
                ClassUtil.getFullColumnStringByDOClass(tClass),
                ClassUtil.getTableNameByDOClass(tClass)
        );
    }

    /**
     * 分页从数据库中查询数据
     *
     * @param columnString
     * @param tableName
     * @return
     */
    @Select("select ${columnString} from ${tableName}")
    Page<T> selectWithColumnByPageFromDB(
            @Param("columnString") String columnString,
            @Param("tableName") String tableName
    );

    /**
     * 通过DO Class获取所有数据
     *
     * @param tClass
     * @return
     */
    default List<T> findAllWithColumn(Class<T> tClass) {
        return selectWithColumnFromDB(
                ClassUtil.getFullColumnStringByDOClass(tClass),
                ClassUtil.getTableNameByDOClass(tClass)
        );
    }

    /**
     * 从数据库中查询所有数据
     *
     * @param columnString
     * @param tableName
     * @return
     */
    @Select("select ${columnString} from ${tableName}")
    List<T> selectWithColumnFromDB(
            @Param("columnString") String columnString,
            @Param("tableName") String tableName
    );

}
