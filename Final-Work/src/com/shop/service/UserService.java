package com.shop.service;

import com.shop.entity.User;

public interface UserService{
	public void login(User user)throws MyException;
}
