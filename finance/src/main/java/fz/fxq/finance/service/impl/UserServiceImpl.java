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
    @HystrixCommand(fallbackMethod = "getUserPayResultError")
    public String getUserPayResult(String userId) {
        logger.info("restTemplate[" + balanceTemplate + "]");

        String obj = balanceTemplate.getForObject("http://pay-service/payService/user/pay/result/" + userId, String.class);
        logger.info("obj=" + obj);

        return obj;
    }

    private String getUserPayResultError(String userId) {
        logger.error("调用远程服务pay-service失败，熔断getUserInfo方法");
        return "[fallback][getUserPayResult] userId[" + userId + "]";
    }

}
