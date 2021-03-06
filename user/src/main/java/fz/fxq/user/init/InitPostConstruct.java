package fz.fxq.user.init;

import fz.fxq.user.service.LoginService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class InitPostConstruct {
    Logger logger = LoggerFactory.getLogger(InitPostConstruct.class);

    @Autowired
    LoginService loginService;

    private InitPostConstruct() {
        logger.info("[PostConstruct]构造方法第一个执行........");
    }

    @PostConstruct
    private void init() {
        logger.info("[start sequence]PostConstruct,Bean注入第二个执行........loginService[" + loginService + "]");
        logger.info("[start sequence]PostConstruct,注解PostConstruct第三个执行........");
    }

}
