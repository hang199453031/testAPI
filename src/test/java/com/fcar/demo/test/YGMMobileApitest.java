package com.fcar.demo.test;
import java.text.ParseException;
import java.util.HashMap;
import java.util.Map;

import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;
import org.testng.annotations.Test;

import com.fcar.demo.test.YGMMapDataF;
import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
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

import com.fcar.demo.api.GetExcelData;
import com.fcar.demo.api.getCityWeather;
import com.fcar.demo.api.getCityWeatherPost;
import com.fcar.basics.utils.*;
public class YGMMobileApitest extends YGMMapDataF  {
	public YGMMobileApitest() throws ParseException {
		super();//在子类的无参构造方法中调用父类的无参构造方法
		// TODO Auto-generated constructor stub
	}

	

	getCityWeatherPost post = new getCityWeatherPost();  //调用post封装方法
	
	
	//@Test(priority=1)//获取验证码
	public void test_getvalidCode() throws JSONException, ParseException, UnsupportedEncodingException, IOException{
		String httpresult;
		//拼装data的json
		JSONObject data=new JSONObject(); 
		data.put("mobile", "18618192101");
		

		super.datapost.put("api", "mpi.kl.validCode");


		super.datapost.put("data", data);
		
		httpresult = post.sendGet(super.testurl, super.datapost);
		System.out.println("获取验证码结果："+httpresult);
		String code  =  AnalyticalJson.getJsonValue(httpresult, "code");
		System.out.println("获取验证码结果："+code);
		Assert.assertEquals("0", code);
	
	}
	
	
	//@Test(priority=2)//车主注册
	public void test_Car_owner_regist() throws JSONException, ParseException, ClassNotFoundException, SQLException, UnsupportedEncodingException, IOException{
		String httpresult;
		String validcode  =  GetRedisData.getRedisData("18618192101") ;//调用封装好的redis接口，取出短信验证码
		//拼装data的json
		JSONObject data=new JSONObject(); 
		data.put("mobile", "18618192101");
		data.put("username", "hanghang0");
		data.put("password", "123456");
		data.put("validCode", validcode);
		

		super.datapost.put("api", "mobile.regist");

		super.datapost.put("data", data);
		
		httpresult=post.sendGet(super.testurl, super.datapost);
		
		String code = AnalyticalJson.getJsonValue(httpresult, "code");
		
		System.out.println("车主注册结果："+httpresult);
		System.out.println("车主注册结果："+code);
		Assert.assertEquals("0", code);
	
	}
	//@Test(priority=3)//车主登录
	public void test_login_chezhu() throws ParseException, JSONException, UnsupportedEncodingException, IOException{
		String httpresult;
		//拼装data的json
		JSONObject data=new JSONObject(); 
		data.put("username", "hanghang0");
		data.put("password", "123456");
		data.put("userSource", 1);//车主1,默认是0管理员登录
		//拼装map
		super.datapost.put("api", "mobile.login");
		super.datapost.put("data", data);
		//发送post请求，并接收服务器返回数据
		httpresult = post.sendGet(super.testurl, super.datapost);
		String code  =  AnalyticalJson.getJsonValue(httpresult, "code");
		Assert.assertEquals("0", code);
		System.out.println("登录结果："+httpresult);
		System.out.println("登录结果"+"code:"+code);
		
			
		
	}
	
	
	//@Test(priority=4)
	public void test_commonLocationList() throws JSONException, ParseException, UnsupportedEncodingException, IOException{
		String httpresult;
		JSONObject data=new JSONObject();
		data.put("pageNum", 1);
		super.datapost.put("data", data);//完善map
		super.datapost.put("api", "mpi.lw.commonLocationList");//完善map
		//httpresult=post.SendPost_Map(super.datapost, super.testurl);//将URL与map传入post方法中
		httpresult=post.sendGet(super.testurl, super.datapost);
		
		System.out.println("mpi.lw.commonLocationList测试结果："+httpresult);

}
	
