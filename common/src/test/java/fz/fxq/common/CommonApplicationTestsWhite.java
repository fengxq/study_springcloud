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
public class CommonApplicationTestsWhite {
    static Logger logger = LoggerFactory.getLogger(CommonApplication.class);

    @Test
    public void matchWhite() throws IOException {
        String whitePath = "D:\\";
        String whiteResult = "D:\\whiteResult.txt";

        FileMatchUtil.match(whitePath, whiteResult);
    }

}
