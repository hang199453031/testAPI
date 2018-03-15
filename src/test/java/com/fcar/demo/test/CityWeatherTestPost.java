package com.fcar.demo.test;

import java.io.IOException;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.fcar.basics.utils.AnalyticalJson;
import com.fcar.demo.api.getCityWeather;
import com.fcar.demo.api.getCityWeatherPost;
public class CityWeatherTestPost {
	String httpResult;
	getCityWeatherPost post = new getCityWeatherPost();
	String url="https://www.sojson.com/open/api/weather/json.shtml?";

	
	
	
	@Test
	public void test_shenzhen(){
		String citycode="101071201";
		String exp_cityname="朝阳县";
		resultCheck(citycode,exp_cityname);
		
	}
	
	
	public void resultCheck(String city_code,String exp_city_str){
		
		Reporter.log("【正常用例】：获取"+exp_city_str+"天气成功！");
		httpResult=post.SendPost_String(city_code, url);
		System.out.println(httpResult);
		
		
		
		
		
		
	}
	
	
}
