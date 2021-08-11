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
@WebServlet("/CheckLogout")
public class CheckLogout extends HttpServlet {
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
	   res.setContentType("text/html");  
       PrintWriter pw=res.getWriter();  
       Cookie[] cookies = req.getCookies();
       if (cookies != null)
           for (Cookie cookie : cookies) {
               cookie.setValue("");
               cookie.setPath("/");
               cookie.setMaxAge(0);
              
               res.addCookie(cookie);
             pw.println("<h1> Thank you ! You Have been logged out sucessfully</h2>)");
           }
	   }
  
}