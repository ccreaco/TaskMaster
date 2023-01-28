package com.taskmaster.beans;

/*
 * This is the UserBuilder class that implements all the methods from the Builder interface.
 * This class is used to build a user, utilizing all of the variables, without having to use complex constructors. 
 *  * 
 */

public class UserBuilder implements Builder {
	
		private int ID;
		private String firstName;
		private String lastName;
		private String email;
		private String userName;
		private String password;
		
		public UserBuilder(UserBuilder builder) {
			this.ID = builder.ID;
			this.firstName = builder.firstName;
			this.lastName = builder.lastName;
			this.email = builder.email;
			this.userName = builder.userName;
			this.password = builder.password;
		}

		public UserBuilder() { 
			
		}
		
		@Override
		public UserBuilder ID(int ID) {
			this.ID = ID;
			return this;
		}

		@Override
		public UserBuilder setFirstName(String firstName) {
			this.firstName = firstName;
			return this;
		}

		@Override
		public UserBuilder setlastName(String lastName) {
			this.lastName = lastName;
			return this;
		}

		@Override
		public UserBuilder setEmail(String email) {
			this.email = email;
			return this;
		}

		@Override
		public UserBuilder setUserName(String userName) {
			this.userName = userName;
			return this;
		}

		@Override
		public UserBuilder setPassword(String password) {
			this.password = password;
			return this;
		}

		public Users buildUser() {
			return new Users(ID, firstName, lastName, email, userName, password);
		}

	
}
