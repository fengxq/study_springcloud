package fz.fxq.user;

import org.mybatis.spring.annotation.MapperScan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient//使用该注解将注册服务到eureka
@MapperScan("fz.fxq.user.mapper")
public class UserApplication {
    static Logger logger = LoggerFactory.getLogger(UserApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(UserApplication.class, args);

        logger.info("--------------------------");
        logger.info("----User Start Success----");
        logger.info("--------------------------");
    }

}
