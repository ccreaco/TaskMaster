package com.taskmaster.servlets;

import com.taskmaster.dao.UserDAO;
import com.taskmaster.beans.UserBuilder;
import com.taskmaster.beans.Users;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/*
 * The login servlet will log the user into their account. It will call the userDAO in order to authorize the login, which will verify that their account is active (status = 1). Once the user is logged in
 * a new session will be created and they will be directed to the welcome page.
 *   *
 */



public class LoginServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private UserDAO dao = new UserDAO(); 
	private Users user;
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String userName = request.getParameter("userName");
		String password = request.getParameter("password");
		
		user = new UserBuilder().setUserName(userName).setPassword(password).buildUser();
		
		String login = dao.authorizeLogin(user);
		
		if(login.equals("Login successful!")) { 
			HttpSession session = request.getSession(true);
			session.setAttribute("userName", user.getUserName());
			RequestDispatcher rd = request.getRequestDispatcher("welcome.jsp");
			rd.forward(request, response);
			
			
		} else { 
			
			String message = "Invalid username or password.";
			request.setAttribute("message", message);
			RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
			rd.include(request, response);
		}
		
		
	}
}