	//@Test(priority=5)
	public void test_commonLocationEdit() throws JSONException, ParseException, UnsupportedEncodingException, IOException{
		String httpresult;
		JSONObject data=new JSONObject();
		data.put("id", 1);
		data.put("listTop", 0);
		data.put("alias", "测试地址");
		data.put("address", "上地西路1号");
		data.put("longitude", 116.29647);
		data.put("latitude", 39.997796);
		data.put("addressType", 0);
		super.datapost.put("api", "mpi.lw.commonLocationEdit");
		super.datapost.put("data", data);
		httpresult=post.sendGet(super.testurl, super.datapost);
		System.out.println("mpi.lw.commonLocationEdit测试结果："+httpresult);
		
	}
	
	//@Test(priority=6)
	public void test_commonLocationDel() throws JSONException, ParseException, UnsupportedEncodingException, IOException{
		String httpresult;
		JSONObject data=new JSONObject();
		data.put("id", 1);
		super.datapost.put("api", "mpi.lw.commonLocationDel");
		super.datapost.put("data", data);
		httpresult=post.sendGet(super.testurl, super.datapost);
		System.out.println("mpi.lw.commonLocationDel测试结果："+httpresult);
		
		
	}
	
	//@Test(priority=7)
	public void test_carNavigate() throws JSONException, ParseException, UnsupportedEncodingException, IOException{
		String httpresult;
		JSONObject data=new JSONObject();
		data.put("vin", "VINHB1YGM01040001");
		data.put("address", "上地西路1号");
		data.put("longitude", 116.29647);
		data.put("latitude", 39.997796);	
		super.datapost.put("api", "mpi.lw.carNavigate");
		super.datapost.put("data", data);
		httpresult=post.sendGet(super.testurl, super.datapost);
		System.out.println("mpi.lw.carNavigate测试结果："+httpresult);
		
		
	}
	
	
	//@Test(priority=8)
	public void test_carTelecontrolBespeakList() throws JSONException, ParseException, UnsupportedEncodingException, IOException{
		String httpresult;
		JSONObject data=new JSONObject();
		data.put("vin", "VINHB1YGM01040001");
		super.datapost.put("api", "mpi.lw.carTelecontrolBespeakList");
		super.datapost.put("data", data);
		httpresult=post.sendGet(super.testurl, super.datapost);
		System.out.println("mpi.lw.carTelecontrolBespeakList测试结果："+httpresult);
		
		
		
	}
	
	
	
	//@Test(priority=9)
	public void test_carTelecontrolBespeak() throws JSONException, ParseException, UnsupportedEncodingException, IOException{
		String httpresult;
		JSONObject data=new JSONObject();
		data.put("vin", "VINHB1YGM01040001");
		data.put("pwd", "b59c67bf196a4758191e42f76670ceba");
		data.put("instruct", 1);
		data.put("dateTime", Stamp());
		super.datapost.put("api", "mpi.lw.carTelecontrolBespeak");
		super.datapost.put("data", data);
		httpresult=post.sendGet(super.testurl, super.datapost);
		System.out.println("mpi.lw.carTelecontrolBespeak测试结果:"+httpresult);
		
		
		
		
	}
	@Test(priority=10)
	public void test_carTelecontrol() throws JSONException, ParseException, UnsupportedEncodingException, IOException{
		String httpresult;
		JSONObject data=new JSONObject();
		data.put("vin", "VINHB1YGM01040001");
		data.put("pwd", "b59c67bf196a4758191e42f76670ceba");
		data.put("instruct", 1);//指令解锁
		super.datapost.put("api", "mpi.lw.carTelecontrol");
		super.datapost.put("data", data);
		httpresult=post.sendGet(super.testurl, super.datapost);
		System.out.println("mpi.lw.carTelecontrol测试结果："+httpresult);
		
		
		
	}
	
	//@Test(priority=11)
	public void test_carTelecontrolResult() throws JSONException, ParseException, UnsupportedEncodingException, IOException{
		String httpresult;
		JSONObject data=new JSONObject();
		data.put("vin", "VINHB1YGM01040001");
		datapost.put("api", "mpi.lw.carTelecontrolResult");
		datapost.put("data", data);
		httpresult=post.sendGet(super.testurl, super.datapost);
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
