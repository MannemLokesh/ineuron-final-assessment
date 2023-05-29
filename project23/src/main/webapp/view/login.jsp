<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>Login Form</h1>
	<p>${message}</p>
	<h5>Enter Your details below</h5>
	<form action="/validate" method="post">
		<label>Username : </label><input type="text" name="userName" required><br>
		<label>Password : </label><input type="password" name="password" required><br>
		<input type="submit">
	</form>
</body>
</html>