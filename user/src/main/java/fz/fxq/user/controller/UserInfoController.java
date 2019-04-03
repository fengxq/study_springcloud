package fz.fxq.user.controller;

import fz.fxq.user.service.UserInfoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("user/info")
public class UserInfoController {
    Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    UserInfoService userInfoService;

    @GetMapping("get/{userId}")
    public String getUserInfo(@PathVariable String userId) {
        return userInfoService.getUserInfo(userId);
    }

    @GetMapping("add/{userId}/{userName}")
    public String addUserInfo(@PathVariable String userId, @PathVariable String userName) {
        int ret = userInfoService.addUserInfo(userId, userName);
        logger.info("addUserInfo,ret=" + ret);
        return "SUCCESS";
    }
}
