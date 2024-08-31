package com.sendmail;


import java.io.FileInputStream;
import java.util.Properties;
import java.util.Random;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;



public class SendMail {

	public static void main(String[] args) {
		FileInputStream fis=null;
		Properties prop = null;
		//JSONObject obj = new JSONObject();
		try {
			System.out.println(System.getProperty("user.dir") );
			fis = new FileInputStream(
					System.getProperty("user.dir") + "\\src\\main\\resources\\mail.properties");
			prop = new Properties();
			prop.load(fis);
		}catch (Exception e) {
			// TODO: handle exception
		}
		
		Random rand = new Random();
		int rand_int1 = rand.nextInt(1000000);
		System.out.println("OTP IS : " + rand_int1);
	
		String to=prop.getProperty("to");
		String content = " <div style=\"font-family: Helvetica,Arial,sans-serif;min-width:1000px;overflow:auto;line-height:2\">\r\n"
				+ "        <div style=\"margin:50px auto;width:70%;padding:20px 0\">\r\n"
				+ "          <div style=\"border-bottom:1px solid #eee\">\r\n"
				+ "            <a href=\"\" style=\"font-size:1.4em;color: #005a6a;text-decoration:none;font-weight:600\">V Travels</a>\r\n"
				+ "          </div>\r\n" + "          <p style=\"font-size:1.1em\">Hi,</p>\r\n"
				+ "          <p>Your OTP for Reset Password\", The OTP is valid for 3 minutes.</p>\r\n"
				+ "          <h2 style=\"background: rgb(24, 153, 175);margin: 0 auto;width: max-content;padding: 0 10px;color: #fff;border-radius: 4px;\">"
				+ rand_int1 + "</h2>\r\n"
				+ "          <p style=\"font-size:0.9em;\">Regards,<br />V Travels</p>\r\n"
				+ "          <hr style=\"border:none;border-top:1px solid #eee\" />\r\n"
				+ "          <div style=\"float:right;padding:8px 0;color:#aaa;font-size:0.8em;line-height:1;font-weight:300\">\r\n"
				+ "            <p>V Travels </p>\r\n"
				+ "            <p>1600 Amphitheatre Parkway</p>\r\n"
				+ "            <p>California</p>\r\n" + "          </div>\r\n"
				+ "        </div>\r\n" + "      </div>";
		String from =prop.getProperty("from");

		final String user =prop.getProperty("user"); 

		final String mailPassword = prop.getProperty("mailPassword");
		Properties properties = new Properties();
		properties.put("mail.smtp.auth", true);
		properties.put("mail.smtp.ssl.enable", true);
		properties.put("mail.smtp.host",prop.getProperty("host"));
		properties.put("mail.smtp.ssl.protocols", prop.getProperty("sslprotocols"));
		properties.put("mail.smtp.port",  prop.getProperty("port"));
		Session session = Session.getDefaultInstance(properties, new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(user, mailPassword);
			}
		});

		try {

			MimeMessage message = new MimeMessage(session);

			message.setFrom(new InternetAddress(from));

			message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
			message.setSubject("Your OTP for Reset");

			message.setContent(content, "text/html");

			Transport.send(message);
			System.out.println("Sent message successfully....to  " + to);
			
		} catch (MessagingException mex) {
			System.out.println("Error While Sending Mail");
			
			mex.printStackTrace();
		}
	}

}
