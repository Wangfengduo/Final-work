package com.shop.product.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import com.shop.entity.Product;

@Repository
public class ProductDaoImpl {
	
	@Resource
	private SessionFactory sessionFactory;
	
	public void saveProduct(Product p) {
		this.sessionFactory.getCurrentSession().save(p);
	}
	
	public List<Product> findAll(){
		try{
			List<Product> list=new ArrayList<Product>();
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/mytest_db?useUnicode=true&characterEncoding=UTF-8","root","");
			PreparedStatement pstm=con.prepareStatement("select * from product");
			ResultSet rs=pstm.executeQuery();
			while(rs.next()){
				Product p=new Product();
				p.setId(rs.getInt("id"));
				p.setName(rs.getString("name"));
				p.setImg(rs.getString("img"));
				p.setDescription(rs.getString("description"));
				p.setPrice(rs.getInt("price"));
				p.setProductTypeId(rs.getInt("productTypeId"));
				list.add(p);
			}
			con.close();
			return list;
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}
	}
	

	public void delProduct(int id) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/mytest_db?useUnicode=true&characterEncoding=UTF-8","root","");
			PreparedStatement pstm=con.prepareStatement("delete from product where id=?");
			pstm.setInt(1, id);
			pstm.executeUpdate();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	
	public void findById(int id) {
		 try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/mytest_db?useUnicode=true&characterEncoding=UTF-8","root","");
			PreparedStatement pstm=con.prepareStatement("select * from product where id=?");
			pstm.setInt(1, id);
			ResultSet rs=pstm.executeQuery();
			Product p=new Product();
			while(rs.next()) {
				p.setId(rs.getInt(1));
				p.setName(rs.getString(2));
				p.setImg(rs.getString(3));
				p.setDescription(rs.getString(4));
				p.setPrice(rs.getInt(5));
				p.setProductTypeId(rs.getInt(6));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	
	
}
