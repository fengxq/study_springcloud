package fz.fxq.zuul.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {
    Logger logger = LoggerFactory.getLogger(this.getClass());

    @GetMapping("info/{userId}")
    public String getUserInfo(@PathVariable String userId) {
        logger.info("zuul userinfo " + userId);
        return "zuul userinfo " + userId;
    }
}
