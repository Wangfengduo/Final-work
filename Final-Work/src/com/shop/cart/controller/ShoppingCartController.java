package com.shop.cart.controller;


import javax.servlet.http.HttpServlet;
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
	
	@RequestMapping("/shoppingCart")
	public String showShoppingCart(HttpSession session) {
		boolean result=shoppingCartServiceImpl.showShoppingCart(session);
		if(result) {
			return "shoppingCart";
		}
		return "shoppingCart";
	}
	
	@RequestMapping("/addshoppingCart")
	public String addShoppingCart(HttpSession session,HttpServlet request) {
		boolean result=shoppingCartServiceImpl.showShoppingCart(session);
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
