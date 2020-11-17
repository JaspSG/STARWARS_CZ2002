//package control;
//
//import java.util.Properties;
//
//import javax.mail.Authenticator;
//import javax.mail.Message;
//import javax.mail.PasswordAuthentication;
//import javax.mail.Session;
//import javax.mail.Transport;
//import javax.mail.internet.InternetAddress;
//import javax.mail.internet.MimeMessage;
//
//public class MailManager {
//	public static void sendMail(String recepient) throws Exception {
//		System.out.println("Preparing to send email");
//		Properties properties = new Properties();
//
//		properties.put("mail.smtp.auth", "true");
//		properties.put("mail.smtp.starttls.enable", "true");
//		properties.put("mail.smtp.host", "smtp.gmail.com");
//		properties.put("mail.smto.port", "587");
//
//		String myAccountEmail = "cz2002gatsby@gmail.com";
//		String password = "0v9Q!9bVSZRG";
//
//		Session session = Session.getInstance(properties, new Authenticator() {
//			@Override
//			protected PasswordAuthentication getPasswordAuthentication() {
//				return new PasswordAuthentication(myAccountEmail, password);
//			}
//		});
//		Message message = prepareMessage(session, myAccountEmail, recepient);
//
//		Transport.send(message);
//		System.out.println("Message sent successfully!");
//	}
//	private static Message prepareMessage(Session session, String myAccountEmail, String recepient) {
//		try {
//			Message message = new MimeMessage(session);
//			message.setFrom(new InternetAddress(myAccountEmail));
//			message.setRecipient(Message.RecipientType.TO, new InternetAddress(recepient));
//			message.setSubject("Test");
//			message.setText("Hey There!");
//			return message;
//		} catch(Exception ex) {
//			System.out.println("Failed");
//		}
//		return null;
//	}
//}
