package com.shop.dao;

import com.shop.entity.User;

public interface UserDao {
	public User findByName(String username);
}
