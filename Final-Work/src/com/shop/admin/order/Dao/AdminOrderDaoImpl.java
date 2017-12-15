package com.shop.admin.order.Dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.shop.entity.Order;
@Repository
public class AdminOrderDaoImpl {
	@Autowired
	private SessionFactory sessionFactory;
	
	@SuppressWarnings("unchecked")
	public List<Order> queryForPage(int offset, int length) {
        // TODO Auto-generated method stub
        List<Order> list=null;
        try{
        	Session session = sessionFactory.getCurrentSession();
			Query query = session.createQuery("from Order");
            query.setFirstResult(offset);
            query.setMaxResults(length);
            list = query.list();
            
        }catch(RuntimeException re){
            throw re;
        }
        
        return list;
	 }
	
	@SuppressWarnings("unchecked")
	public int getAllRowCount() {
		List<Order> list=null;
		int count = 0;
        try{
        	Session session = sessionFactory.getCurrentSession();
			Query query = session.createQuery("from Order");
            list = query.list();
            count = list.size();
        }catch(RuntimeException re){
            throw re;
        }
		return count;
	 }
	
	@SuppressWarnings("unchecked")
	public List<Order> finishOrder(int offset, int length){
		Session session = sessionFactory.getCurrentSession();
		String sql = "from Order o where o.orderState = ?";
		Query query = session.createQuery(sql);
		query.setParameter(0, "�ȴ��̼Ҵ���");
		query.setFirstResult(offset);
        query.setMaxResults(length);
		List<Order> list = query.list();
		return list;
	 }
	
	@SuppressWarnings("unchecked")
	public int finishOrderCount() {
		Session session = sessionFactory.getCurrentSession();
		String sql = "from Order o where o.orderState = ?";
		Query query = session.createQuery(sql);
		query.setParameter(0, "�ȴ��̼Ҵ���");
		List<Order> list = query.list();
		int count = list.size();
		return count;
	 }	
	
	@SuppressWarnings("unchecked")
	public List<Order> deleteOrderList(int offset, int length){
		Session session = sessionFactory.getCurrentSession();
		String sql = "from Order o where o.orderState = ?";
		Query query = session.createQuery(sql);
		query.setParameter(0, "�����ѱ�ɾ��");
		query.setFirstResult(offset);
        query.setMaxResults(length);
		List<Order> list = query.list();
		return list;
	 }
	
	 @SuppressWarnings("unchecked")
	public int deleteOrderCount(){
			Session session = sessionFactory.getCurrentSession();
			String sql = "from Order o where o.orderState = ?";
			Query query = session.createQuery(sql);
			query.setParameter(0, "�����ѱ�ɾ��");
			List<Order> list = query.list();
			int count = list.size();
			return count;
		 }
	 
	 public boolean deleteOrder(int id) {
		 Session session = sessionFactory.getCurrentSession();
		 Order order = session.get(Order.class, new Integer(id));
		 session.delete(order);
		 return true;
	 }
	
}
