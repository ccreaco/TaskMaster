package com.taskmaster.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/*
* The second register servlet will will take the email from the homepage, and enter it into the register2.jsp page form automatically. 
*  *
*/

public class Register2Servlet extends HttpServlet {/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String email = request.getParameter("email");
		
		if(email!=null) { 
			request.setAttribute("email", email);
			  request.getRequestDispatcher("/register2.jsp").include(request, response);
		} else { 
			request.getRequestDispatcher("/index.html");
		}
		
	}

}


