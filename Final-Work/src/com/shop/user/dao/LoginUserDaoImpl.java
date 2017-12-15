package com.shop.user.dao;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import org.springframework.stereotype.Repository;

import com.shop.entity.LoginUser;


@Repository
public class LoginUserDaoImpl{

	@Resource
	private SessionFactory sessionFactory;
	
	
	
	public LoginUser findByName(String loginName) {
		LoginUser lu=this.sessionFactory.getCurrentSession().get(LoginUser.class, loginName);
		return lu;
	}
	
	@SuppressWarnings("unchecked")
	public LoginUser getSome(String username) {
		Session session = sessionFactory.getCurrentSession();
		String sql="from LoginUser u where u.loginName = ?";
		Query query = session.createQuery(sql);
		query.setParameter(0, username);
		List<LoginUser> list = query.list();
		LoginUser user = new LoginUser();
		for(LoginUser user1 : list) {
			user = user1;
		}
		return user;
	}
	
}
