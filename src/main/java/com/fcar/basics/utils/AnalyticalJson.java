package com.fcar.basics.utils;

import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

public class AnalyticalJson {
	/**
	 * 解析Json内容
	 * 
	 * @author 
	 * @version 1.0 2016/3/23
	 * @return JsonValue 返回JsonString中JsonId对应的Value
	 **/
	public static String getJsonValue(String JsonString, String JsonId) {
		String JsonValue = "";
		if (JsonString == null || JsonString.trim().length() < 1) {
			return null;
		}
		try {
			JSONObject obj1 = new JSONObject(JsonString);
			JsonValue = (String) obj1.optString(JsonId);
		} catch (JSONException e) {
			e.printStackTrace();
		}
		return JsonValue;
	}
	/**
	 * Unicode编码转到utf8编码
	 * @author 
	 * @version 1.0 2016/3/23
	 * @return 
	 **/	
	 public static String unicodeToUtf8(String theString) {
	        char aChar;
	        int len = theString.length();
	        StringBuffer outBuffer = new StringBuffer(len);
	        for (int x = 0; x < len;) {
	            aChar = theString.charAt(x++);
	            if (aChar == '\\') {
	                aChar = theString.charAt(x++);
	                if (aChar == 'u') {
	                    // Read the xxxx
	                    int value = 0;
	                    for (int i = 0; i < 4; i++) {
	                        aChar = theString.charAt(x++);
	                        switch (aChar) {
	                        case '0':
	                        case '1':
	                        case '2':
	                        case '3':
	                        case '4':
	                        case '5':
	                        case '6':
	                        case '7':
	                        case '8':
	                        case '9':
	                            value = (value << 4) + aChar - '0';
	                            break;
	                        case 'a':
	                        case 'b':
	                        case 'c':
	                        case 'd':
	                        case 'e':
	                        case 'f':
	                            value = (value << 4) + 10 + aChar - 'a';
	                            break;
	                        case 'A':
	                        case 'B':
	                        case 'C':
	                        case 'D':
	                        case 'E':
	                        case 'F':
	                            value = (value << 4) + 10 + aChar - 'A';
	                            break;
	                        default:
	                            throw new IllegalArgumentException(
	                                    "Malformed   \\uxxxx   encoding.");
	                        }
	                    }
	                    outBuffer.append((char) value);
	                } else {
	                    if (aChar == 't')
	                        aChar = '\t';
	                    else if (aChar == 'r')
	                        aChar = '\r';
	                    else if (aChar == 'n')
	                        aChar = '\n';
	                    else if (aChar == 'f')
	                        aChar = '\f';
	                    outBuffer.append(aChar);
	                }
	            } else
	                outBuffer.append(aChar);
	        }
	        return outBuffer.toString();
	    }
}
