package com.shop.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shop.entity.User;
import com.shop.service.MyException;
import com.shop.service.UserService;
import com.shop.service.UserServiceImpl;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("charset=utf-8");
		 String username = request.getParameter("username");
		 UserService us = new UserServiceImpl();
	     System.out.println(username);
	     User user=new User();
	     user.setUserName(username);
	     try {
	    	 us.login(user);
	    	 request.getSession().setAttribute("username",user.getUserName());//登录成功，将用户名存入session
	         System.out.println("登录成功");//返回true，表示登录成功
	     }catch(MyException e){
	    	 String msg=e.getMessage();
	         request.setAttribute("msg",msg);//返回登录错误的信息
	         System.out.println("登录失败");
	     }
       

    }
}

