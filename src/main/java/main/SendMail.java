package main;

import dataprovider.PropertyObjectProvider;

import java.io.IOException;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMessage.RecipientType;

public class SendMail {

	public Session authenticate(Properties configProp) throws IOException
	{
		PropertyObjectProvider propObj = new PropertyObjectProvider();
		Properties prop = propObj.getAuthPropObj();
		
		return Session.getDefaultInstance(configProp,
				new javax.mail.Authenticator() {
					protected PasswordAuthentication getPasswordAuthentication() {
					return new PasswordAuthentication(prop.getProperty("username"), prop.getProperty("password"));
					}
				});
	}
	public Message ConfigureMessage(Session session) throws IOException, AddressException, MessagingException
	{
		PropertyObjectProvider propObj = new PropertyObjectProvider();
		Properties prop = propObj.getMailPropObj();

	
		Message message = new MimeMessage(session);
		message.setFrom(new InternetAddress(prop.getProperty("recepient")));
		message.setRecipients(RecipientType.TO,InternetAddress.parse(prop.getProperty("recepient")));
		message.setSubject(prop.getProperty("subject"));
		message.setText(prop.getProperty("message"));

		return message;
	}
	public void SendMail(Message message) throws MessagingException
	{
		Transport.send(message);
	}
	public static void main(String []args) throws IOException, MessagingException
	{
		PropertyObjectProvider propObj = new PropertyObjectProvider();
		Properties prop = propObj.getConfigPropObj();
		
		SendMail obj = new SendMail();
		Session session = obj.authenticate(prop);
		System.out.println("Authenticated Successfully..");
		Message message = obj.ConfigureMessage(session);
		System.out.println("Msg created..");
		obj.SendMail(message);
		System.out.println("==== Message Sent ====");
		
	}
}
