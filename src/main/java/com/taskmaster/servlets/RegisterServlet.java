package com.taskmaster.servlets;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.taskmaster.dao.UserDAO;
import com.taskmaster.beans.UserBuilder;
import com.taskmaster.beans.Users;
import com.taskmaster.services.EmailServices;

/*
 * The register servlet will register the user. It will create a new user and insert it into the database. Once the user is registered, it will call the email services class in order to send
 * the authorization email to the user. It will then redirect to the verify.jsp page which tells the user to check their email to activate their account.
 *   *
 */

public class RegisterServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private Users user;
	private UserDAO dao = new UserDAO();

	public RegisterServlet() {
		super();
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		String email = request.getParameter("email");
		String userName = request.getParameter("userName");
		String password = request.getParameter("password");

		user = new UserBuilder().setFirstName(firstName).setlastName(lastName).setUserName(userName).setEmail(email).setPassword(password).buildUser();
				

		int rows = 0;

		try {

			rows = dao.insertUser(user);

		} catch (SQLException e) {

			e.getMessage();

		}

		
		  if (rows == 0) {
		  
		  request.setAttribute("error", "This email/username is already in use. Please login or create new.");
		  request.getRequestDispatcher("/register.jsp").include(request, response);
		  
		  } else {
		  
		  EmailServices es = new EmailServices(email); es.sendAuthroizationEmail();
		  response.sendRedirect(
		  "http://localhost:8081/TaskMaster/verify.jsp");
		  
		  }
		 

	}

}
