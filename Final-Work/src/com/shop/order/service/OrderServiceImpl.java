package com.shop.order.service;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;


import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.shop.entity.LoginUser;
import com.shop.entity.Order;
import com.shop.entity.Product;
import com.shop.order.dao.OrderDaoImpl;
import com.shop.user.dao.LoginUserDaoImpl;


@Service
@Transactional
public class OrderServiceImpl {
	@Resource
	private LoginUserDaoImpl loginUserDaoImpl;
	@Resource
	private OrderDaoImpl orderDaoImpl;
	
	@SuppressWarnings("unchecked")
	public boolean orderInfo(HttpSession session,HttpServletRequest request) {
		ArrayList<Product> list=(ArrayList<Product>)session.getAttribute("shoppingList");
		if(list!=null) {
			String username=(String) session.getAttribute("username");
			LoginUser user=loginUserDaoImpl.getSome(username);
			String telephone=user.getTelephone();
			String address=user.getAddress();
			session.setAttribute("username", username);
			session.setAttribute("telephone", telephone);
			session.setAttribute("address", address);
			String[] num = request.getParameterValues("number");
		    session.setAttribute("num", num);
			session.setAttribute("list",list);
			return true;
		}else {
			return false;
		}
	}
	
	public boolean saveOrder(HttpSession session) {
		boolean result=orderDaoImpl.saveOrder(session);
		return result;
	}
	
	public boolean selectOrder(HttpSession session) {
		boolean result=orderDaoImpl.selectOrder(session);
		if(result) {
			return true;
		}else {
			return false;
		}
	}
	
	@SuppressWarnings("unchecked")
	public boolean deleteOrder(HttpServletRequest request ,HttpSession session) {
		String orderId=request.getParameter("orderId");
		int id=Integer.parseInt(orderId);
		List<Order> list = (List<Order>) session.getAttribute("OrderInfoList");
		int i = 0;
		for(Order order:list) {
			if(order.getOrderId() == id) {
				break;
			}
			i++;
		}
		list.remove(i);
		session.setAttribute("OrderInfoList", list);
		boolean result = orderDaoImpl.deleteOrder(id);
		return result;
	}
	
	public boolean changeState(HttpServletRequest request ,HttpSession session) {
		String orderId = request.getParameter("orderId");
		int id = Integer.parseInt(orderId);
		boolean result = orderDaoImpl.changeState(id);
		return result;
	}
	
	public Order select() {
		Order order = orderDaoImpl.select();
		return order;
	}
	
}
