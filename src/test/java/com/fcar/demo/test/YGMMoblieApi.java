package com.fcar.demo.test;
import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.fcar.basics.utils.AnalyticalJson;
import com.fcar.demo.api.GetExcelData;
import com.fcar.demo.api.getCityWeather;
import com.fcar.demo.api.getCityWeatherPost;
import com.fcar.basics.utils.*;
public class YGMMoblieApi {
	getCityWeatherPost post = new getCityWeatherPost();
	String  testurl="http://mpi.demo.cas-tian.com/mpi";
	
	@Test(priority=3)//车主登录
	public void test_login_chezhu() throws ParseException, JSONException{
		String httpresult;
		//拼装data的json
		JSONObject data=new JSONObject(); 
		data.put("username", "hanghang0");
		data.put("password", "123456");
		data.put("userSource", 1);//车主1,默认是0管理员登录
		//拼装map
		Map<String,Object> datapost = new HashMap<String,Object>();
		datapost.put("version", "1.0");
		datapost.put("appCode", "org.yogomo.lw.app");
		datapost.put("api", "mobile.login");
		datapost.put("appType", "1");
		datapost.put("timestamp", Stamp());
		datapost.put("data", data);
		//发送post请求，并接收服务器返回数据
		httpresult = post.SendPost_Map(datapost, testurl)  ;
		String code  =  AnalyticalJson.getJsonValue(httpresult, "code");
		Assert.assertEquals("0", code);
		System.out.println("登录结果："+httpresult);
		System.out.println("登录结果"+"code:"+code);
		
			
		
	}
	//@Test
	public void test_login_admin() throws ParseException, JSONException{
		String httpresult;
		//拼装data的json
		JSONObject data=new JSONObject(); 
		data.put("username", "admin");
		data.put("password", "123456");
		data.put("userSource", 0);//车主1,默认是0管理员登录
		//拼装map
		Map<String,Object> datapost = new HashMap<String,Object>();
		datapost.put("version", "1.0");
		datapost.put("appCode", "org.yogomo.lw.app");
		datapost.put("api", "mobile.login");
		datapost.put("appType", "1");
		datapost.put("timestamp", Stamp());
		datapost.put("data", data);
		//发送post请求，并接收服务器返回数据
		httpresult = post.SendPost_Map(datapost, testurl)  ;
		String code  =  AnalyticalJson.getJsonValue(httpresult, "code");
		Assert.assertEquals("0", code);
		System.out.println("code:"+code);
		
			
		
	}
	@Test(priority=1)//获取验证码
	public void test_getvalidCode() throws JSONException, ParseException{
		String httpresult;
		//拼装data的json
		JSONObject data=new JSONObject(); 
		data.put("mobile", "13811595822");
		
		Map<String,Object> datapost = new HashMap<String,Object>();
		datapost.put("version", "1.0");
		datapost.put("appCode", "org.yogomo.lw.app");
		datapost.put("api", "mpi.kl.validCode");
		datapost.put("appType", "1");
		datapost.put("timestamp", Stamp());
		datapost.put("data", data);
		
		httpresult = post.SendPost_Map(datapost, testurl);
		System.out.println("获取验证码结果："+httpresult);
		String code  =  AnalyticalJson.getJsonValue(httpresult, "code");
		System.out.println("获取验证码结果："+code);
		Assert.assertEquals("0", code);
		//System.out.println("code:"+code);
		
	}
	@Test(priority=2)//车主注册
	public void test_Car_owner_regist() throws JSONException, ParseException, ClassNotFoundException, SQLException{
		String httpresult;
		String validcode  =  GetRedisData.getRedisData("13811595822") ;//调用封装好的redis接口，取出短信验证码
		//拼装data的json
		JSONObject data=new JSONObject(); 
		data.put("mobile", "13811595822");
		data.put("username", "hanghang0");
		data.put("password", "123456");
		data.put("validCode", validcode);
		
		
		Map<String,Object> datapost = new HashMap<String,Object>();
		datapost.put("version", "1.0");
		datapost.put("appCode", "org.yogomo.lw.app");
		datapost.put("api", "mobile.regist");
		datapost.put("appType", "1");
		datapost.put("timestamp", Stamp());
		datapost.put("data", data);
		
		httpresult=post.SendPost_Map(datapost, testurl);
		
		String code = AnalyticalJson.getJsonValue(httpresult, "code");
		
		System.out.println("车主注册结果："+httpresult);
		System.out.println("车主注册结果："+code);
		Assert.assertEquals("0", code);
	
	}
	
