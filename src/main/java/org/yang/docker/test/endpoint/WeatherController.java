package org.yang.docker.test.endpoint;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.yang.docker.test.model.domain.WeatherDO;
import org.yang.docker.test.service.single.WeatherService;

/**
 * org.yang.docker.test.endpoint.WeatherController
 *
 * @author eleven
 * @date 2019/07/13
 */
@Slf4j
@RestController
public class WeatherController {

    @Autowired
    private WeatherService weatherService;

    @GetMapping("/weather/info/{id}")
    public WeatherDO getWithColumnById(@PathVariable("id") int id) {
        return weatherService.getWithColumnById(id);
    }
}
