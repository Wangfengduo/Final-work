package com.shop.page.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shop.entity.Page;
import com.shop.entity.Product;
import com.shop.entity.ProductType;
import com.shop.page.Dao.PageDaoImpl;

import com.shop.producttype.dao.ProductTypeDaoImpl;


@SuppressWarnings("unchecked")
@Service
public class PageServiceImpl {
	@Autowired
	private PageDaoImpl pageDaoImpl;
	@Autowired
	private ProductTypeDaoImpl productTypeDaoImpl;
	

	@SuppressWarnings("rawtypes")
	public Page queryForPage(int currentPage,int pageSize) {
        // TODO Auto-generated method stub

        Page page = new Page();        
        int allRow = pageDaoImpl.getAllRowCount();

        int offset = page.countOffset(currentPage,pageSize);  

        List<Product> list = pageDaoImpl.queryForPage(offset, pageSize); 

        page.setPageNo(currentPage);
        page.setPageSize(pageSize);
        page.setTotalRecords(allRow);
        page.setList(list);
        
        return page;
    }

	@SuppressWarnings("rawtypes")
	public Page newProduct(int currentPage,int pageSize) {
		Page page = new Page();  
		ProductType productType = productTypeDaoImpl.selectType_id("1");
        //�ܼ�¼��
        int allRow = pageDaoImpl.newBookCount(productType);
        //��ǰҳ��ʼ��¼
        int offset = page.countOffset(currentPage,pageSize);  
        //��ҳ��ѯ�����
        
        List<Product> list = pageDaoImpl.newBook(offset, pageSize,productType);

        page.setPageNo(currentPage);
        page.setPageSize(pageSize);
        page.setTotalRecords(allRow);
        page.setList(list);
        
        return page;
	}
	


	@SuppressWarnings("rawtypes")
	public Page hotProduct(int currentPage,int pageSize) {
		Page page = new Page();  
		ProductType book_type = productTypeDaoImpl.selectType_id("2");
        int allRow = pageDaoImpl.hotBookCount(book_type);
        int offset = page.countOffset(currentPage,pageSize); 
        
        List<Product> list = pageDaoImpl.hotBook(offset, pageSize,book_type); 
        page.setPageNo(currentPage);
        page.setPageSize(pageSize);
        page.setTotalRecords(allRow);
        page.setList(list);
        
        return page;
	}
	

	@SuppressWarnings("rawtypes")
	public Page productTypeList(int currentPage,int pageSize,String type_name) {
		Page page = new Page();  
		ProductType productType = productTypeDaoImpl.selectType_id(type_name);

        int allRow = pageDaoImpl.hotBookCount(productType);

        int offset = page.countOffset(currentPage,pageSize);  
        
        List<Product> list = pageDaoImpl.hotBook(offset, pageSize,productType); 

        page.setPageNo(currentPage);
        page.setPageSize(pageSize);
        page.setTotalRecords(allRow);
        page.setList(list);
        
        return page;
	}
	
	
}
