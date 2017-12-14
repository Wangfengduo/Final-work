package com.shop.order_detail.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.shop.order_detail.service.Order_detailServiceImpl;

@Controller
public class Order_detailController {
	@Autowired
	private Order_detailServiceImpl order_detailSericeImpl;
	
	@SuppressWarnings("unused")
	@RequestMapping("/showOrder")
	public String selectOder_detail(HttpServletRequest request,HttpSession session) {
		boolean result = order_detailSericeImpl.selectOrder_detail(request, session);
		return "showOrder";
	}
}
