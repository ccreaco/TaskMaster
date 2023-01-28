package com.taskmaster.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.taskmaster.beans.UserBuilder;
import com.taskmaster.beans.Users;
import com.taskmaster.services.UserServices;


/* 
 * 
 * The UserDAO class is implementing the UserServices interface. In this class it is overiding all of the methods from the interface.
 * Each method will get the database connection, then run the appropriate SQL statment, while either setting or getting the required variables. 
 * 
 * 
 */

public class UserDAO implements UserServices{

	private Connection connection = null;
	private String GET_USER_SQL = "SELECT * from users WHERE userName=? AND password=? AND status=1;";
	private String INSERT_USERS_SQL = "INSERT INTO users(firstName, lastName, email, userName, password) VALUES (?,?,?,?,?);";
	private String SELECT_USER_EMAIL_SQL = "SELECT email, status FROM users WHERE email=? AND status='0';";
	private String UPDATE_USER_STATUS_SQL = "UPDATE users SET status='1' WHERE email=?;";
	private String DELETE_USER_SQL = "DELETE FROM users WHERE email = ?;";
	private String GET_USERNAME_SQL = "SELECT userName, email, password FROM USERS WHERE userName=?;";
	private String UPDATE_PASSWORD_SQL = "UPDATE USERS SET password=? WHERE email=?;";
	private String GET_USER_EMAIL_SQL = "SELECT * from users WHERE email =?;";
	
	
	public UserDAO() { 
		
	}
	
	@Override
	public int insertUser(Users user) throws SQLException {

		int rows = 0;

		try {

			connection = DBConnection.getInstance().getConnection();
					
			PreparedStatement ps = connection.prepareStatement(INSERT_USERS_SQL);

			ps.setString(1, user.getFirstName());
			ps.setString(2, user.getLastName());
			ps.setString(3, user.getEmail());
			ps.setString(4, user.getUserName());
			ps.setString(5, user.getPassword());

			rows = ps.executeUpdate();

		} catch (Exception e) {

			e.printStackTrace();

		}

		return rows;

	}

	@Override
	public int updateUserStatus(String email) throws SQLException {

		int rowUpdated = 0;

		try {

			connection = DBConnection.getInstance().getConnection();
			PreparedStatement ps = connection.prepareStatement(SELECT_USER_EMAIL_SQL);

			ps.setString(1, email);

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {

				ps = connection.prepareStatement(UPDATE_USER_STATUS_SQL);
				ps.setString(1, email);

				ps.executeUpdate();

			}

		} catch (Exception e) {

			e.printStackTrace();
		}

		return rowUpdated;

	}

	@Override
	public String authorizeLogin(Users user) {
		
		String userName = user.getUserName();
		String password = user.getPassword();

		try {

			connection = DBConnection.getInstance().getConnection();
			PreparedStatement ps = connection.prepareStatement(GET_USER_SQL);

			ps.setString(1, userName);
			ps.setString(2, password);

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {

				String dbUserName = rs.getString("userName");
				String dbPassword = rs.getString("password");

				if (dbUserName.equalsIgnoreCase(userName) && dbPassword.equalsIgnoreCase(password)) {

					return "Login successful!";
				}
			}

		} catch (Exception e) {

			System.out.println("LoginDAO File Error" + e);

		}

		return "Incorrect username or password.";
	}

	@Override
	public Users getUserByUserName(String userName) throws SQLException {
		
		Users user = new Users();
		
		try { 
			
			connection = DBConnection.getInstance().getConnection();
			PreparedStatement ps = connection.prepareStatement(GET_USERNAME_SQL);
			ps.setString(1, userName);
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) { 
				
				userName = rs.getString("userName");
				String email = rs.getString("email");
				String password = rs.getString("password");
				
				user = new UserBuilder().setEmail(email).setUserName(userName).setPassword(password).buildUser();
						
						
			}
			
			
		} catch (Exception e) { 
			e.printStackTrace();
		}
		
		
		return user;
	}

	@Override
	public int deleteUser(String email) throws SQLException {
		int status = 0;
		
		try { 
			
			connection = DBConnection.getInstance().getConnection();
			PreparedStatement ps = connection.prepareStatement(DELETE_USER_SQL);
			ps.setString(1, email);
			status = ps.executeUpdate();
			
		} catch (Exception e) { 
			e.printStackTrace(); 
	}
		return status;
	}

	
	@Override
	public int updatePassword(Users user1) throws SQLException {

		int status = 0;
		
		try { 
			
			connection = DBConnection.getInstance().getConnection();
			PreparedStatement ps = connection.prepareStatement(UPDATE_PASSWORD_SQL);
			
			ps.setString(1, user1.getPassword());
			ps.setString(2, user1.getEmail());
			
			status = ps.executeUpdate();

			
		} catch (Exception e) { 
			
			e.printStackTrace();
			
		}
		
		return status;
	}

	@Override
	public Users getUserByEmail(String email) throws SQLException {
		
		Users user = new Users();
		
		try { 
			
			connection = DBConnection.getInstance().getConnection();
			PreparedStatement ps = connection.prepareStatement(GET_USER_EMAIL_SQL);
			
			ps.setString(1, email);
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) { 
				
				String e = rs.getString("email");
				String un = rs.getString("userName");
				String p = rs.getString("password");
				
				user = new UserBuilder().setEmail(e).setUserName(un).setPassword(p).buildUser();
				
			}
			
		} catch (Exception e) { 
			e.printStackTrace();
		}
		
		return user;
	}

}
