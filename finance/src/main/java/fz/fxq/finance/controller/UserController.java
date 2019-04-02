package fz.fxq.finance.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("user")
public class UserController {
    Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    RestTemplate restTemplate;

    @GetMapping("getUserInfo")
    public String getUserInfo() {
        logger.info("[UserController]restTemplate[" + restTemplate + "]");

        Object obj = restTemplate.getForObject("http://user/user/login/restful/submit/redis", String.class);
        logger.info("obj=" + obj);

        return "fxq test";
    }
}
