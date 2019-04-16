package fz.fxq.user.controller;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

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
    public String loginShiro(HttpServletRequest request, Map<String, Object> map) {
        //shiro异常类的全类名
        String shiroLoginFailure = (String) request.getAttribute("shiroLoginFailure");
        logger.info("shiroLoginFailure[" + shiroLoginFailure + "]");
        String loginMessage = "";

        if (!StringUtils.isEmpty(shiroLoginFailure)) {
            if (UnknownAccountException.class.getName().equals(shiroLoginFailure)) {
                loginMessage = "账号不存在：";
            } else if (IncorrectCredentialsException.class.getName().equals(shiroLoginFailure)) {
                loginMessage = "密码不正确：";
            } else if ("kaptchaValidateFailed".equals(shiroLoginFailure)) {
                loginMessage = "验证码错误";
            } else {
                loginMessage = "其他异常shiroLoginFailure[" + shiroLoginFailure + "]";
            }
        }

        map.put("loginMessage", loginMessage);
        logger.info("loginMessage[" + loginMessage + "]");
        return "shiro/index";
    }

    @PostMapping("shiro/login2")
    @ResponseBody
    public String loginShiro(@RequestParam String userName, @RequestParam String userPassword) {
        logger.info("loginShiro,userName[" + userName + "]userPassword[" + userPassword + "]");
        String loginMessage = "success";
        try {
            Subject subject = SecurityUtils.getSubject();
            UsernamePasswordToken usernamePasswordToken = new UsernamePasswordToken(userName, userPassword);
            subject.login(usernamePasswordToken);
        } catch (UnknownAccountException e) {
            loginMessage = "UnknownAccountException";
        } catch (IncorrectCredentialsException e) {
            loginMessage = "IncorrectCredentialsException";
        } catch (LockedAccountException e) {
            loginMessage = "LockedAccountException";
        } catch (AuthenticationException e) {
            loginMessage = "AuthenticationException";
        }
        logger.info("loginMessage[" + loginMessage + "]");
        return loginMessage;
    }

}
