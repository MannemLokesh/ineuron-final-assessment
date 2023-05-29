package com.ineuron.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ineuron.model.BlogPostModel;
import com.ineuron.service.BlogPostService;

@WebServlet("/CreateBlogPostServlet")
public class CreateBlogPostServlet extends HttpServlet 
{
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
        BlogPostModel blogPostModel = new BlogPostModel();
        blogPostModel.setTitle(request.getParameter("title"));
        blogPostModel.setContent(request.getParameter("content"));
        blogPostModel.setDescription(request.getParameter("description"));
        
        BlogPostService blogPostService = new BlogPostService();
        String postBlogToDb = blogPostService.postBlogToDb(blogPostModel);
        
        if(postBlogToDb.equals("SavedToDb"))
        {
        	response.sendRedirect("index.jsp");
        }
        else {
        	System.out.println("Something went wrong");
        }
	}
}
