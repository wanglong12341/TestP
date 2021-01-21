package com.krb.measurement.oldtest.example.demo;

import com.mysql.jdbc.Connection;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.*;


@Slf4j
@RestController
@ResponseBody
@CrossOrigin
public class HelloWorldController extends Dependencies {
	@Value("${url}")
	public  String url;
	@Value("${url1}")
	public  String url1;
	@Value("${url2}")
	public  String url2;
	@Value("${url3}")
	public  String url3;
	@Value("${url4}")
	public  String url4;
	@Value("${sxurl}")
	public  String sxurl;
	@Value("${zyurl}")
	public  String zyurl;
	@Value("${ywurl}")
	public  String ywurl;
	
	@Value("${bairong}")
	public  String bairong;

	@Value("${zhuce}")
	public  String zhuce;
	@Value("${json1}")
	public  String json1;
	@Value("${shouxin}")
	public  String shouxin;

	@Value("${shouxi}")
	public  String 	shouxi;

	@Value("${tuisong}")
	public  String tuisong;

	@Value("${kaihu}")
	public  String kaihu;
	@Value("${ywjsonzdw}")
	public  String ywjsonzdw;
	@Value("${ywjsonyy}")
	public  String ywjsonyy;
	@Value("${ywjsonsrj}")
	public  String ywjsonsrj;
	@Value("${ywjsonsmj}")
	public  String ywjsonsmj;

	@Value("${json}")
	public  String json;

	@Value("${lzshouxin}")
	public  String lzshouxin;

	@Value("${lzzhiyong}")
	public String lzzhiyong;
	
	@Value("${sytsxurl}")
	public String sytsxurl;
	@Value("${sytsxurl1}")
	public String sytsxurl1;
	@Value("${sytsxurl2}")
	public String sytsxurl2;
	@Value("${sytsxjson}")
	public String sytsxjson;
	
	@Value("${sytdburl}")
	public String sytdburl;
	@Value("${sytdburl1}")
	public String sytdburl1;
	@Value("${sytdburl2}")
	public String sytdburl2;
	
	@Value("${sytdbjson}")
	public String sytdbjson;
	
	@Value("${sytscjfpzurl}")
	public String sytscjfpzurl;
	@Value("${sytscjfpzurl1}")
	public String sytscjfpzurl1;
	
	@Value("${sytscjfpzurl2}")
	public String sytscjfpzurl2;
	
	@Value("${sytscjfpzjson}")
	public String sytscjfpzjson;
	
	@Value("${sytsfkhdurl}")
	public String sytsfkhdurl;
	@Value("${sytsfkhdurl1}")
	public String sytsfkhdurl1;
	@Value("${sytsfkhdurl2}")
	public String sytsfkhdurl2;
	
	
	@Value("${sytsfkhdjson}")
	public String sytsfkhdjson;
	
	@Value("${sytyjurl}")
	public String sytyjurl;
	@Value("${sytyjurl1}")
	public String sytyjurl1;
	@Value("${sytyjurl2}")
	public String sytyjurl2;
	
	@Value("${sytyjjson}")
	public String sytyjjson;
	
	@Value("${qzpt_xxj_url}")
	public String qzpt_xxj_url;
	@Value("${qzpt_xxj_url1}")
	public String qzpt_xxj_url1;
	@Value("${qzpt_xxj_url2}")
	public String qzpt_xxj_url2;
	
	@Value("${qzpt_xxj_json}")
	public String qzpt_xxj_json;
	@Value("${qzpt_xxj_json1}")
	public String qzpt_xxj_json1;
	
	@Value("${qzpt_xxj_qy_url}")
	public String qzpt_xxj_qy_url;
	@Value("${qzpt_xxj_qy_url1}")
	public String qzpt_xxj_qy_url1;
	@Value("${qzpt_xxj_qy_url2}")
	public String qzpt_xxj_qy_url2;
	
	@Value("${qzpt_xxj_qy_json}")
	public String qzpt_xxj_qy_json;
	@Value("${qzpt_xxj_qy_json1}")
	public String qzpt_xxj_qy_json1;
	
	@Value("${qzpt_xxj_qyrz_url}")
	public String qzpt_xxj_qyrz_url;
	@Value("${qzpt_xxj_qyrz_url1}")
	public String qzpt_xxj_qyrz_url1;
	@Value("${qzpt_xxj_qyrz_url2}")
	public String qzpt_xxj_qyrz_url2;
	
	@Value("${qzpt_xxj_qyrz_json}")
	public String qzpt_xxj_qyrz_json;
	@Value("${qzpt_xxj_qyrz_json1}")
	public String qzpt_xxj_qyrz_json1;
	
	@Value("${qzpt_xxj_wjxz_url}")
	public String qzpt_xxj_wjxz_url;
	@Value("${qzpt_xxj_wjxz_url1}")
	public String qzpt_xxj_wjxz_url1;
	@Value("${qzpt_xxj_wjxz_url2}")
	public String qzpt_xxj_wjxz_url2;
	@Value("${qzpt_xxj_wjxz_json}")
	public String qzpt_xxj_wjxz_json;
	
