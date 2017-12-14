package com.shop.order_detail.service;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shop.entity.Order_detail;
import com.shop.entity.Product;
import com.shop.order_detail.dao.Order_detailDaoImpl;
import com.shop.product.dao.ProductDaoImpl;

@Service
public class Order_detailServiceImpl {
	@Autowired
	private Order_detailDaoImpl order_detailDaoImpl;
	@Autowired
	private ProductDaoImpl productDaoImpl;
	
	@SuppressWarnings("unchecked")
	public boolean saveOrder_detail(int order_id,HttpSession session) {
		List<Product> list =(List<Product>) session.getAttribute("shoppingList");
		for(Product pd1:list) {
			Product pd=productDaoImpl.selectProduct(pd1.getName());
			@SuppressWarnings("unused")
			boolean result=order_detailDaoImpl.saveOrder_detail(order_id,pd.getId());
		}
		return true;
	}
	
	
	public boolean selectOrder_detail(HttpServletRequest request,HttpSession session) {
		String orderId=request.getParameter("orderId");
		int id=Integer.parseInt(orderId);
		List<Order_detail> list=order_detailDaoImpl.selectOrder_detail(id);
		ArrayList<String>  str = new ArrayList<String> ();
		for(Order_detail order_detail:list) {
			Product pd=productDaoImpl.findById(order_detail.getProduct_id());
			str.add(pd.getName());
		}
		session.setAttribute("str", str);
		session.setAttribute("id", id);
		return true;
	}
	
}
