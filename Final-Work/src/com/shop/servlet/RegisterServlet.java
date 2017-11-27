package com.shop.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.shop.dao.UserDao;
import com.shop.entity.User;

/**
 * Servlet implementation class RegisterServlet
 */
@WebServlet("/registerservlet")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		 response.setContentType("charset=utf-8");
		 String username=request.getParameter("username");
		 String password=request.getParameter("password");
		 String email=request.getParameter("email");
		 UserDao ud=new UserDao();
		 User user=new User();
		 user.setUserName(username);
		 user.setPassword(password);
		 user.setEmail(email);
		 
		 if(username.equals("")) {
			 String smg1="用户名为空";
			 request.setAttribute("smg1", smg1);
			 request.getRequestDispatcher("Rsegister.jsp").forward(request,response);
		 }else if(ud.findByName(username).getUserName() != null){
			 String smg2="用户名已存在！";
			 request.setAttribute("smg2", smg2);
			 request.getRequestDispatcher("Rsegister.jsp").forward(request,response);
			 System.out.println("1");
		 }else if(ud.findByName(username).getUserName() == null){
			 String smg3="用户名可以使用！";
			 request.setAttribute("smg3", smg3);
			 request.getRequestDispatcher("Rsegister.jsp").forward(request,response);
		 }else if (password.equals("")){
		      String smg4 = "密码为空!";
		      request.setAttribute("smg4", smg4);
		      request.getRequestDispatcher("Register.jsp").forward(request, response);
		  }else if (ud.getUser(email).getEmail() != null){
		      String smg5 = "邮箱已存在!";
		      request.setAttribute("smg5", smg5);
		      request.getRequestDispatcher("Register.jsp").forward(request, response);
		  }else if(ud.getUser(email).getEmail() == null && ud.findByName(username).getUserName() == null){
			  ud.addUser(user);
			  request.getRequestDispatcher("Login.jsp").forward(request, response);
		  }
		 
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request,response);
	}
	
}
