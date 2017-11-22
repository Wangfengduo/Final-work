package com.shop.service;

import org.springframework.jdbc.core.support.JdbcDaoSupport;

import com.shop.dao.UserDao;
import com.shop.dao.UserDaoImpl;
import com.shop.entity.User;


public class UserServiceImpl extends JdbcDaoSupport implements UserService{

	 public void login(User user)throws MyException {
	        UserDao dao = new UserDaoImpl();
	        String username=user.getUserName();
	        User loginUser=new User();
	        loginUser = dao.findByName(username);
	        if(loginUser.getUserName()==null){
	            throw new MyException("用户名不存在！");
	        }
	        if(!user.getPassword().equals(loginUser.getPassword())) {
	            throw new MyException("密码错误！");
	        }
	 }
	 
	 
	 
	 
}