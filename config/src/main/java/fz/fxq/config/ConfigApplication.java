package fz.fxq.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
@EnableConfigServer
public class ConfigApplication {
    static Logger logger = LoggerFactory.getLogger(ConfigApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(ConfigApplication.class, args);

        logger.info("--------------------------");
        logger.info("----Config Start Success----");
        logger.info("--------------------------");
    }

}
