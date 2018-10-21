package com.cmc.jsp_servlet;


import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dbconnect.DbConnect;


@WebServlet("/LoadDataServlet")
public class LoadDataServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    private Connection conn = null;
    private PreparedStatement ps = null;
    public LoadDataServlet() {
        super();
       
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		DbConnect dbConnect = new DbConnect();
		conn = dbConnect.getConnect();
		
		response.setContentType("text/html");
	    PrintWriter out = response.getWriter();
	    String title = "Database Result";
	    String docType =
	        "<!doctype html public \"-//w3c//dtd html 4.0 " +
	         "transitional//en\">\n";
	         out.println(docType +
	         "<html>\n" +
	         "<head><title>" + title + "</title></head>\n" +
	         "<body bgcolor=\"#f0f0f0\">\n" +
	         "<h1 align=\"center\">" + title + "</h1>\n");
		 try{
			 String sql;
	         sql = "SELECT * FROM CAR";
			 ps = conn.prepareStatement(sql);
	         ResultSet rs = ps.executeQuery();

	         while(rs.next()){
	            int carid  = rs.getInt("CARID");
	            String maker = rs.getString("MAKER");
	            String model = rs.getString("MODEL");
	            int year = rs.getInt("YEAR");
	            String color = rs.getString("COLOR");
	            String text = rs.getString("NOTE");

	         
	            out.println("CarID: " + carid + "<br>");
	            out.println(", Maker: " + maker + "<br>");
	            out.println(", Model: " + model + "<br>");
	            out.println(", Year: " + year + "<br>");
	            out.println(", Color: " + color + "<br>");
	            out.println(", Text: " + text + "<br>");
	            
	         }
	         out.println("</body></html>");
	         rs.close();
	         ps.close();
	         conn.close();
	      }catch(SQLException se){  
	         se.printStackTrace();
	      }catch(Exception e){
	        
	         e.printStackTrace();
	      }finally{
	         try{
	            if(ps!=null)
	               ps.close();
	         }catch(SQLException se2){
	         } 
	         try{
	            if(conn!=null)
	            conn.close();
	         }catch(SQLException se){
	            se.printStackTrace();
	         }
	      } 
	   }


	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
