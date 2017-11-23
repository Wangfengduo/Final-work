package com.shop.product.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.shop.dao.BaseDao;
import com.shop.entity.Product;

public class ProductDaoImpl {
	
	public void saveProduct(Product p){
		try{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/myweb?useUnicode=true&characterEncoding=UTF-8","root","");
			PreparedStatement pstm=con.prepareStatement("insert into product(name,price,typeid) values(?,?,?)");
			pstm.setString(1, p.getName());
			pstm.setInt(2, p.getPrice());
			pstm.setInt(3, p.getTypeid());
			pstm.executeUpdate();
			con.close();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public List<Product> findAll(){
		try{
			List<Product> list=new ArrayList<Product>();
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/myweb?useUnicode=true&characterEncoding=UTF-8","root","");
			PreparedStatement pstm=con.prepareStatement("select * from product");
			ResultSet rs=pstm.executeQuery();
			while(rs.next()){
				Product p=new Product();
				p.setId(rs.getInt(1));
				p.setName(rs.getString(2));
				p.setPrice(rs.getInt(3));
				p.setTypeid(rs.getInt(4));
				list.add(p);
			}
			con.close();
			return list;
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}
	}
	
	
	public Product findById(int id){
		try{
			Connection con=BaseDao.getCon();
			PreparedStatement pstm=con.prepareStatement("select * from product where id=?");
			pstm.setInt(1, id);
			ResultSet rs=pstm.executeQuery();
			Product p=new Product();
			while(rs.next()){
				p.setId(rs.getInt(1));
				p.setName(rs.getString(2));
				p.setPrice(rs.getInt(3));
				p.setTypeid(rs.getInt(4));
			}
			return p;
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}
	}
	
	
	public int findCountByPage(){
		try{
			Connection con=BaseDao.getCon();
			PreparedStatement pstm=con.prepareStatement("select count(id) from product");
			ResultSet rs=pstm.executeQuery();
			int count=0;
			while(rs.next()){
				count=rs.getInt(1);
			}
			return count;
		}catch(Exception e){
			e.printStackTrace();
			return 0;
		}
	}
	
	public void deleteProduct(int id){
		try{
			Connection con=BaseDao.getCon();
			PreparedStatement pstm=con.prepareStatement("delete from product where id=?");
			pstm.setInt(1, id);
			pstm.executeUpdate();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
}
