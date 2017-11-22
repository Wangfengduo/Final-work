package com.shop.entity;

import java.util.HashSet;
import java.util.Set;


public class User {
	 private int id;
	    private String userName;
	    private String password;
	    private String email;
		private Set orderSet = new HashSet<Order>();

	    public int getId() {
	        return id;
	    }

	    public void setId(int id) {
	        this.id = id;
	    }

	    public String getUserName() {
	        return userName;
	    }

	    public void setUserName(String userName) {
	        this.userName = userName;
	    }

	    public String getPassword() {
	        return password;
	    }

	    public void setPassword(String password) {
	        this.password = password;
	    }
	    
	    public String getEmail() {
			return email;
		}

		public void setEmail(String email) {
			this.email = email;
		}

	    public Set getOrderSet() {
	        return orderSet;
	    }

	    public void setOrderSet(Set orderSet) {
	        this.orderSet = orderSet;
	    }

}
