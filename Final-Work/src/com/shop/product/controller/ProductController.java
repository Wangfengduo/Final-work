package com.shop.product.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.shop.entity.ProductType;
import com.shop.product.service.ProductServiceImpl;
import com.shop.producttype.service.ProductTypeServiceImpl;
import com.shop.entity.Product;

@Controller
@RequestMapping("/product")
public class ProductController {
	@Resource
	private ProductTypeServiceImpl productTypeServiceImpl;
	
	@Resource
	private ProductServiceImpl productServiceImpl;
	
	@RequestMapping(value="/add",method=RequestMethod.GET)
	public String toAdd(Model model) {
		List<ProductType> list=this.productTypeServiceImpl.listTypes();
		model.addAttribute("list", list);
		return "form";//新增产品
	}
	
	@RequestMapping(value="/add", method=RequestMethod.POST)
	public String add(Product p){
		this.productServiceImpl.addProduct(p);
		return "redirect: add";
	}
	
	@RequestMapping("/list")
	public String list(Model model){
		List<Product> list=this.productServiceImpl.listProducts();
		model.addAttribute("list", list);
		return "list";//产品列表
	}
}
