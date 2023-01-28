package com.taskmaster.services;

import java.sql.SQLException;

import com.taskmaster.beans.UserBuilder;
import com.taskmaster.beans.Users;

/*
 * This is the interface for all of the user services that will be used in the UserServices class to perform actions utilizing the database.
 * These are specific to user authentication, utilizing CRUD to insert a user, update user status, get the user by a specific variable,
 * authorize the login, delete a user and update a password.
 * 
 */

public interface UserServices {

	//insert into users
	int insertUser(Users user) throws SQLException;
	
	//updateUserStatus 
	public int updateUserStatus(String email) throws SQLException;
	
	//get userbyUserName
	public Users getUserByUserName(String userName) throws SQLException;
	
	//get userbyUserName
	public Users getUserByEmail(String email) throws SQLException;
	
	//authroize login 
	public String authorizeLogin(Users user);
	
	//delete user
	public int deleteUser(String email) throws SQLException;
	
	//edit password
	int updatePassword(Users user) throws SQLException;


	
}
