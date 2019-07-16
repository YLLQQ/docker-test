package org.yang.docker.test.service.single;

import com.github.pagehelper.Page;
import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.yang.docker.test.base.sql.WhereCondition;
import org.yang.docker.test.base.sql.WhereOperator;
import org.yang.docker.test.mapper.WeatherMapper;
import org.yang.docker.test.model.domain.WeatherDO;

import java.util.ArrayList;
import java.util.List;

/**
 * org.yang.docker.test.service.single.WeatherService
 *
 * @author eleven
 * @date 2019/07/16
 */
@Service
public class WeatherService {

    @Autowired
    private WeatherMapper weatherMapper;

    public WeatherDO getWithColumnById() {
        return weatherMapper.findWithColumnById(WeatherDO.class, 1);
    }

    public Page<WeatherDO> getWeatherDOWithPage() {
        return weatherMapper.findWithColumnByPage(WeatherDO.class, 2, 2);
    }

    public List<WeatherDO> getWeatherDO() {
        ArrayList<WhereCondition> whereConditions = Lists.newArrayList();

        whereConditions.add(new WhereCondition("id", 1, WhereOperator.GT));

        return weatherMapper.findWithColumnByConditionListAndPage(WeatherDO.class, whereConditions, 1, 1);
    }

    public List<WeatherDO> getWeatherDO1() {
        return weatherMapper.findAllWithColumn(WeatherDO.class);
    }
}
