package com.shop.cart.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.shop.cart.service.ShoppingCartServiceImpl;

@Controller
public class ShoppingCartController {
	@Autowired
	private ShoppingCartServiceImpl shoppingCartServiceImpl;
	
	@RequestMapping("/user/shoppingCart")
	//展示购物车
	public String showShoppingCart(HttpSession session) {
		boolean result=shoppingCartServiceImpl.showShoppingCart(session);
		if(result) {
			return "user/shoppingCart";
		}
		return "user/shoppingCart";
	}
	
	@RequestMapping("/user/addshoppingCart")
	//添加购物车
	public String addshoppingCart(HttpSession session,HttpServletRequest request ) {
		boolean result=shoppingCartServiceImpl.addShoppingCart(request, session);
		
		if(result) {
			return "user/shoppingCart";
		}
		return "user/shoppingCart";
	}
	
	@RequestMapping("/user/clearshoppingCart")
	//删除
	public String clearshoppingCart(HttpSession session) {
		boolean result=shoppingCartServiceImpl.clearShoppingCart(session);
		if (result) {
			return "user/shoppingCart";
		}
		return "user/shoppingCart";
	}
	
	
	@RequestMapping("/user/clearsomeone")
	//删除部分
	public String clearSomeone(HttpServletRequest request,HttpSession session) {
		boolean result=shoppingCartServiceImpl.clearSomeone(request,session);
		if (result) {
			return "user/shoppingCart";
		}
		return "user/shoppingCart";
	}
	
	
}
