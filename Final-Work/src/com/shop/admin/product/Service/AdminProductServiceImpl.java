package com.shop.admin.product.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.shop.entity.Product;
import com.shop.product.dao.ProductDaoImpl;
import com.shop.producttype.dao.ProductTypeDaoImpl;

@Service
@Transactional
public class AdminProductServiceImpl {
	@Autowired
	private ProductDaoImpl productDaoImpl;
	@Autowired
    private ProductTypeDaoImpl productTypeDaoImpl;
    
    public void deleteBook(int id) {
		Product pd = productDaoImpl.findById(id);
		this.productDaoImpl.delProduct(pd);;
	}

    public void addProduct(Product p){
		this.productDaoImpl.saveProduct(p);
	}
    
    public void updateProduct(Product p) {
		
		this.productDaoImpl.updateProduct(p);
	}
}
