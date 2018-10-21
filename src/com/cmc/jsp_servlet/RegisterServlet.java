package com.cmc.jsp_servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dbconnect.DbConnect;

/**
 * Servlet implementation class RegisterServlet
 */
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private Connection conn = null;
	private PreparedStatement ps = null;
	
    public RegisterServlet() {
        super();
        
    }

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		loadParametr(request, response);
	}
	
	private void loadParametr(HttpServletRequest request, HttpServletResponse response) throws ServletException
	, IOException
	{
		DbConnect dbConnect = new DbConnect();
		conn = dbConnect.getConnect();
		
		try {
			String username = request.getParameter("username");
			String password = request.getParameter("password");
			String email = request.getParameter("email");
			ps = conn.prepareStatement("insert into Register values (?,?,?)");
			ps.setString(1, username);
			ps.setString(2, password);
			ps.setString(3, email);
			
			if(ps.executeUpdate()!=0) {
				request.setAttribute("insertMsg", "Đăng ký tài khoản thành công");
			}
			else {
				request.setAttribute("insertMsg", "Đăng ký tài khoản thất bại");
			}
			
			RequestDispatcher rd = request.getRequestDispatcher("/Register.jsp");
			rd.forward(request , response);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

}
