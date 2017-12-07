package com.shop.producttype.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.shop.entity.ProductType;

import com.shop.producttype.dao.ProductTypeDaoImpl;

@Service
@Transactional(readOnly=false)
public class ProductTypeServiceImpl {
	
	@Resource
	private ProductTypeDaoImpl productTypeDaoImpl;
	public List<ProductType> listTypes(){
		List<ProductType> list=	this.productTypeDaoImpl.findAll();
		return list;
	}
}
