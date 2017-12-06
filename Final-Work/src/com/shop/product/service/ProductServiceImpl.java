package com.shop.product.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.shop.entity.Product;
import com.shop.product.dao.ProductDaoImpl;


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
	
	public void deleteProduct(int id) {
		ProductDaoImpl pd=new ProductDaoImpl();
		pd.delProduct(id);
	}
	
	public void updateProduct(Product p) {
		ProductDaoImpl pd=new ProductDaoImpl();
		pd.updateProduct(p);
	}
}
