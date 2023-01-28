package com.taskmaster.services;

import java.util.Properties;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/*
 * The emailservices class is to create the emails that need to be sent to the user. Each method specifies the FROM email account, connects to the mail server using the java.mail API, logins, and 
 * sends an email to the user based on the email provided. 
 * 
 * There is one method to send the user the authentication email in order to activate the account, and another email to reset the user's password if it is forgotten.
 * 
 */


public class EmailServices {

	private String userEmail;

	public EmailServices(String userEmail) {
		super();
		this.userEmail = userEmail;
	}

	public void sendAuthroizationEmail() {

		// declaring the sender's email address and password
		String email = "email@gmail.com";
		String password = "password";

		// create a properties instance
		Properties p = new Properties();

		// setting the properties to the gmail host
		p.setProperty("mail.smtp.auth", "true");
		p.setProperty("mail.smtp.starttls.enable", "true");
		p.setProperty("mail.smtp.host", "smtp.gmail.com");
		p.setProperty("mail.smtp.port", "587");

		// passing the property object and creating a session for authenticating the email
		Session session = Session.getDefaultInstance(p, new javax.mail.Authenticator() {

			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(email, password);
			}
		});

		// creating and transporting out the email to the users email
		try {
			MimeMessage message = new MimeMessage(session);
			message.setFrom(new InternetAddress(email));
			message.addRecipient(Message.RecipientType.TO, new InternetAddress(userEmail));
			message.setSubject("TaskMaster - Activate Accountl");
			message.setText("To activate your account, please click the following link: "
					+ "http://localhost:8081/TaskMaster/ActivateUserServlet?email=" + userEmail);
			Transport.send(message);

		} catch (Exception e) {

			e.printStackTrace();
			System.out.print(e);

		}

	}

	public void sendPasswordResetEmail(String email, String newPassword) {
		// declaring the sender's email address and password
		String fromEmail = "email@gmail.com";
		String password = "password";

		// create a properties instance
		Properties p = new Properties();

		// setting the properties to the gmail host
		p.setProperty("mail.smtp.auth", "true");
		p.setProperty("mail.smtp.starttls.enable", "true");
		p.setProperty("mail.smtp.host", "smtp.gmail.com");
		p.setProperty("mail.smtp.port", "587");

		// passing the property object and creating a session for authenticating the email
		Session session = Session.getDefaultInstance(p, new javax.mail.Authenticator() {

			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(fromEmail, password);
			}
		});

		// creating and transporting out the email to the users email
		try {
			MimeMessage message = new MimeMessage(session);
			message.setFrom(new InternetAddress(email));
			InternetAddress[] toAddresses = { new InternetAddress(email) };
			message.setRecipients(Message.RecipientType.TO, toAddresses);
			message.setSubject("Reset Password");
			message.setText("Your password has been reset. This is your new password: " + newPassword
					+ "\nPlease change your password after logging in.");
			Transport.send(message);

		} catch (Exception e) {
			
			e.printStackTrace();
			System.out.print(e);
			
		}
	}

}
