package com.shop.product.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.shop.entity.Product;
import com.shop.product.dao.ProductDaoImpl;
import com.shop.user.dao.LoginUserDaoImpl;

@Service
@Transactional(readOnly=true)
public class ProductServiceImpl {
	
	@Resource
	private ProductDaoImpl productDaoImpl;
	public void addProduct(Product p){
		
		this.productDaoImpl.saveProduct(p);
	}
	
	public List<Product> listProducts(){
		return new ProductDaoImpl().findAll();
	}
	
	
	public boolean deleteProduct(int id) {
		//return new ProductDaoImpl().delProduct(id);
		return true;
	}
	public boolean updateProduct(Product p) {
		return true;
	}
}
