package com.shop.product.dao;


import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Query;

import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import com.shop.entity.Product;


@Repository
public class ProductDaoImpl {
	
	@Resource
	private SessionFactory sessionFactory;
	
	//添加商品
	public void saveProduct(Product p) {
		this.sessionFactory.getCurrentSession().save(p);
	}
	
	//查询商品
	public Product findById(int id) {
		Product pd=this.sessionFactory.getCurrentSession().get(Product.class,id);
		return pd;
	}
	//查询所有
	@SuppressWarnings("unchecked")
	public List<Product> findAll(){
		Query query = this.sessionFactory.getCurrentSession().createQuery("from Product");
		
		List<Product> list = query.list();  
        return list;  
	}
	
	//删除商品
	public void delProduct(Product p) {
		//this.sessionFactory.getCurrentSession().createQuery("delete from Product pd where pd.id="+id).executeUpdate();
		this.sessionFactory.getCurrentSession().delete(p);
	}
	
	//修改商品
	public void updateProduct(Product pd) {
		
		Product p=this.sessionFactory.getCurrentSession().get(Product.class, pd.getId());
		p.setName(pd.getName());
		p.setPrice(pd.getPrice());
		p.setDescription(pd.getDescription());
		p.setImg(pd.getImg());
		this.sessionFactory.getCurrentSession().update(pd);
//        session.beginTransaction();
//        Query query = session.createQuery("update product pd set pd.name = ?,pd.img = ?,pd.description=?,pd.price = ?,pd.producttypeid=? where pd.id = ?");
//        query.setParameter(0, pd.getName());
//        query.setParameter(1, pd.getImg());
//        query.setParameter(2, pd.getPrice());
//        query.setParameter(3, pd.getDescription());
//        query.setParameter(4, pd.getPrice());
//        query.setParameter(5, pd.getProductTypeId());
//        session.getTransaction().commit();  
	}
	
	
}
