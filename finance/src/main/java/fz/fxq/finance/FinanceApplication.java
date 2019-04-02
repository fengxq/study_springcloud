package fz.fxq.finance;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient//使用该注解将注册服务到eureka
public class FinanceApplication {
    static Logger logger = LoggerFactory.getLogger(FinanceApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(FinanceApplication.class, args);

        logger.info("--------------------------");
        logger.info("----Finance Start Success----");
        logger.info("--------------------------");
    }
}
