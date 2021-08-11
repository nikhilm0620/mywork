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
import javax.servlet.http.HttpServlet;

import com.nk.admin.DBConnection;

public class UserRegistrationServlet extends HttpServlet  {
public ServletContext sc;
	
	public Connection con;
	
	public void init() throws ServletException
	{
		sc=this.getServletContext();

		con=DBConnection.getConnection();
		
	}
   public void service(ServletRequest req,ServletResponse res)throws ServletException,IOException
   {
	   PrintWriter pw=res.getWriter();
	   res.setContentType("text/html");
	   String uName=req.getParameter("username");
	   String pWord=req.getParameter("password");
	   String gender=req.getParameter("sex");
	   String religion=req.getParameter("religion");
	   try
	   {
		   PreparedStatement ps=con.prepareStatement("insert into reguser values(?,?,?,?) ");
		   ps.setString(1,uName);
		   ps.setString(2,pWord);
		   ps.setString(3,gender);
		   ps.setString(4, religion);
		   int k=ps.executeUpdate();
		   
		  if(k>0)
		  {
			  pw.println("<b> <h1> User registred successfully <h1/></b>");
			   }
		  else
		  {
			  pw.println("Invalid Try Again");
			  RequestDispatcher rd=req.getRequestDispatcher("reguser.html");
			  rd.include(req, res);

		  }
	   }
		  catch(Exception e)
		  {
			  e.printStackTrace();
		  }
	   }
}
