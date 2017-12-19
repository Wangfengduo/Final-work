package com.shop.admin.product.Service;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import com.shop.entity.Product;
import com.shop.product.dao.ProductDaoImpl;
import com.shop.producttype.dao.ProductTypeDaoImpl;


@Service
@Transactional
public class AdminProductService {
	@Autowired
	private ProductDaoImpl productDaoImpl;
	@Autowired
	private ProductTypeDaoImpl productTypeDaoImpl;
	
	public void deleteProduct(Product p) {
		this.productDaoImpl.delProduct(p);
	}
	
	public void updateProduct(Product p) {
		
		this.productDaoImpl.updateProduct(p);
	}
	
	public void addProduct(Product p){
		this.productDaoImpl.saveProduct(p);
	}
	
	
	public boolean saveProductType(String name) {
		boolean result = productTypeDaoImpl.save(name);
		return result;
	}
	
	
	public boolean selectProduct(HttpSession session,String name) {
		Product pd=this.productDaoImpl.selectProduct(name);
		session.setAttribute("product", pd);
		return true;
	}
	
	
	public List<Product> listProducts(){
		List<Product> list=this.productDaoImpl.findAll();
		return  list;
	}
	
}
