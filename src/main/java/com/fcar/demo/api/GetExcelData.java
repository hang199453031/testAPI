package com.fcar.demo.api;

import java.io.File;
import java.io.IOException;
import java.security.KeyStore.Entry;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

public class GetExcelData {
	
	public static Map<String,Object> getExcelData(String sourceFile,String sheetname) throws BiffException, IOException{
		ArrayList <String>arrkey = new ArrayList<String>();
		Workbook workbook = Workbook.getWorkbook(new File(sourceFile));
	    Sheet sheet=workbook.getSheet(sheetname);
		int rows = sheet.getRows();
		int cols = sheet.getColumns();
		Map<String, Object> datamap = new HashMap<String,Object>();
		//取列名并存入list
/*		for (int colNum=1;colNum<cols;colNum++){
			
			String columsName = sheet.getCell(colNum,0).getContents();
			arrkey.add(columsName);
		}*/
		//循环将第一列中所有的数据取出，并存入list，留用map.key使用
		for(int rowNum=1;rowNum<rows;rowNum++){
			//getCell(列，行) int 型
			String rowsName = sheet.getCell(0,rowNum).getContents().trim();
			//System.out.println(rowsName);
			arrkey.add(rowsName);
		}
		
		//循环将第二列中所有的数据取出，并将之前获取的key与value存入map
		for(int rowNum = 1;rowNum<rows;rowNum++){
				
						//固定一列，一行一行依次取出内容
						String colContent = sheet.getCell(1,rowNum).getContents();
						//System.out.println(colContent);
						//list是从0开始存储的，所以第一个数的位置是0，但是rownum默认是1
						datamap.put(arrkey.get(rowNum-1), colContent);

		}
					
		return datamap;
	}
	

}
