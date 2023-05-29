package com.ineuron.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.ineuron.model.BlogPostModel;
import com.ineuron.utility.JdbcUtility;

public class BlogPostService 
{
	public String postBlogToDb(BlogPostModel postModel)
	{
		int rowsEfected=0;
		try 
        {
			Connection connection = JdbcUtility.getConnection();
			PreparedStatement prepareStatement = connection.prepareStatement("INSERT INTO blog_post (title, description, content) VALUES (?,?,?);");
			prepareStatement.setString(1, postModel.getTitle());
			prepareStatement.setString(2, postModel.getDescription());
			prepareStatement.setString(3, postModel.getContent());
			
			rowsEfected = prepareStatement.executeUpdate();
			
		} 
        catch (ClassNotFoundException e) 
        {
			e.printStackTrace();
		} 
        catch (SQLException e) 
        {
			e.printStackTrace();
		}
		
		if(rowsEfected!=0)
		{
			return "SavedToDb";
		}
		else
		{
			return "NotSavedToDB";
		}
	}
}
