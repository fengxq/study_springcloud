package fz.fxq.user.controller;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("login")
public class LoginController {
    Logger logger = LoggerFactory.getLogger(this.getClass());

    @GetMapping("shiro/login.html")
    public String loginShiro() {
        return "shiro/login";
    }

    @GetMapping("shiro/index.html")
    public String indexShiro() {
        return "shiro/index";
    }

    @GetMapping("403")
    public String unAuthorizedUrl() {
        return "shiro/403";
    }

    @PostMapping("shiro/login")
    @ResponseBody
    public String loginShiro(@RequestParam String userName, @RequestParam String userPassword) {
        logger.info("loginShiro,userName[" + userName + "]userPassword[" + userPassword + "]");
        String loginMessage = "success";

        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken usernamePasswordToken = new UsernamePasswordToken(userName, userPassword);
        subject.login(usernamePasswordToken);

        logger.info("loginMessage[" + loginMessage + "]");
        return loginMessage;
    }

}
