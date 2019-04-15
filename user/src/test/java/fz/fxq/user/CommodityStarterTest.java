package fz.fxq.user;

import fz.fxq.commoditystarter.service.StarterService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CommodityStarterTest {
    Logger logger = LoggerFactory.getLogger(CommodityStarterTest.class);

    @Autowired
    private StarterService starterService;

    @Test
    public void test() {
        String[] splitArray = starterService.split(",");
        logger.info("splitArray = " + splitArray);
        logger.info("splitArray = " + splitArray.length);
        logger.info("splitArray = " + splitArray[0]);
    }
}
