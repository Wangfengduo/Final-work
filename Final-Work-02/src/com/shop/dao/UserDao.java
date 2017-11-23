package com.shop.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.shop.entity.User;
import com.shop.dao.BaseDao;

public class UserDao{
	public User findByName(String username) {
		Connection con=BaseDao.getCon();
		String sql="select * from user where username=?";
		User user=new User();
		try {
			PreparedStatement pstm=con.prepareStatement(sql);
			pstm.setString(1,username);
			ResultSet rs = pstm.executeQuery();
			if(rs.next()) {        //将查询到的数据存入User对象，如果没有返回一个空的对象，表示用户不存在
                user.setId(rs.getInt("id"));
                user.setUserName(rs.getString("username"));
    	        user.setEmail(rs.getString("email"));
    	        user.setPassword(rs.getString("password"));
            }
            pstm.close();
            con.close(); //关闭连接
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return user;
	}
	
	public User getUser(String email)
	  {
	    Connection con = BaseDao.getCon();
	    ResultSet rs = null;
	    User user = new User();
	    String sql = "select * from user where email=?";
	    try
	    {
	      PreparedStatement pstm = con.prepareStatement(sql);
	      pstm.setString(1, email);
	      rs = pstm.executeQuery();
	      while (rs.next())
	      {
	    	user.setId(rs.getInt("id"));
	        user.setUserName(rs.getString("username"));
	        user.setEmail(rs.getString("email"));
	        user.setPassword(rs.getString("password"));
	      }
	    }
	    catch (SQLException e)
	    {
	      e.printStackTrace();
	    }
	    return user;
	  }

	  public boolean addUser(User user){
		  boolean flag = false;
		  Connection conn = BaseDao.getCon();
		  PreparedStatement pstmt = null;
		  String sql = "insert into user(username,password,email) values(?,?,?)";
		 try
		 {
			 pstmt = conn.prepareStatement(sql);
			 pstmt.setString(1, user.getUserName());
			 pstmt.setString(2, user.getPassword());
			 pstmt.setString(3, user.getEmail());
      
			 flag = pstmt.execute();
		 }catch (SQLException e){
			 e.printStackTrace();
		 }
		 return flag;
	  }

	public void login(User user) {
		// TODO 自动生成的方法存根
		
	}
	
}
