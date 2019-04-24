package fz.fxq.common;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.StringUtils;

import java.io.*;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CommonApplicationTests {
    static Logger logger = LoggerFactory.getLogger(CommonApplication.class);

    @Test
    public void match() throws IOException {
        File whiteFile = new File("F:\\whiteResult.txt");
        File blackFile = new File("F:\\blackResult.txt");

        File inFile = blackFile;
        File outFile = new File("F:\\blackResult100000.txt");

        long startMillis = System.currentTimeMillis();
        FileInputStream fileInputStream = new FileInputStream(inFile);
        InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream);
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
        String line = "";
        FileWriter fileWriter = new FileWriter(outFile);
        while ((line = bufferedReader.readLine()) != null) {
//            logger.info(line);
            fileWriter.write(line);
        }
        fileWriter.close();
        bufferedReader.close();
        inputStreamReader.close();
        fileInputStream.close();
        long endMillis = System.currentTimeMillis();

        logger.info((endMillis - startMillis) + "毫秒   " );

    }

    @Test
    public void test1() throws Exception {
        File whiteFile = new File("F:\\whiteResult.txt");
        FileReader fileReader = new FileReader(whiteFile);
        LineNumberReader lineNumberReader = new LineNumberReader(fileReader);
        lineNumberReader.skip(Long.MAX_VALUE);
        long lines = lineNumberReader.getLineNumber();
        lineNumberReader.close();

        logger.info("lines==============================" + lines);//4531775  4366060

    }

    @Test
    public void test2() throws Exception {
        File whiteFile = new File("F:\\whiteResult.txt");
        File blackFile = new File("F:\\blackResult.txt");

        long startMillis = System.currentTimeMillis();

        long whiteMapSize = 0;
        long blackMapSize = 0;
        for (int i = 0; i < 50; i++) {
            Map<String, String> whiteMap = read(whiteFile, i * 100000, (i + 1) * 100000 + 10000);
            Map<String, String> blackMap = read(blackFile, i * 100000, (i + 1) * 100000 + 10000);

        /*Map<String, String> whiteMap = new ConcurrentHashMap<>();
        whiteMap.put("a", "1");
        whiteMap.put("b", "1");
        whiteMap.put("c", "1");
        Map<String, String> blackMap = new ConcurrentHashMap<>();
        blackMap.put("b", "1");
        blackMap.put("c", "1");
        blackMap.put("e", "1");*/

            Iterator<String> iterator = whiteMap.keySet().iterator();
            while (iterator.hasNext()) {
                String key = iterator.next();
                String value = blackMap.remove(key);
//                logger.info("key" + key + "   value" + value);

                if (!StringUtils.isEmpty(value)) {
                    whiteMap.remove(key);
                }
            }

            long endMillis = System.currentTimeMillis();

            whiteMapSize = whiteMapSize + whiteMap.size();
            blackMapSize = blackMapSize + whiteMap.size();
            logger.info((endMillis - startMillis) + "whiteMap   " + whiteMapSize);
            logger.info((endMillis - startMillis) + "blackMap   " + blackMapSize);


            File whiteFile1 = new File("F:\\whiteResult" + i + ".txt");

            FileWriter fileWriterWhite = new FileWriter(whiteFile1);
            for (String key : whiteMap.keySet()) {
                fileWriterWhite.write(key + "\r\n");
            }
            fileWriterWhite.close();

            File blackFile1 = new File("F:\\blackResult" + i + ".txt");
            FileWriter fileWriterBlack = new FileWriter(blackFile1);
            for (String key : blackMap.keySet()) {
                fileWriterBlack.write(key + "\r\n");
            }
            fileWriterBlack.close();
        }
    }

    public Map<String, String> read(File file, long beginCount, long endCount) throws Exception {
        long startMillis = System.currentTimeMillis();
        FileInputStream fileInputStream = new FileInputStream(file);
        InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream);
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
        String line = "";
        Map<String, String> map = new ConcurrentHashMap<>();
        long count = 0;
        while ((line = bufferedReader.readLine()) != null) {
            count++;
//            logger.info(line);
            if (count <= beginCount) {
                continue;
            }
            map.put(line, "1");
            if (count >= endCount) {
                break;
            }
        }
        bufferedReader.close();
        inputStreamReader.close();
        fileInputStream.close();
        long endMillis = System.currentTimeMillis();

        logger.info((endMillis - startMillis) + "毫秒read   " + map.size());
        return map;
    }


}
