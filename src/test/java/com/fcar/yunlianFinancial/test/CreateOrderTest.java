//package com.fcar.yunlianFinancial.test;
//
//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.net.HttpURLConnection;
//import java.net.URL;
//
//import org.testng.Assert;
//import org.testng.Reporter;
//import org.testng.annotations.Test;
//import com.fcar.basics.utils.AnalyticalJson;
//import com.fcar.demo.api.gerYunlianFinancial;
//import com.fcar.demo.api.getCityWeather;
//
///**
// * 云联金服意向单创建接口
// * @author xu_shan  2017-5-17
// */
//public class CreateOrderTest {
//
//	public String httpResult= null, weatherinfo= null, msg=null,exp_msg = null;
//	public static String q="";	
//	gerYunlianFinancial Financial=new gerYunlianFinancial();
//	
////	//查询数据库查看手机号是否存在意向单
////	@BeforeClass
////	public void 
//	
//	
//	/**
//	 * cases测试用例:输入意向单已经存在手机号
//     * 检查点:"调用异常,手机号已经存在意向单了！"
//	 * 
//	 */
//	@Test(priority=16)//(groups = { "BaseCase"})
//	public void CreateOrder_Repeat() throws IOException{
//		exp_msg="调用异常,手机号已经存在意向单了！";
//		q="{\"cityId\":\"565\",\"mobile\":\"13300010018\",\"vehicleModelId\":\"32699\",\"registerDate\":\"2017-1-10\",\"loanAmount\":\"100000\",\"term\":\"12\",\"invitationCode\":\"hz160000\",\"dealerName\":\"云联金服\"}";
//		resultCheck(q, exp_msg);
//		
//        }
//	/**
//	 * cases测试用例:输入意向单的手机号不经存在
//     * 检查点:"成功"返回单据信息
//	 * 
//	 */
//	@Test(priority=1)//(groups = { "BaseCase"})
//	public void CreateOrder_Succ() throws IOException{
//		exp_msg="成功";
//		q="{\"cityId\":\"565\",\"mobile\":\"13300010018\",\"vehicleModelId\":\"32699\",\"registerDate\":\"2017-1-10\",\"loanAmount\":\"100000\",\"term\":\"12\",\"invitationCode\":\"hz160000\",\"dealerName\":\"云联金服\"}";
//		resultCheck(q, exp_msg);
//        }
//	/**
//	 * cases测试用例:手机号为null
//     * 检查点:"手机号码不能为空"
//	 * 
//	 */
//	@Test(priority=2)//(groups = { "BaseCase"})
//	public void CreateOrder_IphoneNull() throws IOException{
//		exp_msg="手机号码不能为空";
//		q="{\"cityId\":\"565\",\"mobile\":\"\",\"vehicleModelId\":\"32699\",\"registerDate\":\"2017-1-10\",\"loanAmount\":\"100000\",\"term\":\"12\",\"invitationCode\":\"hz160000\",\"dealerName\":\"云联金服\"}";
//		resultCheck(q, exp_msg);
//		
//        }
//	/**
//     * cases测试用例:城市id为null，数据库不存在城市id
//     * 检查点:"城市id不能为空"
//     * 
//	 */
//	@Test(priority=3)//(groups = { "BaseCase"})
//	public void CreateOrder_CityNull() throws IOException{
//		exp_msg="城市id不能为空";
//		q="{\"cityId\":\"\",\"mobile\":\"13300010019\",\"vehicleModelId\":\"32699\",\"registerDate\":\"2017-1-10\",\"loanAmount\":\"100000\",\"term\":\"12\",\"invitationCode\":\"hz160000\",\"dealerName\":\"云联金服\"}";
//		resultCheck(q, exp_msg);
//		
//        }
//	/**
//     * cases测试用例:车型id为null，数据库不存在车型id
//     * 检查点:"车型id不能为空"
//     * 
//	 */
//	@Test(priority=4)//(groups = { "BaseCase"})
//	public void CreateOrder_ModelNull() throws IOException{
//		exp_msg="车型id不能为空";
//		q="{\"cityId\":\"565\",\"mobile\":\"13300010020\",\"vehicleModelId\":\"\",\"registerDate\":\"2017-1-10\",\"loanAmount\":\"100000\",\"term\":\"12\",\"invitationCode\":\"hz160000\",\"dealerName\":\"云联金服\"}";
//		resultCheck(q, exp_msg);
//		
//        }
//	/**
//	 * cases测试用例:登记日期为null
//     * 检查点:"登记日期不能为空"
//     * 
//	 */
//	@Test(priority=5)//(groups = { "BaseCase"})
//	public void CreateOrder_DateNull() throws IOException{
//		exp_msg="登记日期不能为空";
//		q="{\"cityId\":\"565\",\"mobile\":\"13300010021\",\"vehicleModelId\":\"32699\",\"registerDate\":\"\",\"loanAmount\":\"100000\",\"term\":\"12\",\"invitationCode\":\"hz160000\",\"dealerName\":\"云联金服\"}";
//		resultCheck(q, exp_msg);
//		
//        }
//	/**
//	 * cases测试用例:登记日期格式有误
//     * 检查点:"成功"
//     * 已经提bug
//	 */
//	@Test(priority=6)//(groups = { "BaseCase"})
//	public void CreateOrder_DateError() throws IOException{
//		exp_msg="成功";
//		q="{\"cityId\":\"565\",\"mobile\":\"13300010022\",\"vehicleModelId\":\"32699\",\"registerDate\":\"0000000000\",\"loanAmount\":\"100000\",\"term\":\"12\",\"invitationCode\":\"hz160000\",\"dealerName\":\"云联金服\"}";
//		resultCheck(q, exp_msg);
//		
//        }
//	/**
//	 * cases测试用例:不超过7年9个月，超出一天测试
//     * 检查点:"调用异常,登记日期不能超过7年9个月！"
//     * 
//	 */
//	@Test(priority=7)//(groups = { "BaseCase"})
//	public void CreateOrder_DateMore() throws IOException{
//		exp_msg="调用异常,登记日期不能超过7年9个月！";
//		q="{\"cityId\":\"565\",\"mobile\":\"13300010023\",\"vehicleModelId\":\"32699\",\"registerDate\":\"2009-08-17\",\"loanAmount\":\"100000\",\"term\":\"12\",\"invitationCode\":\"hz160000\",\"dealerName\":\"云联金服\"}";
//		resultCheck(q, exp_msg);
//		
//        }
//	/**
//	 * cases测试用例:等于7年9个月
//     * 检查点:"成功"
//	 */
//	@Test(priority=8)//(groups = { "BaseCase"})
//	public void CreateOrder_DateEqual() throws IOException{
//		exp_msg="成功";
//		q="{\"cityId\":\"565\",\"mobile\":\"13300010024\",\"vehicleModelId\":\"32699\",\"registerDate\":\"2009-08-18\",\"loanAmount\":\"100000\",\"term\":\"12\",\"invitationCode\":\"hz160000\",\"dealerName\":\"云联金服\"}";
//		resultCheck(q, exp_msg);
//		
//        }
//	/**
//	 * cases测试用例:贷款金额，贷款期限为null
//     * 检查点:
//     * 
//	 */
//	@Test(priority=9)//(groups = { "BaseCase"})
//	public void CreateOrder_MoneyNull() throws IOException{
//		exp_msg="成功";
//		q="{\"cityId\":\"565\",\"mobile\":\"13300010025\",\"vehicleModelId\":\"32699\",\"registerDate\":\"2009-08-18\",\"loanAmount\":\"\",\"term\":\"\",\"invitationCode\":\"hz160000\",\"dealerName\":\"云联金服\"}";
//		resultCheck(q, exp_msg);
//		
//        }
//	/**
//	 * cases测试用例:贷款金额，贷款期限为负数
//     * 检查点:
//     * 
//	 */
//	@Test(priority=10)//(groups = { "BaseCase"})
//	public void CreateOrder_MoneyNegative () throws IOException{
//		exp_msg="成功";
//		q="{\"cityId\":\"565\",\"mobile\":\"13300010026\",\"vehicleModelId\":\"32699\",\"registerDate\":\"2009-08-18\",\"loanAmount\":\"-100000\",\"term\":\"-12\",\"invitationCode\":\"hz160000\",\"dealerName\":\"云联金服\"}";
//		resultCheck(q, exp_msg);
//		
//        }
//	/**
//	 * cases测试用例:贷款金额，贷款期限正常输入
//     * 检查点:
//     * 
//	 */
//	@Test(priority=11)//(groups = { "BaseCase"})
//	public void CreateOrder_Money () throws IOException{
//		exp_msg="成功";
//		q="{\"cityId\":\"565\",\"mobile\":\"13300010027\",\"vehicleModelId\":\"32699\",\"registerDate\":\"2009-08-18\",\"loanAmount\":\"-100000\",\"term\":\"-12\",\"invitationCode\":\"hz160000\",\"dealerName\":\"云联金服\"}";
//		resultCheck(q, exp_msg);
//		
//        }
//	/**
//	 * cases测试用例:邀请码为null
//     * 检查点:
//     * 
//	 */
//	@Test(priority=12)//(groups = { "BaseCase"})
//	public void CreateOrder_CodeNull() throws IOException{
//		exp_msg="成功";
//		q="{\"cityId\":\"565\",\"mobile\":\"13300010028\",\"vehicleModelId\":\"32699\",\"registerDate\":\"2017-1-10\",\"loanAmount\":\"100000\",\"term\":\"12\",\"invitationCode\":\"\",\"dealerName\":\"云联金服\"}";
//		resultCheck(q, exp_msg);
//		
//        }
//	/**
//	 * cases测试用例:邀请码不存在
//     * 检查点:
//	 */
//	@Test(priority=13)//(groups = { "BaseCase"})
//	public void CreateOrder_CodeError() throws IOException{
//		exp_msg="成功";
//		q="{\"cityId\":\"565\",\"mobile\":\"13300010029\",\"vehicleModelId\":\"32699\",\"registerDate\":\"2017-1-10\",\"loanAmount\":\"100000\",\"term\":\"12\",\"invitationCode\":\"hz16777\",\"dealerName\":\"云联金服\"}";
//		resultCheck(q, exp_msg);
//		
//        }
//	/**
//	 * cases测试用例:经销商名称为null
//     * 检查点:
//	 */
//	@Test(priority=14)//(groups = { "BaseCase"})
//	public void CreateOrder_NameNull() throws IOException{
//		exp_msg="成功";
//		q="{\"cityId\":\"565\",\"mobile\":\"13300010030\",\"vehicleModelId\":\"32699\",\"registerDate\":\"2017-1-10\",\"loanAmount\":\"100000\",\"term\":\"12\",\"invitationCode\":\"hz160000\",\"dealerName\":\"\"}";
//		resultCheck(q, exp_msg);
//		
//        }
//	/**
//	 * cases测试用例:经销商名称不存在
//     * 检查点:
//	 */
//	@Test(priority=15)//(groups = { "BaseCase"})
//	public void CreateOrder_NameError() throws IOException{
//		exp_msg="成功";
//		q="{\"cityId\":\"565\",\"mobile\":\"13300010031\",\"vehicleModelId\":\"32699\",\"registerDate\":\"2017-1-10\",\"loanAmount\":\"100000\",\"term\":\"12\",\"invitationCode\":\"hz160000\",\"dealerName\":\"云联金服123\"}";
//		resultCheck(q, exp_msg);
//		
//        }
//	
//	 //////////////////////////////////////////////////////////////////////////
//	 public void resultCheck(String q_str, String exp_msg_str) throws IOException{
//		 //测试2
//		 //String interfaceUrl = "http://10.104.90.66/fcarpapi/resource/fcar/partner/createWishOrder";
//		 //预生产
//		 //String interfaceUrl = "http://10.204.41.67/fcarpapi/resource/fcar/partner/createWishOrder";
//		 String interfaceUrl = "http://fcaradminpre.10101111.com/ucarmapiproxy/resource/fcar/partner/createWishOrder";
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
//
//}