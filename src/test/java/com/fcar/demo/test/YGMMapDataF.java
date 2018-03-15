package com.fcar.demo.test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class YGMMapDataF {
	public 	String  testurl="http://mpi.demo.cas-tian.com/mpi";
	
	public Map<String,Object> datapost = new HashMap<String,Object>();
	public YGMMapDataF() throws ParseException{
	datapost.put("version", "1.0");
	datapost.put("appCode", "org.yogomo.lw.app");
	datapost.put("appType", "1");
	datapost.put("timestamp", Stamp());
	}
	private static String Stamp() throws ParseException {
		String stamp;
		String systemdates;
		SimpleDateFormat  df = new SimpleDateFormat ("yyyy-MM-dd HH:mm:ss:SSS");
		
		systemdates = df.format(new Date()).toString();
		//调用时间转换时间戳方法
		stamp = dateToStamp(systemdates);
		
		return stamp;
		
	}
	private static String dateToStamp (String s) throws ParseException{
		String res ;
	
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-DD HH:mm:ss:SSS");
		
		Date date= simpleDateFormat.parse(s);
		
		long ts = date.getTime();
		
		res = String.valueOf(ts);

		return res;

		
	}
}
