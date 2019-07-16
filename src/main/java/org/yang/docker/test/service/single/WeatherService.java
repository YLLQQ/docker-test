package org.yang.docker.test.service.single;

import com.github.pagehelper.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.yang.docker.test.mapper.WeatherMapper;
import org.yang.docker.test.model.domain.WeatherDO;

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

    public WeatherDO getWithColumnById(int id) {
        return weatherMapper.findWithColumnById(WeatherDO.class, id);
    }

    public Page<WeatherDO> getWeatherDOWithPage(int pageNum, int pageSize) {
        return weatherMapper.findWithColumnByPage(WeatherDO.class, pageNum, pageSize);
    }

    public List<WeatherDO> getWeatherDO() {
        return weatherMapper.findAllWithColumn(WeatherDO.class);
    }

    public List<WeatherDO> getWeatherDO1() {
        return weatherMapper.findAllWithColumn(WeatherDO.class);
    }
}
