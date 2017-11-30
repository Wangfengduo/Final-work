package com.shop.product.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;

import com.shop.entity.Product;

public class ProductDaoImpl {
	public void saveProduct(Product p) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/myweb?useUnicode=true&characterEncoding=UTF-8","root","");
			PreparedStatement pstm=con.prepareStatement("insert into product(id,name,img,deccription,price,producttypeid) values(?,?,?,?,?,?)");
			pstm.setInt(1, p.getId());
			pstm.setString(2, p.getName());
			pstm.setString(3, p.getImg());
			pstm.setString(4, p.getDescription());
			pstm.setInt(5, p.getPrice());
			pstm.setInt(6, p.getProductTypeId());
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
	

	public static boolean delProduct(int id) {
		try {
			JdbcTemplate.update("delete from product where id=?",new Object[]{id});
			return true;
		}catch(Exception e){
			e.printStackTrace();
		}
		return false;
	}
	
	
	public boolean updateProduct(Product p) {
		 
		try {
		 
		String sql="update product set name=?,img=?,description=?,price=?,producttypeid=? where id=?";
		JdbcTemplate.update(sql, new Object[]{
		 p.getName();
		 
		});
		return true;
		 
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	
	
	
	
}
