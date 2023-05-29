package com.ineuron;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.ineuron.utility.JdbcUtility;

public class JdbcExample
{
	public static void main(String[] args) throws ClassNotFoundException, SQLException 
	{
		Connection connection = JdbcUtility.getConnection();
		
		Statement statement = connection.createStatement();

        String sql = "SELECT * FROM student"; // Replace with your table name
        ResultSet resultSet = statement.executeQuery(sql);

        while (resultSet.next()) 
        {
            // Retrieve data from each row
            int roll = resultSet.getInt("roll"); // Replace "id" with your column name
            String city = resultSet.getString("city"); // Replace "name" with your column name
            String name = resultSet.getString("name"); // Replace "age" with your column name

            // Display the data
            System.out.println("Roll: " + roll + ", Name: " + name + ", City: " + city);
        }
		
	}
}