package fz.fxq.common;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CommonApplicationTests {
    static Logger logger = LoggerFactory.getLogger(CommonApplication.class);

    @Test
    public void match() throws IOException {
        String blackPath = "E:\\personal";
        String blackResult = "E:\\blackResult.txt";
        String whitePath = "E:\\personal";
        String whiteResult = "E:\\whiteResult.txt";

        File blackResultFile = new File(blackResult);
        if (blackResultFile.exists()) {
            blackResultFile.delete();
        }
        FileWriter blackWriter = new FileWriter(blackResultFile);
        File blackPathFile = new File(blackPath);
        readFile(blackPathFile, blackWriter);
        blackWriter.close();
        logger.info("black match end ......");

        File whiteResultFile = new File(whiteResult);
        if (whiteResultFile.exists()) {
            whiteResultFile.delete();
        }
        FileWriter whiteWriter = new FileWriter(whiteResultFile);
        File whitePathFile = new File(whitePath);
        readFile(whitePathFile, whiteWriter);
        whiteWriter.close();

        logger.info("white match end ......");
    }

    public void readFile(File file, FileWriter fileWriter) throws IOException {
        File[] files = file.listFiles();
        if (files == null || files.length <= 0) {
            return;
        }
        for (File f : files) {
            logger.info("match......[" + f.getPath() + "]");
            fileWriter.write(f.getPath() + "\r\n");
            if (f.isDirectory()) {
                readFile(f, fileWriter);
            }
        }
    }

}
