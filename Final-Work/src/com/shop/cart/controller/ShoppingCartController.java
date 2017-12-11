package com.shop.cart.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


import com.shop.cart.service.ShoppingCartServiceImpl;
import com.shop.entity.Product;
import com.shop.entity.ShoppingCart;
import com.shop.product.service.ProductServiceImpl;




@Controller
public class ShoppingCartController {
	
	@Resource
	private ProductServiceImpl productServiceImpl;
	@Resource
	private ShoppingCartServiceImpl shoppingCartServiceImpl;
	
	@RequestMapping(value="/shoppingcart")
	public String shoppingcart() {
		return "shoppingcart";
	}
	
	 @RequestMapping(value = "/addShoppingCart",method = RequestMethod.POST)
	 public String add(ShoppingCart shoppingCart){
			this.shoppingCartServiceImpl.addShoppingCart(shoppingCart);
			return "redirect: add";
		}
	 
	 @RequestMapping(value = "/addShoppingCart",method = RequestMethod.POST)
	 public Map<String,Object> addShoppingCart(int productId,int counts){
		 System.out.println("数量为"+counts);
		 ShoppingCart shoppingCart=shoppingCartServiceImpl.getShoppingCart(productId);
		 if(shoppingCart==null) {
			 ShoppingCart shoppingCart1=new ShoppingCart();
			 shoppingCart1.setProductId(productId);
			 shoppingCart1.setCounts(counts);
			 shoppingCart1.setProductPrice(shoppingCartServiceImpl.getShoppingCart(productId).getProductPrice()*counts);
			 shoppingCartServiceImpl.addShoppingCart(shoppingCart1);
			 
		 }else {
			 shoppingCart.setCounts(shoppingCart.getCounts()+counts);
			 shoppingCart.setProductPrice(shoppingCartServiceImpl.getShoppingCart(productId).getProductPrice()*shoppingCart.getProductPrice());
			 shoppingCartServiceImpl.updateShoppingCart(shoppingCart);
		 }
		 Map<String, Object> resultMap = new HashMap<String,Object>();
		 resultMap.put("result","success");
		 return resultMap;
		 
	 }
	 
	 @RequestMapping(value = "/deleteShoppingCart",method = RequestMethod.POST)
	 public Map<String,Object> deleteShoppingCart(int productId){
		 shoppingCartServiceImpl.deleteShoppingCart(productId);
		 Map<String, Object> resultMap = new HashMap<String,Object>();
		 resultMap.put("result","success");
		 return resultMap;
	 }
	 
	 
	@RequestMapping(value = "/getShoppingCart",method = RequestMethod.POST)
	public String list(Model model){
		List<ShoppingCart> shoppingCartlist=this.shoppingCartServiceImpl.getAllShoppingCat();
		model.addAttribute("shoppingCartlist", shoppingCartlist);
		return "shoppingCart";//购物车列表
	}
	 
}
