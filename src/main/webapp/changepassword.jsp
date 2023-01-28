<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" session="true" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  

    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" type="text/css" href="style.css">
<title>Change Password</title>
</head>
<body>
	<!-- LOGO -->
	<div style="text-align: center; float: center; margin: 10px;">
		<img src="images/Logo.PNG" alt="logo" width="200" height="45">
	</div>
	<br />
	
	
	<% 
		if(session.getAttribute("userName")==null) { 
			response.sendRedirect("index.html");
			
		}
	%>

<div class="form">
<form action="ChangePasswordServlet" method="post">
<table>
<tr><td><input type="password" name="current" placeholder="current password"></td></tr>
<tr><td><input type="password" name="new" placeholder="new password"></td></tr>
<tr><td><input type="password" name="confirm" placeholder="confirm new password"></td></tr>
<tr><td><input type="submit" value="Change Password"></td></tr>
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