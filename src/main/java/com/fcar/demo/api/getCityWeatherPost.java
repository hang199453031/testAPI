package com.fcar.demo.api;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.testng.Reporter;
import org.apache.http.client.config.*;


import com.gargoylesoftware.htmlunit.javascript.host.fetch.Response;

//import cn.inter.action.RequestConfig;




public class getCityWeatherPost {
	
	private String gurl;
	private String Rid;
	private String httpResults="";
	public static final String CHARSET = "UTF-8"; 
	private static final CloseableHttpClient httpclient;  
    static{  
        RequestConfig config = RequestConfig.custom().setConnectTimeout(1000).setSocketTimeout(1000).build();  
        httpclient = HttpClientBuilder.create().setDefaultRequestConfig(config).build();  
    }  

	public String SendPost_String(String code,String url) {
		
		gurl=url;
		Rid=code;
		System.out.println(gurl);
		System.out.println(Rid);
		//创建httpclient对象
		CloseableHttpClient httpClient = HttpClientBuilder.create().build();
		//创建httppost对象
		HttpPost post = new HttpPost(gurl);
		post.addHeader("User-Agent","USER_AGENT");
		//设置POST请求传递参数
		List<NameValuePair>params = new ArrayList<NameValuePair>();
		params.add(new BasicNameValuePair("citykey",Rid));
		

		

		
		try{
			
			UrlEncodedFormEntity entity = new UrlEncodedFormEntity(params);
			post.setEntity(entity);		
			
		}
		catch (UnsupportedEncodingException e){
			
			e.printStackTrace();			
		}
		//执行请求并处理响应
		try{
			
			CloseableHttpResponse  response = httpClient.execute(post);
			
			HttpEntity entity = response.getEntity();
			

			
			if(entity !=null){
				
				System.out.println("进入");
				//System.out.println(EntityUtils.toString(entity));
				
				httpResults=EntityUtils.toString(entity,"utf-8");	
				//System.out.println(httpResults);
				
			}else{
				System.out.println("未进入");
				Reporter.log("请求没有任何应答");
				return httpResults;
			}
			//释放资源
			EntityUtils.consume(entity);  
			response.close();
			
		}catch(ClientProtocolException  e){
			
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			//释放资源
			try{
				
				httpClient.close();
			}catch(IOException e){
				
				e.printStackTrace();
			}				
			
		}
		
					
		return httpResults;
	}
	
	

	public String SendPost_Map(Map<String,Object> params,String url){
		
		gurl=url;
		List<NameValuePair> pairs = new ArrayList<NameValuePair>(params.size());
		if (params != null&& !params.isEmpty()){

			for(String key:params.keySet()){
				
				pairs.add(new BasicNameValuePair(key, params.get(key).toString()));			
			}
			System.out.println(params);
			
		}else{
			Reporter.log("未读取到参数数据！");
			return null;
			
		}
		
		//创建httpclient对象
		CloseableHttpClient httpClient = HttpClientBuilder.create().build();
		//创建httppost对象
		//System.out.println(gurl);
		HttpPost post = new HttpPost(gurl);
		//设置POST请求传递参数
		try{
			
			UrlEncodedFormEntity entity = new UrlEncodedFormEntity(pairs);
			post.setEntity(entity);		
			
		}
		catch (UnsupportedEncodingException e){
			
			e.printStackTrace();			
		}
		//执行请求并处理响应
		try{
			
			CloseableHttpResponse  response = httpClient.execute(post);
			
			HttpEntity entity = response.getEntity();
			
			if(entity !=null){
				
				//System.out.println("响应内容：");
				//System.out.println(EntityUtils.toString(entity));
				
				httpResults=EntityUtils.toString(entity,"utf-8");	
				
			}else{
				
				Reporter.log("请求没有任何应答");
				return null;
			}
			//释放资源
			EntityUtils.consume(entity);  
			response.close();
			
		}catch(ClientProtocolException  e){
			
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			//释放资源
			try{
				
				httpClient.close();
			}catch(IOException e){
				
				e.printStackTrace();
			}				
			
		}
		return httpResults;
					
		
	}
	
	
	
	public  String sendGet(String url,Map <String,Object> params) throws  UnsupportedEncodingException, IOException{

		
		//判断传过来的map是否为空，如果不为空读取map中的数据并全部存入list
		if(params !=null && !params.isEmpty()){
			
			 List<NameValuePair> pairs = new ArrayList<NameValuePair>(params.size());  
			 
			
			for (String key : params.keySet()){
				
				pairs.add(new BasicNameValuePair(key, params.get(key).toString()));
				
				
			}
			
			//拼接url，并将list中的值：参数全部拼接成url
			 url +="?"+EntityUtils.toString(new UrlEncodedFormEntity(pairs),CHARSET);  
			 System.out.println(url);
			//创建一个httpget，并传入拼接好的url
			HttpGet httpget = new HttpGet(url);
			//提交请求，并创建CloseableHttpResponse类型变量存储服务器返回的信息
			CloseableHttpResponse response = httpclient.execute(httpget);
			//获取请求后服务器返回的响应代码
			int statusCode = response.getStatusLine().getStatusCode();
			
			//如果请求返回的状态码不是200，那么结束测试，抛出运行异常与返回的状态码
			if(statusCode !=200){
				System.out.println(statusCode);
				httpget.abort();
				throw new RuntimeException("HttpClient error,the code:"+statusCode);

			}
			
			HttpEntity entity = response.getEntity();
			String result ;
			if(entity != null){
				
				result=EntityUtils.toString(entity,"utf-8");
				EntityUtils.consume(entity);
				response.close();
				//System.out.println(result);
				return result;
			}
			else{
				Reporter.log("请求没有任何应答");
				return null;
				
			}
			
		
			
			
			
			 
			 
		}
		
		
		
		
		
		
		
		
		return null;
		
		
	}
	
	public String SendPost(String api,String version,String data,String url) {
		
		gurl=url;
		

		//创建httpclient对象
		CloseableHttpClient httpClient = HttpClientBuilder.create().build();
		//创建httppost对象
		HttpPost post = new HttpPost(gurl);
		post.addHeader("User-Agent","USER_AGENT");
		//设置POST请求传递参数
		List<NameValuePair>params = new ArrayList<NameValuePair>();
		params.add(new BasicNameValuePair("api",api));
		params.add(new BasicNameValuePair("version",version));
		params.add(new BasicNameValuePair("data",data));

		

		
		try{
			
			UrlEncodedFormEntity entity = new UrlEncodedFormEntity(params);
			post.setEntity(entity);		
			
		}
		catch (UnsupportedEncodingException e){
			
			e.printStackTrace();			
		}
		//执行请求并处理响应
		try{
			
			CloseableHttpResponse  response = httpClient.execute(post);
			
			HttpEntity entity = response.getEntity();
			

			
			if(entity !=null){
				
				System.out.println("进入");
				//System.out.println(EntityUtils.toString(entity));
				
				httpResults=EntityUtils.toString(entity,"utf-8");	
				//System.out.println(httpResults);
				
			}else{
				System.out.println("未进入");
				Reporter.log("请求没有任何应答");
				return httpResults;
			}
			//释放资源
			EntityUtils.consume(entity);  
			response.close();
			
		}catch(ClientProtocolException  e){
			
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			//释放资源
			try{
				
				httpClient.close();
			}catch(IOException e){
				
				e.printStackTrace();
			}				
			
		}
		
					
		return httpResults;
	}




}
