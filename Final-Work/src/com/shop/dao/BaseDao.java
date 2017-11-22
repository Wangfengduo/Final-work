package com.shop.dao;

import java.sql.Connection;
import java.sql.DriverManager;

public class BaseDao {
	public static Connection getCon() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/myweb?useUnicode=true&characterEncoding=UTF-8","root","");
			return con;
		}catch(Exception e) {
			e.printStackTrace();
			return null;
			
		}
	}
}