	@Value("${sfpt_dy_url}")
	public String sfpt_dy_url;
	@Value("${sfpt_dy_url1}")
	public String sfpt_dy_url1;
	@Value("${sfpt_dy_json1}")
	public String sfpt_dy_json1;
	@Value("${sfpt_dy_json2}")
	public String sfpt_dy_json2;
	@Value("${sfpt_dy_json3}")
	public String sfpt_dy_json3;
	public static InputStreamReader in;
	public static Properties proper;
	@Autowired Test1 test1;
	@PostMapping("/riskNotifyTest")
	public String riskNotifyTest(@RequestBody Map<String, String> map){
		System.out.println(map);
		return null;
	}
	static {
		try {
			in = new InputStreamReader(HelloWorldController.class
					.getResourceAsStream("data1.properties"),"UTF-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		proper = new Properties();
		try {
			proper.load(in);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("&&&&&&&&&&&&&&&&*******");
	}
	
	@RequestMapping("/getinfo")
	public Map getinfo(){
		String name =getName();
		String idno = getJsIdcardNO1();
		String bankno = getJsbankno();
		String phone = getPhonenm();
		Map map =new HashMap();
		map.put("name",name);
        map.put("idno",idno);
        map.put("bankno",bankno);
        map.put("phone",phone);
		return map;
//		return "{\"name\":"+"\""+name +"\""+"," + "\"certid\":"+"\""+idno+"\""+"," + "\"bankno\":"+"\""+bankno+"\""+","+ "\"phone\":"+"\""+phone+"\""+"}";
		
	}
	
	@RequestMapping("/liubiaoDev")
	public String lb(String itemid) throws IOException, InterruptedException, SQLException {
		com.mysql.jdbc.Connection conn = getConnDev();
		String itemsetid = null;
		String sql1 = "update biz_item set expire_date = '2019-05-19 12:00:00' where item_id="+itemid;
		
		String itemsetidsql = "select itemset_id from biz_item WHERE item_id = '"+itemid+"'; ";
		try {
			
			itemsetid = selectInfo(conn, itemsetidsql);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		Thread.sleep(1000);
		String sql2 = "update biz_itemset set expire_date = '2019-05-19 12:00:00' where itemset_id="+itemsetid;
		System.out.println(sql2);
		try {
			updateInfo(conn, sql1);
			Thread.sleep(3000);
			updateInfo(conn, sql2);
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			conn.close();
		}

		
		return "修改成功"+"<br>"+"请到cms后台查看流标审核里查看"+itemid+"信息，审核即可";
		
	}
	@RequestMapping("/liubiaoTxt")
	public String lbt(String itemid) throws IOException, InterruptedException, SQLException {
		com.mysql.jdbc.Connection conn = getConnTet();
		String itemsetid = null;
		String sql1 = "update biz_item set expire_date = '2019-05-19 12:00:00' where item_id="+itemid;
		
		String itemsetidsql = "select itemset_id from biz_item WHERE item_id = '"+itemid+"'; ";
		try {
			
			itemsetid = selectInfo(conn, itemsetidsql);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		Thread.sleep(1000);
		String sql2 = "update biz_itemset set expire_date = '2019-05-19 12:00:00' where itemset_id="+itemsetid;
		System.out.println(sql2);
		try {
			updateInfo(conn, sql1);
			Thread.sleep(3000);
			updateInfo(conn, sql2);
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			conn.close();
		}
		System.out.println("sql1：：：：："+sql1);
		System.out.println("itemsetidsql：：：：："+itemsetidsql);
		System.out.println("sql2：：：：："+sql2);
		
		return "修改成功"+"<br>"+"请到cms后台查看流标审核里查看"+itemid+"信息，审核即可"+"<br>"+sql1+"<br>"+sql2;
		
	}
	@RequestMapping("/yuqiTxt")
	public String yqt(String itemid) throws IOException, InterruptedException, SQLException {
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String endDate = df.format(System.currentTimeMillis() - 2 * 24 * 60 * 60 * 1000L);
		String startDate = df.format(System.currentTimeMillis() - 62 * 24 * 60 * 60 * 1000L);
//		String unlockDate = df.format(new Date(System.currentTimeMillis() - 44 * 24 * 60 * 60 * 1000L));
		
		com.mysql.jdbc.Connection conn = getConnTet();
		String itemsetid = null;
		String sql1 = "update biz_item set unlock_date = '2019-05-19 12:00:00' where item_id = " + itemid;
		String itemsetidsql = "select itemset_id from biz_item WHERE item_id = '" + itemid + "';";
		try {
			
			itemsetid = selectInfo(conn, itemsetidsql);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		Thread.sleep(1000);
		String sql2 = "update biz_term set status_term = '3' where itemset_id= "+ itemsetid;
		String sql3 = "update biz_item set begin_date = '" + startDate + "', end_date = '" + endDate + "' where item_id = "+ itemid;
		String sql4 = "update biz_term set term_bdate = '" + startDate + "', term_edate = '" + endDate + "' where itemset_id = "+ itemsetid;
		
		try {
			updateInfo(conn, sql1);
			Thread.sleep(3000);
			updateInfo(conn, sql3);
			Thread.sleep(3000);
			updateInfo(conn, sql2);
			Thread.sleep(3000);
			updateInfo(conn, sql4);
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			conn.close();
		}
		System.out.println("sql1：：：：：" + sql1);
		System.out.println("sql3：：：：：" + sql3);
		System.out.println("itemsetidsql：：：：：" + itemsetidsql);
		System.out.println("sql2：：：：：" + sql2);
		System.out.println("sql4：：：：：" + sql4);
		return "修改成功"+"<br>"+"请到cms后台查看还款操作里查看"+itemid+"信息，进行还款即可"+"<br>"+sql1+"<br>"+sql2+"<br>"+sql3+"<br>"+sql4;
		
	}
	@RequestMapping("/normalTxt")
	public String normalT(String itemid) throws IOException, InterruptedException, SQLException {
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String startDate = df.format(new Date());
		String endDate = df.format(new Date(System.currentTimeMillis() - 59 * 24 * 60 * 60 * 1000L));
		String unlockDate = df.format(new Date(System.currentTimeMillis() - 44 * 24 * 60 * 60 * 1000L));
		System.out.println("结束时间是"+startDate);
		System.out.println("开始时间是"+endDate);
		com.mysql.jdbc.Connection conn = getConnTet();
		String sql1 = "update biz_item set unlock_date = '"+unlockDate+"', open_date ='"+endDate+"',expire_date ='"+startDate+"',begin_date ='"+endDate+"',end_date ='"+startDate+"',verify_time ='"+endDate+"',reach_time ='"+endDate+"',loan_time ='"+endDate+"',finish_time ='"+startDate+"',create_time ='"+endDate+"'where item_id="+itemid;
		System.out.println("sql1"+"@@@@@@@@@@@@@@@"+sql1);
		String sql2 = "update biz_itemset set open_date ='"+endDate+"',expire_date ='"+startDate+"',begin_date ='"+endDate+"',end_date ='"+startDate+"',verify_time ='"+endDate+"',reach_time ='"+endDate+"',loan_time ='"+endDate+"',finish_time ='"+startDate+"',create_time ='"+endDate+"'where itemset_id="+itemid;
		String sql3 = "update biz_itemsetpayment set term_bdate ='"+endDate+"',term_edate ='"+startDate+"',pay_time ='"+startDate+"',paid_time ='"+startDate+"',create_time ='"+endDate+"'where itemset_id="+itemid;
		String sql4 = "update biz_term set term_bdate ='"+endDate+"',term_edate ='"+startDate+"',pay_time ='"+startDate+"',paid_time ='"+startDate+"',create_time ='"+endDate+"'where itemset_id="+itemid;
		System.out.println("sql1：：：：："+sql1);
		System.out.println("sql2：：：：："+sql2);
		System.out.println("sql3：：：：："+sql3);
		System.out.println("sql4：：：：："+sql4);
		try {
			updateInfo(conn, sql1);
			Thread.sleep(3000);
			updateInfo(conn, sql2);
			Thread.sleep(3000);
			updateInfo(conn, sql3);
			Thread.sleep(3000);
			updateInfo(conn, sql4);
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			conn.close();
		}
		
		return "修改成功"+"<br>"+"请到cms后台查看还款操作里查看"+itemid+"信息，进行还款即可"+"<br>"+sql1+"<br>"+sql2+"<br>"+sql3+"<br>"+sql4;
		
	}
	@RequestMapping("/normalDev")
	public String normalD(String itemid) throws IOException, InterruptedException, SQLException {
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String startDate = df.format(new Date());
		String endDate = df.format(new Date(System.currentTimeMillis() - 59 * 24 * 60 * 60 * 1000L));
		String unlockDate = df.format(new Date(System.currentTimeMillis() - 44 * 24 * 60 * 60 * 1000L));
		com.mysql.jdbc.Connection conn = getConnDev();
		String sql1 = "update biz_item set unlock_date = '"+unlockDate+"', open_date ='"+endDate+"',expire_date ='"+startDate+"',begin_date ='"+endDate+"',end_date ='"+startDate+"',verify_time ='"+endDate+"',reach_time ='"+endDate+"',loan_time ='"+endDate+"',finish_time ='"+startDate+"',create_time ='"+endDate+"'where item_id="+itemid;
		String sql2 = "update biz_itemset set open_date ='"+endDate+"',expire_date ='"+startDate+"',begin_date ='"+endDate+"',end_date ='"+startDate+"',verify_time ='"+endDate+"',reach_time ='"+endDate+"',loan_time ='"+endDate+"',finish_time ='"+startDate+"',create_time ='"+endDate+"'where itemset_id="+itemid;
		String sql3 = "update biz_itemsetpayment set term_bdate ='"+endDate+"',term_edate ='"+startDate+"',pay_time ='"+startDate+"',paid_time ='"+startDate+"',create_time ='"+endDate+"'where itemset_id="+itemid;
		String sql4 = "update biz_term set term_bdate ='"+endDate+"',term_edate ='"+startDate+"',pay_time ='"+startDate+"',paid_time ='"+startDate+"',create_time ='"+endDate+"'where itemset_id="+itemid;
		
		try {
			updateInfo(conn, sql1);
			Thread.sleep(3000);
			updateInfo(conn, sql2);
			Thread.sleep(3000);
			updateInfo(conn, sql3);
			Thread.sleep(3000);
			updateInfo(conn, sql4);
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			conn.close();
		}
		
		return "修改成功"+"<br>"+"请到cms后台查看还款操作里查看"+itemid+"信息，进行还款即可";
		
	}
	@RequestMapping("/yuqiDev")
	public String yqd(String itemid) throws IOException, InterruptedException, SQLException {
		com.mysql.jdbc.Connection conn = getConnDev();
		String itemsetid = null;
		String sql1 = "update biz_item set unlock_date = '2019-05-19 12:00:00' where item_id="+itemid;
		String itemsetidsql = "select itemset_id from biz_item WHERE item_id = '"+itemid+"'; ";
		try {
			
			itemsetid = selectInfo(conn, itemsetidsql);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		Thread.sleep(1000);
		String sql2 = "update biz_term set status_term = '3' where itemset_id="+itemid;
		try {
			updateInfo(conn, sql1);
			Thread.sleep(3000);
			updateInfo(conn, sql2);
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			conn.close();
		}
		
		return "修改成功"+"<br>"+"请到cms后台查看还款操作里查看"+itemid+"信息，进行还款即可";
		
	}
	@RequestMapping("/unlockDev")
	public String unlock1(String itemid) throws IOException, InterruptedException, SQLException {
		com.mysql.jdbc.Connection conn = getConnDev();
		String sql1 = "update biz_item set unlock_date = '2019-05-19 12:00:00' where item_id="+itemid;
//		String sql2 = "update biz_term set status_term = '3' where itemset_id="+itemid;
		try {
			updateInfo(conn, sql1);
			Thread.sleep(3000);
//			updateInfo(conn, sql2);
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			conn.close();
		}
		
		return "修改unlock_date成功"+"<br>"+"请到cms后台查看还款操作里查看"+itemid+"信息，进行还款即可";
		
	}
	@RequestMapping("/unlockTxt")
	public String unlock2(String itemid) throws IOException, InterruptedException, SQLException {
		com.mysql.jdbc.Connection conn = getConnTet();
		String sql1 = "update biz_item set unlock_date = '2019-05-19 12:00:00' where item_id="+itemid;
//		String sql2 = "update biz_term set status_term = '3' where itemset_id="+itemid;
		try {
			updateInfo(conn, sql1);
			Thread.sleep(3000);
//			updateInfo(conn, sql2);
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			conn.close();
		}
		System.out.println("sql1：：：：："+sql1);
		return "修改unlock_date成功"+"<br>"+"请到cms后台查看还款操作里查看"+itemid+"信息，进行还款即可"+"<br>"+sql1;
		
	}
	@RequestMapping("/tuisong")
	public String index() throws IOException, InterruptedException {

		Map<String, String> returnmap = new HashMap<String, String>();
		try {
			Map f4 = f4();
			if (!f4.isEmpty()) {
				String customerId = f4.get("customerId").toString();
				String idCardNum = f4.get("idCardNum").toString();
				String mobile = f4.get("mobile").toString();
				String js = tuisong;
				Map jsmap = returnmap(js);
				jsmap.put("customerId", customerId);
				String json = mapTostring(jsmap);
				System.out.println("推送的json@@@@"+json);
				String [] strings = new String[5];
				strings[0]="API_CREATE_ITEM";
				strings[1]=getrequestNum();
				strings[2]="ROMA";
				strings[3]="20190408152211";
				strings[4]=json;
				
				String post2 = post2(url1, strings);
				System.out.println(post2);
				Map tuisong = returnmap(post2);
				Map res = returnmap(tuisong.get("responseData").toString());
				String itemId = res.get("itemId").toString();
				returnmap.put("customerId", customerId);
				returnmap.put("idCardNum", idCardNum);
				returnmap.put("mobile", mobile);
				returnmap.put("itemId", itemId);
			} else {
				returnmap.put("错误", "授信失败，请重试");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			return e.toString();
		}
		return "发标成功!!"+"<br>" +" 标的itemId: "+ returnmap.get("itemId")+"<br>" +"借款人手机号mobile："+returnmap.get("mobile")+ "<br>"+ "借款人身份证号idCardNum: "+ returnmap.get("idCardNum") +"<br>" +"借款人customerId："+ returnmap.get("customerId");
	}
	@RequestMapping("/zhuce")
	public String zhuc() throws IOException, InterruptedException {

		Map<String, String> returnmap = new HashMap<String, String>();
		try {
			Map zc = zc();
			returnmap.put("customerId", zc.get("customerId").toString());
			returnmap.put("mobile", zc.get("mobile").toString());
		} catch (Exception e) {
			e.printStackTrace();
			return e.toString();
		}
		return "注册成功 " +"<br>"+"手机号码是："+returnmap.get("mobile").toString()+"<br>"+"密码：111111";
	}
	@RequestMapping("/zcdev")
	public String zhucee() throws IOException, InterruptedException {

		Map<String, String> returnmap = new HashMap<String, String>();
		try {
			Map zc = zc11();
			returnmap.put("customerId", zc.get("customerId").toString());
			returnmap.put("mobile", zc.get("mobile").toString());
		} catch (Exception e) {
			e.printStackTrace();
			return e.toString();
		}
		return "注册成功 " +"<br>"+"手机号码是："+returnmap.get("mobile").toString()+"<br>"+"密码：111111";
	}
	public Map sq() throws IOException, InterruptedException {
		Map<String, String> returnmap = new HashMap<String, String>();
		Map zc = zc();
		Thread.sleep(5000);
		String[] strings = new String[5];
		strings[0] = "API_CREDIT";
		strings[1] = getrequestNum();
		strings[2] = "ROMA";
		strings[3] = "20190408152211";
		String js = shouxin;
		Map map1 = returnmap(js);
		map1.put("customerId", zc.get("customerId"));

		Map personalInfo = returnmap(map1.get("personalInfo").toString());
		String bankNum = getJsbankno();
		String realName = getName();
		System.out.println("realName:"+realName);
		String idCardNum = getJsIdcardNO1();
		personalInfo.put("bankNum", bankNum);
		personalInfo.put("realName", realName);
		personalInfo.put("idCardNum", idCardNum);
		personalInfo.put("mobile", zc.get("mobile"));

		map1.put("personalInfo", personalInfo);
		strings[4] = mapTostring(map1);
		System.out.println("444444444" + strings[4]);
		// String json1 = properties.getProperty("json1");

		String post2 = post2(url1, strings);
		Map mappost = returnmap(post2);
		Map responseData = returnmap(mappost.get("responseData").toString());
		String errorCode = responseData.get("errorCode").toString();
		// assertEquals(errorCode, "0000");
		System.out.println("@@@@@@@@@@@@@@@@@@@@" + post2);
		returnmap.put("customerId", zc.get("customerId").toString());
		returnmap.put("realName", realName);
		returnmap.put("idCardNum", idCardNum);
		returnmap.put("mobile", zc.get("mobile").toString());
		returnmap.put("bankNum", bankNum);
		returnmap.put("errorCode", errorCode);
		return returnmap;
	}
	@RequestMapping("/sxtxt")
	public Map sq2() throws IOException, InterruptedException {
		Map<String, String> returnmap = new HashMap<String, String>();
		Map zc = zc();
		Thread.sleep(5000);
		String[] strings = new String[5];
		strings[0] = "API_CREDIT";
		strings[1] = getrequestNum();
		strings[2] = "ROMA";
		strings[3] = "20190408152211";
		String js = shouxin;
		Map map1 = returnmap(js);
		map1.put("customerId", zc.get("customerId"));

		Map personalInfo = returnmap(map1.get("personalInfo").toString());
		String bankNum = getJsbankno();
		String realName = getName();
		String idCardNum = getJsIdcardNO();
		personalInfo.put("bankNum", bankNum);
		personalInfo.put("realName", realName);
		personalInfo.put("idCardNum", idCardNum);
		personalInfo.put("mobile", zc.get("mobile"));

		map1.put("personalInfo", personalInfo);
		strings[4] = mapTostring(map1);
		System.out.println("444444444" + strings[4]);
		// String json1 = properties.getProperty("json1");

		String post2 = post2(url1, strings);
		Map mappost = returnmap(post2);
		Map responseData = returnmap(mappost.get("responseData").toString());
		String errorCode = responseData.get("errorCode").toString();
		// assertEquals(errorCode, "0000");
		System.out.println("@@@@@@@@@@@@@@@@@@@@" + post2);
		returnmap.put("customerId", zc.get("customerId").toString());
		returnmap.put("realName", realName);
		returnmap.put("idCardNum", idCardNum);
		returnmap.put("mobile", zc.get("mobile").toString());
		returnmap.put("bankNum", bankNum);
		returnmap.put("errorCode", errorCode);
		return returnmap;
	}
	@RequestMapping("/sxdev")
	public Map sq3() throws IOException, InterruptedException {
		Map<String, String> returnmap = new HashMap<String, String>();
		Map zc = zc1();
		Thread.sleep(5000);
		String[] strings = new String[5];
		strings[0] = "API_CREDIT";
		strings[1] = getrequestNum();
		strings[2] = "ROMA";
		strings[3] = "20190408152211";
		String js = shouxin;
		Map map1 = returnmap(js);
		map1.put("customerId", zc.get("customerId"));

		Map personalInfo = returnmap(map1.get("personalInfo").toString());
		String bankNum = getJsbankno();
		String realName = getName();
		String idCardNum = getJsIdcardNO1();
		personalInfo.put("bankNum", bankNum);
		personalInfo.put("realName", realName);
		personalInfo.put("idCardNum", idCardNum);
		personalInfo.put("mobile", zc.get("mobile"));

		map1.put("personalInfo", personalInfo);
		strings[4] = mapTostring(map1);
		System.out.println("444444444" + strings[4]);
		// String json1 = properties.getProperty("json1");

		String post2 = post2(url3, strings);
		Map mappost = returnmap(post2);
		Map responseData = returnmap(mappost.get("responseData").toString());
		String errorCode = responseData.get("errorCode").toString();
		// assertEquals(errorCode, "0000");
		System.out.println("@@@@@@@@@@@@@@@@@@@@" + post2);
		returnmap.put("customerId", zc.get("customerId").toString());
		returnmap.put("realName", realName);
		returnmap.put("idCardNum", idCardNum);
		returnmap.put("mobile", zc.get("mobile").toString());
		returnmap.put("bankNum", bankNum);
		returnmap.put("errorCode", errorCode);
		return returnmap;
	}
	public Map zc() throws IOException {
		Map<String, String> map1 = new HashMap<String, String>();
		String phonenum = getPhonenm();
		String js = zhuce;
		Map map = returnmap(js);
		map.put("mobile", phonenum);
		String json = mapTostring(map);
		String[] strings = new String[5];
		strings[0] = "API_REGIST";
		strings[1] = getrequestNum();
		strings[2] = "ROMA";
		strings[3] = "20190408152211";
		strings[4] = json;

		// String json1 = properties.getProperty("json1");
		String post2 = post2(url1, strings);
		System.out.println(post2);
		Map map2 = returnmap(post2);
		System.out.println("注册成功");
		Map responseData = returnmap(map2.get("responseData").toString());
		String customerId = responseData.get("customerId").toString();

		map1.put("mobile", phonenum);
		map1.put("customerId", customerId);
		System.out.println("mobile:" + phonenum + "@" + "customerId:"
				+ customerId);
		return map1;
	}
	public Map zc11() throws IOException {
		Map<String, String> map1 = new HashMap<String, String>();
		String phonenum = getPhonenm();
		String js = zhuce;
		Map map = returnmap(js);
		map.put("mobile", phonenum);
		String json = mapTostring(map);
		String[] strings = new String[5];
		strings[0] = "API_REGIST";
		strings[1] = getrequestNum();
		strings[2] = "ROMA";
		strings[3] = "20190408152211";
		strings[4] = json;

		// String json1 = properties.getProperty("json1");
		String post2 = post2(url3, strings);
		System.out.println(post2);
		Map map2 = returnmap(post2);
		System.out.println("注册成功");
		Map responseData = returnmap(map2.get("responseData").toString());
		String customerId = responseData.get("customerId").toString();

		map1.put("mobile", phonenum);
		map1.put("customerId", customerId);
		System.out.println("mobile:" + phonenum + "@" + "customerId:"
				+ customerId);
		return map1;
	}

	// 注册，授信，绑卡
	public Map f4() throws IOException, InterruptedException {
		Map<String, String> returnmap = new HashMap<String, String>();
		Map sq = sq();
		
		String bankNum = sq.get("bankNum").toString();
		// System.out.println("bankNumbankNumbankNumbankNumbankNum"+bankNum);
		String realName = sq.get("realName").toString();
		String idCardNum = sq.get("idCardNum").toString();
		String mobile = sq.get("mobile").toString();
		String customerId = sq.get("customerId").toString();
		String errorCode = sq.get("errorCode").toString();
		if ("0000".equals(errorCode)) {
			String js = kaihu;
			Map mapjs = returnmap(js);
			mapjs.put("customerId", customerId);
			mapjs.put("realName", realName);
			mapjs.put("idCardNum", idCardNum);
			mapjs.put("mobile", mobile);
			String aft = mapTostring(mapjs);
			String[] strings = new String[5];
			strings[0] = "API_PERSONAL_REGIST_EXPAND";
			strings[1] = getrequestNum();
			strings[2] = "ROMA";
			strings[3] = "20190408152211";
			strings[4] = aft;
			System.out.println("aftttttttttttttt" + strings[4]);
			Thread.sleep(5000);
			String post2 = post2(url2, strings);
			System.out.println(post2);
			writeFile(post2);
			System.out.println("写入文件成功");
			bk();
			System.out.println("绑卡成功");
			returnmap.put("customerId", customerId);
			returnmap.put("realName", realName);
			returnmap.put("idCardNum", idCardNum);
			returnmap.put("mobile", mobile);	
		}else{
			returnmap.put("error", "授信失败，请重试");
		}
		
		return returnmap;

	}


	@RequestMapping("/shouxintxt")
	public String shouxin() throws IOException, InterruptedException {
		String[] strings = new String[5];
		strings[0] = "API_CREDIT";
		strings[1] = getrequestNum();
		strings[2] = "ROMA";
		strings[3] = "20190408152211";
		String js = shouxin;
		Map map1 = returnmap(js);

	
		strings[4] = mapTostring(map1);
		System.out.println("444444444" + strings[4]);
		// String json1 = properties.getProperty("json1");

		String post2 = post2(url1, strings);
		System.out.println(post2);
		return post2;
		
	}
	
	
	
	
	
	@RequestMapping("/tuisongdev")
	public String index1() throws IOException, InterruptedException {

		Map<String, String> returnmap = new HashMap<String, String>();
		try {
			Map f4 = f41();
			if (!f4.isEmpty()) {
				String customerId = f4.get("customerId").toString();
				String idCardNum = f4.get("idCardNum").toString();
				String mobile = f4.get("mobile").toString();
				String js = tuisong;
				Map jsmap = returnmap(js);
				jsmap.put("customerId", customerId);
				String json = mapTostring(jsmap);
				String [] strings = new String[5];
				strings[0]="API_CREATE_ITEM";
				strings[1]=getrequestNum();
				strings[2]="ROMA";
				strings[3]="20190408152211";
				strings[4]=json;
				
				String post2 = post2(url3, strings);
				System.out.println(post2);
				Map tuisong = returnmap(post2);
				Map res = returnmap(tuisong.get("responseData").toString());
				String itemId = res.get("itemId").toString();
				returnmap.put("customerId", customerId);
				returnmap.put("idCardNum", idCardNum);
				returnmap.put("mobile", mobile);
				returnmap.put("itemId", itemId);
			} else {
				returnmap.put("错误", "授信失败，请重试");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			return e.toString();
		}
		return "发标成功!!"+"<br>" +" 标的itemId: "+ returnmap.get("itemId")+"<br>" +"借款人手机号mobile："+returnmap.get("mobile")+ "<br>"+ "借款人身份证号idCardNum: "+ returnmap.get("idCardNum") +"<br>" +"借款人customerId："+ returnmap.get("customerId");
	}
	@RequestMapping("/zhucedev")
	public String zhuce() throws IOException, InterruptedException {

		Map<String, String> returnmap = new HashMap<String, String>();
		try {
			Map zc = zc1();
			returnmap.put("customerId", zc.get("customerId").toString());
			returnmap.put("mobile", zc.get("mobile").toString());
		} catch (Exception e) {
			e.printStackTrace();
			return e.toString();
		}
		return "注册成功 " +"<br>"+"手机号码是："+returnmap.get("mobile").toString()+"<br>"+"密码：111111";
	}
	public Map sq1() throws IOException, InterruptedException {
		Map<String, String> returnmap = new HashMap<String, String>();
		Map zc = zc1();
		Thread.sleep(5000);
		String[] strings = new String[5];
		strings[0] = "API_CREDIT";
		strings[1] = getrequestNum();
		strings[2] = "ROMA";
		strings[3] = "20190408152211";
		String js = shouxin;
		Map map1 = returnmap(js);
		map1.put("customerId", zc.get("customerId"));

		Map personalInfo = returnmap(map1.get("personalInfo").toString());
		String bankNum = getJsbankno();
		String realName = getName();
		String idCardNum = getJsIdcardNO1();
		personalInfo.put("bankNum", bankNum);
		personalInfo.put("realName", realName);
		personalInfo.put("idCardNum", idCardNum);
		personalInfo.put("mobile", zc.get("mobile"));

		map1.put("personalInfo", personalInfo);
		strings[4] = mapTostring(map1);
		System.out.println("444444444" + strings[4]);
		// String json1 = properties.getProperty("json1");

		String post2 = post2(url3, strings);
		Map mappost = returnmap(post2);
		Map responseData = returnmap(mappost.get("responseData").toString());
		String errorCode = responseData.get("errorCode").toString();
		// assertEquals(errorCode, "0000");
		System.out.println("@@@@@@@@@@@@@@@@@@@@" + post2);
		Thread.sleep(60000);
		returnmap.put("customerId", zc.get("customerId").toString());
		returnmap.put("realName", realName);
		returnmap.put("idCardNum", idCardNum);
		returnmap.put("mobile", zc.get("mobile").toString());
		returnmap.put("bankNum", bankNum);
		returnmap.put("errorCode", errorCode);
		return returnmap;
	}

	public Map zc1() throws IOException {
		Map<String, String> map1 = new HashMap<String, String>();
		String phonenum = getPhonenm();
		String js = zhuce;
		Map map = returnmap(js);
		map.put("mobile", phonenum);
		String json = mapTostring(map);
		String[] strings = new String[5];
		strings[0] = "API_REGIST";
		strings[1] = getrequestNum();
		strings[2] = "ROMA";
		strings[3] = "20190408152211";
		strings[4] = json;

		// String json1 = properties.getProperty("json1");
		String post2 = post2(url3, strings);
		System.out.println(post2);
		Map map2 = returnmap(post2);
		System.out.println("注册成功");
		Map responseData = returnmap(map2.get("responseData").toString());
		String customerId = responseData.get("customerId").toString();

		map1.put("mobile", phonenum);
		map1.put("customerId", customerId);
		System.out.println("mobile:" + phonenum + "@" + "customerId:"
				+ customerId);
		return map1;
	}

	// 注册，授信，绑卡
	public  Map f41() throws IOException, InterruptedException {
		Map<String, String> returnmap = new HashMap<String, String>();
		Map sq = sq1();
		
		String bankNum = sq.get("bankNum").toString();
		// System.out.println("bankNumbankNumbankNumbankNumbankNum"+bankNum);
		String realName = sq.get("realName").toString();
		String idCardNum = sq.get("idCardNum").toString();
		String mobile = sq.get("mobile").toString();
		String customerId = sq.get("customerId").toString();
		String errorCode = sq.get("errorCode").toString();
		if ("0000".equals(errorCode)) {
			String js = kaihu;
			Map mapjs = returnmap(js);
			mapjs.put("customerId", customerId);
			mapjs.put("realName", realName);
			mapjs.put("idCardNum", idCardNum);
			mapjs.put("mobile", mobile);
			String aft = mapTostring(mapjs);
			String[] strings = new String[5];
			strings[0] = "API_PERSONAL_REGIST_EXPAND";
			strings[1] = getrequestNum();
			strings[2] = "ROMA";
			strings[3] = "20190408152211";
			strings[4] = aft;
			System.out.println("aftttttttttttttt" + strings[4]);
			Thread.sleep(5000);
			String post2 = post2(url4, strings);
			System.out.println(post2);
			writeFile(post2);
			System.out.println("写入文件成功");
			bk();
			System.out.println("绑卡成功");
			returnmap.put("customerId", customerId);
			returnmap.put("realName", realName);
			returnmap.put("idCardNum", idCardNum);
			returnmap.put("mobile", mobile);	
		}else{
			returnmap.put("error", "授信失败，请重试");
		}
		
		return returnmap;

	}
	
	@RequestMapping("/lzsxtxt")
	public String lzshouxin() throws IOException, InterruptedException {
		Map<String, String> returnmap = new HashMap<String, String>();
		String[] strings = new String[5];
		strings[0] = "API_CREDIT_EXTENSION";
		strings[1] = getrequestNum();
		strings[2] = "CZ";
		strings[3] = "20190408152211";
		String js = lzshouxin;
		Map map1 = returnmap(js);
		
		String APP_NO = getrequestNum();
		String realName = getName();
		String idCardNum = getJsIdcardNO1();
		map1.put("APP_NO", APP_NO);
		map1.put("USER_CERT_CODE", idCardNum);
		map1.put("CUST_NAME", realName);
	

		
		strings[4] = mapTostring(map1);
		System.out.println("灵芝授信requestdata:" + strings[4]);
		// String json1 = properties.getProperty("json1");

		String post2 = postlz(sxurl, strings);
		Map mappost = returnmap(post2);
		Map responseData = returnmap(mappost.get("responseData").toString());
		String errorCode = responseData.get("errorCode").toString();
		// assertEquals(errorCode, "0000");
		System.out.println("灵芝授信请求结果@@@@@@@" + post2);
//		returnmap.put("customerId", zc.get("customerId").toString());
//		returnmap.put("realName", realName);
//		returnmap.put("idCardNum", idCardNum);
//		returnmap.put("mobile", zc.get("mobile").toString());
//		returnmap.put("bankNum", bankNum);
//		returnmap.put("errorCode", errorCode);
		return "灵芝授信requestdata:"+"<br>" + strings[4] + "<br></br>"+"灵芝授信请求结果"+"<br>" + post2;
	}
	@RequestMapping("/lzzytxt")
	public String lzzhiyong() throws IOException, InterruptedException {
		Map<String, String> returnmap = new HashMap<String, String>();
		Map userinf = lzshouxin1();
		Thread.sleep(660000);
		String[] strings = new String[5];
		strings[0] = "API_WITHDRAW";
		strings[1] = getrequestNum();
		strings[2] = "CZ";
		strings[3] = "20190408152211";
		String js = lzzhiyong;
		Map map1 = returnmap(js);
		
		String MOBILE = userinf.get("MOBILE").toString();
		String CUST_NAME = userinf.get("CUST_NAME").toString();
		String USER_CERT_CODE = userinf.get("USER_CERT_CODE").toString();
		map1.put("MOBILE", MOBILE);
		map1.put("USER_CERT_CODE", USER_CERT_CODE);
		map1.put("CUST_NAME", CUST_NAME);
	

		
		strings[4] = mapTostring(map1);
		System.out.println("灵芝支用requestdata:" + strings[4]);
		// String json1 = properties.getProperty("json1");

		String post2 = postlz(zyurl, strings);
		Map mappost = returnmap(post2);
		Map responseData = returnmap(mappost.get("responseData").toString());
		String errorCode = responseData.get("errorCode").toString();
		// assertEquals(errorCode, "0000");
		System.out.println("灵芝支用请求结果@@@@@@@" + post2);
//		returnmap.put("customerId", zc.get("customerId").toString());
//		returnmap.put("realName", realName);
//		returnmap.put("idCardNum", idCardNum);
//		returnmap.put("mobile", zc.get("mobile").toString());
//		returnmap.put("bankNum", bankNum);
//		returnmap.put("errorCode", errorCode);
		return "灵芝支用requestdata:"+"<br>" + strings[4] + "<br></br>"+"灵芝支用re请求结果"+"<br>" + post2;
	}
	/**
	 * 110岁身份证
	 * @return
	 * @throws IOException
	 * @throws InterruptedException
	 */
	@RequestMapping("/ageonehd")
	public static String age() throws IOException, InterruptedException {
		String age = getJsIdcardNO100();
		return "年龄110岁的身份证号码:"+"<br>" + age ;
	}
	public Map lzshouxin1() throws IOException, InterruptedException {
		Map<String, String> returnmap = new HashMap<String, String>();
		String[] strings = new String[5];
		strings[0] = "API_CREDIT_EXTENSION";
		strings[1] = getrequestNum();
		strings[2] = "CZ";
		strings[3] = "20190408152211";
		String js = lzshouxin;
		Map map1 = returnmap(js);
		
		String APP_NO = getrequestNum();
		String realName = getName();
		String idCardNum = getJsIdcardNO1();
		String MOBILE = map1.get("MOBILE").toString();
		map1.put("APP_NO", APP_NO);
		map1.put("USER_CERT_CODE", idCardNum);
		map1.put("CUST_NAME", realName);
	

		
		strings[4] = mapTostring(map1);
		System.out.println("灵芝授信requestdata:" + strings[4]);
		// String json1 = properties.getProperty("json1");

		String post2 = postlz(sxurl, strings);
		Map mappost = returnmap(post2);
		Map responseData = returnmap(mappost.get("responseData").toString());
		String errorCode = responseData.get("errorCode").toString();
		// assertEquals(errorCode, "0000");
		System.out.println("灵芝授信请求结果@@@@@@@" + post2);
		returnmap.put("MOBILE", MOBILE);
		returnmap.put("CUST_NAME", realName);
		returnmap.put("USER_CERT_CODE", idCardNum);
//		returnmap.put("mobile", zc.get("mobile").toString());
//		returnmap.put("bankNum", bankNum);
//		returnmap.put("errorCode", errorCode);
		return returnmap;
	}
	
	@RequestMapping("/ywsxtxt")
	public String ywshouxin() throws IOException, InterruptedException {
		Map<String, String> returnmap = new HashMap<String, String>();
		String js = ywjsonzdw;
		Map map1 = returnmap(js);
		Map map2= (Map) map1.get("personalInfo");
		String certId = map2.get("idCardNum").toString();
		String name = map2.get("realName").toString();
		String mobile = map2.get("mobile").toString();
		String sourceOrderId = getrequestNum();
		String sourceChannelOrderId = getrequestNum();
		System.out.println("远望授信requestdata:" + js);
		// String json1 = properties.getProperty("json1");
		String urll1 = ywurl + "&certId="+certId + "&name="+name + "&mobile="+mobile + "&sourceOrderId="+sourceOrderId + "&sourceChannelOrderId="+sourceChannelOrderId ;
		String post2 = post1(urll1, js);
		Map mappost = returnmap(post2);
//		Map responseData = returnmap(mappost.get("responseData").toString());
//		String errorCode = responseData.get("errorCode").toString();
		// assertEquals(errorCode, "0000");
		System.out.println("远望授信请求结果@@@@@@@" + post2);
		
		String js1 = ywjsonyy;
		Map map3 = returnmap(js1);
		Map map4= (Map) map3.get("personalInfo");
		String certId1 = map4.get("idCardNum").toString();
		String name1 = map4.get("realName").toString();
		String mobile1 = map4.get("mobile").toString();
		String sourceOrderId1 = getrequestNum();
		String sourceChannelOrderId1 = getrequestNum();
		System.out.println("远望授信requestdata:" + js1);
		// String json1 = properties.getProperty("json1");
		String urll2 = ywurl + "&certId="+certId + "&name="+name + "&mobile="+mobile + "&sourceOrderId="+sourceOrderId + "&sourceChannelOrderId="+sourceChannelOrderId ;
		String post3 = post1(urll2, js1);
		Map mappost1 = returnmap(post3);
//		Map responseData = returnmap(mappost.get("responseData").toString());
//		String errorCode = responseData.get("errorCode").toString();
		// assertEquals(errorCode, "0000");
		System.out.println("远望授信请求结果@@@@@@@" + post3);
		
		String js2 = ywjsonsrj;
		Map map5 = returnmap(js2);
		Map map6= (Map) map5.get("personalInfo");
		String certId2 = map6.get("idCardNum").toString();
		String name2 = map6.get("realName").toString();
		String mobile2 = map6.get("mobile").toString();
		String sourceOrderId2 = getrequestNum();
		String sourceChannelOrderId2 = getrequestNum();
		System.out.println("远望授信requestdata:" + js2);
		// String json1 = properties.getProperty("json1");
		String urll3 = ywurl + "&certId="+certId + "&name="+name + "&mobile="+mobile + "&sourceOrderId="+sourceOrderId + "&sourceChannelOrderId="+sourceChannelOrderId ;
		String post4 = post1(urll3, js2);
		Map mappost2 = returnmap(post4);
//		Map responseData = returnmap(mappost.get("responseData").toString());
//		String errorCode = responseData.get("errorCode").toString();
		// assertEquals(errorCode, "0000");
		System.out.println("远望授信请求结果@@@@@@@" + post4);
		
		String js3 = ywjsonsmj;
		Map map7 = returnmap(js3);
		Map map8= (Map) map7.get("personalInfo");
		String certId3 = map8.get("idCardNum").toString();
		String name3 = map8.get("realName").toString();
		System.out.println("___+++"+name3);
		String mobile3 = map8.get("mobile").toString();
		String sourceOrderId3 = getrequestNum();
		String sourceChannelOrderId3 = getrequestNum();
		System.out.println("远望授信requestdata:" + js3);
		// String json1 = properties.getProperty("json1");
		String urll4 = ywurl + "&certId="+certId + "&name="+name + "&mobile="+mobile + "&sourceOrderId="+sourceOrderId + "&sourceChannelOrderId="+sourceChannelOrderId ;
		String post5 = post1(urll4, js3);
		Map mappost3 = returnmap(post5);
//		Map responseData = returnmap(mappost.get("responseData").toString());
//		String errorCode = responseData.get("errorCode").toString();
		// assertEquals(errorCode, "0000");
		System.out.println("远望授信请求结果@@@@@@@" + post5);
//		returnmap.put("customerId", zc.get("customerId").toString());
//		returnmap.put("realName", realName);
//		returnmap.put("idCardNum", idCardNum);
//		returnmap.put("mobile", zc.get("mobile").toString());
//		returnmap.put("bankNum", bankNum);
//		returnmap.put("errorCode", errorCode);
		return "用户:"+name+"<br>" + "远望授信请求结果"+"<br>" + post2+"<br>" +"用户:"+name1+"<br>" + "远望授信请求结果"+"<br>" + post3+"<br>" +"用户:"+name2+"<br>" + "远望授信请求结果"+"<br>" + post4+"<br>" +"用户:"+name3+"<br>" + "远望授信请求结果"+"<br>" + post5;
	}
	
	
	@RequestMapping("/liubliucheng")
	public String liub() throws IOException, InterruptedException {

		Map<String, String> returnmap = new HashMap<String, String>();
		try {
			Map f4 = f4();
			if (!f4.isEmpty()) {
				String customerId = f4.get("customerId").toString();
				String idCardNum = f4.get("idCardNum").toString();
				String mobile = f4.get("mobile").toString();
				String js = tuisong;
				Map jsmap = returnmap(js);
				jsmap.put("customerId", customerId);
				String json = mapTostring(jsmap);
				System.out.println("推送的json@@@@"+json);
				String [] strings = new String[5];
				strings[0]="API_CREATE_ITEM";
				strings[1]=getrequestNum();
				strings[2]="ROMA";
				strings[3]="20190408152211";
				strings[4]=json;
				
				String post2 = post2(url1, strings);
				System.out.println(post2);
				Map tuisong = returnmap(post2);
				Map res = returnmap(tuisong.get("responseData").toString());
				String itemId = res.get("itemId").toString();
				returnmap.put("customerId", customerId);
				returnmap.put("idCardNum", idCardNum);
				returnmap.put("mobile", mobile);
				returnmap.put("itemId", itemId);
			} else {
				returnmap.put("错误", "授信失败，请重试");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			return e.toString();
		}
		return "发标成功!!"+"<br>" +" 标的itemId: "+ returnmap.get("itemId")+"<br>" +"借款人手机号mobile："+returnmap.get("mobile")+ "<br>"+ "借款人身份证号idCardNum: "+ returnmap.get("idCardNum") +"<br>" +"借款人customerId："+ returnmap.get("customerId");
	}
	@RequestMapping(value="/doSign")
	public String getsign(String requestBodyJson, HttpServletRequest request){
		String requestURI = request.getRequestURI();
		StringBuffer requestURL = request.getRequestURL();
		System.out.println("requestBodyJson:"+requestBodyJson);
		System.out.println("requestURI:"+requestURI);
		System.out.println("requestURL:"+requestURL);
		String doSign = doSign(requestBodyJson);
		System.out.println("簽名doSign:"+doSign);
		return doSign;
		
	}
	
	@RequestMapping("/doEncrypt")
	public String doEncrypt1(String requestBodyJson, HttpServletRequest request){
		String requestURI = request.getRequestURI();
		StringBuffer requestURL = request.getRequestURL();
		System.out.println("requestBodyJson:"+requestBodyJson);
		System.out.println("requestURI:"+requestURI);
		System.out.println("requestURL:"+requestURL);
		String doEncrypt = doEncrypt(requestBodyJson);
		System.out.println("解密doEncrypt:"+doEncrypt);
		return doEncrypt;
		
	}
	
	@RequestMapping("/decreptRes")
	public String doEncryptRes(String requestBodyJson, HttpServletRequest request) throws Exception{
		String requestURI = request.getRequestURI();
		StringBuffer requestURL = request.getRequestURL();
		System.out.println("requestBodyJson:"+requestBodyJson);
		System.out.println("requestURI:"+requestURI);
		System.out.println("requestURL:"+requestURL);
		String doEncrypt = decryptRes(requestBodyJson);
		System.out.println("解密doEncrypt:"+doEncrypt);
		return doEncrypt;
		
	}
	@ResponseBody
	@RequestMapping("/sytSX")
	public Map sytsx(String env, String enterpriseName, String uniformSocialCreditCode) throws Exception{
//		String utf8 = new String(sytsxjson.getBytes("iso-8859-1"), "utf-8");
//		String utf8 = new String(sytsxjson.getBytes("iso-8859-1"), "utf-8");
		String utf8= sytsxjson;
		Map map = returnmap(utf8);
		System.out.println("************"+sytsxurl1);
		System.out.println(map.toString());
		String enterpriseName1 = getName()+"企业";
		String uniformSocialCreditCode1="信用代码"+ getPhonenm();
		String apply=map.get("apply").toString();
		//获取apply信息
		Map applyMap = returnmap(apply);
//		String enterpriseInfo = (String) applyMap.get("enterpriseInfo");
		//获取企业信息
		Map mapEnterpriseInfo = (Map) applyMap.get("enterpriseInfo");
		//存入企业信息
		if(enterpriseName.equals("")){
			mapEnterpriseInfo.put("enterpriseName", enterpriseName1);
		} else {
			mapEnterpriseInfo.put("enterpriseName", enterpriseName);
		}
		if(uniformSocialCreditCode.equals("")){
			mapEnterpriseInfo.put("uniformSocialCreditCode", uniformSocialCreditCode1);
		} else {
			mapEnterpriseInfo.put("uniformSocialCreditCode", uniformSocialCreditCode);
		}

//		String mapEnterpriseInfo1= mapTostring(mapEnterpriseInfo);
		//把企业信息放回apply
		applyMap.put("enterpriseInfo", mapEnterpriseInfo);
//		String allpy =mapTostring(applyMap);
		//applyMap放回map
		map.put("apply", applyMap);
		String json1= mapTostring(map);
		System.out.println(json1);
		log.info("请求参数为："+json1);
		String response=null;
		if (env.equals("test")) {
			response = postsyt(sytsxurl1, json1,env);
		}else if(env.equals("third")){
			response = postsyt(sytsxurl2, json1,env);
		} else {
			response = postsyt(sytsxurl, json1,env);
		}
//		String response = postsyt(sytsxurl, json1,env);
//		System.out.println(response);
//		Map mapRes=returnmap(response);
//		Map mapcontent =returnmap(mapRes.get("content").toString());
//		String creditId = mapcontent.get("creditId").toString();
		//return "授信接口调用成功，返回creditId:"+creditId+"<br>"+"企业名称："+enterpriseName+"<br>"+"统一社会信用代码："+uniformSocialCreditCode+"<br>";
		Map resmap = new HashMap() ;
		resmap.put("data",map);
		resmap.put("response",returnmap(response)) ;
		System.out.println(response);
		log.info("请求返回："+response);
        return resmap;
	}
	
	@RequestMapping("/sytDB")
	public Map sytdb(String creditId, String env) throws Exception{
//		String utf8 = new String(sytdbjson.getBytes("iso-8859-1"), "utf-8");
		String utf8 = sytdbjson;
		Map map = returnmap(utf8);
		System.out.println(map.toString());
//		String enterpriseName = getName()+"企业";
		String guaranteeApplyNum="保函申请编号"+ getPhonenm();
		String sql = "SELECT syt_order_num from credit_order where id="+creditId;
		System.out.println("sql+++++++++++++++"+sql);
//		String sytCreditId = selectSYT_syt_order_num(getConnTetSYT(), sql);
		map.put("creditId", creditId);
		map.put("guaranteeApplyNum", guaranteeApplyNum);
		map.put("sytCreditId", "平台项目编号0001");
		String json1= mapTostring(map);
		System.out.println(json1);
		log.info("请求参数为："+json1);
		String response=null;
		if (env.equals("test")) {
			response = postsyt(sytdburl1, json1,env);
		}else if(env.equals("third")){
			response = postsyt(sytdburl2, json1,env);
		}  else {
			response = postsyt(sytdburl, json1,env);
		}

		Map mapRes=returnmap(response);
//		Map mapcontent =returnmap(mapRes.get("content").toString());
//		String guaranteeId = mapcontent.get("guaranteeId").toString();
//		return "开立接口调用成功，返回guaranteeId:"+guaranteeId;
		Map resmap = new HashMap() ;
		resmap.put("data",map) ;
		resmap.put("response",returnmap(response)) ;
		System.out.println(response);
		log.info("请求返回："+response);
        return resmap;
	}
	@RequestMapping("/sytJF")
	public Map sytjf(String guaranteeId, String env) throws Exception{
//		String utf8 = new String(sytscjfpzjson.getBytes("iso-8859-1"), "utf-8");
		String utf8=sytscjfpzjson;
		Map map = returnmap(utf8);
		System.out.println(map.toString());
//		String enterpriseName = getName()+"企业";
		String paidNum="paidNum"+ getPhonenm();
//		String sql = "SELECT syt_order_num from credit_order where id="+creditId;
//		System.out.println("sql+++++++++++++++"+sql);
//		String sytCreditId = selectSYT_syt_order_num(getConnTetSYT(), sql);
		map.put("paidNum", paidNum);
		map.put("guaranteeId", guaranteeId);
//		map.put("sytCreditId", guaranteeId);
		String json1= mapTostring(map);
		System.out.println(json1);
		log.info("请求参数为："+json1);
		String response=null;
		if (env.equals("test")) {
			response = postsyt(sytscjfpzurl1, json1,env);
		} else if(env.equals("third")){
			response = postsyt(sytscjfpzurl2, json1,env);
		}  else {
			response = postsyt(sytscjfpzurl, json1,env);
		}
		

//		Map mapRes=returnmap(response);
//		Map mapcontent =returnmap(mapRes.get("content").toString());
//		String resultCode = mapRes.get("resultCode").toString();
//		String errMsg=mapRes.get("errMsg").toString();
        Map resmap = new HashMap();
        resmap.put("data",map);
        resmap.put("response",returnmap(response));
		System.out.println(response);
		log.info("请求返回："+response);
        return resmap;
	}
	
	@RequestMapping("/sytFKHD")
	public Map sytfkhd(String creditId, String env) throws Exception{
//		String utf8 = new String(sytsfkhdjson.getBytes("iso-8859-1"), "utf-8");
		String utf8 = sytsfkhdjson;
		Map map = returnmap(utf8);
		System.out.println(map.toString());
//		String enterpriseName = getName()+"企业";
//		String paidNum="paidNum"+ getPhonenm();
//		String sql = "SELECT syt_order_num from credit_order where id="+creditId;
//		System.out.println("sql+++++++++++++++"+sql);
//		String sytCreditId = selectSYT_syt_order_num(getConnTetSYT(), sql);
		map.put("creditId", creditId);
//		map.put("guaranteeId", guaranteeId);
//		map.put("sytCreditId", guaranteeId);
		String json1= mapTostring(map);
		System.out.println(json1);
		log.info("请求参数为："+json1);
		String response=null;
		if (env.equals("test")) {
			response = postsyt(sytsfkhdurl1, json1,env);
		} else if(env.equals("third")){
			response = postsyt(sytsfkhdurl2, json1,env);
		} else {
			response = postsyt(sytsfkhdurl, json1,env);
		}

		Map mapRes=returnmap(response);
//		Map mapcontent =returnmap(mapRes.get("content").toString());
		String resultCode = mapRes.get("resultCode").toString();
		Map resmap = new HashMap();
		resmap.put("data",map);
		resmap.put("response",returnmap(response));
		System.out.println(response);
		log.info("请求返回："+response);
		return resmap;
	}
	//通关保预警添加
	@RequestMapping("/sytYJTJ")
	public Map sytyjtj(String creditId, String env, String touchWarningDate) throws Exception{
		String utf8 = sytyjjson;
//		new String(sytyjjson.getBytes("iso-8859-1"), "utf-8");
		Map map = returnmap(utf8);
		System.out.println(map.toString());
//		String enterpriseName = getName()+"企业";
//		String paidNum="paidNum"+ getPhonenm();
//		String sql = "SELECT syt_order_num from credit_order where id="+creditId;
//		System.out.println("sql+++++++++++++++"+sql);
//		String sytCreditId = selectSYT_syt_order_num(getConnTetSYT(), sql);
		List list = (List) map.get("warnings");
		String sytOrderNum = "税银通订单编号"+getPhonenm();
		String sytWarningNo = "税银通预警编号"+getPhonenm();
		Map map2 =returnmap(list.get(0).toString());
		map2.put("orderId", creditId);
		map2.put("sytOrderNum", sytOrderNum);
		map2.put("sytWarningNo", sytWarningNo);
		map2.put("touchWarningDate", touchWarningDate);
		
		list.set(0, map2);
		map.put("warnings", list);
//		map.put("guaranteeId", guaranteeId);
//		map.put("sytCreditId", guaranteeId);
		String json1= mapTostring(map);
		System.out.println(json1);
		log.info("请求参数为："+json1);
		String response=null;
		if (env.equals("test")) {
			response = postsyt(sytyjurl1, json1,env);
		}else if(env.equals("third")){
			response = postsyt(sytyjurl2, json1,env);
		}else {
			response = postsyt(sytyjurl, json1,env);
		}

		Map mapRes=returnmap(response);
//		Map mapcontent =returnmap(mapRes.get("content").toString());
/*		String resultCode = mapRes.get("resultCode").toString();
//
		if("2000".equals(resultCode)){
//		return "开立接口调用成功，返回guaranteeId:"+guaranteeId;
		return "发送成功"+"</br>"+response.toString();
		}else{
			String errMsg=mapRes.get("errMsg").toString();
			return "发送失败,错误原因："+errMsg;
		}*/
        Map resmap = new HashMap();
        resmap.put("data",map);
        resmap.put("response",returnmap(response));
		System.out.println(response);
        log.info("请求返回："+response);
        return resmap;
	}
	//内签
	@RequestMapping("/qzptXXJ")
	public Map qzptXXJ(String env, String contractHandleCode, String contractConfigCode, String sourceCode, String isnew) throws Exception{
		String utf8=null;
		String content = null;
		if (isnew.equals("y")) {
			utf8 =qzpt_xxj_json;
			InputStream is = this.getClass().getClassLoader().getResourceAsStream("合同模板长.docx");
			content =  FileToBase64.encodeBase64File1(is);

		} else {
			utf8 = qzpt_xxj_json;
			InputStream is = this.getClass().getClassLoader().getResourceAsStream("test2.docx");
			content =  FileToBase64.encodeBase64File1(is);

			System.out.println("***********"+content);
		}
		String sourceOrderId = getPhonenm();
		Map map = returnmap(utf8);
		System.out.println(map.toString());
		map.put("content", content);
		map.put("contractHandleCode", contractHandleCode);
		map.put("contractConfigCode", contractConfigCode);
		map.put("sourceOrderId", sourceOrderId);
		map.put("sourceCode", sourceCode);
		String json1= mapTostring(map);
		System.out.println(json1);
		log.info("请求参数为："+json1);
		String response=null;
		if (env.equals("test")) {
			response = postqz(qzpt_xxj_url, json1,env);
		}else if (env.equals("third")) {
			response = postqz(qzpt_xxj_url2, json1,env);
		}else {
			response = postqz(qzpt_xxj_url1, json1,env);
		}
		System.out.println(response);
//		Map mapRes=returnmap(response);
//		Map mapcontent =returnmap(mapRes.get("content").toString());
//		String resultCode = mapRes.get("resultCode").toString();
//		Map mapcontent =returnmap(mapRes.get("content").toString());
//		String guaranteeId = mapcontent.get("orderId").toString();
		Map resmap = new HashMap();
		resmap.put("data",map);
		resmap.put("response",returnmap(response));
		System.out.println(response);
		log.info("请求返回："+response);
        return resmap;
//		if("2000".equals(resultCode)){
////		return "开立接口调用成功，返回guaranteeId:"+guaranteeId;
//		return "发送成功";
//		}else{
//			String errMsg=mapRes.get("errMsg").toString();
//			return "发送失败,错误原因："+errMsg;
//		}
	}
	//企业外签
	@RequestMapping("/qzptXXJQY")
	public Map qzptXXJqy(String env, String uscEnterpriseNum, String isnew, String sourceCode, String contractConfigCode, String contractHandleCode) throws Exception{
		String utf8=null;
		if (isnew.equals("y")) {
			utf8 = qzpt_xxj_qy_json1;
		} else {
			utf8 =qzpt_xxj_qy_json;
		}
		String sourceOrderId = getPhonenm();
		Map map = returnmap(utf8);
		System.out.println(map.toString());

//		map.put("contractHandleCode", contractHandleCode);
//		map.put("contractConfigCode", contractConfigCode);
		map.put("sourceOrderId", sourceOrderId);
		map.put("sourceCode", sourceCode);
		map.put("contractConfigCode", contractConfigCode);
		map.put("contractHandleCode", contractHandleCode);
		map.put("uscEnterpriseNum", uscEnterpriseNum);
		String json1= mapTostring(map);
		System.out.println(json1);
		log.info("请求参数为："+json1);
		String response=null;
		if (env.equals("test")) {
			System.out.println("##############################"+qzpt_xxj_qy_url1);
			response = postqz(qzpt_xxj_qy_url1, json1,env);
		}
		else if (env.equals("qa")) {
			response = postqz(qzpt_xxj_qy_url2, json1,env);
		}else {
			response = postqz(qzpt_xxj_qy_url, json1,env);
		}
		Map resmap = new HashMap();
		resmap.put("data",map);
		resmap.put("response",returnmap(response));
		System.out.println(response);
		Map mapRes=returnmap(response);
//		Map mapcontent =returnmap(mapRes.get("content").toString());
//		String resultCode = mapRes.get("resultCode").toString();
//		Map mapcontent =returnmap(mapRes.get("content").toString());
//		String guaranteeId = mapcontent.get("orderId").toString();
		log.info("请求返回："+response);
        return resmap;
//		if("2000".equals(resultCode)){
////		return "开立接口调用成功，返回guaranteeId:"+guaranteeId;
//		return "发送成功";
//		}else{
//			String errMsg=mapRes.get("errMsg").toString();
//			return "发送失败,错误原因："+errMsg;
//		}
	}
	//企业认证
	@ResponseBody
	@RequestMapping("/qzptXXJQYRZ")
	public Map qzptXXJqyrz(String env, String businessCode, String sourceCode, String uscEnterpriseNum) throws Exception{
		String utf8 = qzpt_xxj_qyrz_json1;
		String enterpriseName = getName();
		String sourceOrderId = getPhonenm();
		Map map = returnmap(utf8);
		Map enterpriseInfo = returnmap(map.get("enterpriseInfo").toString());
		if (uscEnterpriseNum.equals("")) {
			String uscEnterpriseNum1= getPhonenm();
			enterpriseInfo.put("uscEnterpriseNum", uscEnterpriseNum1);
		}else{
			enterpriseInfo.put("uscEnterpriseNum", uscEnterpriseNum);
		}
		enterpriseInfo.put("enterpriseName", enterpriseName);
		map.put("businessCode", businessCode);
		map.put("sourceCode", sourceCode);
		map.put("sourceOrderId", sourceOrderId);
		map.put("enterpriseInfo", enterpriseInfo);
		String json1= mapTostring(map);
		System.out.println(json1);
		log.info("请求参数为："+json1);
		String response=null;
		if (env.equals("test")) {
			response = postqz(qzpt_xxj_qyrz_url, json1,env);
		}else if (env.equals("third")) {
			response = postqz(qzpt_xxj_qyrz_url2, json1,env);
		} 
		else {
			response = postqz(qzpt_xxj_qyrz_url1, json1,env);
		}
		Map resmap = new HashMap();
		resmap.put("data",map);
		resmap.put("response",returnmap(response));
		System.out.println(response);
//		Map mapRes=returnmap(response);
//		Map mapcontent =returnmap(mapRes.get("content").toString());
//		String resultCode = mapRes.get("resultCode").toString();
//		Map mapcontent =returnmap(mapRes.get("content").toString());
//		String guaranteeId = mapcontent.get("orderId").toString();
		log.info("请求返回："+response);
        return resmap;
//		if("2000".equals(resultCode)){
////		return "开立接口调用成功，返回guaranteeId:"+guaranteeId;
//		return "发送成功";
//		}else{
//			String errMsg=mapRes.get("errMsg").toString();
//			return "发送失败,错误原因："+errMsg;
//		}
	}
	//企业外签合同下载
	@RequestMapping("/qzptXXJQYHTCX")
	public Map qzptXXJQYHTCX(String env, String contractCode) throws Exception{
		String utf8 = proper.getProperty("qzptqyhtcxjson", "utf-8");
		String qzptqyhtcxurl = proper.getProperty("qzptqyhtcxurl", "utf-8");
		String qzptqyhtcxurl1 = proper.getProperty("qzptqyhtcxurl1", "utf-8");
		String qzptqyhtcxurl2 = proper.getProperty("qzptqyhtcxurl2", "utf-8");

		Map map = returnmap(utf8);

		map.put("contractCode", contractCode);
		String json1= mapTostring(map);
		System.out.println(json1);
		log.info("请求参数为："+json1);
		String response=null;
		if (env.equals("test")) {
			log.info("请求地址："+qzptqyhtcxurl);
			response = postqz(qzptqyhtcxurl, json1,env);
		}else if (env.equals("qa")) {
			response = postqz(qzptqyhtcxurl1, json1,env);
		}
		else {
			response = postqz(qzptqyhtcxurl2, json1,env);
		}
		Map resmap = new HashMap();
		resmap.put("data",map);
		resmap.put("response",returnmap(response));
		System.out.println(response);
//		Map mapRes=returnmap(response);
//		Map mapcontent =returnmap(mapRes.get("content").toString());
//		String resultCode = mapRes.get("resultCode").toString();
//		Map mapcontent =returnmap(mapRes.get("content").toString());
//		String guaranteeId = mapcontent.get("orderId").toString();
		log.info("请求返回："+response);
        return resmap;
//		if("2000".equals(resultCode)){
////		return "开立接口调用成功，返回guaranteeId:"+guaranteeId;
//		return "发送成功";
//		}else{
//			String errMsg=mapRes.get("errMsg").toString();
//			return "发送失败,错误原因："+errMsg;
//		}
	}
	
	@RequestMapping("/qzptXXJWJXZ")
	public String qzptXXJwjxz(String env,String contractCode) throws Exception{
		String utf8 = qzpt_xxj_wjxz_json;
		Map map = returnmap(utf8);
		map.put("contractCode", contractCode);
		String json1= mapTostring(map);
		System.out.println(json1);
		log.info("请求参数为："+json1);
		String response=null;
		if (env.equals("test")) {
			response = postqz(qzpt_xxj_wjxz_url1, json1,env);
		}else if (env.equals("third")) {
			response = postqz(qzpt_xxj_wjxz_url2, json1,env);
		} 
		else {
			response = postqz(qzpt_xxj_wjxz_url, json1,env);
		}
		System.out.println(response);
//		Map mapRes=returnmap(response);
//		Map mapcontent =returnmap(mapRes.get("content").toString());
//		String resultCode = mapRes.get("resultCode").toString();
//		Map mapcontent =returnmap(mapRes.get("content").toString());
//		String guaranteeId = mapcontent.get("orderId").toString();
		log.info("请求返回："+response);
        return response.toString();
//		if("2000".equals(resultCode)){
////		return "开立接口调用成功，返回guaranteeId:"+guaranteeId;
//		return "发送成功";
//		}else{
//			String errMsg=mapRes.get("errMsg").toString();
//			return "发送失败,错误原因："+errMsg;
//		}
	}
	//三方平台调用一只产品
	@RequestMapping("/sfptDmyDyOne")
	public Map sfptDyOne(String env) throws Exception{
		String utf8 = sfpt_dy_json1;
		Map map = returnmap(utf8);
		String json1= mapTostring(map);
		System.out.println(json1);
		log.info("请求参数为："+json1);
		String response=null;
		if (env.equals("test")) {
			response = postsf(sfpt_dy_url, json1,env);
		}else if (env.equals("dev")) {
			response = postsf(sfpt_dy_url1, json1,env);
		} 
		else {
			response = postsf(sfpt_dy_url1, json1,env);
		}
		System.out.println(response);
        log.info("请求返回："+response);
		Map resmap = new HashMap();
		resmap.put("data",map);
		resmap.put("response",returnmap(response));
		return resmap;

	}
	//三方平台同时调用两只产品
	@RequestMapping("/sfptDmyDyTwo")
	public Map sfptDyTwo(String env) throws Exception{
		String utf8 = sfpt_dy_json2;
		Map map = returnmap(utf8);
		String json1= mapTostring(map);
		System.out.println(json1);
		log.info("请求参数为："+json1);
		String response=null;
		if (env.equals("test")) {
			response = postsf(sfpt_dy_url, json1,env);
		}else if (env.equals("third")) {
			response = postsf(sfpt_dy_url1, json1,env);
		} 
		else {
			response = postsf(sfpt_dy_url1, json1,env);
		}
		System.out.println(response);
        log.info("请求返回："+response);
		Map resmap = new HashMap();
		resmap.put("data",map);
		resmap.put("response",returnmap(response));
		return resmap;

	}
	//三方平台同时调用3只产品
	@RequestMapping("/sfptDmyDyThree")
	public Map sfptDyThree(String env) throws Exception{
		String utf8 = sfpt_dy_json3;
		Map map = returnmap(utf8);
		String json1= mapTostring(map);
		System.out.println(json1);
		log.info("请求参数为："+json1);
		String response=null;
		if (env.equals("test")) {
			response = postsf(sfpt_dy_url, json1,env);
		}else if (env.equals("third")) {
			response = postsf(sfpt_dy_url1, json1,env);
		} 
		else {
			response = postsf(sfpt_dy_url1, json1,env);
		}
		System.out.println(response);
        log.info("请求返回："+response);
		Map resmap = new HashMap();
		resmap.put("data",map);
		resmap.put("response",returnmap(response));
		return resmap;

	}
	//首佳904
	@RequestMapping("/sfptSjDyYb")
	public Map sfptSjDyYb(String env, String packageId) throws Exception{
		String utf8 = proper.getProperty("sjjson904","UTF-8");
//				new String(sfpt_dy_json3.getBytes("iso-8859-1"), "utf-8");
		String sjyburl =  proper.getProperty("sjyburl","UTF-8");
		String sjyburl1 =  proper.getProperty("sjyburl1","UTF-8");
		String sjyburl2 =  proper.getProperty("sjyburl2","UTF-8");
		Map map = returnmap(utf8);
		String sourceOrderId = getPhonenm();
		List list = (List) map.get("thirdPackageList");
		Map thirdPackageList = returnmap(list.get(0).toString());
		thirdPackageList.put("packageId", packageId);
		Map paramMap = returnmap(thirdPackageList.get("paramMap").toString());

		thirdPackageList.put("paramMap", paramMap);
		list.set(0, thirdPackageList);
		map.put("thirdPackageList", list);
		map.put("sourceOrderId", sourceOrderId);
		String json1= mapTostring(map);
		System.out.println(json1);
		log.info("请求参数为："+json1);
		String response=null;
		if (env.equals("test")) {
			response = postyb(env,sjyburl, json1);
		}else if (env.equals("third")) {
			response = postyb(env,sjyburl1, json1);
		}
		else {
			response = postyb(env,sjyburl2, json1);
		}
		System.out.println(response);
		log.info("请求返回："+response);
		Map resmap = new HashMap();
		resmap.put("data",map);
		resmap.put("response",returnmap(response));
		return resmap;

	}
    //首佳904
    @RequestMapping("/sfptSjDy902")
    public Map sfptSjDy902(String env, String packageId) throws Exception{
        String utf8 = proper.getProperty("sjjson902","UTF-8");
//				new String(sfpt_dy_json3.getBytes("iso-8859-1"), "utf-8");
        String sjyburl =  proper.getProperty("sjyburl","UTF-8");
        String sjyburl1 =  proper.getProperty("sjyburl1","UTF-8");
        String sjyburl2 =  proper.getProperty("sjyburl2","UTF-8");
        Map map = returnmap(utf8);
        String sourceOrderId = getPhonenm();
        List list = (List) map.get("thirdPackageList");
        Map thirdPackageList = returnmap(list.get(0).toString());
        thirdPackageList.put("packageId", packageId);
        Map paramMap = returnmap(thirdPackageList.get("paramMap").toString());

        thirdPackageList.put("paramMap", paramMap);
        list.set(0, thirdPackageList);
        map.put("thirdPackageList", list);
        map.put("sourceOrderId", sourceOrderId);
        String json1= mapTostring(map);
        System.out.println(json1);
        log.info("请求参数为："+json1);
        String response=null;
        if (env.equals("test")) {
            response = postyb(env,sjyburl, json1);
        }else if (env.equals("third")) {
            response = postyb(env,sjyburl1, json1);
        }
        else {
            response = postyb(env,sjyburl2, json1);
        }
        System.out.println(response);
        log.info("请求返回："+response);
		Map resmap = new HashMap();
		resmap.put("data",map);
		resmap.put("response",returnmap(response));
		return resmap;

    }
	//企查查产品调用
	@RequestMapping("/sfptQccDy")
	public Map sfptQccDy(String env, String packageId, String searchKey, String detailId) throws Exception{
		String utf8 = proper.getProperty("qccjson","UTF-8");
//				new String(sfpt_dy_json3.getBytes("iso-8859-1"), "utf-8");
		Map map = returnmap(utf8);
		String sourceOrderId = getPhonenm();
		List list = (List) map.get("thirdPackageList");
		Map thirdPackageList = returnmap(list.get(0).toString());
		thirdPackageList.put("packageId", packageId);
		Map paramMap = returnmap(thirdPackageList.get("paramMap").toString());
		paramMap.put("searchKey", searchKey);
		paramMap.put("detailId", detailId);
		thirdPackageList.put("paramMap", paramMap);
		list.set(0, thirdPackageList);
		map.put("thirdPackageList", list);
		map.put("sourceOrderId", sourceOrderId);
		String json1= mapTostring(map);
		System.out.println(json1);
		String response=null;
		if (env.equals("test")) {
			response = postsf(sfpt_dy_url, json1,env);
		}else if (env.equals("third")) {
			response = postsf(sfpt_dy_url1, json1,env);
		} 
		else {
			response = postsf(sfpt_dy_url1, json1,env);
		}
		Map resmap = new HashMap();
		resmap.put("data",map);
		resmap.put("response",returnmap(response));
		System.out.println(response);

		return resmap;

	}
	//汇法产品调用个人
	@RequestMapping("/sfptHfDyPerson")
	public Map sfptHfDyPerson(String env, String packageId, String realNameOrCompanyName, String idCardOrCompanyCode) throws Exception{
		String utf8 = proper.getProperty("hfjsonperson","UTF-8");
//				new String(sfpt_dy_json3.getBytes("iso-8859-1"), "utf-8");
		Map map = returnmap(utf8);
		String sourceOrderId = getPhonenm();
		map.put("sourceOrderId", sourceOrderId);
		if(!realNameOrCompanyName.equals("")&&!idCardOrCompanyCode.equals("")){
		List list = (List) map.get("thirdPackageList");
		Map thirdPackageList = returnmap(list.get(0).toString());
		thirdPackageList.put("packageId", packageId);
		Map paramMap = returnmap(thirdPackageList.get("paramMap").toString());
		paramMap.put("realNameOrCompanyName", realNameOrCompanyName);
		paramMap.put("idCardOrCompanyCode", idCardOrCompanyCode);
		thirdPackageList.put("paramMap", paramMap);
		list.set(0, thirdPackageList);
		map.put("thirdPackageList", list);
		}
		String json1= mapTostring(map);
		System.out.println(json1);
		log.info("请求参数为："+json1);
		String response=null;
		if (env.equals("test")) {
			response = postsf(sfpt_dy_url, json1,env);
		}else if (env.equals("third")) {
			response = postsf(sfpt_dy_url1, json1,env);
		} 
		else {
			response = postsf(sfpt_dy_url1, json1,env);
		}
		Map resmap = new HashMap();
		resmap.put("data",map);
		resmap.put("response",returnmap(response));
		System.out.println(response);
        log.info("请求返回："+response);
		return resmap;

	}
    //异步结果查询
    @RequestMapping("/sfptYbCx")
    public Map sfptHfDyPerson(String env, String orderId) throws Exception{
        String utf8 = proper.getProperty("sfybcxjson","UTF-8");
        String url= proper.getProperty("sfybcxurl","UTF-8");
        String url1= proper.getProperty("sfybcxurl1","UTF-8");
        String url2= proper.getProperty("sfybcxurl2","UTF-8");

//				new String(sfpt_dy_json3.getBytes("iso-8859-1"), "utf-8");
        Map map = returnmap(utf8);

        map.put("orderId", orderId);

        String json1= mapTostring(map);
        System.out.println(json1);
        log.info("请求参数为："+json1);
        String response=null;
        if (env.equals("test")) {
            response = postsf(url, json1,env);
        }else if (env.equals("third")) {
            response = postsf(url1, json1,env);
        }
        else {
            response = postsf(url2, json1,env);
        }
        System.out.println(response);
        log.info("请求返回："+response);
        Map resmap = new HashMap();
        resmap.put("data",map);
        resmap.put("response",returnmap(response));
        return resmap;

    }
	//汇法产品统计查询调用个人或企业
	@RequestMapping("/sfptHfDyDouble")
	public Map sfptHfDyDouble(String env, String packageId, String stype, String realNameOrCompanyName, String idCardOrCompanyCode) throws Exception{
		String utf8 = proper.getProperty("hfdouble","UTF-8");
//				new String(sfpt_dy_json3.getBytes("iso-8859-1"), "utf-8");
		Map map = returnmap(utf8);
		String sourceOrderId = getPhonenm();
		map.put("sourceOrderId", sourceOrderId);
		if(!realNameOrCompanyName.equals("")&&!idCardOrCompanyCode.equals("")){
			List list = (List) map.get("thirdPackageList");
			Map thirdPackageList = returnmap(list.get(0).toString());
			thirdPackageList.put("packageId", packageId);
			Map paramMap = returnmap(thirdPackageList.get("paramMap").toString());
			paramMap.put("realNameOrCompanyName", realNameOrCompanyName);
			paramMap.put("stype", stype);
			paramMap.put("idCardOrCompanyCode", idCardOrCompanyCode);
			thirdPackageList.put("paramMap", paramMap);
			list.set(0, thirdPackageList);
			map.put("thirdPackageList", list);
		}
		String json1= mapTostring(map);
		System.out.println(json1);
		log.info("请求参数为："+json1);
		String response=null;
		if (env.equals("test")) {
			response = postsf(sfpt_dy_url, json1,env);
		}else if (env.equals("third")) {
			response = postsf(sfpt_dy_url1, json1,env);
		}
		else {
			response = postsf(sfpt_dy_url1, json1,env);
		}
		Map resmap = new HashMap();
		resmap.put("data",map);
		resmap.put("response",returnmap(response));
		System.out.println(response);
		log.info("请求返回："+response);
		return resmap;

	}
	//汇法产品调用公司
	@RequestMapping("/sfptHfDyCompany")
	public Map sfptHfDyCompany(String env, String packageId, String realNameOrCompanyName, String idCardOrCompanyCode) throws Exception{
		String utf8 = proper.getProperty("hfjsoncompany","UTF-8");
//				new String(sfpt_dy_json3.getBytes("iso-8859-1"), "utf-8");
		Map map = returnmap(utf8);
		String sourceOrderId = getPhonenm();
		map.put("sourceOrderId", sourceOrderId);
		if(!realNameOrCompanyName.equals("")&&!idCardOrCompanyCode.equals("")){
		List list = (List) map.get("thirdPackageList");
		Map thirdPackageList = returnmap(list.get(0).toString());
		thirdPackageList.put("packageId", packageId);
		Map paramMap = returnmap(thirdPackageList.get("paramMap").toString());
		paramMap.put("realNameOrCompanyName", realNameOrCompanyName);
		paramMap.put("idCardOrCompanyCode", idCardOrCompanyCode);
		thirdPackageList.put("paramMap", paramMap);
		list.set(0, thirdPackageList);
		map.put("thirdPackageList", list);
		}
		String json1= mapTostring(map);
		System.out.println(json1);
		log.info("请求参数为："+json1);
		String response=null;
		if (env.equals("test")) {
			response = postsf(sfpt_dy_url, json1,env);
		}else if (env.equals("third")) {
			response = postsf(sfpt_dy_url1, json1,env);
		} 
		else {
			response = postsf(sfpt_dy_url1, json1,env);
		}
		Map resmap = new HashMap();
		resmap.put("data",map);
		resmap.put("response",returnmap(response));
		System.out.println(response);
        log.info("请求返回："+response);
		return resmap;

	}
	//首佳产品调用901
	@RequestMapping("/sfptSjDy")
	public Map sfptSjDy(String env, String packageId) throws Exception{
		String utf8 = proper.getProperty("sjjson","UTF-8");
//				new String(sfpt_dy_json3.getBytes("iso-8859-1"), "utf-8");
		Map map = returnmap(utf8);
		String sourceOrderId = getPhonenm();
		List list = (List) map.get("thirdPackageList");
		Map thirdPackageList = returnmap(list.get(0).toString());
		thirdPackageList.put("packageId", packageId);
		Map paramMap = returnmap(thirdPackageList.get("paramMap").toString());
		
		thirdPackageList.put("paramMap", paramMap);
		list.set(0, thirdPackageList);
		map.put("thirdPackageList", list);
		map.put("sourceOrderId", sourceOrderId);
		String json1= mapTostring(map);
		System.out.println(json1);
		log.info("请求参数为："+json1);
		String response=null;
		if (env.equals("test")) {
			response = postsf(sfpt_dy_url, json1,env);
		}else if (env.equals("third")) {
			response = postsf(sfpt_dy_url1, json1,env);
		} 
		else {
			response = postsf(sfpt_dy_url1, json1,env);
		}
		Map resmap = new HashMap();
		resmap.put("data",map);
		resmap.put("response",returnmap(response));
		System.out.println(response);
        log.info("请求返回："+response);
		return resmap;

	}
	//三要素验证
	@RequestMapping("/sfptThreeInfoDy")
	public Map sfptThreeInfoDy(String env, String realName, String idCard, String mobile) throws Exception{
		String utf8 = proper.getProperty("threejson","UTF-8");
//				new String(sfpt_dy_json3.getBytes("iso-8859-1"), "utf-8");
		Map map = returnmap(utf8);
		String sourceOrderId = getPhonenm();
		List list = (List) map.get("thirdPackageList");
		Map thirdPackageList = returnmap(list.get(0).toString());
//		thirdPackageList.put("packageId", packageId);
		Map paramMap = returnmap(thirdPackageList.get("paramMap").toString());
		paramMap.put("realName",realName);
		paramMap.put("idCard",idCard);
		paramMap.put("mobile",mobile);
		thirdPackageList.put("paramMap", paramMap);
		list.set(0, thirdPackageList);
		map.put("thirdPackageList", list);
		map.put("sourceOrderId", sourceOrderId);
		String json1= mapTostring(map);
		System.out.println(json1);
		log.info("请求参数为：" +json1);
		String response=null;
		if (env.equals("test")) {
			response = postsf(sfpt_dy_url, json1,env);
		}else if (env.equals("third")) {
			response = postsf(sfpt_dy_url1, json1,env);
		} 
		else {
			response = postsf(sfpt_dy_url1, json1,env);
		}
		Map resmap = new HashMap();
		resmap.put("data",map);
		resmap.put("response",returnmap(response));
		System.out.println(response);
        log.info("请求返回："+response);
		return resmap;
	}
	//信宜家个人认证
	@RequestMapping("/xyjNewRz")
	public Map xyjNewRz(String env, String idCardNum, String phone, String realName, String businessCode) throws Exception{
		String utf8 = proper.getProperty("qzptrzsqjson","UTF-8");
		String url = proper.getProperty("qzpturl","UTF-8");
		String url1 = proper.getProperty("qzpturl","UTF-8");
		String url2 = proper.getProperty("qzpturl2","UTF-8");
//				new String(sfpt_dy_json3.getBytes("iso-8859-1"), "utf-8");
		Map map = returnmap(utf8);
		String sourceOrderId = getPhonenm();
		String aa = idCardNum;
		if(idCardNum.length()>10){

		 Map personInfo = returnmap(map.get("personInfo").toString());
		 personInfo.put("idCardNum", idCardNum);
		 personInfo.put("phone", phone);
		 personInfo.put("realName", realName);
		 map.put("personInfo", personInfo);

		 }
		System.out.println(url);
		map.put("sourceOrderId", sourceOrderId);
		map.put("businessCode", businessCode);
		String json1= mapTostring(map);
		System.out.println("*********"+json1);
		log.info("请求参数为："+json1);
		String response=null;
		if (env.equals("test")) {
			response = postxxjqz(url, json1,env);
		}else if (env.equals("qa")) {
			response = postxxjqz(url1, json1,env);
		}
		else {
			response = postxxjqz(url2, json1,env);
		}
		Map resmap = new HashMap();
		resmap.put("data",map);
		resmap.put("response",returnmap(response));
		System.out.println(response);
        log.info("请求返回："+response);
		return resmap;
	}
	//信宜家个人认证查询
	@RequestMapping("/xyjGRRZCX")
	public Map xyjNewRz(String env, String certifiedNum) throws Exception{
		String utf8 = proper.getProperty("qzptgrcxjson","UTF-8");
		String url = proper.getProperty("qzptgrcxurl","UTF-8");
		String url1 = proper.getProperty("qzptgrcxurl1","UTF-8");
		String url2 = proper.getProperty("qzptgrcxurl2","UTF-8");
		Map map = returnmap(utf8);
		String sourceOrderId = getPhonenm();
		System.out.println(url);
//		map.put("sourceOrderId", "15064009220");
		map.put("certifiedNum", certifiedNum);
		String json1= mapTostring(map);
		System.out.println("*********"+json1);
		log.info("请求参数为："+json1);
		String response=null;
		if (env.equals("test")) {
			response = postxxjqz(url, json1,env);
		}else if (env.equals("qa")) {
			response = postxxjqz(url1, json1,env);
		}
		else {
			response = postxxjqz(url2, json1,env);
		}
		Map resmap = new HashMap();
		resmap.put("data",map);
		resmap.put("response",returnmap(response));
		System.out.println(response);
        log.info("请求返回："+response);
		return resmap;
	}
	//信宜家个人合同查询
	@RequestMapping("/xyjGRHTCX")
	public Map xyjGRHTCX(String env, String orderId) throws Exception{
		String utf8 = proper.getProperty("qzptgrhtcxjson","UTF-8");
		String url = proper.getProperty("qzptgrhtcxurl","UTF-8");
		String url1 = proper.getProperty("qqzptgrhtcxurl1","UTF-8");
		String url2 = proper.getProperty("qzptgrhtcxurl2","UTF-8");
		Map map = returnmap(utf8);
//		String sourceOrderId = getPhonenm();

//		map.put("sourceOrderId", "15064009220");
		map.put("orderId", orderId);
		String json1= mapTostring(map);
//		System.out.println("*********"+json1);
		log.info("请求参数"+json1);
		String response=null;

		if (env.equals("test")) {
			response = postxxjqz(url, json1,env);
		}else if (env.equals("qa")) {
			response = postxxjqz(url1, json1,env);
		}
		else {
			response = postxxjqz(url2, json1,env);
		}
		Map resmap = new HashMap();
		resmap.put("data",map);
		resmap.put("response",returnmap(response));
		System.out.println(response);
		log.info("请求返回值："+response);

		return resmap;
	}
	//信宜家合同验证签章同步返回
	@RequestMapping("/xyjNewContract")
	public Map xyjNewContract(String env, String certifiedNum, String contractConfigCode) throws Exception{
		String utf8 = proper.getProperty("qzpthtyzjson","UTF-8");
		String url = proper.getProperty("qzpthtyzurl","UTF-8");
		String url1 = proper.getProperty("qzpthtyzurl1","UTF-8");
		String url2 = proper.getProperty("qzpthtyzurl2","UTF-8");
//		System.out.println(url);
//				new String(sfpt_dy_json3.getBytes("iso-8859-1"), "utf-8");
		Map map = returnmap(utf8);

		InputStream is = this.getClass().getClassLoader().getResourceAsStream("个人无限连带责任反担保.pdf");
		String content =  FileToBase64.encodeBase64File1(is);
		String sourceOrderId = getPhonenm();
		if(certifiedNum.length()>10){
			List contractDetailList = (List) map.get("contractDetailList");

			Map persionInfo1 = returnmap(contractDetailList.get(0).toString());
			persionInfo1.put("content", content);
			persionInfo1.put("contractConfigCode", contractConfigCode);
			contractDetailList.set(0, persionInfo1);
			map.put("contractDetailList", contractDetailList);

		}

		map.put("sourceOrderId", sourceOrderId);
		map.put("certifiedNum", certifiedNum);
		String json1= mapTostring(map);
		System.out.println(json1);
		log.info("请求参数为："+json1);
		String response=null;
		if (env.equals("test")) {
			response = postxxjqz(url, json1,env);
		}else if (env.equals("dev")) {
			response = postxxjqz(url1, json1,env);
		}
		else {
			response = postxxjqz(url2, json1,env);
		}
		Map resmap = new HashMap();
		resmap.put("data",map);
		resmap.put("response",returnmap(response));
		System.out.println(response);
		log.info("返回值是{}"+response);
		return resmap;
	}
	//清除用户数据重置人员手机号授权
	@RequestMapping("/jbzDeleteInfo")
	public String jbzDeleteInfo(String env, String id) throws Exception{
//		String name1 = AESEncryptTypeHandler.encryptValue(name);
//		String sql  = "select id from running_user_member where real_name="+name1;

		if (env.equals("test")) {
			Connection connection = getConnTet();
//			String id = selectInfo(connection,sql);
			String sqlup = "UPDATE running_user_member r SET r.auth_phone = 0 WHERE r.id="+id;
			updateInfo(connection,sqlup);
			String sqlde = "DELETE FROM biz_running_log WHERE user_id = "+id;
			deleteInfo(connection,sqlde);
		}else if (env.equals("dev")) {
			Connection connection = getConnTet();
//			String id = selectInfo(connection,sql);
		}
		else {
			Connection connection = getConnTet();
//			String id = selectInfo(connection,sql);
		}
		log.info("返回值是{}");
		System.out.println();

		return "{res:操作成功}";
	}


}
