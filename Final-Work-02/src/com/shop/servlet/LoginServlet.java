package com.shop.servlet;

import java.io.IOException;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shop.dao.UserDao;



/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/loginservlet")
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
		String email=request.getParameter("email");
		String password=request.getParameter("password");
		UserDao userdao=new UserDao();
		try {
		 if (userdao.getUser(email).getEmail() == null){
		      String msg1 = "邮箱不存在!";
		      request.setAttribute("msg1", msg1);
		      request.getRequestDispatcher("Login.jsp").forward(request, response);
		 }else if (email.equals("")){
	      String msg2 = "邮箱为空！";
	      request.setAttribute("msg2", msg2);
	      request.getRequestDispatcher("Login.jsp").forward(request, response);
	    }
	    else if (password.equals("")){
	      String msg3 = "密码不能为空！";
	      request.setAttribute("msg3", msg3);
	      request.getRequestDispatcher("Login.jsp").forward(request, response);
	    }
	    else if ((userdao.getUser(email).getEmail().equals(email)) && (userdao.getUser(email).getPassword().equals(password)))
	    {
	      response.sendRedirect("Index.jsp");
	    }
	    else if (userdao.getUser(email).getPassword() != password)
	    {
	      String msg4 = "密码错误，请重新输入!";
	      request.setAttribute("msg4", msg4);
	      request.getRequestDispatcher("Login.jsp").forward(request, response);
	    }
	 }catch(Exception e ) {
		 e.printStackTrace();
	 }
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request,response);
	}
}

