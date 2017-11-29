package com.shop.user.dao;

import javax.annotation.Resource;

import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import com.shop.entity.LoginUser;

@Repository
public class LoginDaoImpl {
	@Resource
	private SessionFactory sessionFactory;
	
	public LoginUser findById(String loginName) {
		LoginUser lu=this.sessionFactory.getCurrentSession().get(LoginUser.class,loginName);
		return lu;
	}
}
