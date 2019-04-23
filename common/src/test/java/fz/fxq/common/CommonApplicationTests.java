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
        String blackPath = "F:\\";
        String blackResult = "F:\\blackResult.txt";
        String whitePath = "D:\\";
        String whiteResult = "D:\\whiteResult.txt";

        File blackResultFile = new File(blackResult);
        if (blackResultFile.exists()) {
            blackResultFile.delete();
        }
        FileWriter blackWriter = new FileWriter(blackResultFile);
        File blackPathFile = new File(blackPath);
        new MyThread(blackPathFile, blackWriter, "black").start();

        logger.info("black match end ......");

        File whiteResultFile = new File(whiteResult);
        if (whiteResultFile.exists()) {
            whiteResultFile.delete();
        }
        FileWriter whiteWriter = new FileWriter(whiteResultFile);
        File whitePathFile = new File(whitePath);
        new MyThread(whitePathFile, whiteWriter, "white").start();

        logger.info("white match end ......");
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

    class MyThread extends Thread {
        File file;
        FileWriter fileWriter;
        String threadName;

        public MyThread(File file, FileWriter fileWriter, String threadName) {
            this.file = file;
            this.fileWriter = fileWriter;
            this.threadName = threadName;
        }

        @Override
        public void run() {
            long start = System.currentTimeMillis();
            readFile(file, fileWriter);

            try {
                fileWriter.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            long end = System.currentTimeMillis();
            logger.info((end - start) + "[" + threadName + "]");
        }
    }

}
