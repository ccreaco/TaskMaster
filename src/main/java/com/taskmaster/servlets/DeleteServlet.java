package com.taskmaster.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.taskmaster.dao.UserDAO;

/*
 * The delete servlet deletes the user's account. The user will be prompted at the delete.jsp page to enter their email address to confirm delete. Once the email address is entered,
 * it will delete the account and redirect the user to the homepage.
 *  *  
 *  
 */

public class DeleteServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private UserDAO dao = new UserDAO();

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		int status = 0;

		try {

			String email = request.getParameter("email");
			status = dao.deleteUser(email);

		} catch (Exception e) {

			e.printStackTrace();

		}

		if (status > 0) {
			response.sendRedirect("http://localhost:8081/TaskMaster/");
		} else {
			PrintWriter writer = response.getWriter();
			writer.write("Unable to delete!");
		}
	}
}
