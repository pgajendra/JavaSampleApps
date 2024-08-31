package com.smsandwhatsapp;

import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;

public class SendSMS {
	// Find your Account SID and Auth Token at twilio.com/console
	public static final String ACCOUNT_SID = "";
	public static final String AUTH_TOKEN = "";

	public static void main(String[] args) {
		Twilio.init(ACCOUNT_SID, AUTH_TOKEN);

		Message message = Message.creator(new PhoneNumber("+91676"), // To number
				new PhoneNumber("+6575756"), // From number (Twilio number)
				"Hello murali from gaja!").create();

		System.out.println(message.getSid());
	}
}
