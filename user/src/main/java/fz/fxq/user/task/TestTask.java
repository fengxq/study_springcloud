package fz.fxq.user.task;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * cron表达式详解
 */
@Component
public class TestTask {
    Logger logger = LoggerFactory.getLogger(this.getClass());

    @Scheduled(cron = "0 0/1 * * * ?")
    public void test() {
        logger.info("TestTask.................................");
    }

}
