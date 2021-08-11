package com.nk.admin;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet
	.ServletConfig;
import javax.servlet
	.ServletException;
import javax.servlet
	.annotation.MultipartConfig;
import javax.servlet
	.annotation.WebServlet;
import javax.servlet
	.http.HttpServlet;
import javax.servlet
	.http.HttpServletRequest;
import javax.servlet
	.http.HttpServletResponse;
import javax.servlet.http.Part;



// This is the annotation-based
// mapping URL to Servlet.


// This annotation defines the maximum
// file size which can be taken.

@MultipartConfig(maxFileSize = 16177215)
public class AddBabyFoodsServlet extends HttpServlet {

	// auto generated
	private static final long serialVersionUID = 1L;

	public AddBabyFoodsServlet()
	{
		super();
	}

	// This Method takes in All the information
	// required and is used to store in the
	// MySql Database.
	
	 public void doGet(HttpServletRequest request, 
		        HttpServletResponse response) throws ServletException, 
		        IOException 
		    {            
		        // Setting up the content type of web page      
		        response.setContentType("text/html");
		        // Writing the message on the web page      
		         
		    }
	// As Submit button is hit from
	// the Web Page, request is made
	// to this Servlet and
	// doPost method is invoked.
	protected void doPost(
		HttpServletRequest request,
		HttpServletResponse response)
		throws ServletException, IOException
	{
		PrintWriter pw=response.getWriter();

		// Getting the parametes from web page
		String name
			= request.getParameter("name");

		String foodid
			= request.getParameter("foodid");

		// Input stream of the upload file
		InputStream inputStream = null;

		String message = null;

		// Obtains the upload file
		// part in this multipart request
		Part filePart
			= request.getPart("foodimage");

		if (filePart != null) {

			// Prints out some information
			// for debugging
			System.out.println(
				filePart.getName());
			System.out.println(
				filePart.getSize());
			System.out.println(
				filePart.getContentType());

			// Obtains input stream of the upload file
			inputStream
				= filePart.getInputStream();
		}

		// Sends the statement to the
		// database server
		String SQL
		= "INSERT INTO babyfood "
		+ "(name, id, "
		+ "foodimage) values (?, ?, ?)";
	int row = 0;

	Connection connection
		= DBConnection.getConnection();

	PreparedStatement preparedStatement;
	try {
		preparedStatement
			= connection.prepareStatement(SQL);

		preparedStatement
			.setString(1, name);

		preparedStatement
			.setString(2, foodid);

		if (inputStream != null) {

			// Fetches the input stream
			// of the upload file for
			// the blob column
			preparedStatement.setBlob(3, inputStream);
		}

		// Sends the statement to
		// the database server
		row = preparedStatement
				.executeUpdate();
	}
	catch (SQLException e) {
		System.out.println(e.getMessage());
	}

		
		if (row > 0) {
			message
				= "File uploaded and "
				+ "saved into database";
			pw.println("<h3>Product Added Sucessfully</h3>");
		}
		System.out.println(message);
	}
}
