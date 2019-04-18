package fz.fxq.commoditystarter.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StringUtils;

public class StarterService {
    Logger logger = LoggerFactory.getLogger(this.getClass());

    private String config;

    public StarterService(String config) {
        logger.info("服务启动时执行：commodityStarter中StarterService的构造方法");
        this.config = config;
    }

    public String[] split(String separatorChar) {
        return StringUtils.split(config, separatorChar);
    }
}
