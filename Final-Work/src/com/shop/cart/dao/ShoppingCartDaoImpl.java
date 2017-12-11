package com.shop.cart.dao;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import com.shop.entity.ShoppingCart;



@Repository
public class ShoppingCartDaoImpl {
	@Resource
    private SessionFactory sessionFactory;
	
	//查询
	public ShoppingCart getShoppingCart(int productId) {
		ShoppingCart shoppingcart=this.sessionFactory.getCurrentSession().get(ShoppingCart.class,productId);
		return shoppingcart;
	 }
	
	//查询所有
	@SuppressWarnings("unchecked")
	public List<ShoppingCart> getAllShoppingCat(){
		Query query = this.sessionFactory.getCurrentSession().createQuery("from ShoppingCart");
		List<ShoppingCart> list = query.list();  
        return list;  
	}
	
	//增
	public void addShoppingCart(ShoppingCart shoppingCart) {
        sessionFactory.getCurrentSession().save(shoppingCart);
    }
	
	//删除
	public void deleteShoppingCart(int productId) {
		this.sessionFactory.getCurrentSession().createQuery("delete from ShoppingCart sc where sc.productId="+productId).executeUpdate();
		
	}
	
	//修改
	public void updateShoppingCart(ShoppingCart shoppingCart) {
		ShoppingCart sc=this.sessionFactory.getCurrentSession().get(ShoppingCart.class,shoppingCart.getProductId());
		sc.setProductName(shoppingCart.getProductName());
		sc.setProductPrice(shoppingCart.getProductPrice());
		sc.setCounts(shoppingCart.getCounts());
		this.sessionFactory.getCurrentSession().update(shoppingCart);
	}
	
	
}
