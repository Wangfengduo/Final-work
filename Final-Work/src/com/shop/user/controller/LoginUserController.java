package com.shop.user.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.shop.entity.LoginUser;
import com.shop.user.service.LoginUserServiceImpl;

@Controller
@RequestMapping("/user")
public class LoginUserController {
	@Resource
	private LoginUserServiceImpl LoginUserServiceImpl;
	
	@RequestMapping("/login")
	public String login(@RequestParam("loginName") String loginName,
			@RequestParam("password") String password,
			Model model, HttpSession session){
		LoginUser lu=this.LoginUserServiceImpl.login(loginName, password);
		if(lu!=null){
			session.setAttribute("lu", lu);
			return "main";
		}else{
			model.addAttribute("errorinfo", "您的账号密码不正确！");
			return "login";
		}
	}

}
