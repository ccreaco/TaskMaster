<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
		<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
	
	
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" type="text/css" href="style.css">

<title>Register</title>
</head>
<body>

	<!-- LOGO -->
	<div style="text-align: center; float: center; margin: 10px;">
		<img src="images/Logo.PNG" alt="logo" width="200" height="45">
	</div>
	<br />
	<div class="form">
		<form action="RegisterServlet" method="post">

			<table>
				<tr>
				<td><h3>Sign up for your account</h3></td>
				<tr>
					<td><input type="text" name="firstName"
						placeholder="first name" required></td>
				</tr>
				<tr>
					<td><input type="text" name="lastName" placeholder="last name" required></td>
				</tr>
				<tr>
					<td><input type="text" name="email" value="${email}" required></td>
				</tr>
				<tr>
					<td><input type="text" name="userName" placeholder="username" required></td>
				</tr>
				<tr>
					<td><input type="password" name="password"
						placeholder="password" required></td>
				</tr>
				<tr>
					<td><input type="submit" name="register" value="Register">
						<input type="reset" name="reset" value="Clear"></td>
				</tr>
			</table>
						<em>${error}</em>
			<c:remove var="message" scope="session" /> 
			
			
			<br /> <em><a href="login.jsp">Already have account? Login here</a></em>
			


		</form>
	</div>
	
	
	<div class="bottom_nav">
<a href="http://localhost:8081/TaskMaster_CapstoneProject_Group7/">Home</a>
</div>
	
	
	
</body>
</html>
