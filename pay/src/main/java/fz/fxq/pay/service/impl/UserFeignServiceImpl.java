package fz.fxq.pay.service.impl;

import fz.fxq.pay.service.UserFeignService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class UserFeignServiceImpl implements UserFeignService {
    Logger logger = LoggerFactory.getLogger(this.getClass());

    @Override
    public String getUserInfo(String userId) {
        logger.error("调用远程服务user-service失败，熔断getUserInfo方法");
        return "user " + userId + " doError";
    }
}
