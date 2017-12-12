package com.shop.cart.service;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Service;

import com.shop.entity.Product;

@Service
public class ShoppingCartServiceImpl {
	
	@SuppressWarnings("unchecked")
	public boolean showShoppingCart(HttpSession session) {
		List<Product> shoppingList=(List<Product>)session.getAttribute("shoppingList");
		if(shoppingList==null) {
			String srg="购物车为空";
			session.setAttribute("srg", srg);
		}else {
			session.setAttribute("shoppingList", shoppingList);
		}
		return true;
	}
	
	@SuppressWarnings("unchecked")
	public boolean addShoppingCart(HttpServletRequest request,HttpSession session) {
		String productname=request.getParameter("ProductName");
		String productprice=request.getParameter("ProductPrice");
		List<Product> list=(List<Product>) session.getAttribute("shoppingList");
		Product pd=new Product();
		if(list==null) {
			list=new ArrayList<Product>();
			pd.setName(productname);
			pd.setPrice(productprice);
			list.add(pd);
			session.setAttribute("shoppingList", list);
			return true;
		}else {
			pd.setName(productname);
			pd.setPrice(productprice);
			list.add(pd);
			session.setAttribute("shoppingList", list);
			return true;
		}
	}
	
	@SuppressWarnings("unchecked")
	public boolean deleteShoppingCart(HttpSession session) {
		List<Product> list=(List<Product>) session.getAttribute("shoppingList");
		if(list.size()!=0) {
			list.clear();
			session.setAttribute("shoppingList", list);
		}
		return true;
		
	}
	
	@SuppressWarnings("unchecked")
	public boolean deleteSomeone(HttpServletRequest request,HttpSession session) {
		String productname=request.getParameter("ProductName");
		List<Product> list=(List<Product>) session.getAttribute("shoppingList");
		int i=0;
		for(Product pd:list) {
			if(pd.getName().equals(productname)) {
				break;
			}
			i++;
		}
		list.remove(i);
		session.setAttribute("shoppingList", list);
		return true;
		
	}
	
	
}
