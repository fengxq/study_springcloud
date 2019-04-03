package fz.fxq.finance.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("user")
public class UserController {
    Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    RestTemplate balanceTemplate;

    @GetMapping("getUserInfo/{userId}")
    public String getUserInfo(@PathVariable String userId) {
        logger.info("[UserController]restTemplate[" + balanceTemplate + "]");

        Object obj = "";
        try {
            obj = balanceTemplate.getForObject("http://user-service/userService/user/info/get/" + userId, String.class);
            logger.info("obj=" + obj);
        } catch (Exception e) {
            logger.error("系统异常", e);
        }

        return "fxq test " + obj;
    }
}
