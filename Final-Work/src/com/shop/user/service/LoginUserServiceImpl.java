package com.shop.user.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.shop.entity.LoginUser;
import com.shop.user.dao.LoginUserDaoImpl;

@Service
@Transactional(readOnly=true)
public class LoginUserServiceImpl {
	
	@Resource
	private LoginUserDaoImpl loginUserDaoImpl;
	
	public LoginUser login(String name, String pwd){
		LoginUser lu=this.loginUserDaoImpl.findByName(name);
		if(lu!=null){
			if(lu.getPassword().equals(pwd)){
				return lu;
			}else{
				return null;
			}
		}else{
			return null;
		}
	}
}
