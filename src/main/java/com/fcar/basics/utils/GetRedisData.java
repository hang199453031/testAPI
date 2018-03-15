package com.fcar.basics.utils;

import redis.clients.jedis.Jedis;

public class GetRedisData {
	
	public  static String getRedisData(String mobileNum){
		Jedis jedis = new Jedis("r-2ze0c74e98e0b0e4.redis.rds.aliyuncs.com", 6379);//地址、端口号
		jedis.auth("Summeriscomming2");//密码
	    String validCode = jedis.get("smsCode" + mobileNum); //设置键值取出redis中的数据
	    jedis.close();
	    return validCode;

	}

}
