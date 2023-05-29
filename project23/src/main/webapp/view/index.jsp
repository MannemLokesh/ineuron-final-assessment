<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>Registration Form</h1>
	<h5>Enter Your details below</h5>
	<form action="/postUser" method="post">
		<label>Username : </label><input type="text" name="userName" required><br>
		<label>Password : </label><input type="password" name="password" required><br>
		<label>Age : </label><input type="number" name="age" required><br>
		<label>Address : </label><input type="text" name="address" required><br>
		<label>MObile Number : </label><input type="number" name="mobileNo" required><br>
		<input type="submit">
	</form>
</body>
</html>