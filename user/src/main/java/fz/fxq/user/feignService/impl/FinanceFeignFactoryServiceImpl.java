package fz.fxq.user.feignService.impl;

import feign.hystrix.FallbackFactory;
import fz.fxq.user.feignService.FinanceFeignService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class FinanceFeignFactoryServiceImpl implements FallbackFactory<FinanceFeignService> {
    Logger logger = LoggerFactory.getLogger(this.getClass());

    @Override
    public FinanceFeignService create(Throwable throwable) {
        logger.error("系统异常", throwable);
        return new FinanceFeignService() {
            @Override
            public String getUserBalance(String userId) {
                logger.error("调用远程服务finance-service失败，getUserBalance");
                return "[fallback][getUserBalance] userId[" + userId + "]";
            }

            @Override
            public String getUserPayResult(String userId) {
                logger.error("调用远程服务finance-service失败，getUserPayResult");
                return "[fallback][getUserPayResult] userId[" + userId + "]";
            }
        };
    }
}
