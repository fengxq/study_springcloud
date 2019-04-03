package fz.fxq.pay.controller;

import fz.fxq.pay.service.UserFeignService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("user")
public class UserController {
    Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    UserFeignService userFeignService;

    @GetMapping("getUserInfo/{userId}")
    public String getUserInfo(@PathVariable String userId) {

        Object obj = "";
        try {
            obj = userFeignService.getUserInfo(userId);
        } catch (Exception e) {
            logger.error("系统异常", e);
        }

        return "fxq test " + obj;
    }

}
