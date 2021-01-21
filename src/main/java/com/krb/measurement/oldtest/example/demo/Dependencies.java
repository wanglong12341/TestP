package com.krb.measurement.oldtest.example.demo;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import javax.annotation.Resource;
import javax.script.Invocable;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.validation.constraints.NotNull;

import okhttp3.*;
import org.apache.commons.logging.Log;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.nio.charset.StandardCharsets;

import com.krb.measurement.oldtest.cloudloan.akira.demo.util.RSA;
//import com.alibaba.fastjson.JSONObject;
//import com.alibaba.fastjson.support.config.FastJsonConfig;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;

import net.sf.json.JSONObject;
import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.write.WritableWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;

public class Dependencies {


	private String privatekey = "MIICdQIBADANBgkqhkiG9w0BAQEFAASCAl8wggJbAgEAAoGBALCFSbbdkAgfGlTphbp6WS9k8dTs8LKJezBrAo5m46V9i4Eg8H/rdUi8cwy5TaaGBUHFTHe2/KI10nPUMA4Ng22l30Uc+yOXuW6vzwsYEWeVjQh9Z5eeqtR7ilnJPNEwhocq2P2DbCCuwWelH1pMQARPsCxiMjnbPQHyxDn6YSW1AgMBAAECgYAmzfZJe+V405WPSxK5zsGiWJeNDlVPekeZejzCnz22GKY9Scd054cN6VeFWYsHa3jmX4AS5SgeZKSSD/hMbo4QgszCL8xiyP8AmzpglYsif84JXbeuCjGFAnVIFM9tgJ5nEOi3pp7GgpGrPstjWGQJEXGK3r9N1PrHuMEywry1IQJBAPwtcD9KAdkE0mXisspcrOWZ2Inwgs0xw/Lu+Rfpo+xa0cQQsy2UOfr+7jcqfineaN2L5N/f3dJsg9EMAGxNi+kCQQCzMkRgDc4m8WxusBfWqGEB7V+u7cQGM6ebdG+ZbyPP8clr+Y3jOY7c+xueNMpwruCGFeqSQe43UrpgmyU14UftAkAypElbXFhcpZw++7Sd8NiDz05t/Q+3d1v7aEQ7qh7SMzbW4eepqo+uOQ3LpEvryo9SlmpjDwjz3fjmvTtEhJopAkAD8hBlWQh3/QrZKRFtTYnNRA++R0fwpwSCvL6UT0knk/hOY1FHdoX5waGrCxiGAKO68BKZI9B98VlfNStNk2dFAkBGu0rf+mbDwU58fAXA8whsuMO2mcEVYQlzLDqdJZZEBcCQ4bg+wrQUgiBkMGwWXnhCIoTlWLUERHXJfkyO0OiD";
	private String publickey = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQCwhUm23ZAIHxpU6YW6elkvZPHU7PCyiXswawKOZuOlfYuBIPB/63VIvHMMuU2mhgVBxUx3tvyiNdJz1DAODYNtpd9FHPsjl7lur88LGBFnlY0IfWeXnqrUe4pZyTzRMIaHKtj9g2wgrsFnpR9aTEAET7AsYjI52z0B8sQ5+mEltQIDAQAB";
	private static int i = 0;
	public static final String NUMBERCHAR = "0123456789";
	public static Workbook workbook = null;
	public static WritableWorkbook wwb = null;
	static OkHttpClient client = new OkHttpClient();
	static {
		// OkHttpClient.Builder builder = new OkHttpClient.Builder();
		// builder.connectTimeout(new Long(20000), TimeUnit.MILLISECONDS);
		client = new OkHttpClient.Builder()
				.connectTimeout(60000, TimeUnit.MILLISECONDS)
				.readTimeout(60000, TimeUnit.MILLISECONDS).retryOnConnectionFailure(true).build();

	}

	public static final MediaType JSON = MediaType
			.parse("application/json; charset=utf-8");
	public static final MediaType JSON1 = MediaType
			.parse("application/x-www-form-urlencoded; charset=utf-8");
	// 用力集合
	public static ArrayList alldata = null;
	public static ArrayList<String> evdata = null;

	// 入参为测试地址路径，和json的参数形式，同步传输
	public static String post(String url, String json) throws IOException {
		RequestBody body = RequestBody.create(JSON, json);
		Request request = new Request.Builder()
				.addHeader("X-TBC-SOURCE", "tbc_zhtb_czb")
				.addHeader("X-TBC-SIGN", "").url(url).post(body).build();
		Response response = client.newCall(request).execute();
		String result = response.body().string();
		// 结果返回为字符串
		return result;
	}
	//异步调用
	public static String postyb(String env,String url, String json) throws IOException {
		RequestBody body = RequestBody.create(JSON, json);
		String key1 = "thisissignaturekey";
		String key = "thisisriskkey";
		String sign = null;
		if (env.equals("test")) {
			sign = IFCSignUtil.sign(json, key1);
			System.out.println("&&&&&&&&&&&&&&&&&&&&&&&&       " + key1);
			System.out.println("&&&&&&&&&&&&&&&&&&&&&&&&       " + sign);
		} else if (env.equals("third")) {
			sign = IFCSignUtil.sign(json, key1);
		} else {
			sign = IFCSignUtil.sign(json, key);
		}
		String requestNo = getPhonenm();

		Request request = new Request.Builder().addHeader("app", "signature")
				.addHeader("sign", sign).addHeader("requestNo",requestNo)
				.url(url).post(body).build();
		Call call = client.newCall(request);
//		String result = null;
//		call.enqueue(new Callback() {
//			@Override
//			public void onFailure(@NotNull Call call, @NotNull IOException e) {
//			}
//
//			@Override
//			public void onResponse(@NotNull Call call, @NotNull Response response) throws IOException {
//				String result = response.body().string();
//				System.out.println("OkHttp POST请求成功: "+result);
//			}
//		});
		Response response = client.newCall(request).execute();
		String result = response.body().string();
		// 结果返回为字符串
		return result;
	}
	// 稅銀通
	public  String postsyt(String url, String json, String env)
			throws IOException {
		String key1 = "thisissytkey";
		String key = "21b99637fb2949ecb1e7da0aa52b44ee";
		String sign = null;
		if (env.equals("test")) {
			sign = IFCSignUtil.sign(json, key1);
			System.out.println("&&&&&&&&&&&&&&&&&&&&&&&&       " + key1);
		} else if (env.equals("third")) {
			sign = IFCSignUtil.sign(json, key1);
		} else {
			sign = IFCSignUtil.sign(json, key);
		}
		String result = Test1.baiRongHttp(url,sign,json);


		// 结果返回为字符串
		return result;
	}
	// 稅銀通
	public  String postsyt1(String url, String json, String env)
			throws IOException {
		String key1 = "thisissytkey";
		String key = "21b99637fb2949ecb1e7da0aa52b44ee";
		String sign = null;
		if (env.equals("test")) {
			sign = IFCSignUtil.sign(json, key1);
			System.out.println("&&&&&&&&&&&&&&&&&&&&&&&&       " + key1);
		} else if (env.equals("third")) {
			sign = IFCSignUtil.sign(json, key1);
		} else {
			sign = IFCSignUtil.sign(json, key);
		}
		HttpHeaders httpHeaders = new HttpHeaders();
		httpHeaders.set("app","xyj");
		httpHeaders.set("requestNo","SYT-");
		httpHeaders.set("sign",sign);
		final HttpEntity entity = new HttpEntity<>(json,httpHeaders);


		RequestBody body = RequestBody.create(JSON, json);
		Request request = new Request.Builder().addHeader("app", "syt")
				.addHeader("sign", sign).addHeader("requestNo", "SYT-").addHeader("Connection","close")
				.url(url).post(body).build();
		Response response = client.newCall(request).execute();
		String result = response.body().string();
		// 结果返回为字符串
		return result;
	}
	// 三方平台
	public static String postsf(String url, String json, String env)
			throws IOException {

		String key1 = "thisissignaturekey";
		String key = "thisisriskkey";
		String sign = null;
		if (env.equals("test")) {
			sign = IFCSignUtil.sign(json, key1);
			System.out.println("&&&&&&&&&&&&&&&&&&&&&&&&       " + key1);
			System.out.println("&&&&&&&&&&&&&&&&&&&&&&&&       " + sign);
		} else if (env.equals("third")) {
			sign = IFCSignUtil.sign(json, key1);
		} else {
			sign = IFCSignUtil.sign(json, key);
		}
		String requestNo = getPhonenm();
		RequestBody body = RequestBody.create(JSON, json);
		Request request = new Request.Builder().addHeader("app", "signature")
				.addHeader("sign", sign).addHeader("requestNo",requestNo)
				.url(url).post(body).build();
		System.out.println("requestNo++"+requestNo);
		Response response = client.newCall(request).execute();
		String result = response.body().string();
		// 结果返回为字符串
		return result;
	}

