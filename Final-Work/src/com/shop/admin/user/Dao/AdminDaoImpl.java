package com.shop.admin.user.Dao;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import com.shop.admin.entity.Admin;

@Repository
public class AdminDaoImpl {
	@Resource
	private SessionFactory sessionFactory;
	
	@SuppressWarnings("unchecked")
	public Admin loginCheck(String username,String password) {
		Session session = sessionFactory.getCurrentSession();
		String sql = "from Admin a where a.admin_username = ? and a.admin_password = ?";
		Query query = session.createQuery(sql);
		query.setParameter(0, username);
		query.setParameter(1, password);
		List<Admin> list = query.list();
		Admin admin = null;
		if(list.size() != 0) {
			for(Admin admin2:list) {
				admin = admin2;
			}
			return admin;
		}else {
			return null;
		}
	}
	
	public boolean register(String username,String password) {
		Session session = sessionFactory.getCurrentSession();
		Admin admin = new Admin();
		admin.setAdmin_username(username);
		admin.setAdmin_password(password);
		session.save(admin);
		return true;
	}
	
	
	
	@SuppressWarnings("unchecked")
	public Admin getSome(String admin_username) {
		Session session = sessionFactory.getCurrentSession();
		String sql = "from Admin a where a.admin_username = ?";
		Query query = session.createQuery(sql);
		query.setParameter(0, admin_username);
		List<Admin> list = query.list();
		Admin admin = null;
		if(list.size() != 0) {
			for(Admin admin2:list) {
				admin = admin2;
			}
			return admin;
		}else {
			return null;
		}
	}
	
	
	
	public boolean changePwd(Admin admin,String password) {
		Session session = sessionFactory.getCurrentSession();
		admin.setAdmin_password(password);
		session.update(admin);
		return true;
	}
	
	
	
	
	
	
	
	
	
	
	
}
