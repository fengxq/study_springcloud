package fz.fxq.pay;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableEurekaClient
@EnableHystrix
@EnableHystrixDashboard
@EnableFeignClients
//@EnableCircuitBreaker
public class PayApplication {
    static Logger logger = LoggerFactory.getLogger(PayApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(PayApplication.class, args);

        logger.info("--------------------------");
        logger.info("----Pay Start Success----");
        logger.info("--------------------------");
    }

}
