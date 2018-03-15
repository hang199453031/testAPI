//package com.fcar.yunlianFinancial.test;
//
//import java.io.IOException;
//
//import org.testng.Assert;
//import org.testng.Reporter;
//import org.testng.annotations.Test;
//
//import com.fcar.basics.utils.AnalyticalJson;
//import com.fcar.demo.api.gerYunlianFinancial;
//
//public class OrderOverDueTest {
//
//	public String httpResult= null,content= null,msg=null,exp_msg = null,status = null,exp_status = null;
//	public static String q="";	
//	gerYunlianFinancial Financial=new gerYunlianFinancial();
//	
//	/**
//	 * 单据状态：未过期订单
//	 * cases测试用例:单据处于未过期订单，查看结果
//    * 检查点:调用异常,null
//	 */
//	@Test(priority=1)//(groups = { "BaseCase"})
//	public void OrderStatus_OverdueOrder () throws IOException{
//		exp_msg="成功";
//		q="{\"applyNo\":\"2366352430622\"}";
//		resultCheck(q, exp_msg);
//		
//       }
////	/**
////	 * 单据状态：过期订单
////	 * cases测试用例:单据处于过期订单，查看结果
////    * 检查点:调用异常,null
////	 */
////	@Test(priority=1)//(groups = { "BaseCase"})
////	public void OrderStatus_PastDueOrders () throws IOException{
////		exp_msg="调用异常,null";
////		q="{\"applyNo\":\"2366346567564\"}";
////		resultCheck(q, exp_msg);
////		
////       }
//	
//	 //////////////////////////////////////////////////////////////////////////
//	 public void resultCheck(String q_str, String exp_msg_str) throws IOException{
//		 String interfaceUrl = "http://10.104.90.66/fcarpapi/resource/fcar/partner/orderOverDue";
//		 Reporter.log("【正常用例】:获取"+exp_msg_str+"成功!");
//        System.out.println("【正常用例】:获取"+exp_msg_str+"成功!");
//        httpResult=Financial.getHttpRespone(interfaceUrl,q_str);
//        Reporter.log("请求地址: "+Financial.geturl());
//        System.out.println("请求地址: "+Financial.geturl());
//        Reporter.log("返回结果: "+httpResult);
//        System.out.println(AnalyticalJson.unicodeToUtf8(httpResult));
//        msg=AnalyticalJson.getJsonValue(httpResult, "msg");
//		 System.out.println(msg);
//		 Reporter.log("用例结果: resultCode=>expected: " + exp_msg_str + " ,actual: "+ msg);
//		 System.out.println("用例结果: resultCode=>expected: " + exp_msg_str + " ,actual: "+ msg);
//		 Assert.assertEquals(msg,exp_msg_str);
//               
//    }
//}
