package com.nk.admin;
import java.sql.*;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class AdminLoginServlet extends HttpServlet {
	public ServletContext sc;
	
	public Connection con;
	
	public void init() throws ServletException
	{
		sc=this.getServletContext();

		con=DBConnection.getConnection();
		
	}
   public void service(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException
   {
	   PrintWriter pw=res.getWriter();
	   res.setContentType("text/html");
	   String uName=req.getParameter("uname");
	   String pWord=req.getParameter("pword");
	   try
	   {
		   PreparedStatement ps=con.prepareStatement("select * from adminlogin where username =? and password =? ");
		   ps.setString(1,uName);
		   ps.setString(2,pWord);
		   ResultSet rs=ps.executeQuery();
		   
		  if(rs.next())
		  {
			  RequestDispatcher rd=req.getRequestDispatcher("adminview.html");
			  rd.forward(req, res);
			  Cookie ck1=new Cookie("name",uName);  
	            res.addCookie(ck1);
				
			   }
		  else
		  {
			  pw.println("Invalid Username and Password");
			  RequestDispatcher rd=req.getRequestDispatcher("admin.html");
			  rd.include(req, res);

		  }
	   }
		  catch(Exception e)
		  {
			  e.printStackTrace();
		  }
	   }
   }

