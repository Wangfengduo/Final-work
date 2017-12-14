package com.shop.order_detail.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.shop.entity.Order_detail;



@Repository
public class Order_detailDaoImpl {
	@Autowired
	private SessionFactory sessionFactory;
	
	public boolean saveOrder_detail(int order_id,Integer product_id) {
		Session session = sessionFactory.getCurrentSession();
		Order_detail order_detail = new Order_detail();
		order_detail.setOrder_id(order_id);
		order_detail.setProduct_id(product_id);
		session.save(order_detail);
		return true;
	}
	
	@SuppressWarnings("unchecked")
	public List<Order_detail> selectOrder_detail(Integer order_id) {
		Session session = sessionFactory.getCurrentSession();
		String sql = "from Order_detail o where o.order_id = ?";
		Query query = session.createQuery(sql);
		query.setParameter(0, order_id);
		List<Order_detail> list = query.list();
		return list;
	}
	
	
	
	
}
