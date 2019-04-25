package fz.fxq.common;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.StringUtils;

import java.io.*;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CommonApplicationTests {
    static Logger logger = LoggerFactory.getLogger(CommonApplication.class);

    @Test
    public void test() throws IOException {
        int type = 1;

        File inFile = null;
        File outFile = null;

        if (type == 1) {
            inFile = new File("F:\\whiteResult.txt");
            outFile = new File("F:\\whiteResult1200000.txt");
        } else if (type == 2) {
            inFile = new File("F:\\blackResult.txt");
            outFile = new File("F:\\blackResult1200000.txt");
        }
        long startMillis = System.currentTimeMillis();
        FileInputStream fileInputStream = new FileInputStream(inFile);
        InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream);
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
        String line = "";
        FileWriter fileWriter = new FileWriter(outFile);
        long count = 0;
        while ((line = bufferedReader.readLine()) != null) {
            count++;
//            logger.info(line);
            if (count < 1200000) {
                continue;
            }
            fileWriter.write("count" + count + line + "\r\n");
            if (count > 1300000) {
                break;
            }
        }
        fileWriter.close();
        bufferedReader.close();
        inputStreamReader.close();
        fileInputStream.close();
        long endMillis = System.currentTimeMillis();

        logger.info((endMillis - startMillis) + "毫秒   ");

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
        File whiteFile = new File("F:\\whiteResult.txt");//D:\$RECYCLE.BIN
        File blackFile = new File("F:\\blackResult.txt");//F:\$RECYCLE.BIN

        long startMillis = System.currentTimeMillis();

        long whiteMapSize = 0;
        long blackMapSize = 0;
        for (int i = 0; i < 1; i++) {
            Map<String, String> whiteMap = read(whiteFile, i * 100000, (i + 1) * 6000000);
            Map<String, String> blackMap = read(blackFile, i * 100000, (i + 1) * 6000000);

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
            blackMapSize = blackMapSize + blackMap.size();
            logger.info((endMillis - startMillis) + "whiteMap   " + whiteMapSize);
            logger.info((endMillis - startMillis) + "blackMap   " + blackMapSize);


            File whiteFile1 = new File("F:\\whiteResult" + i + ".txt");

            FileWriter fileWriterWhite = new FileWriter(whiteFile1);
            for (String key : whiteMap.keySet()) {
                fileWriterWhite.write("D:\\" + key + "\r\n");
            }
            fileWriterWhite.close();

            File blackFile1 = new File("F:\\blackResult" + i + ".txt");
            FileWriter fileWriterBlack = new FileWriter(blackFile1);
            for (String key : blackMap.keySet()) {
                fileWriterBlack.write("F:\\" + key + "\r\n");
            }
            fileWriterBlack.close();
        }
    }

    @Test
    public void test3(){

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

            line = line.substring(1);
            map.put(line, count + "");

            if (count % 10000 == 0) {
                logger.error("count===================" + count);
            }
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
