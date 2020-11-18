package control;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

public class MailManager {
	public static void sendMail(String recepient) throws Exception {
		System.out.println("Sending email...");
		Properties properties = new Properties();

		properties.put("mail.smtp.auth", "true");
		properties.put("mail.smtp.starttls.enable", "true");
		properties.put("mail.smtp.host", "smtp.gmail.com");
		properties.put("mail.smto.port", "587");

		String myAccountEmail = "cz2002gatsby@gmail.com";
		String password = "0v9Q!9bVSZRG";

		Session session = Session.getInstance(properties, new Authenticator() {
			@Override
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(myAccountEmail, password);
			}
		});
		Message message = prepareMessage(session, myAccountEmail, recepient);

		Transport.send(message);
		System.out.println("Message sent successfully!");
	}
	private static Message prepareMessage(Session session, String myAccountEmail, String recepient) {
		try {
			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress(myAccountEmail));
			message.setRecipient(Message.RecipientType.TO, new InternetAddress(recepient));
			message.setSubject("You have been enroll into the course.");
			message.setText("Dear student, you have been added in the course.");
			return message;
		} catch(Exception ex) {
			System.out.println("Failed");
		}
		return null;
	}
}
