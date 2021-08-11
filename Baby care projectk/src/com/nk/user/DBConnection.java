package com.nk.user;
import java.sql.*;
public class DBConnection {

	private static Connection con;
	
	static
	{
		try
		{			Class.forName("oracle.jdbc.driver.OracleDriver");

			con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","scott","tiger");
		}
		catch(Exception e)
		{
		e.printStackTrace();
			
			
		}
	}
	
	public static Connection getConnection()
	{
		return con;
	}
}
