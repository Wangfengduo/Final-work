package com.shop.product.service;

import java.util.List;

import com.shop.entity.Product;
import com.shop.product.dao.ProductDaoImpl;

public class ProductServiceImpl {
	
	public void addProduct(Product p){
		ProductDaoImpl pdi=new ProductDaoImpl();
		pdi.saveProduct(p);
	}
	
	public List<Product> listProducts(){
		return new ProductDaoImpl().findAll();
	}
	
	
	public boolean deleteProduct(int id) {
		return new ProductDaoImpl().delProduct(id);
	}
	public boolean updateProduct(Product p) {
		return true;
	}
}
