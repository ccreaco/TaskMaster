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
					href="http://localhost:8081/TaskMaster_CapstoneProject_Group7/changepassword.jsp">Change
						Password</a></li>
				<li><a
					href="http://localhost:8081/TaskMaster_CapstoneProject_Group7/deleteaccount.jsp">Delete
						Account</a></li>

				<li><a
					href="http://localhost:8081/TaskMaster_CapstoneProject_Group7/LogoutServlet">Logout</a></li>
			</ul></li>
	</div>

	<!-- BOTTOM NAVIGATION -->
	<div class="bottom_nav">
		<a href="http://localhost:8081/TaskMaster_CapstoneProject_Group7/">Home</a>
	</div>


	<sql:setDataSource var="myDS" driver="com.mysql.jdbc.Driver"
		url="jdbc:mysql://localhost:3309/taskmaster" user="root"
		password="Sandor12" />

	<sql:query var="listTasks" dataSource="${myDS}">
    	SELECT * 
			FROM tasks 
				ORDER BY CASE 
				when taskStatus = 'Pending' THEN 1 WHEN taskStatus ='Complete' THEN 2 END;
	</sql:query>

	<!-- TASK -->
	<div style="text-align: left; float: center;"  >

		<table class="tasks">
			<h3>TASKS</h3>
			<tr> 
				<th>Task</th>
				<th>Status</th>
				<th>Target Date</th>
				<th>Actions</th>
			</tr>
			<c:forEach var="task" items="${listTasks.rows}">
				<tr>
					<td><c:out value="${task.taskName}"/></td>
					<td><c:out value="${task.taskStatus}"/></td>
					<td><c:out value="${task.targetDate}"/></td>
					<td>
					<a href="http://localhost:8081/TaskMaster_CapstoneProject_Group7/MarkTaskCompleteServlet?taskID=<c:out value='${task.taskID}' />">Complete</a>
						&nbsp;&nbsp;&nbsp;&nbsp; <a href="http://localhost:8081/TaskMaster_CapstoneProject_Group7/DeleteTaskServlet?taskID=<c:out value='${task.taskID}' />">Delete</a>
					</td>
				</tr>
				
			</c:forEach>

		</table>
		</br>
		</br>
		<a href="http://localhost:8081/TaskMaster_CapstoneProject_Group7/addtask.jsp">New Task</a>
		&nbsp;&nbsp;&nbsp;&nbsp; 
		<a href="http://localhost:8081/TaskMaster_CapstoneProject_Group7/DeleteAllTasksServlet">Delete all tasks</a>

	</div>
</body>
</html>
