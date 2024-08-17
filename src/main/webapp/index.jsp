<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>Enter your login details</h3>
	<form action="login-user" method="post">
		Enter your email <br>
		<input type="text" name="userEmail" placeholder="Enter your email.."><br>
		<br> Enter your password <br>
		<input type="text" name="userPassword" placeholder="Enter your password:"><br>
		<br> <input type="submit">
	</form>
	<p>
		New here? <a href="registration.jsp">Click here</a> to register
	</p>

</body>
</html>