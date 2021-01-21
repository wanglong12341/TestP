package com.krb.measurement.oldtest.example.demo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;

public class FileReadHelper {
	public static String readFile(InputStream inputStream) throws IOException {

		StringBuilder builder = new StringBuilder();
		try {
			InputStreamReader reader = new InputStreamReader(inputStream,
					"UTF-8");
			BufferedReader bfReader = new BufferedReader(reader);
			String tmpContent = null;
			while ((tmpContent = bfReader.readLine()) != null) {
				builder.append(tmpContent);
			}
			bfReader.close();
		} catch (UnsupportedEncodingException e) {
			// 忽略
		}
		return filter(builder.toString());
	}

	// 过滤输入字符串, 剔除多行注释以及替换掉反斜杠
	public static String filter(String input) {
		return input.replaceAll("/\\*[\\s\\S]*?\\*/", "");
	}

}
