package org.yang.docker.test.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.yang.docker.test.base.BaseMapper;
import org.yang.docker.test.model.domain.WeatherDO;

/**
 * org.yang.docker.test.mapper.WeatherMapper
 *
 * @author eleven
 * @date 2019/07/16
 */
@Mapper
public interface WeatherMapper extends BaseMapper<WeatherDO> {

}
