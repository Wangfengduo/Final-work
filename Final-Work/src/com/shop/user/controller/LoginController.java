package com.shop.user.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.shop.entity.LoginUser;
import com.shop.user.service.LoginServiceImpl;

@Controller
@RequestMapping("/loginuser")
public class LoginController {
	@Autowired
	@Resource
	private LoginServiceImpl LoginServiceImpl;
	
	@RequestMapping("/login")
	public String login(@RequestParam("loginName")String loginName,@RequestParam("password")String password,
			Model model,HttpSession session) {
		LoginUser lu=this.LoginServiceImpl.login(loginName,password);
		if(lu!=null) {
			session.setAttribute("lu", lu);
			return "main";
		}else {
			model.addAttribute("errorinfo","账号密码不正确");
			return "index";
		}
	}
}
