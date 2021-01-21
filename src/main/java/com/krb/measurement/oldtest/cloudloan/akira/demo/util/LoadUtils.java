package com.krb.measurement.oldtest.cloudloan.akira.demo.util;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.stream.Collectors;

/**
 * 私钥加载工具
 *
 * @author cloudloan
 */
public class LoadUtils {

    /**
     *
     */
    private LoadUtils() {
    }

    /**
     * 加载指定路径文件
     *
     * @param classPathFile 路径
     * @return 私钥内容
     */
    public static String loadClassPathFile(String classPathFile) {
        try (FileInputStream inputStream = new FileInputStream(new File(classPathFile));
             InputStreamReader inputStreamReader = new InputStreamReader(inputStream, StandardCharsets.UTF_8);
             BufferedReader bufferedReader = new BufferedReader(inputStreamReader)) {
            return bufferedReader.lines().collect(Collectors.joining(System.lineSeparator()));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
