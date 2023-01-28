<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" type="text/css" href="style.css">

<title>Login</title>
</head>
<body>

	<!-- LOGO -->
	<div style="text-align: center; float: center; margin: 10px;">
		<img src="images/Logo.PNG" alt="logo" width="200" height="45">
	</div>
	<br />
	<div class="form">
		<form action="LoginServlet" method="post">

			<table>
				<h3>Login to TaskMaster</h3>
				<tr>
					<td><input type="text" name="userName" placeholder="username"></td>
				</tr>
				<tr>
					<td><input type="password" name="password" placeholder="password"></td>
				</tr>
				<tr>
					<td><input type="submit" name="login" value="Login"> <input
						type="reset" name="reset" value="Clear"></td>
				</tr>
			</table>
			
			
			<em>${message}</em>
<c:remove var="message" scope="session" /> 


<br /> <a href="forgotpassword.jsp">I forgot my password</a>
			<br /><br />  <em><a href="register.jsp">Can't log in? Sign up for
					an account here</a></em>

		</form>
	</div>
	

	<div class="bottom_nav">
		<a href="http://localhost:8081/TaskMaster/">Home</a>
	</div>

</body>
</html>
