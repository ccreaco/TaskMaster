package com.taskmaster.beans;

/*
 * This is the Builder interface that has all of the methods to build a user.
 * 
 * 
 */


public interface Builder {

	public UserBuilder ID(int ID);

	public UserBuilder setFirstName(String firstName);

	public UserBuilder setlastName(String lastName);

	public UserBuilder setEmail(String email);

	public UserBuilder setUserName(String userName);

	public UserBuilder setPassword(String password);
}
