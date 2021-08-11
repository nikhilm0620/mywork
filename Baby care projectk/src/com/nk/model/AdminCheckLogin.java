package com.nk.model;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.nk.admin.DBConnection;
import com.nk.user.*;
@WebServlet("/AdminCheckLogin")
public class AdminCheckLogin extends HttpServlet {
public ServletContext sc;
	
	public Connection con;
	HttpSession session;
	
	public void init() throws ServletException
	{
		sc=this.getServletContext();

		con=DBConnection.getConnection();
		
	}
   public void doGet(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException
   {
	   Cookie ck1[]=req.getCookies();  
	   if(ck1!=null){  
	         String name=ck1[0].getValue();  
	        if(!name.equals("")||name!=null){  
	            res.sendRedirect("adminview.html");
	         } else {
	        	 RequestDispatcher rd= req.getRequestDispatcher("adminlogin.html");
	                rd.include(req, res);
	         }
	      }
	   }
  
}
