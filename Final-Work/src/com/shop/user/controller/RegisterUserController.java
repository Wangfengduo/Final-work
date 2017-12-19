package com.shop.user.controller;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.shop.entity.LoginUser;
import com.shop.entity.RegisterUser;


@Controller
@RequestMapping("/user")
public class RegisterUserController {
	@RequestMapping(value="/register",method=RequestMethod.GET)
	public String toRegister(Model model) {
		model.addAttribute("user",new RegisterUser());
		return "login";
	}
	
	@RequestMapping(value="/register",method=RequestMethod.POST)
	public String register(@Valid RegisterUser user, BindingResult bindingResult,
			HttpSession session, Model model) {
		if(bindingResult.hasErrors()){
			model.addAttribute("user", user);
			return "register";
		}else{
			session.setAttribute("user", user);
			return "login";
		}
	}
}