	// 信息加
	public static String postxxjqz(String url, String json, String env)
			throws IOException {

		String key1 = "TEST_XYJ59SP0P";
		String key = "VJ34XI409707";
		RequestBody body = null;
		Request request = null;
		String sign = null;
		String requestNo = getPhonenm();
		if (env.equals("test")) {
			sign = IFCSignUtil.sign(json, key1);
			System.out.println("&&&&&&&&&&&&&&&&&&&&&&&&       " + key1);
			System.out.println("&&&&&&&&&&&&&&&&&&&&&&&&       " + sign);
		} else if (env.equals("dev")) {
			sign = IFCSignUtil.sign(json, key1);
		} else {
			sign = IFCSignUtil.sign(json, key);
		}
		if (env.equals("test")) {
			body = RequestBody.create(JSON, json);
			request = new Request.Builder().addHeader("app", "xyj")
					.addHeader("sign", sign).addHeader("requestNo", requestNo)
					.url(url).post(body).build();
		}else{
			body = RequestBody.create(JSON, json);
			request = new Request.Builder().addHeader("app", "xyj")
					.addHeader("sign", sign).addHeader("requestNo", requestNo)
					.url(url).post(body).build();
		}
		Response response = client.newCall(request).execute();
		String result = response.body().string();
		// 结果返回为字符串
		return result;
	}

	// xxj
	public static String postqz(String url, String json, String env)
			throws IOException {
		String key1 = "TEST_XYJ59SP0P";
		String key = "TEST_XYJ59SP0P";
		String requestNo = getPhonenm();
		String sign = null;
		if (env.equals("test")) {
			sign = IFCSignUtil.sign(json, key1);
		} else {
			sign = IFCSignUtil.sign(json, key1);
		}

		RequestBody body = RequestBody.create(JSON, json);


//		HttpHeaders httpHeaders = new HttpHeaders();
//		httpHeaders.set("app","xyj");
//		httpHeaders.set("sign",sign);
//		final HttpEntity entity = new HttpEntity<>(body,httpHeaders);
//		ResponseEntity<String> exchange =  restTemplate.postForEntity(url,entity,String.class);

		Request request = new Request.Builder().addHeader("app", "xyj")
				.addHeader("sign", sign).addHeader("requestNo", requestNo).addHeader("Connection","close")
				.url(url).post(body).build();
		Response response = client.newCall(request).execute();
		String result = response.body().string();
		// 结果返回为字符串
		return result;
	}


	// 入参为测试地址路径 ，普通表单的参数形式，同步传输
	public static String post2(String url, String... strings)
			throws IOException {
		RequestBody body = new FormBody.Builder()
				.add("serviceName", strings[0].toString())
				.add("requestNum", strings[1].toString())
				.add("appId", strings[2].toString())
				.add("requestTime", strings[3].toString()).add("sign", "")
				.add("ext", "").add("requestData", strings[4].toString())
				.build();
		Request request = new Request.Builder()
				.header("Content-Type", "application/x-www-form-urlencoded")
				.url(url).post(body).build();
		Response response = client.newCall(request).execute();
		String result = response.body().string();
		// 结果返回为字符串
		return result;
	}

	// LZ 授信、支用
	public static String postlz(String url, String... strings)
			throws IOException {
		RequestBody body = new FormBody.Builder()
				.add("serviceName", strings[0].toString())
				.add("requestNum", strings[1].toString())
				.add("appId", strings[2].toString())
				.add("requestTime", strings[3].toString()).add("sign", "")
				.add("ext", "").add("notifyUrl", "")
				.add("requestData", strings[4].toString()).build();
		Request request = new Request.Builder()
				.header("Content-Type", "application/x-www-form-urlencoded")
				.url(url).post(body).build();
		Response response = client.newCall(request).execute();
		String result = response.body().string();
		// 结果返回为字符串
		return result;
	}

	// 远望 授信
	public static String postyw(String url, String... strings)
			throws IOException {
		RequestBody body = new FormBody.Builder()
				.add("certId", strings[0].toString())
				.add("name", strings[1].toString())
				.add("mobile", strings[2].toString())
				.add("sourceOrderId", strings[3].toString())
				.add("sourceChannelOrderId", strings[3].toString())
				.add("applyType", "CREDIT").add("productId", "10000")
				.add("certType", "1").add("requestData", strings[4].toString())
				.add("apiKey", "100190618001")
				.add("sign", "1881485d7e91e7a45aead318e8a9a1b8").build();
		Request request = new Request.Builder()
				.header("Content-Type", "application/x-www-form-urlencoded")
				.url(url).post(body).build();
		Response response = client.newCall(request).execute();
		String result = response.body().string();
		// 结果返回为字符串
		return result;
	}

	// 入参为测试地址路径，和json的参数形式，同步传输
	public static String post1(String url, String json) throws IOException {
		RequestBody body = RequestBody.create(JSON, json);
		Request request = new Request.Builder().url(url).post(body).build();
		Response response = client.newCall(request).execute();
		String result = response.body().string();
		// 结果返回为字符串
		return result;
	}

