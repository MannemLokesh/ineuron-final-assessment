<%@page import="com.ineuron.model.BlogPostModel"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>View Blog Posts</h1>
    <table>
        <tr>
            <th>Title</th>
            <th>Description</th>
            <th>Content</th>
        </tr>
        <tr>
	<%
	    List<BlogPostModel> blogposts= (List<BlogPostModel>) request.getAttribute("blogPosts");
		for(BlogPostModel b: blogposts)
		{
			out.print("<td>"+b.getTitle()+"</td><td>"+b.getDescription()+"</td><td>"+b.getContent()+"</td></tr>");
		}
	%>
	</table>
</body>
</html>