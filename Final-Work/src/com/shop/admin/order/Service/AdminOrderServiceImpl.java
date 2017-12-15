package com.shop.admin.order.Service;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shop.admin.order.Dao.AdminOrderDaoImpl;
import com.shop.entity.Order;
import com.shop.entity.Page;
import com.shop.order.dao.OrderDaoImpl;

@Service
public class AdminOrderServiceImpl {
	@Autowired
	private AdminOrderDaoImpl adminOrderDaoImpl;
	@Autowired
	private OrderDaoImpl orderDaoImpl;
	
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public Page queryForPage(int currentPage,int pageSize) {
        // TODO Auto-generated method stub

        Page page = new Page();        

        int allRow = adminOrderDaoImpl.getAllRowCount();

        int offset = page.countOffset(currentPage,pageSize);  
        List<Order> list = adminOrderDaoImpl.queryForPage(offset, pageSize); 

        page.setPageNo(currentPage);
        page.setPageSize(pageSize);
        page.setTotalRecords(allRow);
        page.setList2(list);
        
        return page;
    }
	
	public boolean deleteOrder(String orderId) {
		int id = Integer.parseInt(orderId);
		boolean result = adminOrderDaoImpl.deleteOrder(id);
		return result;
	}
	//���ݶ����Ų���ĳһ������
	public boolean someOneOrder(HttpSession session,String orderId) {
		int id = Integer.parseInt(orderId);
		Order order =orderDaoImpl.someOneOrder(id);
		session.setAttribute("order", order);
		return true;
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public Page finishOrder(int currentPage,int pageSize) {
		Page page = new Page();        

        int allRow = adminOrderDaoImpl.finishOrderCount();

        int offset = page.countOffset(currentPage,pageSize);  
        List<Order> list = adminOrderDaoImpl.finishOrder(offset, pageSize); 

        page.setPageNo(currentPage);
        page.setPageSize(pageSize);
        page.setTotalRecords(allRow);
        page.setList2(list);
        
        return page;
	}
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public Page deleteOrderList(int currentPage,int pageSize) {
		Page page = new Page();        

        int allRow = adminOrderDaoImpl.deleteOrderCount();

        int offset = page.countOffset(currentPage,pageSize);  

        List<Order> list = adminOrderDaoImpl.deleteOrderList(offset, pageSize); 

        page.setPageNo(currentPage);
        page.setPageSize(pageSize);
        page.setTotalRecords(allRow);
        page.setList2(list);
        
        return page;
	}
	
	
	
}
