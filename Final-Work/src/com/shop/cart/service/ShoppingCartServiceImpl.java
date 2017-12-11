package com.shop.cart.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shop.cart.dao.ShoppingCartDaoImpl;
import com.shop.entity.ShoppingCart;

@Service
public class ShoppingCartServiceImpl {
	@Autowired
	private ShoppingCartDaoImpl shoppingCartDaoImpl;
	
	public ShoppingCart getShoppingCart(int productId) {
		return shoppingCartDaoImpl.getShoppingCart(productId);
	}
	
	public List<ShoppingCart> getAllShoppingCat(){
		return shoppingCartDaoImpl.getAllShoppingCat();
	}
	
	public void addShoppingCart(ShoppingCart shoppingCart) {
		shoppingCartDaoImpl.addShoppingCart(shoppingCart);
	}
	
	public void deleteShoppingCart(int productId) {
		shoppingCartDaoImpl.deleteShoppingCart(productId);
	}
	
	public void updateShoppingCart(ShoppingCart shoppingCart) {
		shoppingCartDaoImpl.updateShoppingCart(shoppingCart);
	}
	
	
	
}
