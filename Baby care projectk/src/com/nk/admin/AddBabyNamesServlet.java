package com.nk.admin;
import java.sql.*;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class AddBabyNamesServlet extends HttpServlet {
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
	   String Name=req.getParameter("name");
	   String Meaning=req.getParameter("meaning");
	   String Gender=req.getParameter("sex");
	   String Religion=req.getParameter("religion");
	   try
	   {
		   PreparedStatement ps=con.prepareStatement("insert into babynames values(?,?,?,?)");
		   ps.setString(1,Name);
		   ps.setString(2,Meaning);
		   ps.setString(3,Gender);
		   ps.setString(4, Religion);
		int k=ps.executeUpdate();
		   
		  if(k>0)
		  {
			  pw.println("Added Baby Name Succesfully");
			  RequestDispatcher rd=req.getRequestDispatcher("adminview.html");
			  rd.include(req, res);
			   }
		  else
		  {
			  pw.println("Try Again ");
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
