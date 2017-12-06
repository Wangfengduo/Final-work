package com.shop.producttype.dao;


import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import com.shop.entity.ProductType;

@Repository
public class ProductTypeDaoImpl {
	
	@Resource
	private SessionFactory sessionFactory;
	
	@SuppressWarnings("unchecked")
	public List<ProductType> findAll(){
		Query query = sessionFactory.getCurrentSession().createQuery("from Producttype");  
        List<ProductType> list = query.list();  
        return list;  
	}
}
