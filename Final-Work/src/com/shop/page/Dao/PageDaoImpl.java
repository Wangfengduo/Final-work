package com.shop.page.Dao;

import java.util.List;


import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.shop.entity.Product;
import com.shop.entity.ProductType;

@Repository
public class PageDaoImpl {
	@Autowired
	private SessionFactory sessionFactory;
	
	@SuppressWarnings("unchecked")
	public List<Product> queryForPage(int offset, int length) {
        // TODO Auto-generated method stub
        List<Product> list=null;
        try{
        	Session session = sessionFactory.getCurrentSession();
			Query query = session.createQuery("from Book");
            query.setFirstResult(offset);
            query.setMaxResults(length);
            list = query.list();
            
        }catch(RuntimeException re){
            throw re;
        }
        
        return list;
    }
 
	@SuppressWarnings("unchecked")
	public int getAllRowCount() {
		List<Product> list=null;
		int count = 0;
	    try{
	    	Session session = sessionFactory.getCurrentSession();
			Query query = session.createQuery("from Book");
	        list = query.list();
	        count = list.size();
	    }catch(RuntimeException re){
	        throw re;
	    }
		return count;
	}


@SuppressWarnings("unchecked")
public List<Product> newBook(int offset, int length,ProductType product_type){
 List<Product> list=null;
    try{
    	Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("from Book b where b.book_type=?");
       
        query.setFirstResult(offset);
        query.setMaxResults(length);
        query.setParameter(0, product_type);
        list = query.list();
        
    }catch(RuntimeException re){
        throw re;
    }
    
    return list;
}

	@SuppressWarnings("unchecked")
	public int newBookCount(ProductType product_type) {
		List<Product> list=null;
		int count = 0;
	    try{
	    	Session session = sessionFactory.getCurrentSession();
	
			Query query = session.createQuery("from Book b where b.book_type=?");
	        query.setParameter(0,product_type);
	        list = query.list();
	        count = list.size();
	        
	    }catch(RuntimeException re){
	        throw re;
	    }
	    return count;
	}


	@SuppressWarnings("unchecked")
	public List<Product> hotBook(int offset, int length,ProductType product_type){
	 List<Product> list=null;
        try{
        	Session session = sessionFactory.getCurrentSession();
			Query query = session.createQuery("from Product p where p.producttypeid=?");
           
            query.setFirstResult(offset);
            query.setMaxResults(length);
            query.setParameter(0, product_type);
            list = query.list();
            
        }catch(RuntimeException re){
            throw re;
        }
        
        return list;
	}
	//�����鼮������
	@SuppressWarnings("unchecked")
	public int hotBookCount(ProductType product_type) {
		List<Product> list=null;
		int count = 0;
        try{
        	Session session = sessionFactory.getCurrentSession();
			Query query = session.createQuery("from Book b where b.book_type=?");
            query.setParameter(0, product_type);
            list = query.list();
            count = list.size();
            
        }catch(RuntimeException re){
            throw re;
        }
        return count;
	}
}
