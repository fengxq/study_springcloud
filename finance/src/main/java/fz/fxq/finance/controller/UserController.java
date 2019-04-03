package fz.fxq.finance.controller;

import fz.fxq.finance.service.UserService;
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
    UserService userService;

    @GetMapping("getUserInfo/{userId}")
    public String getUserInfo(@PathVariable String userId) {

        Object obj = "";
        try {
            obj = userService.getUserInfo(userId);
        } catch (Exception e) {
            logger.error("系统异常", e);
        }

        return "fxq test " + obj;
    }

}
