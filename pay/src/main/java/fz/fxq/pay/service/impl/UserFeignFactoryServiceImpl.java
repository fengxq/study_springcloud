package fz.fxq.pay.service.impl;

import feign.hystrix.FallbackFactory;
import fz.fxq.pay.service.UserFeignService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class UserFeignFactoryServiceImpl implements FallbackFactory<UserFeignService> {
    Logger logger = LoggerFactory.getLogger(this.getClass());

    @Override
    public UserFeignService create(Throwable throwable) {
        logger.error("系统异常", throwable);
        return new UserFeignService() {
            @Override
            public String getUserInfo(String userId) {
                logger.error("调用远程服务user-service失败，熔断getUserInfo方法");
                return "[fallback][getUserInfo] userId[" + userId + "]";
            }
        };
    }
}
