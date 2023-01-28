package com.taskmaster.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
/*
 * The logout servlet will end the user session and remove the attributes. Once logged out, the user will be redirected to the homepage.
 *   *
 */


public class LogoutServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession(false);

		if (session != null) {
			session.removeAttribute("userName");
			session.invalidate();

			response.sendRedirect("http://localhost:8081/TaskMaster_CapstoneProject_Group7/");

		}
	}
}