	// GET方法
	public static String get(String url) throws IOException {
		OkHttpClient client = new OkHttpClient();
		String result = null;
		Request request = new Request.Builder().url(url).build();
		Response response = client.newCall(request).execute();
		return response.body().string();
	}
	// 三方查询GET方法
	/*
	public static String getsf(String env,String url,String orderId) throws IOException {
		String key1 = "thisissignaturekey";
		String key = "thisisriskkey";
		String sign = null;
		if (env.equals("test")) {
			sign = IFCSignUtil.sign(json, key1);
			System.out.println("&&&&&&&&&&&&&&&&&&&&&&&&       " + key1);
			System.out.println("&&&&&&&&&&&&&&&&&&&&&&&&       " + sign);
		} else if (env.equals("third")) {
			sign = IFCSignUtil.sign(json, key1);
		} else {
			sign = IFCSignUtil.sign(json, key);
		}
		OkHttpClient client = new OkHttpClient();
//		String url1 = url+ orderId;
		String result = null;
		Request request = new Request.Builder().url(url).build();
		Response response = client.newCall(request).execute();
		return response.body().string();
	}*/

	// 生成手机号
	public static String getPhonenm() {
		StringBuilder str = new StringBuilder("");
		Random random = new Random();
		// 随机生成数字，并添加到字符串
		for (int i = 0; i < 8; i++) {
			str.append(random.nextInt(10));
		}
		String phnum = "150" + str;
		return phnum;

	}

	// 生成sourceUserId
	public static String getsourceUserId() {
		StringBuilder str = new StringBuilder("");
		Random random = new Random();
		// 随机生成数字，并添加到字符串
		for (int i = 0; i < 4; i++) {
			str.append(random.nextInt(10));
		}

		return str.toString();

	}

	// 生成bankCardNo
	public static String getbankCardNo() {
		StringBuilder str = new StringBuilder("");
		Random random = new Random();
		// 随机生成数字，并添加到字符串
		for (int i = 0; i < 8; i++) {
			str.append(random.nextInt(10));
		}
		String bankCardNo = "62226666" + str;
		return bankCardNo;

	}

	// 生成bankCardNo
	public static String getcraditCardNum() {
		StringBuilder str = new StringBuilder("");
		Random random = new Random();
		// 随机生成数字，并添加到字符串
		for (int i = 0; i < 11; i++) {
			str.append(random.nextInt(10));
		}
		String bankCardNo = "62226666" + str;
		return bankCardNo;

	}

	// 51生成creditApplyNo
	public static String getcreditApplyNo() {
		StringBuilder str = new StringBuilder("");
		Random random = new Random();
		// 随机生成数字，并添加到字符串
		for (int i = 0; i < 10; i++) {
			str.append(random.nextInt(10));
		}

		return str.toString();

	}

	// 51生成productId
	public static String getproductId() {
		StringBuilder str = new StringBuilder("");
		Random random = new Random();
		// 随机生成数字，并添加到字符串
		for (int i = 0; i < 5; i++) {
			str.append(random.nextInt(10));
		}
		String productId = "channel" + str;
		return productId;

	}

	// 51生成requestNum
	public static String getrequestNum() {
		StringBuilder str = new StringBuilder("");
		Random random = new Random();
		// 随机生成数字，并添加到字符串
		for (int i = 0; i < 6; i++) {
			str.append(random.nextInt(10));
		}
		String requestNum = "51CARDno" + str;
		return requestNum;

	}

	// czb 生成transactionId
	public static String gettransactionId() {
		StringBuilder str = new StringBuilder("");
		Random random = new Random();
		// 随机生成数字，并添加到字符串
		for (int i = 0; i < 4; i++) {
			str.append(random.nextInt(10));
		}
		String transactionId = "Test_" + str;
		return transactionId;

	}

