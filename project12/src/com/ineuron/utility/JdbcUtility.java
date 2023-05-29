package com.ineuron.utility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JdbcUtility 
{
	public static Connection getConnection() throws ClassNotFoundException 
	{
		Connection con=null;
		Class.forName("com.mysql.cj.jdbc.Driver");
		try 
		{
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ineuron", "root", "root");
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		return con;
	}
}
