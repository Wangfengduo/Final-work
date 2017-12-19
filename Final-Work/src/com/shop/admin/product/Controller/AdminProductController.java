package com.shop.admin.product.Controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


import com.shop.admin.product.Service.AdminProductService;
import com.shop.entity.Page;
import com.shop.entity.Product;
import com.shop.page.Service.PageServiceImpl;



@Controller
@RequestMapping("/admin")
public class AdminProductController {
	@Autowired
	private AdminProductService productService;
	@Autowired
	private PageServiceImpl pageServiceImpl;
	
	
	
	
	@RequestMapping(value="/deleteProduct", method=RequestMethod.POST)
	public String deleteProduct(Product p){
		this.productService.deleteProduct(p);
		return "redirect:/admin/productlist";
	}
	
	
	@RequestMapping("/addProduct")
	public String addProduct(Product p) {
		this.productService.addProduct(p);
		return "success2";
	}
	
	@RequestMapping("/updateProduct")
	public String updateProduct(Product p) {
		this.productService.updateProduct(p);
		return "success3";
	}
	

	
	
	@SuppressWarnings("unused")
	@RequestMapping("/addProductType")
	public String saveProductType(String name) {
		boolean result = productService.saveProductType(name);
		return "success4";
	}
	
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@RequestMapping("/productlist")
	public String select(HttpServletRequest request) {
        try {
            String pageNo = request.getParameter("pageNo");
            if (pageNo == null) {
                pageNo = "1";
            }
            Page page = pageServiceImpl.queryForPage(Integer.valueOf(pageNo), 5);
            request.setAttribute("page", page);
            List<Product> list = page.getList();
            request.setAttribute("productlist", list);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "productlist";
    }
	
	
	public String someOneBook(HttpServletRequest request,HttpSession session) {
		String productname = request.getParameter("name");
		@SuppressWarnings("unused")
		boolean result = productService.selectProduct(session, productname);
		return "someOneProduct";
	}
	
	
}
