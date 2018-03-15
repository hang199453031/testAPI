package com.fcar.demo.test;

import java.io.IOException;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.fcar.basics.utils.AnalyticalJson;
import com.fcar.demo.api.getCityWeather;



public class CityWeatherTest {
	public String httpResult= null, weatherinfo= null, city=null,exp_city = null;
	public static String cityCode="";	
	getCityWeather weather=new getCityWeather();
	
	@Test(priority=1)//(groups = { "BaseCase"})
	public void getShenZhen_Succ() throws IOException{
		exp_city="深圳";
		cityCode="101280601";
		System.out.println("-------------------------");
		
	    System.out.println(	weather.getHttpRespone(cityCode));
		
		
		System.out.print("-------------------------");
		Reporter.log("【正常用例】:获取"+exp_city+"天气成功!");
		System.out.println("【正常用例】:获取"+exp_city+"天气成功!");
		httpResult=weather.getHttpRespone(cityCode);
		Reporter.log("请求地址: "+weather.geturl());
		System.out.println("请求地址: "+weather.geturl());
		Reporter.log("返回结果: "+httpResult);
		System.out.println("返回结果: "+httpResult);
		System.out.println(AnalyticalJson.unicodeToUtf8(httpResult));
		weatherinfo=AnalyticalJson.getJsonValue(httpResult, "weatherinfo");
		System.out.println(weatherinfo);
		city=AnalyticalJson.getJsonValue(weatherinfo, "city");
		Reporter.log("用例结果: resultCode=>expected: " + exp_city + " ,actual: "+ city);
		Assert.assertEquals(city,exp_city);
	}
	
//	@Test(priority=2)//(groups = { "BaseCase"})
//	public void getBeiJing_Succ() throws IOException{
//		exp_city="北京";
//		cityCode="101010100";
//		Reporter.log("【正常用例】:获取"+exp_city+"天气成功!");
//		httpResult=weather.getHttpRespone(cityCode);
//		Reporter.log("请求地址: "+weather.geturl());
//		Reporter.log("返回结果: "+httpResult);
//		weatherinfo=AnalyticalJson.getJsonValue(httpResult, "weatherinfo");
//		city=AnalyticalJson.getJsonValue(weatherinfo, "city");
//		Reporter.log("用例结果: resultCode=>expected: " + exp_city + " ,actual: "+ city);
//		Assert.assertEquals(city,exp_city);
//	}
//	
//	@Test(priority=3)//(groups = { "BaseCase"})
//	public void getShangHai_Succ() throws IOException{
//		exp_city="上海";
//		cityCode="101020100";
//		Reporter.log("【正常用例】:获取"+exp_city+"天气成功!");
//		httpResult=weather.getHttpRespone(cityCode);
//		Reporter.log("请求地址: "+weather.geturl());
//		Reporter.log("返回结果: "+httpResult);
//		weatherinfo=AnalyticalJson.getJsonValue(httpResult, "weatherinfo");
//		city=AnalyticalJson.getJsonValue(weatherinfo, "city");
//		Reporter.log("用例结果: resultCode=>expected: " + exp_city + " ,actual: "+ city);
//		Assert.assertEquals(city,exp_city);
//	}	
}
