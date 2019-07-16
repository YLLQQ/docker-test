package org.yang.docker.test.service.single;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.yang.docker.test.DockerTestApplicationTests;
import org.yang.docker.test.model.domain.WeatherDO;

import java.util.List;

/**
 * org.yang.docker.test.service.single.WeatherServiceTest
 *
 * @author eleven
 * @date 2019/07/16
 */
public class WeatherServiceTest extends DockerTestApplicationTests {

    @Autowired
    private WeatherService weatherService;

    @Test
    public void getWeatherDO() {

        long start = System.currentTimeMillis();

        List<WeatherDO> weatherDOList = weatherService.getWeatherDO();

        for (WeatherDO weatherDO : weatherDOList) {
            System.out.println(weatherDO);
        }

        long end = System.currentTimeMillis();
        System.out.println(end - start);

        start = System.currentTimeMillis();

        weatherDOList = weatherService.getWeatherDO1();

        for (WeatherDO weatherDO : weatherDOList) {
            System.out.println(weatherDO);
        }

        end = System.currentTimeMillis();
        System.out.println(end - start);

        start = System.currentTimeMillis();

        WeatherDO weatherDO = weatherService.getWithColumnById();

        System.out.println(weatherDO);

        end = System.currentTimeMillis();
        System.out.println(end - start);
    }
}