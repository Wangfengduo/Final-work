package com.shop.product.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.shop.entity.Product;
import com.shop.product.dao.ProductDaoImpl;


@Service
@Transactional(readOnly=false)
public class ProductServiceImpl {
	
	@Resource
	private ProductDaoImpl productDaoImpl;
	
	
	public void addProduct(Product p){
		this.productDaoImpl.saveProduct(p);
	}
	
	public List<Product> listProducts(){
		List<Product> list=this.productDaoImpl.findAll();
		return  list;
	}
	
	public void deleteProduct(Product p) {
		
		this.productDaoImpl.delProduct(p);
	}
	
	public void updateProduct(Product p) {
		
		this.productDaoImpl.updateProduct(p);
	}
}