	//@Test//有问题
	public void test_repeat_Car_owner_regist() throws JSONException, ParseException, ClassNotFoundException, SQLException{
		String httpresult;
		String validcode  =  GetRedisData.getRedisData("18618192101") ;//调用封装好的redis接口，取出短信验证码
		//拼装data的json
		JSONObject data=new JSONObject(); 
		data.put("mobile", "18618192101");
		data.put("username", "hanghang0");
		data.put("password", "123456");
		data.put("validCode", validcode);
		
		
		Map<String,Object> datapost = new HashMap<String,Object>();
		datapost.put("version", "1.0");
		datapost.put("appCode", "org.yogomo.lw.app");
		datapost.put("api", "mobile.regist");
		datapost.put("appType", "1");
		datapost.put("timestamp", Stamp());
		datapost.put("data", data);
		
		httpresult=post.SendPost_Map(datapost, testurl);
		
		String code = AnalyticalJson.getJsonValue(httpresult, "code");
		
		System.out.println(code);
		Assert.assertEquals("0", code);
		//删除注册的账号
	//	GetMysqlData.Mysql("delete from car_owner where mobile='18618192101'");
		
	}
	
	//@Test
	public void test_car_owner_reset_pwd() throws JSONException, ParseException{
		test_getvalidCode();//调用获取验证码的方法
		String httpresult;
		String validcode  =  GetRedisData.getRedisData("18618192101") ;//调用封装好的redis接口，取出短信验证码
		JSONObject data=new JSONObject();
		data.put("username", "hanghang0");
		data.put("newpassword", "654321");
		data.put("validCode", validcode);
		data.put("userSource", 1);
		Map<String,Object> datapost = new HashMap<String,Object>();
		datapost.put("version", "1.0");
		datapost.put("appCode", "org.yogomo.lw.app");
		datapost.put("api", "mpi.kl.carOwnerresetPwd");
		datapost.put("appType", "1");
		datapost.put("timestamp", Stamp());
		datapost.put("data", data);
		
		httpresult=post.SendPost_Map(datapost, testurl);
		System.out.println(httpresult);
		
	}
	
