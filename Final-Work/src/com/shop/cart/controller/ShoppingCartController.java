package com.shop.cart.controller;




import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.shop.cart.service.ShoppingCartServiceImpl;



@Controller
@RequestMapping("/cart")
public class ShoppingCartController {
	
	@Resource
	private ShoppingCartServiceImpl shoppingCartServiceImpl;
	
	@RequestMapping("/shoppingCart")
	public String showShoppingCart(HttpSession session) {
		boolean result=shoppingCartServiceImpl.showShoppingCart(session);
		if(result) {
			return "shoppingCart";
		}
		return "shoppingCart";
	}
	
	@RequestMapping("/addshoppingCart")
	public String addShoppingCart(HttpSession session,HttpServletRequest request) {
		boolean result=shoppingCartServiceImpl.addShoppingCart(request, session);
		if(result) {
			return "shoppingCart";
		}
		return "shoppingCart";
	}
	 
	@RequestMapping("/deleteshoppingCart")
	public String deleteShoppingCart(HttpSession session) {
		boolean result=shoppingCartServiceImpl.deleteShoppingCart(session);
		if(result) {
			return "shoppingCart";
		}
		return "shoppingCart";
	}
	
	@RequestMapping("/deleteSomeone")
	public String deleteSomeone(HttpServletRequest request,HttpSession session) {
		boolean result=shoppingCartServiceImpl.deleteSomeone(request, session);
		if(result) {
			return "shoppingCart";
		}
		return "shoppingCart";
	}
	
}
