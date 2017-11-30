package com.shop.producttype.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.shop.entity.ProductType;

public class ProductTypeDaoImpl {
	public List<ProductType> findAll(){
		try{
			List<ProductType> list=new ArrayList<ProductType>();
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/myweb?useUnicode=true&characterEncoding=UTF-8","root","");
			PreparedStatement pstm=con.prepareStatement("select * from producttype");
			ResultSet rs=pstm.executeQuery();
			while(rs.next()){
				ProductType pt=new ProductType();
				pt.setId(rs.getInt(1));
				pt.setName(rs.getString(2));
				list.add(pt);
			}
			con.close(); 
			return list;
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}
	}
}
