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
///**
// * 云联金服意向单创建接口
// * @author xu_shan  2017-5-18
// */
//public class OrderStatusTest {
//	
//	public String httpResult= null,content= null,msg=null,exp_msg = null,status = null,exp_status = null;
//	public static String q="";	
//	gerYunlianFinancial Financial=new gerYunlianFinancial();
//	
//	
//	/**
//	 * 预生产环境验证
//	 * 单据状态：贷款意向单
//	 * cases测试用例:单据处于贷款意向单，查看结果
//     * 检查点:调用异常,null
//	 */
//	@Test(priority=1)//(groups = { "BaseCase"})
//	public void OrderStatus_Yixiangdan() throws IOException{
//		exp_msg="调用异常,null";
//		q="{\"loanApplyNo\":\"2366346567564\"}";
//		resultCheck1(q, exp_msg);
//		
//        }
//	
//	
////	/**
////	 * 单据状态：贷款意向单
////	 * cases测试用例:单据处于贷款意向单，查看结果
////     * 检查点:调用异常,null
////	 */
////	@Test(priority=1)//(groups = { "BaseCase"})
////	public void OrderStatus_LetterIntent() throws IOException{
////		exp_msg="调用异常,null";
////		q="{\"loanApplyNo\":\"2366346567564\"}";
////		resultCheck1(q, exp_msg);
////		
////        }
////	
////	/**
////	 * 单据状态：无意向单
////	 * cases测试用例:单据处于无意向单，查看结果
////     * 检查点:
////	 */
////	@Test(priority=1)//(groups = { "BaseCase"})
////	public void OrderStatus_LetterIntentNot() throws IOException{
////		exp_msg="成功";
////		q="{\"loanApplyNo\":\"2366352430601\"}";
////		resultCheck1(q, exp_msg);
////		
////        }
////	
////	/**
////	 * 单据状态：待分单订单
////	 * 2366337065354  单据状态为：待分单订单
////	 * cases测试用例:闪贷订单输入单据号，查看结果
////   * 检查点:可以查询到订单
////	 */
////	@Test(priority=3)//(groups = { "BaseCase"})
////	public void OrderStatus_WaitList () throws IOException{
////		exp_msg="成功";
////		q="{\"loanApplyNo\":\"2366337065354\"}";
////		resultCheck1(q, exp_msg);
////		
////        }
////	
////	/**
////	 * 单据状态：已分单，待确认车辆信息订单
////	 * 2366346567542单据状态为：待确认车辆信息订单
////	 * cases测试用例:闪贷订单输入单据号，查看结果
////     * 检查点:可以查询到订单
////	 */
////	@Test(priority=4)//(groups = { "BaseCase"})
////	public void OrderStatus_WaitCar() throws IOException{
////		exp_msg="成功";
////		q="{\"loanApplyNo\":\"2366346567542\"}";
////		resultCheck1(q, exp_msg);
////		
////        }
////	
////	/**
////	 * 单据状态：已确认车辆信息,
////	 * 2366346567562单据状态为：待验车订单
////	 * cases测试用例:闪贷订单输入单据号，查看结果
////     * 检查点:可以查询到订单
////	 */
////	@Test(priority=4)//(groups = { "BaseCase"})
////	public void OrderStatus_WaitVehicle() throws IOException{
////		exp_msg="成功";
////		exp_status="2";
////		q="{\"loanApplyNo\":\"2366346567562\"}";
////		resultCheck2(q, exp_msg,exp_status);
////		
////        }
////	
////	/**
////	 * 单据状态：已验车,
////	 * 2366346567530单据状态为：待确认订单
////	 * cases测试用例:闪贷订单输入单据号，查看结果
////     * 检查点:可以查询到订单
////	 */
////	@Test(priority=5)//(groups = { "BaseCase"})
////	public void OrderStatus_WaitConfirm() throws IOException{
////		exp_msg="成功";
////		exp_status="2";
////		q="{\"loanApplyNo\":\"2366346567530\"}";
////		resultCheck2(q, exp_msg,exp_status);
////		
////        }
////	
////	/**
////	 * 单据状态：已确认,
////	 * 2366346567525单据状态为：待资质审核订单
////	 * cases测试用例:闪贷订单输入单据号，查看结果
////     * 检查点:可以查询到订单
////	 */
////	@Test(priority=6)//(groups = { "BaseCase"})
////	public void OrderStatus_WaitAptitude() throws IOException{
////		exp_msg="成功";
////		exp_status="2";
////		q="{\"loanApplyNo\":\"2366346567525\"}";
////		resultCheck2(q, exp_msg,exp_status);
////		
////        }
////	
////	/**
////	 * 单据状态：已初审,
////	 * 2366346567532单据状态为：待签合同订单
////	 * cases测试用例:闪贷订单输入单据号，查看结果
////     * 检查点:可以查询到订单
////	 */
////	@Test(priority=7)//(groups = { "BaseCase"})
////	public void OrderStatus_WaitContract () throws IOException{
////		exp_msg="成功";
////		exp_status="2";
////		q="{\"loanApplyNo\":\"2366346567532\"}";
////		resultCheck2(q, exp_msg,exp_status);
////		
////        }
////	
////	/**
////	 * 单据状态：已签合同,
////	 * 2366346567531单据状态为：待装GPS订单
////	 * cases测试用例:闪贷订单输入单据号，查看结果
////     * 检查点:可以查询到订单
////	 */
////	@Test(priority=8)//(groups = { "BaseCase"})
////	public void OrderStatus_WaitGPS() throws IOException{
////		exp_msg="成功";
////		exp_status="2";
////		q="{\"loanApplyNo\":\"2366346567531\"}";
////		resultCheck2(q, exp_msg,exp_status);
////		
////        }
////	
////	/**
////	 * 单据状态：已装GPS,
////	 * 2366346567533单据状态为：待过户/抵押订单
////	 * cases测试用例:闪贷订单输入单据号，查看结果
////     * 检查点:可以查询到订单
////	 */
////	@Test(priority=9)//(groups = { "BaseCase"})
////	public void OrderStatus_WaitMortgage () throws IOException{
////		exp_msg="成功";
////		exp_status="2";
////		q="{\"loanApplyNo\":\"2366346567533\"}";
////		resultCheck2(q, exp_msg,exp_status);
////		
////        }
////	
////	/**
////	 * 单据状态：已抵押/过户,
////	 * 2366346567535单据状态为：保险待处理订单
////	 * cases测试用例:闪贷订单输入单据号，查看结果
////     * 检查点:可以查询到订单
////	 */
////	@Test(priority=10)//(groups = { "BaseCase"})
////	public void OrderStatus_WaitInsurance() throws IOException{
////		exp_msg="成功";
////		exp_status="2";
////		q="{\"loanApplyNo\":\"2366346567535\"}";
////		resultCheck2(q, exp_msg,exp_status);
////		
////        }
////	
////	/**
////	 * 单据状态：已过户保险/变更受益人,
////	 * 2366346567536单据状态为：待传交接单订单
////	 * cases测试用例:闪贷订单输入单据号，查看结果
////     * 检查点:可以查询到订单
////	 */
////	@Test(priority=11)//(groups = { "BaseCase"})
////	public void OrderStatus_WaitTransfer() throws IOException{
////		exp_msg="成功";
////		exp_status="2";
////		q="{\"loanApplyNo\":\"2366346567536\"}";
////		resultCheck2(q, exp_msg,exp_status);
////		
////        }
////	
////	/**
////	 * 单据状态：已交接,
////	 * 2366346567544单据状态为：待放款审核订单
////	 * cases测试用例:闪贷订单输入单据号，查看结果
////     * 检查点:可以查询到订单
////	 */
////	@Test(priority=12)//(groups = { "BaseCase"})
////	public void OrderStatus_WaitLoanExamine () throws IOException{
////		exp_msg="成功";
////		exp_status="2";
////		q="{\"loanApplyNo\":\"2366346567544\"}";
////		resultCheck2(q, exp_msg,exp_status);
////		
////        }
////	
////	/**
////	 * 单据状态：已通过,
////	 * 2366346567545单据状态为：待放款订单
////	 * cases测试用例:闪贷订单输入单据号，查看结果
////     * 检查点:可以查询到订单
////	 */
////	@Test(priority=13)//(groups = { "BaseCase"})
////	public void OrderStatus_WaitLoan() throws IOException{
////		exp_msg="成功";
////		exp_status="2";
////		q="{\"loanApplyNo\":\"2366346567545\"}";
////		resultCheck2(q, exp_msg,exp_status);
////		
////        }
////	/**
////	 * 单据状态：已放款,
////	 * 2366346567561单据状态为：
////	 * cases测试用例:闪贷订单输入单据号，查看结果
////     * 检查点:可以查询到订单
////	 */
////	@Test(priority=14)//(groups = { "BaseCase"})
////	public void OrderStatus_SecuredLoan() throws IOException{
////		exp_msg="成功";
////		exp_status="3";
////		q="{\"loanApplyNo\":\"2366346567561\"}";
////		resultCheck2(q, exp_msg,exp_status);
////		
////        }
////	
////	/**
////	 * 单据状态：已取消,
////	 * 2366346567546单据状态为：取消订单
////	 * cases测试用例:闪贷订单输入单据号，查看结果
////     * 检查点:可以查询到订单
////	 */
////	@Test(priority=15)//(groups = { "BaseCase"})
////	public void OrderStatus_CancelOrder() throws IOException{
////		exp_msg="成功";
////		exp_status="4";
////		q="{\"loanApplyNo\":\"2366346567546\"}";
////		resultCheck2(q, exp_msg,exp_status);
////		
////        }
////	/**
////	 * 单据状态：已违约,
////	 * 2366346567547单据状态为：违约订单
////	 * cases测试用例:闪贷订单输入单据号，查看结果
////     * 检查点:可以查询到订单
////	 */
////	@Test(priority=15)//(groups = { "BaseCase"})
////	public void OrderStatus_BreachOrder() throws IOException{
////		exp_msg="成功";
////		exp_status="4";
////		q="{\"loanApplyNo\":\"2366346567547\"}";
////		resultCheck2(q, exp_msg,exp_status);
////		
////        }
//	
//	 //////////////////////////////////////////////////////////////////////////
//	 public void resultCheck1(String q_str, String exp_msg_str) throws IOException{
//		 String interfaceUrl = "http://10.104.90.66/fcarpapi/resource/fcar/partner/orderStatus";
//		 Reporter.log("【正常用例】:获取"+exp_msg_str+"成功!");
//         System.out.println("【正常用例】:获取"+exp_msg_str+"成功!");
//         httpResult=Financial.getHttpRespone(interfaceUrl,q_str);
//         Reporter.log("请求地址: "+Financial.geturl());
//         System.out.println("请求地址: "+Financial.geturl());
//         Reporter.log("返回结果: "+httpResult);
//         System.out.println(AnalyticalJson.unicodeToUtf8(httpResult));
//         msg=AnalyticalJson.getJsonValue(httpResult, "msg");
// 		 System.out.println(msg);
// 		 Reporter.log("用例结果: resultCode=>expected: " + exp_msg_str + " ,actual: "+ msg);
//		 System.out.println("用例结果: resultCode=>expected: " + exp_msg_str + " ,actual: "+ msg);
//		 Assert.assertEquals(msg,exp_msg_str);
//                
//     }
//	 public void resultCheck2(String q_str, String exp_msg_str,String exp_status_str) throws IOException{
//		 String interfaceUrl = "http://10.104.90.66/fcarpapi/resource/fcar/partner/orderStatus";
//		 Reporter.log("【正常用例】:获取"+exp_msg_str+"成功!");
//         System.out.println("【正常用例】:获取"+exp_msg_str+"成功!");
//         httpResult=Financial.getHttpRespone(interfaceUrl,q_str);
//         Reporter.log("请求地址: "+Financial.geturl());
//         System.out.println("请求地址: "+Financial.geturl());
//         Reporter.log("返回结果: "+httpResult);
//         System.out.println(AnalyticalJson.unicodeToUtf8(httpResult));
//         msg=AnalyticalJson.getJsonValue(httpResult, "msg");
// 		 System.out.println(msg);
// 		 Reporter.log("用例结果: resultCode=>expected: " + exp_msg_str + " ,actual: "+ msg);
//		 System.out.println("用例结果: resultCode=>expected: " + exp_msg_str + " ,actual: "+ msg);
//		 Assert.assertEquals(msg,exp_msg_str);
//		 content=AnalyticalJson.getJsonValue(httpResult, "content");
//		 status=AnalyticalJson.getJsonValue(content, "status");
//		 Reporter.log("用例结果: resultCode=>expected: " + exp_status_str + " ,actual: "+ status);
//		 System.out.println("用例结果: resultCode=>expected: " + exp_status_str + " ,actual: "+ status);
//		 Assert.assertEquals(status,exp_status_str);
//		 
//     }
//
//}
