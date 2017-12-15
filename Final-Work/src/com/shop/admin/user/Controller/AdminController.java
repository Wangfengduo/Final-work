package com.shop.admin.user.Controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.shop.admin.user.Service.AdminServiceImpl;

@Controller
public class AdminController {
	@Resource
	private AdminServiceImpl adminSericeImpl;
	
	@RequestMapping("admin/loginCheck")
	public String loginCheck(HttpSession session,String username,String password,String verification) {
		String result = adminSericeImpl.loginCheck(session,username, password,verification);
		if(result.equals("yes")) {
			return "admin/index";
		}else if(result.equals("no2")){
			return "admin/error";
		}else {
			return "admin/error3";
		}
	}
	
	@RequestMapping("admin/register")
	public String register(String username,String password,String newpassword) {
		String result = adminSericeImpl.register(username, password, newpassword);
		if(result.equals("error1")) {
			return "admin/error1";
		}else if(result.equals("error2")){
			return "admin/error2";
		}else if(result.equals("error7")){
			return "admin/error7";
		}else {
			return "admin/success";
		}
		
	}
	
	@RequestMapping("admin/changePwd")
	public String changePwd(HttpSession session,String password,String newpassword,String newpwd) {
		String string = adminSericeImpl.changePwd(session, password, newpassword, newpwd);
		if(string.equals("error4")) {
			return "admin/error4";
		}else if(string.equals("error5")) {
			return "admin/error5";
		}else {
			return "admin/success1";
		}
	}
	
	
}
