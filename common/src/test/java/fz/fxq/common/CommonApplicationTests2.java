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
public class CommonApplicationTests2 {
    static Logger logger = LoggerFactory.getLogger(CommonApplication.class);

    @Test
    public void match() throws IOException {
        String blackPath = "F:\\";
        String blackResult = "F:\\blackResult.txt";

        File blackResultFile = new File(blackResult);
        if (blackResultFile.exists()) {
            blackResultFile.delete();
        }
        FileWriter blackWriter = new FileWriter(blackResultFile);
        File blackPathFile = new File(blackPath);
        readFile(blackPathFile, blackWriter);

        long start = System.currentTimeMillis();
        long end = System.currentTimeMillis();
        logger.info((end - start) + "[" + CommonApplicationTests2.class + "]");

    }

    public void readFile(File file, FileWriter fileWriter) {
        try {
            File[] files = file.listFiles();
            if (files == null || files.length <= 0) {
                return;
            }
            for (File f : files) {
                fileWriter.write(f.getPath() + "\r\n");
                if (f.isDirectory()) {
                    readFile(f, fileWriter);
                }
            }
        } catch (Exception e) {
            logger.error("读取异常：", e);
        }
    }


}
