package fz.fxq.user.config.shiro;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authz.AuthorizationException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ShiroExceptionController {
    Logger logger = LoggerFactory.getLogger(this.getClass());

    @ExceptionHandler(AuthenticationException.class)
    public String handleShiroException(AuthenticationException e) {
        logger.error("账户验证失败：", e);
        return e.getMessage();
    }

    @ExceptionHandler(AuthorizationException.class)
    public String handleShiroException(AuthorizationException e) {
        logger.error("没有权限：", e);
        return e.getMessage();
    }

    @ExceptionHandler(UnknownAccountException.class)
    public String handleShiroException(UnknownAccountException e) {
        logger.error("账号不存在：", e);
        return e.getMessage();
    }

    @ExceptionHandler(IncorrectCredentialsException.class)
    public String handleShiroException(IncorrectCredentialsException e) {
        logger.error("密码不正确：", e);
        return e.getMessage();
    }

    @ExceptionHandler(LockedAccountException.class)
    public String handleShiroException(LockedAccountException e) {
        logger.error("账号已被锁定：", e);
        return e.getMessage();
    }
}
