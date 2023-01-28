package com.taskmaster.servlets;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.lang3.RandomStringUtils;

import com.taskmaster.dao.UserDAO;
import com.taskmaster.beans.Users;
import com.taskmaster.services.EmailServices;

/*
 * The forgot password servlet will get the users email address that was entered in the form. Once the email is recieved it will generate a random password for the client, update the database with
 * the new password, and send an email to the user with their new password. The user can then log in with their new password.
 *   *
 */


public class ForgotPasswordServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private UserDAO dao = new UserDAO();
	private String randomPassword;
	private Users user = new Users();
    

	
	 protected void doPost(HttpServletRequest request, HttpServletResponse response)
	            throws ServletException, IOException {
		 
		 
		 String email = request.getParameter("email"); 
		 user.setEmail(email);
		 user.setPassword(resetUserPassword(randomPassword));
		 
	    try {
			
			dao.updatePassword(user);
			
		} catch (SQLException e) {

			e.printStackTrace();
		}
		 
		 EmailServices es = new EmailServices(email); 
		 es.sendPasswordResetEmail(email, randomPassword);
		 
		String message = "Email sent. Please check your inbox for your new password.";
		request.setAttribute("message", message);
		RequestDispatcher rd = request.getRequestDispatcher("forgotpassword.jsp");
		rd.include(request, response);
		
	
		 
		
		 
	 }
	 
	 public String resetUserPassword(String email) {
		    
			randomPassword = RandomStringUtils.randomAlphanumeric(10);
			
		    return randomPassword;
		}
}
