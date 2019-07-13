package org.yang.docker.test.endpoint;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;

/**
 * org.yang.docker.test.endpoint.MainController
 *
 * @author eleven
 * @date 2019/07/13
 */
@Slf4j
@RestController
public class MainController {

    @GetMapping("/")
    public String index() {
        if (log.isInfoEnabled()) {
            log.info("visit / at {}", LocalDate.now());
        }

        if (log.isErrorEnabled()) {
            log.error("visit / at {}", LocalDate.now());
        }

        return "hello world";
    }
}
