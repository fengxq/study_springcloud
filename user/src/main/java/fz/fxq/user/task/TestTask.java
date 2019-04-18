package fz.fxq.user.task;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

/**
 * cron表达式详解
 */
@Configuration
@EnableScheduling
public class TestTask {
    Logger logger = LoggerFactory.getLogger(this.getClass());

    @Scheduled(cron = "0 0/1 * * * ?")
    public void test() {
        logger.info("TestTask.................................");
    }

}