	@Test(priority=5)
	public void test_commonLocationList() throws JSONException, ParseException{
		String httpresult;
		JSONObject data=new JSONObject();
		data.put("pageNum", 1);
		Map<String,Object> datapost = new HashMap<String,Object>();
		datapost.put("version", "1.0");
		datapost.put("appCode", "org.yogomo.lw.app");
		datapost.put("api", "mpi.lw.commonLocationList");
		datapost.put("appType", "1");
		datapost.put("timestamp", Stamp());
		datapost.put("data", data);
		
		httpresult=post.SendPost_Map(datapost, testurl);
		System.out.println("mpi.lw.commonLocationList测试结果："+httpresult);
		
	}
	@Test(priority=6)
	public void test_commonLocationEdit() throws JSONException, ParseException{
		String httpresult;
		JSONObject data=new JSONObject();
		data.put("id", 1);
		data.put("listTop", 0);
		data.put("alias", "测试地址");
		data.put("address", "上地西路1号");
		data.put("longitude", 116.29647);
		data.put("latitude", 39.997796);
		data.put("addressType", 0);
		Map<String,Object> datapost = new HashMap<String,Object>();
		datapost.put("version", "1.0");
		datapost.put("appCode", "org.yogomo.lw.app");
		datapost.put("api", "mpi.lw.commonLocationEdit");
		datapost.put("appType", "1");
		datapost.put("timestamp", Stamp());
		datapost.put("data", data);
		httpresult=post.SendPost_Map(datapost, testurl);
		System.out.println("mpi.lw.commonLocationEdit测试结果："+httpresult);
		
	}
	@Test(priority=7)
	public void test_commonLocationDel() throws JSONException, ParseException{
		String httpresult;
		JSONObject data=new JSONObject();
		data.put("id", 1);
		Map<String,Object> datapost = new HashMap<String,Object>();
		datapost.put("version", "1.0");
		datapost.put("appCode", "org.yogomo.lw.app");
		datapost.put("api", "mpi.lw.commonLocationDel");
		datapost.put("appType", "1");
		datapost.put("timestamp", Stamp());
		datapost.put("data", data);
		httpresult=post.SendPost_Map(datapost, testurl);
		System.out.println("mpi.lw.commonLocationDel测试结果："+httpresult);
		
		
	}
	@Test(priority=8)
	public void test_carNavigate() throws JSONException, ParseException{
		String httpresult;
		JSONObject data=new JSONObject();
		data.put("vin", "VINHB1YGM01040001");
		data.put("address", "上地西路1号");
		data.put("longitude", 116.29647);
		data.put("latitude", 39.997796);
		Map<String,Object> datapost = new HashMap<String,Object>();
		datapost.put("version", "1.0");
		datapost.put("appCode", "org.yogomo.lw.app");
		datapost.put("api", "mpi.lw.carNavigate");
		datapost.put("appType", "1");
		datapost.put("timestamp", Stamp());
		datapost.put("data", data);
		httpresult=post.SendPost_Map(datapost, testurl);
		System.out.println("mpi.lw.carNavigate测试结果："+httpresult);
		
		
	}
	@Test(priority=9)
	public void test_carTelecontrolBespeakList() throws JSONException, ParseException{
		String httpresult;
		JSONObject data=new JSONObject();
		data.put("vin", "VINHB1YGM01040001");
		Map<String,Object> datapost = new HashMap<String,Object>();
		datapost.put("version", "1.0");
		datapost.put("appCode", "org.yogomo.lw.app");
		datapost.put("api", "mpi.lw.carTelecontrolBespeakList");
		datapost.put("appType", "1");
		datapost.put("timestamp", Stamp());
		datapost.put("data", data);
		httpresult=post.SendPost_Map(datapost, testurl);
		System.out.println("mpi.lw.carTelecontrolBespeakList测试结果："+httpresult);
		
		
		
	}
	@Test(priority=10)
	public void test_carTelecontrolBespeak() throws JSONException, ParseException{
		String httpresult;
		JSONObject data=new JSONObject();
		data.put("vin", "VINHB1YGM01040001");
		data.put("pwd", "b59c67bf196a4758191e42f76670ceba");
		data.put("instruct", 1);
		data.put("dateTime", Stamp());
		Map<String,Object> datapost = new HashMap<String,Object>();
		datapost.put("version", "1.0");
		datapost.put("appCode", "org.yogomo.lw.app");
		datapost.put("api", "mpi.lw.carTelecontrolBespeak");
		datapost.put("appType", "1");
		datapost.put("timestamp", Stamp());
		datapost.put("data", data);
		httpresult=post.SendPost_Map(datapost, testurl);
		System.out.println("mpi.lw.carTelecontrolBespeak测试结果:"+httpresult);
		
		
		
		
	}
	@Test(priority=11)
	public void test_carTelecontrol() throws JSONException, ParseException{
		String httpresult;
		JSONObject data=new JSONObject();
		data.put("vin", "VINHB1YGM01040001");
		data.put("pwd", "b59c67bf196a4758191e42f76670ceba");
		data.put("instruct", 1);//指令解锁
		Map<String,Object> datapost = new HashMap<String,Object>();
		datapost.put("version", "1.0");
		datapost.put("appCode", "org.yogomo.lw.app");
		datapost.put("api", "mpi.lw.carTelecontrol");
		datapost.put("appType", "1");
		datapost.put("timestamp", Stamp());
		datapost.put("data", data);
		httpresult=post.SendPost_Map(datapost, testurl);
		System.out.println("mpi.lw.carTelecontrol测试结果："+httpresult);
		
		
		
	}
	
	@Test(priority=12)
	public void test_carTelecontrolResult() throws JSONException, ParseException{
		String httpresult;
		JSONObject data=new JSONObject();
		data.put("vin", "VINHB1YGM01040001");
		Map<String,Object> datapost = new HashMap<String,Object>();
		datapost.put("version", "1.0");
		datapost.put("appCode", "org.yogomo.lw.app");
		datapost.put("api", "mpi.lw.carTelecontrolResult");
		datapost.put("appType", "1");
		datapost.put("timestamp", Stamp());
		datapost.put("data", data);
		httpresult=post.SendPost_Map(datapost, testurl);
		System.out.println("mpi.lw.carTelecontrolResult测试结果："+httpresult);
		
		
	}
	
	//传入时间并转换为时间戳
	public static String dateToStamp (String s) throws ParseException{
		String res ;
	
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-DD HH:mm:ss:SSS");
		
		Date date= simpleDateFormat.parse(s);
		
		long ts = date.getTime();
		
		res = String.valueOf(ts);

		return res;
		
	
		
	}
	
	//获取当前系统时间（时间戳）
	
	public static String Stamp() throws ParseException {
		String stamp;
		String systemdates;
		SimpleDateFormat  df = new SimpleDateFormat ("yyyy-MM-dd HH:mm:ss:SSS");
		
		systemdates = df.format(new Date()).toString();
		//调用时间转换时间戳方法
		stamp = dateToStamp(systemdates);
		
		return stamp;
		
	}
	

}
