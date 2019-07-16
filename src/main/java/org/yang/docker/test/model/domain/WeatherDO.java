package org.yang.docker.test.model.domain;

import lombok.Data;
import org.yang.docker.test.base.BaseDO;

import java.util.Date;

/**
 * @author eleven
 */
@Data
public class WeatherDO implements BaseDO {

    /**
     * null
     */
    private String city;

    /**
     * null
     */
    private Integer tempLo;

    /**
     * null
     */
    private Integer tempHi;

    /**
     * null
     */
    private Double prcp;

    /**
     * null
     */
    private Date date;

    /**
     * null
     */
    private Integer id;

}
