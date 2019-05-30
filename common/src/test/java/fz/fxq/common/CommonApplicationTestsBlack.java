package fz.fxq.common;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CommonApplicationTestsBlack {
    static Logger logger = LoggerFactory.getLogger(CommonApplicationTestsBlack.class);

    @Test
    public void matchBlack() throws IOException {
        String blackPath = "F:\\";
        String blackResult = "F:\\blackResult.txt";

        FileMatchUtil.match(blackPath, blackResult);

    }

}
