package com.shop.admin.order.Controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.shop.admin.order.Service.AdminOrderServiceImpl;
import com.shop.entity.Order;
import com.shop.entity.Page;
import com.shop.order_detail.service.Order_detailServiceImpl;

@Controller
public class AdminOrderController {
	@Autowired
	private AdminOrderServiceImpl orderServiceImpl;
	@Autowired
	private Order_detailServiceImpl order_detailServiceImpl;
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@RequestMapping("admin/orderlist")
	public String select(HttpServletRequest request) {
        try {
            String pageNo = request.getParameter("pageNo");
            if (pageNo == null) {
                pageNo = "1";
            }
            Page page = orderServiceImpl.queryForPage(Integer.valueOf(pageNo), 4);
            request.setAttribute("page", page);
            List<Order> list = page.getList2();
            request.setAttribute("orderlist", list);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "orderlist";
    }
	
	
	@RequestMapping("admin/deleteOrder")
	public String deleteOrder(HttpServletRequest request,String orderId) {
		@SuppressWarnings("unused")
		boolean result = orderServiceImpl.deleteOrder(orderId);
		return "admin/success5";
	}
	
	@RequestMapping("admin/someOneOrder")
	public String someOneOrder(HttpSession session,String orderId) {
		@SuppressWarnings("unused")
		boolean result = orderServiceImpl.someOneOrder(session, orderId);
		return "admin/someOneOrder";
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@RequestMapping("admin/finishOrder")
	public String finishOrder(HttpServletRequest request) {
	 try {
            String pageNo = request.getParameter("pageNo");
            if (pageNo == null) {
                pageNo = "1";
            }
            Page page = orderServiceImpl.finishOrder(Integer.valueOf(pageNo), 3);
            request.setAttribute("page", page);
            List<Order> list = page.getList2();
            request.setAttribute("finishOrder", list);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "admin/finishOrder";
	}
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@RequestMapping("admin/deleteOrderList")
	public String deleteOrderList(HttpServletRequest request) {
	 try {
            String pageNo = request.getParameter("pageNo");
            if (pageNo == null) {
                pageNo = "1";
            }
            Page page = orderServiceImpl.deleteOrderList(Integer.valueOf(pageNo), 3);
            request.setAttribute("page", page);
            List<Order> list = page.getList2();
            request.setAttribute("deleteOrderList", list);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "admin/deleteOrderList";
	}
	@RequestMapping("admin/showOrder")
	public String selectOrder_detail(HttpServletRequest request,HttpSession session) {
		@SuppressWarnings("unused")
		boolean result = order_detailServiceImpl.selectOrder_detail(request, session);
		return "admin/showOrder";
	}
	
	
}
