package com.smsandwhatsapp;

import java.net.URI;
import java.util.Arrays;

import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;

public class WhatsAppMessageSender {

	// Your Account SID and Auth Token from Twilio
	public static final String ACCOUNT_SID = "78686";
	public static final String AUTH_TOKEN = "hfjhjty7";

	public static void main(String[] args) {
		Twilio.init(ACCOUNT_SID, AUTH_TOKEN);

//
		 Message message2 =
	                Message.creator(
	                               new com.twilio.type.PhoneNumber("whatsapp:+7868"),//to number
	                               new com.twilio.type.PhoneNumber("whatsapp:+886"),//from number
	                               Arrays.asList(URI.create(
	                                       "https://jhgajsc.ap-south-1.amazonaws.com/images11.jpg")))
	                        .create();
	
		

	        System.out.println(message2.getSid());
		 
		 

	}
}
