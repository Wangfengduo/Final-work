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
	}
}
