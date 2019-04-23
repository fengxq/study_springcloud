package fz.fxq.common;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CommonApplication {
    static Logger logger = LoggerFactory.getLogger(CommonApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(CommonApplication.class, args);

        logger.info("--------------------------");
        logger.info("----Common Start Success----");
        logger.info("--------------------------");
    }

}
