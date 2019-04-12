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

    @GetMapping("balance/{userId}")
    public String getUserBalance(@PathVariable String userId) {

        return this.getClass() + " Balance=0.0 userId[" + userId + "]";
    }

    @GetMapping("pay/result/{userId}")
    public String getUserPayResult(@PathVariable String userId) {

        Object obj = "";
        try {
            obj = userService.getUserPayResult(userId);
        } catch (Exception e) {
            logger.error("系统异常", e);
        }

        return this.getClass() + " userId[" + userId + "] Result[" + obj + "]";
    }

}