	public static ArrayList readExcel(String path) {
		InputStream in = null;
		alldata = new ArrayList();
		evdata = new ArrayList<String>();
		String[] str = null;
		try {

			// 读取输入流
			in = new FileInputStream(path);
			workbook = Workbook.getWorkbook(in);
			// 读取sheet页默认从第一页开始
			Sheet s1 = workbook.getSheet(0);
			// Sheet s2 = readwb.getSheet("");
			// 读取列数
			int columns = s1.getColumns();
			// System.out.println("lieshu:" + columns);
			// 读取行数
			int rows = s1.getRows();
			// System.out.println("行數：" + rows);
			for (int i = 2; i < rows; i++) {
				str = new String[3];
				// for (int j = 1; j < columns; j++) {
				// if(j==1 || j==3 || j==4){

				Cell cell1 = s1.getCell(1, i);
				// System.out.print(cell1.getContents() + " ");
				if (cell1.getContents() != "") {
					str[0] = cell1.getContents();
				}
				Cell cell3 = s1.getCell(3, i);
				if (cell3.getContents() != "") {
					str[1] = cell3.getContents();
				}
				// System.out.print(cell3.getContents() + " ");
				Cell cell4 = s1.getCell(4, i);
				if (cell4.getContents() != "") {
					str[2] = cell4.getContents();
					// System.out.print(cell4.getContents() + " ");
				}
				alldata.add(str);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				in.close();
				// System.out.println("closed inputstream");
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		// System.out.println("读取测试用例完成");
		// System.out.println(alldata.size());
		return alldata;
	}

	// 通过js获取身份证号
	public static String getJsIdcardNO() {
		String idcrd = null;
		// 创建一个脚本引擎管理器
		ScriptEngineManager manager = new ScriptEngineManager();
		// 获取一个指定的名称的脚本引擎
		ScriptEngine engine = manager.getEngineByName("js");
		try {
			// 获取当前类的所在目录的路径
			InputStream inputStream = Thread.currentThread()
					.getContextClassLoader().getResourceAsStream("static/id.js");

			// String path = Dependencies.class.getResource("").getPath();
			// // FileReader的参数为所要执行的js文件的路径
			// engine.eval(new
			// FileReader(ResourceUtils.getFile("classpath:id.js")));
			engine.eval(FileReadHelper.readFile(inputStream));
			if (engine instanceof Invocable) {
				Invocable invocable = (Invocable) engine;
				idcrd = (String) invocable.invokeFunction("getIdNo");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return idcrd;

	}

	// 通过js获取身份证号
	public static String getJsIdcardNO100() {
		String idcrd = null;
		// 创建一个脚本引擎管理器
		ScriptEngineManager manager = new ScriptEngineManager();
		// 获取一个指定的名称的脚本引擎
		ScriptEngine engine = manager.getEngineByName("js");
		try {
			InputStream inputStream = Thread.currentThread()
					.getContextClassLoader().getResourceAsStream("static/ageid.js");
			engine.eval(FileReadHelper.readFile(inputStream));
			if (engine instanceof Invocable) {
				Invocable invocable = (Invocable) engine;
				idcrd = (String) invocable.invokeFunction("getIdNo");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return idcrd;
	}
	// 通过js获取銀行号
	public static String getJsbankno() {
		String idcrd = null;
		// 创建一个脚本引擎管理器
		ScriptEngineManager manager = new ScriptEngineManager();
		// 获取一个指定的名称的脚本引擎
		ScriptEngine engine = manager.getEngineByName("js");
		try {
			InputStream inputStream = Thread.currentThread()
					.getContextClassLoader().getResourceAsStream("static/bk.js");
			engine.eval(FileReadHelper.readFile(inputStream));
			if (engine instanceof Invocable) {
				Invocable invocable = (Invocable) engine;
				idcrd = (String) invocable.invokeFunction("getBankAccount");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return idcrd;

	}

	// 通过js获取身份证号
	public static String getJsIdcardNO1() {
		String idcrd = null;
		// 创建一个脚本引擎管理器
		ScriptEngineManager manager = new ScriptEngineManager();
		// 获取一个指定的名称的脚本引擎
		ScriptEngine engine = manager.getEngineByName("js");
		try {
			InputStream inputStream = Thread.currentThread()
					.getContextClassLoader().getResourceAsStream("static/guding.js");

			// String path = Dependencies.class.getResource("").getPath();
			// // FileReader的参数为所要执行的js文件的路径
			// engine.eval(new
			// FileReader(ResourceUtils.getFile("classpath:id.js")));
			engine.eval(FileReadHelper.readFile(inputStream));
			// 获取当前类的所在目录的路径
			// String path = Dependencies.class.getResource("").getPath();
			// // FileReader的参数为所要执行的js文件的路径
			// engine.eval(new FileReader("guding.js"));
			if (engine instanceof Invocable) {
				Invocable invocable = (Invocable) engine;
				idcrd = (String) invocable.invokeFunction("getIdNo");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return idcrd;

	}

	// 获取新的身份信息
	public static Map getUserinfo() throws InterruptedException {
		Map<String, String> map = new HashMap<String, String>();
		System.setProperty("webdriver.chrome.driver", "d:\\chromedriver.exe");
		ChromeOptions chromeOptions = new ChromeOptions();
		// 设置 chrome 的无头模式
		chromeOptions.setHeadless(Boolean.TRUE);
		// 启动一个 chrome 实例
		WebDriver driver = new ChromeDriver(chromeOptions);
		// WebDriver driver = new HtmlUnitDriver();
		// Thread.sleep(2000);
		driver.manage().window().maximize();
		driver.get("http://jsrun.net/7shKp/detail");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//iframe"));
		Thread.sleep(2000);
		driver.findElement(By.tagName("iframe"));
		Thread.sleep(2000);
		String nameid = driver
				.findElement(
						By.cssSelector("#list > table > tbody > tr:nth-child(3) > td:nth-child(1)"))
				.getText();
		String id = driver
				.findElement(
						By.cssSelector("#list > table > tbody > tr:nth-child(3) > td:nth-child(2)"))
				.getText();
		// String[] nameId = nameid.split(" ");
		// String name = nameId[0];
		// String idno = nameId[1];
		driver.quit();
		map.put("custName", nameid);
		map.put("cardNum", id);
		// map.put("sex", sex);
		return map;
	}

	// 把String 结果转换为Map
	public static Map returnmap(String str) {
		// Map<String, Object> map =
		// com.alibaba.fastjson.JSON.parseObject(str,Map.class);
		// Map<String, Object> map =
		// FastJsonConfig.JSON.parseObject(str,Map.class);
		com.alibaba.fastjson.JSONObject jsonObject = com.alibaba.fastjson.JSONObject
				.parseObject(str);
		// System.out.println(jsonObject.toString());
		Map<String, Object> map = (Map<String, Object>) jsonObject;
		return map;
	}

	public static Connection getConn() {
		String driver = "com.mysql.jdbc.Driver";
		String url = "jdbc:mysql://172.20.20.2:9919/test-use-only";
		String username = "root";
		String password = "dJ_xw2ve_Dc9_1OiY3";
		Connection conn = null;
		try {
			Class.forName(driver); // classLoader,加载对应驱动
			conn = (Connection) DriverManager.getConnection(url, username,
					password);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}


	// 连接开发库
	public static Connection getConnDev() {
		String driver = "com.mysql.jdbc.Driver";
		String url = "jdbc:mysql://39.106.164.42:9919/krbdb-dev";
		String username = "root";
		String password = "dJ_xw2ve_Dc9_1OiY3";
		Connection conn = null;
		try {
			Class.forName(driver); // classLoader,加载对应驱动
			conn = (Connection) DriverManager.getConnection(url, username,
					password);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}

	// 连接ceshi库
	public static Connection getConnTet() {
		String driver = "com.mysql.jdbc.Driver";
		String url1 = "jdbc:mysql://172.20.20.2:9919/keep-running";
		String url = "jdbc:mysql://47.94.212.153:9919/krbdb-prod-copy20190527";
		String username = "root";
		String password = "dJ_xw2ve_Dc9_1OiY3";
		Connection conn = null;
		try {
			Class.forName(driver); // classLoader,加载对应驱动
			conn = (Connection) DriverManager.getConnection(url1, username,
					password);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}

	// 连接ceshi库
	public static Connection getConnTetSYT() {
		String driver = "com.mysql.jdbc.Driver";
		String url1 = "jdbc:mysql://47.94.212.153:9919/customhouse";
		String url = "jdbc:mysql://47.94.212.153:9919/customhouse";
		String username = "root";
		String password = "dJ_xw2ve_Dc9_1OiY3";
		Connection conn = null;
		try {
			Class.forName(driver); // classLoader,加载对应驱动
			conn = (Connection) DriverManager.getConnection(url1, username,
					password);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}

	// 更新
	public static void updateInfo(Connection conn, String sql) {

		try {
			PreparedStatement ps = (PreparedStatement) conn
					.prepareStatement(sql);
			int res = ps.executeUpdate();
			if (res > 0) {
				System.out.println("更新数据成功");
			}
			ps.close();
		} catch (SQLException e) {
			System.out.println("操作失败o(╥﹏╥)");
			e.printStackTrace();
		} finally {
			System.out.println();
		}

	}

	// 查询
	public static String selectSYT_syt_order_num(Connection conn, String sql) {
		Statement sttmt = null;
		String syt_order_num = null;
		try {
			sttmt = (Statement) conn.createStatement();
			ResultSet resset = sttmt.executeQuery(sql);
			while (resset.next()) {

				syt_order_num = resset.getString("syt_order_num");
			}
			System.out.println("syt_order_num$$$$$$$$" + syt_order_num);
		} catch (SQLException e) {
			System.out.println("操作失败o(╥﹏╥)");
			e.printStackTrace();
		} finally {
			System.out.println();
		}
		return syt_order_num;

	}

	// 查询
	public static String selectInfo(Connection conn, String sql) {
		Statement sttmt = null;
		String itemsetid = null;
		try {
			sttmt = (Statement) conn.createStatement();
			ResultSet resset = sttmt.executeQuery(sql);
			while (resset.next()) {

				itemsetid = resset.getString("id");
			}
			System.out.println("itemsetid$$$$$$$$" + itemsetid);
		} catch (SQLException e) {
			System.out.println("操作失败o(╥﹏╥)");
			e.printStackTrace();
		} finally {
			System.out.println();
		}
		return itemsetid;

	}

	public static int insert(String sql) {
		Connection conn = getConn();
		int i = 0;

		PreparedStatement pstmt;
		try {
			pstmt = (PreparedStatement) conn.prepareStatement(sql);
			i = pstmt.executeUpdate();
			pstmt.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return i;
	}
	//删除
	public static int deleteInfo(Connection conn,String sql) throws SQLException {
		Statement stmt = null;
		try {
			stmt =  (Statement) conn.createStatement();
			//5.执行sql
			int count = stmt.executeUpdate(sql);
			//6.处理结果
			System.out.println(count);
			if(count > 0){
				System.out.println("删除成功！");
			}else{
				System.out.println("删除失败");
			}} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			//7.释放资源

			if(stmt != null){
				try {
					stmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}

			if(conn != null){
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return 0;
	}

	// map zhuan string
	public static String mapTostring(Map map) {
		JSONObject jsonObject = JSONObject.fromObject(map);
		return jsonObject.toString();
	}

	public static String getName() {
		Random random = new Random();
		String firstname = "赵钱孙李周吴郑王冯陈褚卫蒋沈韩杨朱秦尤许何吕施张孔曹严华金魏陶姜戚谢邹喻柏水窦章云苏潘葛奚范彭郎鲁韦昌马苗凤花方俞任袁柳酆鲍史唐费廉岑薛雷贺倪汤滕殷罗毕郝邬安常乐于时傅皮卞齐康伍余元卜顾孟平黄和穆萧尹姚邵湛汪祁毛禹狄米贝明臧计伏成戴谈宋茅庞熊纪舒屈项祝董梁杜阮蓝闵席季麻强贾路娄危江童颜郭梅盛林刁钟徐邱骆高夏蔡田樊胡凌霍虞万支柯昝管卢莫经房裘缪干解应宗丁宣贲邓郁单杭洪包诸左石崔吉钮龚程嵇邢滑裴陆荣翁荀羊於惠甄曲家封芮羿储靳汲邴糜松井段富巫乌焦巴弓牧隗山谷车侯宓蓬全郗班仰秋仲伊宫宁仇栾暴甘钭厉戎祖武符刘景詹束龙叶幸司韶郜黎蓟薄印宿白怀蒲邰从鄂索咸籍赖卓蔺屠蒙池乔阴鬱胥能苍双闻莘党翟谭贡劳逄姬申扶堵冉宰郦雍卻璩桑桂濮牛寿通边扈燕冀郏浦尚农温别庄晏柴瞿阎充慕连茹习宦艾鱼容向古易慎戈廖庾终暨居衡步都耿满弘匡国文寇广禄阙东欧殳沃利蔚越夔隆师巩厍聂晁勾敖融冷訾辛阚那简饶空曾毋沙乜养鞠须丰巢关蒯相查后荆红游竺权逯盖益桓公万俟司马上官欧阳夏侯诸葛闻人东方赫连皇甫尉迟公羊澹台公冶宗政濮阳淳于单于太叔申屠公孙仲孙轩辕令狐钟离宇文长孙慕容鲜于闾丘司徒司空丌官司寇仉督子车颛孙端木巫马公西漆雕乐正壤驷公良拓跋夹谷宰父谷梁晋楚闫法汝鄢涂钦段干百里东郭南门呼延归海羊舌微生岳帅缑亢况郈有琴梁丘左丘东门西门商牟佘佴伯赏南宫墨哈谯笪年爱阳佟";
		String names = "子璇淼国栋夫子瑞堂甜敏尚国贤贺祥晨涛昊轩易轩辰益帆冉瑾春瑾昆春齐杨文昊东雄霖浩晨熙涵溶溶冰枫欣宜豪欣慧建政美欣淑慧文轩杰欣源忠林榕润欣汝慧嘉新建建林亦菲林冰洁佳欣涵涵禹辰淳美泽惠伟洋涵越润丽翔淑华晶莹凌晶苒溪雨涵嘉怡佳毅子辰佳琪紫轩瑞辰昕蕊萌明远欣宜泽远欣怡佳怡佳惠晨茜晨璐运昊汝鑫淑君晶滢润莎榕汕佳钰佳玉晓庆一鸣语晨添池添昊雨泽雅晗雅涵清妍诗悦嘉乐晨涵天赫玥傲佳昊天昊萌萌若萌测试身份证号大全和名由程序随机组合而成所有信息均为虚构生成不会泄密真实公民隐私信息也非现实生活中真实的身份证号码和真实名身份证号码所属年龄均为岁以上均已通过校验身份证号码和名仅供测试或用在必须输入身份证号码和名的网站上请不要将身份证号码和名用于任何非法用途且自行承担使用本工具的任何后果和责任";

		int a = random.nextInt(firstname.length());
		int b = random.nextInt(names.length());
		int c = random.nextInt(names.length());
		System.out.println(a + ":" + b + ":" + c);
		String fname = firstname.substring(Math.abs(a), Math.abs(a) + 1);
		String nname1 = names.substring(Math.abs(b), Math.abs(b) + 1);
		String nname2 = names.substring(Math.abs(c), Math.abs(c) + 1);
		String name = fname + nname1 + nname2;

		return name;
	}

	// 写入文件
	public static void writeFile(String s) throws IOException {
		File file = new File("D:\\a.html");
		// File file = new File("/opt/risk/a.html");
		FileWriter fw = new FileWriter(file); // 设置成true就是追加
		fw.write(s);
		fw.close();
	}

	// 写入文件
	public static void writeFile1(String s) throws IOException {
		// File file = new File("D:\\a.html");
		File file = new File("/opt/risk/a.html");
		FileWriter fw = new FileWriter(file); // 设置成true就是追加
		fw.write(s);
		fw.close();
	}

	// 进行绑卡
	public static void bk1() throws IOException, InterruptedException {
		ChromeDriverService service = new ChromeDriverService.Builder()
				.usingDriverExecutable(
						new File("/opt/risk/driver/chromedriver"))
				.usingAnyFreePort().build();
		service.start();

		System.setProperty("webdriver.chrome.driver",
				"/opt/risk/driver/chromedriver");
		// ChromeOptions chromeOptions = new ChromeOptions();
		// 设置 chrome 的无头模式
		// chromeOptions.setHeadless(Boolean.TRUE);
		// 启动一个 chrome 实例
		// WebDriver driver = new ChromeDriver();
		WebDriver driver = new RemoteWebDriver(service.getUrl(),
				DesiredCapabilities.chrome());
		Thread.sleep(2000);
		driver.manage().window().maximize();
		driver.get("file:////opt/risk/a.html");
		Thread.sleep(2000);
		((JavascriptExecutor) driver).executeScript("window.scrollBy(0, 1400)");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id=\"sendSmsVerify\"]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id=\"alertLayer\"]/div[2]/a"))
				.click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id=\"smsCode\"]")).sendKeys("111111");
		Thread.sleep(2000);
		// ((JavascriptExecutor)
		// driver).executeScript("window.scrollBy(0, 2500)");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id=\"password\"]"))
				.sendKeys("111111");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id=\"confirmPassword\"]")).sendKeys(
				"111111");
		Thread.sleep(2000);
		// ((JavascriptExecutor)
		// driver).executeScript("window.scrollBy(0, 3500)");
		Thread.sleep(2000);
		driver.findElement(
				By.xpath("//*[@id=\"form\"]/div[11]/div[2]/div/label/i[1]/img"))
				.click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id=\"nextButton\"]")).click();
		Thread.sleep(2000);
		driver.close();
		// 关闭 ChromeDriver 接口
		// service.stop();
	}

	// 进行绑卡
	public static void bk() throws IOException, InterruptedException {
		ChromeDriverService service = new ChromeDriverService.Builder()
				.usingDriverExecutable(new File("d:\\chromedriver.exe"))
				.usingAnyFreePort().build();
		service.start();

		System.setProperty("webdriver.chrome.driver", "d:\\chromedriver.exe");
		// ChromeOptions chromeOptions = new ChromeOptions();
		// 设置 chrome 的无头模式
		// chromeOptions.setHeadless(Boolean.TRUE);
		// 启动一个 chrome 实例
		// WebDriver driver = new ChromeDriver();
		WebDriver driver = new RemoteWebDriver(service.getUrl(),
				DesiredCapabilities.chrome());
		Thread.sleep(2000);
		driver.manage().window().maximize();
		driver.get("file:///D:/a.html");
		Thread.sleep(2000);
		((JavascriptExecutor) driver).executeScript("window.scrollBy(0, 1400)");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id=\"sendSmsVerify\"]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id=\"alertLayer\"]/div[2]/a"))
				.click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id=\"smsCode\"]")).sendKeys("111111");
		Thread.sleep(2000);
		// ((JavascriptExecutor)
		// driver).executeScript("window.scrollBy(0, 2500)");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id=\"password\"]"))
				.sendKeys("111111");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id=\"confirmPassword\"]")).sendKeys(
				"111111");
		Thread.sleep(2000);
		// ((JavascriptExecutor)
		// driver).executeScript("window.scrollBy(0, 3500)");
		Thread.sleep(2000);
		driver.findElement(
				By.xpath("//*[@id=\"form\"]/div[11]/div[2]/div/label/i[1]/img"))
				.click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id=\"nextButton\"]")).click();
		Thread.sleep(2000);
		driver.close();
		// 关闭 ChromeDriver 接口
		// service.stop();
	}

	public static void main(String[] args) throws Exception {
		/*
		 * ChromeDriverService service = new ChromeDriverService.Builder()
		 * .usingDriverExecutable(new File("D:\\chromedriver.exe"))
		 * .usingAnyFreePort().build(); service.start();
		 * 
		 * System.setProperty("webdriver.chrome.driver",
		 * "d:\\chromedriver.exe"); ChromeOptions chromeOptions = new
		 * ChromeOptions(); // 设置 chrome 的无头模式
		 * chromeOptions.setHeadless(Boolean.TRUE); // 启动一个 chrome 实例 WebDriver
		 * driver = new ChromeDriver(chromeOptions); // WebDriver driver = new
		 * RemoteWebDriver(service.getUrl(), // DesiredCapabilities.chrome());
		 * Thread.sleep(2000); driver.manage().window().maximize();
		 * driver.get("file:///D:/a.html"); Thread.sleep(2000);
		 * ((JavascriptExecutor)
		 * driver).executeScript("window.scrollBy(0, 1400)");
		 * Thread.sleep(2000);
		 * driver.findElement(By.xpath("//*[@id=\"sendSmsVerify\"]")).click();
		 * Thread.sleep(2000);
		 * driver.findElement(By.xpath("//*[@id=\"alertLayer\"]/div[2]/a"))
		 * .click(); Thread.sleep(2000);
		 * driver.findElement(By.xpath("//*[@id=\"smsCode\"]"
		 * )).sendKeys("111111"); Thread.sleep(2000); // ((JavascriptExecutor)
		 * // driver).executeScript("window.scrollBy(0, 2500)");
		 * Thread.sleep(2000);
		 * driver.findElement(By.xpath("//*[@id=\"password\"]"))
		 * .sendKeys("111111"); Thread.sleep(2000);
		 * driver.findElement(By.xpath("//*[@id=\"confirmPassword\"]"
		 * )).sendKeys( "111111"); Thread.sleep(2000); // ((JavascriptExecutor)
		 * // driver).executeScript("window.scrollBy(0, 3500)");
		 * Thread.sleep(2000); driver.findElement(
		 * By.xpath("//*[@id=\"form\"]/div[11]/div[2]/div/label/i[1]/img"))
		 * .click(); Thread.sleep(2000);
		 * driver.findElement(By.xpath("//*[@id=\"nextButton\"]")).click();
		 * Thread.sleep(2000); driver.quit(); // 关闭 ChromeDriver 接口
		 * service.stop();
		 */
		/*
		 * String plainText =
		 * "{\"serviceSn\": \"1234567890000\", \"channel\": \"wxjk\", \"sourceCode\": \"wxjk\", \"transactionId\": \"Test4524141\", \"sourceUserId\": \"392\", \"sourceProjectId\": \"196110\", \"applyInfo\": {\"applyTime\": \"2020-05-26 10:20:56\", \"applyAmount\": 20000, \"applyTerm\": 3, \"applicationPeriod\": 0, \"productCode\": \"XJ_WX_KKD\", \"productGroup\": 1110, \"applySource\": \"api\", \"financeChannel\": 1}, \"loanInfo\": {\"loanAmount\": 20000, \"loanTerm\": 3, \"cycleInterval\": 0, \"assetInterestRate\": 0.105, \"assetInterestRatePeriod\": 1, \"userInterestRate\": 0.105, \"userInterestRatePeriod\": 1, \"repayMethod\": \"AI\", \"discountRate\": 0.0, \"discountAmount\": 1.0}, \"cardInfo\": {\"accountProp\": 0, \"bankCode\": \"CCB\", \"bankCardNo\": \"6217002200003225701\", \"bankPhone\": \"18833220101\", \"bankNameSub\": \"建设银行\", \"bankCardAccountType\": 2}, \"personalInfo\": {\"cardNum\": \"42010119600813110X\", \"faceRecognition\": \"Y\", \"custName\": \"左以忠\", \"livePhone\": \"1012345678\", \"cardValidDate\": \"1900-12-10-9999-09-09\", \"phone\": \"15559053006\", \"currentCity\": \"110000\", \"sex\": \"M\", \"age\": 22, \"fourVerifyResult\": \"Y\", \"hasChildren\": 0, \"maritalStatus\": 1, \"education\": 1, \"repaymentAbility\": \"9999.99\", \"registeredAddressProvince\": \"110000\", \"registeredAddressCity\": \"110100\", \"registeredAddressBorough\": \"110105\", \"registeredDetailAddress\": \"草莓抹茶\", \"firstContactName\": \"王一\", \"firstContactPhone\": \"18833332222\", \"liveAddressProvince\": \"110000\", \"liveAddressCity\": \"110100\", \"liveAddressBorough\": \"110105\", \"liveDetailAddress\": \"耳机线\"}, \"imageInfo\": {\"backPhotoOfIDCard\": \"http://5b0988e595225.cdn.sohucs.com/images/20200409/94880ee7acde45abb2f13b9d05024279.jpeg\", \"frontPhotoOfIDCard\": \"http://5b0988e595225.cdn.sohucs.com/images/20171025/e7f95b3b97bf4770b2ac06f22819803c.jpeg\", \"livingVerificationScreenshot\": \"http://img4.imgtn.bdimg.com/it/u=1134285202,3668869954&fm=26&gp=0.jpg,http://www.kaixian.tv/gd/d/file/201608/02/5d97764e974aa0aa53363e36d0fd547c.jpg\"}}\n"
		 * ; String requestBodyJson1 = "2"; //
		 * System.out.println(requestBodyJson.getBytes()); String doEncrypttest
		 * = doEncrypttest(plainText); System.out.println(doEncrypttest);
		 * 
		 * String privateKey =
		 * "MIICeQIBADANBgkqhkiG9w0BAQEFAASCAmMwggJfAgEAAoGBAI58YCtTMJu8hNakIrgidYpQDyL+eO/+qNnpU7SmbEhmU/HXIRqOrLtZlAKwozSQp1jroARaUHBZncH8HTHcw1V/UvX8GyeiiP7oqn4O+tYkdwW2y1Jf0zyqOLrbnvO6ZnA9YiP5dc+HFGd667/MiUrhNaVs4n7QINPrJR6lrsUFAgMBAAECgYEAiHlw046W3FQxGDWWW7AFzTjphqcexyCwMiheWIWe6am5dcaMmpdVsw0Vy43MhKiY4X6ugfzPVw0/IXKNtBizrlXCbMKlfadftWIbRnfiSFoBiI6wTUJxCLeyfk120tj4hhsQWifI8MPlJU6PPqagB3w1SkKmNKeuXcpelhKn6gECQQDuDhv97rK6scbkbf32cMh6YB98uFIUnXM7GQQxNh3VfxCAyQX3VfmbO4Q8umXAqre7GztWe4GwJgxW4hyiWJYhAkEAmToCaYEJ0tLxFIfEKDq0uYe51pgRCTsf6AXVPIVAYuRHPHtoAOeR4Fa4pqBbWAHy+HCeWsjWRqU6a3HwRpZKZQJBALw8r+m1i+KQnMMYLo9mU0BhLcTDQzRF5E5A083OCv09AmGzk2Imu78B6ujSQ4977tinCd6yvrP5AhzZoubEwcECQQCCRGwqkDbu0sF9B9O/s/FTzk0zYQMSyv5cPyFDm7HaoWLiy7PnGPjPNksz9h7SWo3bo7stSZPKacyZ7jstd7Z1AkEAwQJCyj4LA7Ehf31jCdsL8DXtWPLDr9PtazfNMmSlZcuvlZ8VEBd7CRJa6oqu8DfyN2ByLx2aYeyEhbA8kOOA9A=="
		 * ; RSAPrivateKey rsaPrivateKey = RSA.loadPrivateKeyByStr(privateKey);
		 * String decrypt = RSA.decrypt(rsaPrivateKey, doEncrypttest);
		 * System.out.println(decrypt);
		 */
		// String a = decryptRes();
		// System.out.println(a);
		//
		// String requestBodyJson = "22222222222222222222";
		// String doSign1 = doSign1(requestBodyJson);
		// System.out.println(doSign1);

	}

	public static String doSign1(String requestBodyJson) {
		String key = "tbc_zhtb_wxjk";
		String privateKey = "MIICdQIBADANBgkqhkiG9w0BAQEFAASCAl8wggJbAgEAAoGBALCFSbbdkAgfGlTphbp6WS9k8dTs8LKJezBrAo5m46V9i4Eg8H/rdUi8cwy5TaaGBUHFTHe2/KI10nPUMA4Ng22l30Uc+yOXuW6vzwsYEWeVjQh9Z5eeqtR7ilnJPNEwhocq2P2DbCCuwWelH1pMQARPsCxiMjnbPQHyxDn6YSW1AgMBAAECgYAmzfZJe+V405WPSxK5zsGiWJeNDlVPekeZejzCnz22GKY9Scd054cN6VeFWYsHa3jmX4AS5SgeZKSSD/hMbo4QgszCL8xiyP8AmzpglYsif84JXbeuCjGFAnVIFM9tgJ5nEOi3pp7GgpGrPstjWGQJEXGK3r9N1PrHuMEywry1IQJBAPwtcD9KAdkE0mXisspcrOWZ2Inwgs0xw/Lu+Rfpo+xa0cQQsy2UOfr+7jcqfineaN2L5N/f3dJsg9EMAGxNi+kCQQCzMkRgDc4m8WxusBfWqGEB7V+u7cQGM6ebdG+ZbyPP8clr+Y3jOY7c+xueNMpwruCGFeqSQe43UrpgmyU14UftAkAypElbXFhcpZw++7Sd8NiDz05t/Q+3d1v7aEQ7qh7SMzbW4eepqo+uOQ3LpEvryo9SlmpjDwjz3fjmvTtEhJopAkAD8hBlWQh3/QrZKRFtTYnNRA++R0fwpwSCvL6UT0knk/hOY1FHdoX5waGrCxiGAKO68BKZI9B98VlfNStNk2dFAkBGu0rf+mbDwU58fAXA8whsuMO2mcEVYQlzLDqdJZZEBcCQ4bg+wrQUgiBkMGwWXnhCIoTlWLUERHXJfkyO0OiD";

		// final String content = key + requestBodyJson;
		return RSA.sha1WithRSA(requestBodyJson, privateKey,
				StandardCharsets.UTF_8);
	}

	// String a = "\"\"";
	public String doSign(String requestBodyJson) {
		String key = "tbc_zhtb_wxjk";
		String privateKey = "MIICdQIBADANBgkqhkiG9w0BAQEFAASCAl8wggJbAgEAAoGBALCFSbbdkAgfGlTphbp6WS9k8dTs8LKJezBrAo5m46V9i4Eg8H/rdUi8cwy5TaaGBUHFTHe2/KI10nPUMA4Ng22l30Uc+yOXuW6vzwsYEWeVjQh9Z5eeqtR7ilnJPNEwhocq2P2DbCCuwWelH1pMQARPsCxiMjnbPQHyxDn6YSW1AgMBAAECgYAmzfZJe+V405WPSxK5zsGiWJeNDlVPekeZejzCnz22GKY9Scd054cN6VeFWYsHa3jmX4AS5SgeZKSSD/hMbo4QgszCL8xiyP8AmzpglYsif84JXbeuCjGFAnVIFM9tgJ5nEOi3pp7GgpGrPstjWGQJEXGK3r9N1PrHuMEywry1IQJBAPwtcD9KAdkE0mXisspcrOWZ2Inwgs0xw/Lu+Rfpo+xa0cQQsy2UOfr+7jcqfineaN2L5N/f3dJsg9EMAGxNi+kCQQCzMkRgDc4m8WxusBfWqGEB7V+u7cQGM6ebdG+ZbyPP8clr+Y3jOY7c+xueNMpwruCGFeqSQe43UrpgmyU14UftAkAypElbXFhcpZw++7Sd8NiDz05t/Q+3d1v7aEQ7qh7SMzbW4eepqo+uOQ3LpEvryo9SlmpjDwjz3fjmvTtEhJopAkAD8hBlWQh3/QrZKRFtTYnNRA++R0fwpwSCvL6UT0knk/hOY1FHdoX5waGrCxiGAKO68BKZI9B98VlfNStNk2dFAkBGu0rf+mbDwU58fAXA8whsuMO2mcEVYQlzLDqdJZZEBcCQ4bg+wrQUgiBkMGwWXnhCIoTlWLUERHXJfkyO0OiD";
		final String content = key + requestBodyJson;
		System.out.println("@@@@@@@@@@" + content);
		return RSA.sha1WithRSA(content, privateKey, StandardCharsets.UTF_8);
	}

	public String doEncrypt(String requestBodyJson) {
		String encryptRequestBodyJson = "";
		String publicKeyStr = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQCOfGArUzCbvITWpCK4InWKUA8i/njv/qjZ6VO0pmxIZlPx1yEajqy7WZQCsKM0kKdY66AEWlBwWZ3B/B0x3MNVf1L1/Bsnooj+6Kp+DvrWJHcFtstSX9M8qji6257zumZwPWIj+XXPhxRneuu/zIlK4TWlbOJ+0CDT6yUepa7FBQIDAQAB";
		try {
			RSAPublicKey rsaPublicKey = RSA.loadPublicKeyByStr(publicKeyStr);
			encryptRequestBodyJson = RSA.encrypt(rsaPublicKey, requestBodyJson);
			// for (int i = 0; i < encryptRequestBodyJson.length; i++) {
			// System.out.print(encryptRequestBodyJson[i]);
			// }
		} catch (Exception e) {
			e.printStackTrace();
		}
		return encryptRequestBodyJson;
	}

	public static String doEncrypttest(String requestBodyJson) {

		String encryptRequestBodyJson = "";
		String publicKeyStr = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQCOfGArUzCbvITWpCK4InWKUA8i/njv/qjZ6VO0pmxIZlPx1yEajqy7WZQCsKM0kKdY66AEWlBwWZ3B/B0x3MNVf1L1/Bsnooj+6Kp+DvrWJHcFtstSX9M8qji6257zumZwPWIj+XXPhxRneuu/zIlK4TWlbOJ+0CDT6yUepa7FBQIDAQAB";
		try {
			RSAPublicKey rsaPublicKey = RSA.loadPublicKeyByStr(publicKeyStr);
			// String encryptText = RSA.encrypt(rsaPublicKey, requestBodyJson);
			// System.out.println("鍔犲瘑鍚庢暟鎹�:" + encryptText);
			// RSAPublicKey rsaPublicKey = RSA.loadPublicKeyByStr(publicKeyStr);
			encryptRequestBodyJson = RSA.encrypt(rsaPublicKey, requestBodyJson);
			// for (int i = 0; i < encryptRequestBodyJson.length; i++) {
			// System.out.print(encryptRequestBodyJson[i]);
			// }
		} catch (Exception e) {
			e.printStackTrace();
		}
		return encryptRequestBodyJson;
	}

	public String decryptRes(String res) throws Exception {
		String prkey = "MIICdQIBADANBgkqhkiG9w0BAQEFAASCAl8wggJbAgEAAoGBALCFSbbdkAgfGlTphbp6WS9k8dTs8LKJezBrAo5m46V9i4Eg8H/rdUi8cwy5TaaGBUHFTHe2/KI10nPUMA4Ng22l30Uc+yOXuW6vzwsYEWeVjQh9Z5eeqtR7ilnJPNEwhocq2P2DbCCuwWelH1pMQARPsCxiMjnbPQHyxDn6YSW1AgMBAAECgYAmzfZJe+V405WPSxK5zsGiWJeNDlVPekeZejzCnz22GKY9Scd054cN6VeFWYsHa3jmX4AS5SgeZKSSD/hMbo4QgszCL8xiyP8AmzpglYsif84JXbeuCjGFAnVIFM9tgJ5nEOi3pp7GgpGrPstjWGQJEXGK3r9N1PrHuMEywry1IQJBAPwtcD9KAdkE0mXisspcrOWZ2Inwgs0xw/Lu+Rfpo+xa0cQQsy2UOfr+7jcqfineaN2L5N/f3dJsg9EMAGxNi+kCQQCzMkRgDc4m8WxusBfWqGEB7V+u7cQGM6ebdG+ZbyPP8clr+Y3jOY7c+xueNMpwruCGFeqSQe43UrpgmyU14UftAkAypElbXFhcpZw++7Sd8NiDz05t/Q+3d1v7aEQ7qh7SMzbW4eepqo+uOQ3LpEvryo9SlmpjDwjz3fjmvTtEhJopAkAD8hBlWQh3/QrZKRFtTYnNRA++R0fwpwSCvL6UT0knk/hOY1FHdoX5waGrCxiGAKO68BKZI9B98VlfNStNk2dFAkBGu0rf+mbDwU58fAXA8whsuMO2mcEVYQlzLDqdJZZEBcCQ4bg+wrQUgiBkMGwWXnhCIoTlWLUERHXJfkyO0OiD";
		RSAPrivateKey rsaPrivateKey = RSA.loadPrivateKeyByStr(prkey);
		// String res
		// ="A4ShIaLbyt7iIlQOCPg3AX8nr92Ehwj7UzWVbugjhshPkHJS8dmYMwsX41C2+vj1UbX5Cz9YgQKd88r6JXP5SNilYURnzSGOjk+ik3b3FYs1ufNzyE5N/P/6yTJgquqegPlAXUDf1uKiTjboTpe15g9WvwXKPD4zTGRG/4qN3VUOYslftGMdjanrh0orpiJS0BeEq1REmqfrQ7htgIdakJ/erLSBXsPxmqvttWvws4m/N+ex369j8n4Rh7al2vzaIwgJFzG+VmM9h0KR42bqgrXA5+MfkBG/Zt+0xToD/eTygbnb7RITrPUNBhI0ZREeKIq2Nnum7XHYrakc3gYLGQ==";
		String decryptText1 = RSA.decrypt(rsaPrivateKey, res);
		System.out.println("解密后数据:" + decryptText1);
		return decryptText1;
	}

}
