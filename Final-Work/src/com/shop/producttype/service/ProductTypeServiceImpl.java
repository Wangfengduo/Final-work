package com.shop.producttype.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.shop.entity.ProductType;
import com.shop.producttype.dao.ProductTypeDaoImpl;

@Service
public class ProductTypeServiceImpl {
	
	public List<ProductType> listTypes(){
		ProductTypeDaoImpl pdi=new ProductTypeDaoImpl();
		return pdi.findAll();
	}
}
