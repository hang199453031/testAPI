package com.fcar.demo.test;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import com.fcar.demo.api.*;

import jxl.read.biff.BiffException;
public class testExcelData {
	public static void main(String arg[]) throws IOException, BiffException{
		String filename="testCase1";
		String sourceFile = null;
		GetExcelData test = new GetExcelData();
		File directory  = new File(".");
		sourceFile=directory.getCanonicalPath()+ "\\src\\main\\resources\\"+filename+".xls";
		
		Map<String, Object> a=	test.getExcelData(sourceFile, "login");
	 
		Set set = a.entrySet();
		
		Iterator iterator = set.iterator();
		
		while(iterator.hasNext()){
			
			Map.Entry mapentry =(Map.Entry)iterator.next();
			System.out.println(mapentry.getKey()+"     "+mapentry.getValue());
			//System.out.println(mapentry.getKey());
			//System.out.println(mapentry.getValue());
			
		}
		
	}

}
