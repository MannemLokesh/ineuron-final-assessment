package com.ineuron.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ineuron.model.BlogPostModel;
import com.ineuron.service.ViewBlogPostService;

@WebServlet("/view")
public class ViewBlogPostsServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
    {
        ViewBlogPostService viewBlogPostService = new ViewBlogPostService();
        List<BlogPostModel> blogPostsData = viewBlogPostService.getBlogPostsData();

        request.setAttribute("blogPosts", blogPostsData);
        request.getRequestDispatcher("view.jsp").forward(request, response);
    }
}
