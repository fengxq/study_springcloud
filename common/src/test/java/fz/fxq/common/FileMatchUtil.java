package fz.fxq.common;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class FileMatchUtil {
    static Logger logger = LoggerFactory.getLogger(CommonApplication.class);

    public static void match(String filePath, String resultPath) throws IOException {
        long start = System.currentTimeMillis();

        File whiteResultFile = new File(resultPath);
        if (whiteResultFile.exists()) {
            whiteResultFile.delete();
        }
        FileWriter whiteWriter = new FileWriter(whiteResultFile);
        File whitePathFile = new File(filePath);
        readFile(whitePathFile, whiteWriter);

        long end = System.currentTimeMillis();
        logger.info("[" + resultPath + "]耗时" + (end - start));
    }

    public static void readFile(File file, FileWriter fileWriter) {
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
