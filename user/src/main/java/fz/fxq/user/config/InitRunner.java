package fz.fxq.user.config;

import fz.fxq.user.config.shiro.ShiroConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * 在所有 Spring Beans都初始化之后，SpringApplication.run()之前执行
 */
@Component
@Order(1)
public class InitRunner implements CommandLineRunner {
    Logger logger = LoggerFactory.getLogger(ShiroConfig.class);

    @Override
    public void run(String... args) throws Exception {
        logger.info("[start sequence]InitRunner......");
    }
}
