package fz.fxq.finance.service.impl;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import fz.fxq.finance.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class UserServiceImpl implements UserService {
    Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    RestTemplate balanceTemplate;

    @Override
    @HystrixCommand(fallbackMethod = "getUserInfoError")
    public String getUserInfo(String userId) {

        logger.info("[UserController]restTemplate[" + balanceTemplate + "]");

        String obj = balanceTemplate.getForObject("http://user-service/userService/user/info/get/" + userId, String.class);
        logger.info("obj=" + obj);

        return obj;
    }

    private String getUserInfoError(String userId) {
        logger.error("调用远程服务user-service失败，熔断getUserInfo方法");
        return "user " + userId + " doError";
    }

}
