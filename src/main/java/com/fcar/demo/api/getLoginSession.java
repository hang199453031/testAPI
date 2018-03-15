package com.fcar.demo.api;
import org.apache.commons.httpclient.Cookie;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.NameValuePair;
import org.apache.commons.httpclient.cookie.CookiePolicy;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.httpclient.methods.PostMethod;
public class getLoginSession {
	
	public String getLoginSession(String loingURL){
		
		
		HttpClient httpclient = new HttpClient();
		PostMethod postmethod = new PostMethod(loingURL);
		
		NameValuePair[] data = { new NameValuePair("username", "hanghang0"), new NameValuePair("password", "123456"),new NameValuePair("userSource","1") };
		
		postmethod.setRequestBody(data);
		
		try{
		httpclient.getParams().setCookiePolicy(CookiePolicy.BROWSER_COMPATIBILITY);
		
		int statusCode = httpclient.executeMethod(postmethod);
		
		Cookie[] cookies = httpclient.getState().getCookies();
		
		StringBuffer tmpcookies = new StringBuffer();
		
		for(Cookie c :cookies ){
			
			tmpcookies.append(c.toString()+";");
			System.out.println("cookies = :"+c.toString());
			return c.toString();
		}

		
		
		
		}catch(Exception e){
			
			e.printStackTrace();
		}
		
		
		return null;
		
	}

}
