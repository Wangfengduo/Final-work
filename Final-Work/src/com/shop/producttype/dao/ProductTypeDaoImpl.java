package com.shop.producttype.dao;


import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import com.shop.entity.ProductType;

@Repository
public class ProductTypeDaoImpl {
	
	@Resource
	private SessionFactory sessionFactory;
	
	 @SuppressWarnings("unchecked")
	public List<ProductType> findAll(){
		Query query = sessionFactory.getCurrentSession().createQuery("from ProductType");  
       
		List<ProductType> list = query.list();  
        return list;  
	}
	 
	 public ProductType selectType_id(String type_name) {
			Session session = sessionFactory.getCurrentSession();
			String sql = "from ProductType b where b.name = ?";
			Query query = session.createQuery(sql);
			query.setParameter(0, type_name);
			ProductType productType = (ProductType) query.uniqueResult();
			return productType;
		}
	 
	 public boolean save(String name) {
			Session session = sessionFactory.getCurrentSession();
			ProductType productType = new ProductType();
			productType.setName(name);
			session.save(productType);
			return true;
		}
	 
	 @SuppressWarnings("unchecked")
	public List<ProductType> select(){
			Session session = sessionFactory.getCurrentSession();
			String sql = "from ProductType";
			Query query = session.createQuery(sql);
			List<ProductType> list = query.list();
			return list;
		}
	 
}
