package com.ineuron.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ineuron.model.BlogPostModel;
import com.ineuron.utility.JdbcUtility;

public class ViewBlogPostService 
{
	public List<BlogPostModel> getBlogPostsData()
	{
		List<BlogPostModel> listOfPosts= new ArrayList<BlogPostModel>();
		
		try 
        {
			Connection connection = JdbcUtility.getConnection();
			PreparedStatement prepareStatement = connection.prepareStatement("SELECT * FROM blog_post");
			
			ResultSet rs = prepareStatement.executeQuery();
			
			while(rs.next())
			{
				String title = rs.getString("title");
                String description = rs.getString("description");
                String content = rs.getString("content");
                
                BlogPostModel blogPostModel = new BlogPostModel(title, content, description);
                listOfPosts.add(blogPostModel);
			}
			
		} 
        catch (ClassNotFoundException e) 
        {
			e.printStackTrace();
		} 
        catch (SQLException e) 
        {
			e.printStackTrace();
		}
		return listOfPosts;
	}

}
