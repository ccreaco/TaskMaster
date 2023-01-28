<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" type="text/css" href="style.css">
<title>TaskMaster</title>
</head>
<body>

	<%
	if (session.getAttribute("userName") == null) {
		response.sendRedirect("index.html");

	}
	%>
	<div style="text-align: left; float: left; margin: 10px;">
		<em>${message}</em>
		<c:remove var="message" scope="session" />
	</div>


	<!-- LOGO -->
	<div style="text-align: center; float: center; margin: 10px;">
		<img src="images/Logo.PNG" alt="logo" width="200" height="45">
	</div>
	<br />

	<!-- ACCOUNT -->
	<div style="text-align: left; float: right; margin: 10px;" class="ul">
		<li><a href="welcome.jsp">Account Options</a>
			<ul>

				<li><a
					href="http://localhost:8081/TaskMaster/changepassword.jsp">Change
						Password</a></li>
				<li><a
					href="http://localhost:8081/TaskMaster/deleteaccount.jsp">Delete
						Account</a></li>

				<li><a
					href="http://localhost:8081/TaskMaster/LogoutServlet">Logout</a></li>
			</ul></li>
	</div>

	<!-- BOTTOM NAVIGATION -->
	<div class="bottom_nav">
		<a href="http://localhost:8081/TaskMaster/">Home</a>
	</div>

	
		<div class="form">
		<form action="TaskServlet" method="post">

			<table>
				<tr>
				<td><h3>Add New Task</h3></td>
				<tr>
					<td><input type="text" name="taskName"
						placeholder="task name" required></td>
				</tr>
				<tr>
					<td><input type="text" name="targetDate" placeholder="target date" required></td>
				</tr>
				<tr>
					<td><input type="submit" name="register" value="Add">
						<input type="reset" name="reset" value="Clear"></td>
				</tr>
			</table>
						<em>${error}</em>
			<c:remove var="message" scope="session" /> 
			
			


		</form>
	</div>