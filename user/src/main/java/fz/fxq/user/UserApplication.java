package fz.fxq.user;

import org.mybatis.spring.annotation.MapperScan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableEurekaClient
@EnableHystrix
@EnableHystrixDashboard
@EnableFeignClients
@EnableScheduling
@MapperScan("fz.fxq.user.mapper")
public class UserApplication {
    static Logger logger = LoggerFactory.getLogger(UserApplication.class);

    public static void main(String[] args) {
        logger.info("[start sequence]main start......");

        SpringApplication.run(UserApplication.class, args);

        logger.info("[start sequence]main end......");

        logger.info("--------------------------");
        logger.info("----User Start Success----");
        logger.info("--------------------------");
    }

}
