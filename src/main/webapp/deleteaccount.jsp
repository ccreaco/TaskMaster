<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" type="text/css" href="style.css">
<title>Delete Account</title>
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
	
	<div style="text-align: center; float: center">We are sad to see you go!
	
	Please confirm your email address to delete your account.</div>
	
		<div class="form">
		<form action="DeleteServlet" method="post">
			<table>
				<tr>
				<td><input type="text" name="email" placeholder="Email"><nobr></nobr>
				<input type="submit" name="delete" value="Delete Account">
				</td>
				</tr>
			</table>
		</form>
	</div>

<div class="bottom_nav">
<a href="http://localhost:8081/TaskMaster_CapstoneProject_Group7/">Home</a>
</div>


</body>
</html>