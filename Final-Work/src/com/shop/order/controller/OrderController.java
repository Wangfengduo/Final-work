package com.shop.order.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.shop.entity.Order;
import com.shop.order.service.OrderServiceImpl;
import com.shop.order_detail.service.Order_detailServiceImpl;


@Controller
public class OrderController {
	@Resource
	private OrderServiceImpl orderServiceImpl;
	@Resource
	private Order_detailServiceImpl order_detailServiceImpl;
	
	@RequestMapping("/order")
	public String orderInfo(HttpServletRequest request,HttpSession session) {
		boolean result=orderServiceImpl.orderInfo(session, request);
		if (result) {
			return "order";
		}else {
			return "error1";
		}
	}
	
	//生成订单
	@SuppressWarnings("unused")
	@RequestMapping("/addOrder")
	public String saveOrder(HttpServletRequest request,HttpSession session) {
		boolean result =orderServiceImpl.saveOrder(session);
		Order order=orderServiceImpl.select();
		boolean result1=order_detailServiceImpl.saveOrder_detail(order.getOrderId(), session);
		return "success1";
	}
	
	@RequestMapping("/orderInfo")
	public String selectOrder(HttpSession session) {
		boolean result=orderServiceImpl.selectOrder(session);
		if(result) {
    		return "orderInfo";
    	} else {
    		return "error2";
    	}
	}
	
	@SuppressWarnings("unused")
	@RequestMapping("/deleteOrder")
	public String deleteOrder(HttpServletRequest request , HttpSession session) {
		boolean result=orderServiceImpl.deleteOrder(request, session);
		return"orderInfo";
		
	}
	
	
	//取消订单
	@SuppressWarnings("unused")
	@RequestMapping("/changeState")
	 public String changeState(HttpServletRequest request ,HttpSession session) {
		boolean result=orderServiceImpl.changeState(request, session);
		return"success2";
	}
	
	
}
