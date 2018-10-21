package com.cmc.jsp_servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;



	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			loadParameter(request, response);
	}
	
	private void loadParameter(HttpServletRequest request, HttpServletResponse response) throws ServletException
	, IOException
	{
		
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		if(username.equalsIgnoreCase("Dung")  && password.equalsIgnoreCase("1234")) {
			request.setAttribute("errorMsg", "Đăng nhập thành công");
		}
		else {
			request.setAttribute("errorMsg", "Đăng nhập thất bại");
		}
		
		RequestDispatcher rd = request.getRequestDispatcher("/Login.jsp");
		rd.forward(request , response);
		
	}

}
