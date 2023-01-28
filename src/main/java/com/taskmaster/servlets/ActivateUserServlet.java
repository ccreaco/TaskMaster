package com.taskmaster.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.taskmaster.dao.UserDAO;


/*
 * The activateuser servlet is used to activate the user after they recieve their email. Once the user clicks the email, it will redirect to the activate user class. 
 * The activate user class will update the status of the user to 1 confirming that their account has been activated. Once the account is active the user will be redirected to the login page
 * to login to their account.
 * 
 *  
 *  
 */

public class ActivateUserServlet extends HttpServlet {

	
	
	private static final long serialVersionUID = 1L;
	private UserDAO dao = new UserDAO();

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String email = request.getParameter("email");

		int status = 0;

		try {

			status = dao.updateUserStatus(email);

		} catch (SQLException e) {

			e.printStackTrace();
		}

		if (status > 0) {
			
			System.out.print("ERROR");
			
			
		} else {
			
			response.sendRedirect("login.jsp");
			PrintWriter write = response.getWriter();
			write.write("Your account is now active!");
		}
	}
}
