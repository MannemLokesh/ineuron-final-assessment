package com.ineuron.utility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JdbcUtility 
{
	public static Connection getConnection() throws ClassNotFoundException 
	{
		Connection con=null;
		Class.forName("org.postgresql.Driver");
		try 
		{
			con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/ineuron", "postgres", "postgres");
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		return con;
	}
}
