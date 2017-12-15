package com.shop.admin.user.Service;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Service;

import com.shop.admin.entity.Admin;
import com.shop.admin.user.Dao.AdminDaoImpl;
@Service
public class AdminServiceImpl {
	@Resource
	private AdminDaoImpl adminDaoImpl;
	
	public String loginCheck(HttpSession session,String username,String password,String verification) {
		String rand = (String)session.getAttribute("rand");
		Admin result = adminDaoImpl.loginCheck(username, password);
		if(result != null && verification.equals(rand)) {
			session.setAttribute("admin_username", result.getAdmin_username());
			return "yes";
		}else if(!verification.equals(rand)){
			return "no1";
		}else {
			return "no2";
		}
	}
	
	
	public String register(String username,String password,String newpassword) {
		Admin admin = adminDaoImpl.loginCheck(username, password);
		if(admin != null) {
			return "error1";
		}else if(!password.equals(newpassword)){
			return "error2";
		}else if(username == "" || password == "") {
			return "error7";
		}else{
			@SuppressWarnings("unused")
			boolean result = adminDaoImpl.register(username, password);
			return "success";
		}
	}
	
	public String changePwd(HttpSession session,String password,String newpassword,String newpwd) {
		String admin_username = (String) session.getAttribute("admin_username");
		Admin admin = adminDaoImpl.getSome(admin_username);
		if(!admin.getAdmin_password().equals(password)) {
			return "error4";
		}else if(!newpassword.equals(newpwd)) {
			return "error5";
		}else {
			@SuppressWarnings("unused")
			boolean result = adminDaoImpl.changePwd(admin, newpassword);
			return "success";
		}
	}
	
	
	
	
	
	
	
	
}
