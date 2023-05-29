<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
    <title>Create Blog Post</title>
</head>
<body>
    <h1>Create Blog Post</h1>
    <form action="CreateBlogPostServlet" method="post">
        <label>Title:</label>
        <input type="text" name="title" required><br>
        <label>Description:</label>
        <input type="text" name="description" required><br>
        <label>Content:</label>
        <textarea name="content" rows="5" required></textarea><br>
        <input type="submit" value="Create">
    </form>
    <hr>
    <a href="view">View Blog Posts</a>
</body>
</html>