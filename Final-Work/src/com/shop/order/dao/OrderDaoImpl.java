package com.shop.order.dao;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import org.springframework.stereotype.Repository;

import com.shop.entity.LoginUser;
import com.shop.entity.Order;
import com.shop.user.dao.LoginUserDaoImpl;


@Repository
public class OrderDaoImpl {
	@Resource
	private SessionFactory sessionFactory;
	@Resource
	private LoginUserDaoImpl loginUserDaoImpl;
	
	public boolean saveOrder(HttpSession session) {
		Session session1=sessionFactory.getCurrentSession();
		LoginUser lu=(LoginUser) session.getAttribute("lu");
		LoginUser user=new LoginUser();
		user=loginUserDaoImpl.getSome(lu.getLoginName());
		Date date = new Date();
		SimpleDateFormat ft =  new SimpleDateFormat ("yyyy.MM.dd");
		String Time = ft.format(date);
		String orderState = "1";
		Order order = new Order();
		order.setUser(user);
		order.setOrderTime(Time);
		order.setOrderState(orderState);
		session1.save(order);
		
		return true;
	}
	
	
	@SuppressWarnings("unchecked")
	public boolean selectOrder(HttpSession session) {
		Session session1=sessionFactory.getCurrentSession();
		LoginUser lu=(LoginUser) session.getAttribute("lu");
		LoginUser user=new LoginUser();
		user=loginUserDaoImpl.getSome(lu.getLoginName());
		
		String sql="from Order o where o.user=?";
		Query query = session1.createQuery(sql);
		query.setParameter(0, user);
		List<Order> list = query.list();
		if(list.size() != 0) {
			session.setAttribute("OrderInfoList", list);
			return true;
		}else {
			return false;
		}
	}
	
	public boolean deleteOrder(Integer id) {
		Session session = sessionFactory.getCurrentSession();
		Order order = session.get(Order.class, new Integer(id));
		session.delete(order);
		return true;
	}
	
	@SuppressWarnings("unchecked")
	public boolean changeState(int orderId) {
		Session session = sessionFactory.getCurrentSession();
		String sql = "from Order o where o.orderId = ?";
		Query query = session.createQuery(sql);
		query.setParameter(0, orderId);
		List<Order> list = query.list();
		Order order = null;
		for(Order order1:list) {
			order = order1;
		}
		order.setOrderState("");
		session.update(order);
		return true;
	}
	
	
	@SuppressWarnings("unchecked")
	public Order select() {
		Session session = sessionFactory.getCurrentSession();
		String sql = "from Order";
		Query query = session.createQuery(sql);
		List<Order> list = query.list();
		Order order = null;
		for(Order order1:list) {
			order = order1;
		}
		return order;
	}
	
	public Order someOneOrder(Integer id) {
		Session session = sessionFactory.getCurrentSession();
		Order order = session.get(Order.class, new Integer(id));
		return order;
	}
	
	
}
