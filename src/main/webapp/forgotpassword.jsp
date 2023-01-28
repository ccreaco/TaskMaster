<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" session="true"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" type="text/css" href="style.css">
<title>Forgot Password</title>
</head>
<body>
	<!-- LOGO -->
	<div style="text-align: left; float: left; margin: 10px;">
		<img src="images/Logo.PNG" alt="logo" width="200" height="45">
	</div>

	<!-- LOGIN -->
	<div style="text-align: right; float: right; margin: 10px; class="loginbar">
		<a
			href="http://localhost:8081/TaskMaster_CapstoneProject_Group7/login.jsp">Login</a>
		<div class="register">
			<a
				href="http://localhost:8081/TaskMaster_CapstoneProject_Group7/register.jsp">Register</a>
		</div>
	</div>
	
	<div class="form">
		<form action="ForgotPasswordServlet" method="post">
			<table>
				<tr>
					<td></td>
				</tr>
				<tr>
					<td></td>
				</tr>
				<tr>
					<td><input type="text" name="email" placeholder="email"></td>
				</tr>
				<tr>
					<td><input type="submit" value="Send new password"></td>
				</tr>
			</table>

			<em>${message}</em>
			<c:remove var="message" scope="session" />

		</form>

	</div>

	<div class="bottom_nav">
		<a href="http://localhost:8081/TaskMaster_CapstoneProject_Group7/">Home</a>
	</div>


</body>
</html>