package com.krb.measurement.oldtest.example.demo;

import cn.hutool.core.io.IoUtil;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

/**
 * @Author: mahui
 * @Description:
 * @Date: Create in 09:50 2020-08-20
 */
public class FileToBase64 {
    /**
     * 文件转base64
     * @param path
     * @return
     */
    public static String encodeBase64File(String path) throws Exception {
        File file = new File(path);
        FileInputStream inputFile = new FileInputStream(file);
        byte[] buffer = new byte[(int)file.length()];
        inputFile.read(buffer);
        inputFile.close();
        return org.apache.commons.codec.binary.Base64.encodeBase64String(buffer);
    }
    public static String encodeBase64File1(InputStream path) throws Exception {

        return org.apache.commons.codec.binary.Base64.encodeBase64String(IoUtil.readBytes(path));
    }

}
