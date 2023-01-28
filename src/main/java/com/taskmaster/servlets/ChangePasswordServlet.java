package com.taskmaster.servlets;

import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.taskmaster.dao.UserDAO;
import com.taskmaster.beans.Users;

/*
 * The change password servlet servlet is used to change the users password. A HTTPSession will be created to get the username of the user logged in. Once the username is recieved, it will call the DAO
 * and get the users email and current password and set it into a new user. 
 * 
 * The user will be prompted to the change password jsp/form and will enter in their current password and their new password. If what the user puts as their current password is equal to the current password,
 * it will allow the user to change their password in the database. If not, it will prompt an error message depending on the error.
 * 
 * Once the password is changed it will bring the user back to their home page. 
 *  *  
 *  
 */


public class ChangePasswordServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private Users user = new Users();
	private UserDAO dao = new UserDAO();
	private String email;
	private String userName;
	private String password;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession();
		userName = (String) session.getAttribute("userName");

		try {
			user = dao.getUserByUserName(userName);
			email = user.getEmail();
			password = user.getPassword();

		} catch (SQLException e1) {

			e1.printStackTrace();
		}

		user.setUserName(userName);
		user.setEmail(email);
		user.setPassword(password);

		String currentPassword = request.getParameter("current");
		String newPassword = request.getParameter("new");
		String newPasswordConfirm = request.getParameter("confirm");

		String message = null;

		try {

			if (password.equals(currentPassword)) {

				if (newPassword.equals(newPasswordConfirm)) {

					Users user1 = new Users();
					user1.setPassword(newPasswordConfirm);
					user1.setEmail(email);
					dao.updatePassword(user1);

					message = "Your password has been changed.";
					request.setAttribute("message", message);
					request.getRequestDispatcher("/welcome.jsp").include(request, response);

				} else {

					message = "Your passwords do not match";
					request.setAttribute("message", message);
					request.getRequestDispatcher("/changepassword.jsp").include(request, response);

				}

			} else {

				message = "Current password is incorrect";
				request.setAttribute("message", message);
				request.getRequestDispatcher("/changepassword.jsp").forward(request, response);
			}

		} catch (Exception e) {

			e.printStackTrace();

		}

	}

}
