package com.fcar.demo.test;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.fcar.basics.utils.AnalyticalJson;
import com.fcar.demo.api.GetExcelData;
import com.fcar.demo.api.getCityWeather;
import com.fcar.demo.api.getCityWeatherPost;
public class testLogin {
	getCityWeatherPost getlogin = new getCityWeatherPost();
	String  testurl="https://mpi.carmall.tian-net.com/mpi";
/*	@Test
	public void testLoing_post(){
	String resultcode ="0";
	String resultmessage = "登陆成功！";
		
	String httpresult =	getlogin.SendPost_String("mobile.login", "0.0.1", "{'mobile':'18611556722','password':'123456'}", testurl);
		
	System.out.println(httpresult);
	String data = AnalyticalJson.getJsonValue(httpresult, "data");
	System.out.println(data);
	String message = AnalyticalJson.getJsonValue(data, "resultMessage");
	String code = AnalyticalJson.getJsonValue(data, "resultCode");
	System.out.println(message);
	Assert.assertEquals(resultmessage, message);
	Assert.assertEquals(resultcode, code);
	}*/
	//@Test
	public void testLoing_post(){
		String httpresult;
		String resultcode ="0";
		String resultmessage = "登陆成功！";
		Map<String,Object> postdata = new HashMap<String,Object>();
		
		postdata.put("api", "mobile.login");
		postdata.put("version", "0.0.1");
		postdata.put("data", "{'mobile':'18611556722','password':'123456'}");
		httpresult = getlogin.SendPost_Map(postdata, testurl);
		//System.out.println(httpresult);
		String data = AnalyticalJson.getJsonValue(httpresult, "data");
		String message = AnalyticalJson.getJsonValue(data, "resultMessage");
		String code = AnalyticalJson.getJsonValue(data, "resultCode");
		
		Assert.assertEquals(resultcode, code);
		Assert.assertEquals(resultmessage, message);
	}
	
	@Test(priority=1)
	public void testLoing_get(){
		
		Map<String,Object> getdata = new HashMap<String,Object>();
		
		getdata.put("api", "mobile.getItemGoodsList");
		getdata.put("version", "0.0.1");
		getdata.put("data", "{'pageNum':'1','pageSize':'6','orderBy':'saleQty','direction':'desc'}");
		
		try{
		String httpresult =	getlogin.sendGet(testurl, getdata);
		System.out.println(httpresult);
		
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		
	}
	
	//@Test(priority=2)
	public void testloing_postExcel(){
		
		String httpresult;
	//	String resultcode ="0";
	//	String resultmessage = "登陆成功！";
/*		Map<String,Object> postdata = new HashMap<String,Object>();
		
		postdata.put("api", "mobile.login");
		postdata.put("version", "0.0.1");
		postdata.put("data", "{'mobile':'18611556722','password':'123456'}");*/
		String filename="testCase1";
		String sourceFile = null;
		File directory  = new File(".");
		try{
		sourceFile=directory.getCanonicalPath()+ "\\src\\main\\resources\\"+filename+".xls";
		
		httpresult = getlogin.SendPost_Map(GetExcelData.getExcelData(sourceFile, "login"), testurl);
		
		System.out.println(httpresult);
		}catch(Exception e){
			
			e.printStackTrace();
			
		}
		
	}
	
	
	
	
	

}