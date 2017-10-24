package com.chuanglan.demo;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.alibaba.fastjson.JSON;
import com.chuanglan.sms.request.SmsSendRequest;
import com.chuanglan.sms.response.SmsSendResponse;
import com.chuanglan.sms.util.ChuangLanSmsUtil;
import com.huluwa.cc.testapi.module.AjaxResult;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 
 * @author tianyh 
 * @Description:普通短信发送
 * mobile:手机号
 * password :密码
 * idcode :验证码
 *
 */
@Controller
@RequestMapping("/ChuangLanDemo")
public class SmsSendDemo {

	public static final String charset = "utf-8";
	// 用户平台API账号(非登录账号,示例:N1234567)
	public static String account = "";
	// 用户平台API密码(非登录密码)
	public static String pswd = "";

	@RequestMapping("/SendMessage")
	public AjaxResult getMessage(String mobile,String password){

		AjaxResult res=new AjaxResult();

		//请求地址请登录253云通讯自助通平台查看或者询问您的商务负责人获取
		String smsSingleRequestServerUrl = "";
		// 短信内容
		List<Integer> list = new ArrayList<>();
		Random rand = new Random();
		for(int i = 0; i < 1; i++)
			while(!list.add(rand.nextInt(900000)+1));
		String msg="【葫芦娃签】你好,你的验证码是";
		for (Integer integer : list) {
			 msg +=integer;
		}
		//手机号码
		String phone = mobile;
		//状态报告
		String report= "true";
		
		SmsSendRequest smsSingleRequest = new SmsSendRequest(account, pswd, msg, phone,report);
		
		String requestJson = JSON.toJSONString(smsSingleRequest);
		
		System.out.println("before request string is: " + requestJson);
		
		String response = ChuangLanSmsUtil.sendSmsByPost(smsSingleRequestServerUrl, requestJson);
		
		System.out.println("response after request result is :" + response);
		
		SmsSendResponse smsSingleResponse = JSON.parseObject(response, SmsSendResponse.class);
		
		System.out.println("response  toString is :" + smsSingleResponse);

		return res;

	}

}
