package com.nk.user;

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
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.nk.admin.DBConnection;

public class UserLoginServlet extends HttpServlet {
public ServletContext sc;
	
	public Connection con;
	
	public void init() throws ServletException
	{
		sc=this.getServletContext();

		con=DBConnection.getConnection();
		
	}
   public void doPost(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException
   {
	   PrintWriter pw=res.getWriter();
	   res.setContentType("text/html");
	   String uName=req.getParameter("username1");
	   String pWord=req.getParameter("password1");
	   try
	   {
		   PreparedStatement ps=con.prepareStatement("select * from reguser where username =? and password =?");
		   ps.setString(1,uName);
		   ps.setString(2,pWord);
		   ResultSet rs=ps.executeQuery();
		


		   
		  if(rs.next())
		  {
			RequestDispatcher rd= req.getRequestDispatcher("viewuser.html");
			rd.include(req, res);
		    
            Cookie ck=new Cookie("name",uName);  
            res.addCookie(ck);
			
			   }
		  else
		  {
			  
				RequestDispatcher rd= req.getRequestDispatcher("index.html");
                rd.include(req, res);
		  }
	   }
		  catch(Exception e)
		  {
			  e.printStackTrace();
		  }
	   }
}
