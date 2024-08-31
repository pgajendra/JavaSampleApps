package com.smsandwhatsapp;

import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.rest.api.v2010.account.Message.Status;
import com.twilio.type.PhoneNumber;

import java.net.URI;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class WhatsAppTemplateMessage {
	public static final String ACCOUNT_SID = "jhfksb";
	public static final String AUTH_TOKEN = "dfrgdfgbzd";

	public static void main(String[] args) {
		Twilio.init(ACCOUNT_SID, AUTH_TOKEN);

	
		String fileName = "file-sample_150kB.pdf";
		Message message1 = Message.creator(new PhoneNumber("whatsapp:+236453"),
				
				new PhoneNumber("whatsapp:+45234"), // From number
				"").setMessagingServiceSid("fgfdgdghrt") // Messaging Service SID
				.setContentSid("ffdfdd") // Content SID of the approved template

//         
				.setContentVariables("{\"name\":\"rr123\",\"date\":\"10/2/2020\",\"fileName\":\"file-sample_150kB.pdf\"}")
				.create();

		System.out.println(message1.getSid());
		//delete(message1.getSid());
		Message.deleter(message1.getSid()).delete();
		try {
			
			while(true) {
			Status status = Message.fetcher(message1.getSid()).fetch().getStatus();
		if(	status.toString().equalsIgnoreCase("delivered")) {
			Message.deleter(message1.getSid()).delete();
			break;
		}else if(	status.toString().equalsIgnoreCase("undelivered")||status.toString().equalsIgnoreCase("failed")) {
			System.out.println("message was faild unable to delete");
			break;
		}
		Thread.sleep(1000);
			}
			
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	
	}
	
	public static String delete(String msid) {
try {
			
			while(true) {
			Status status = Message.fetcher(msid).fetch().getStatus();
		if(	status.toString().equalsIgnoreCase("delivered")) {
			Message.deleter(msid).delete();
			return "success";
		}else if(	status.toString().equalsIgnoreCase("undelivered")||status.toString().equalsIgnoreCase("failed")) {
			System.out.println("message was faild unable to delete");
			return "failed";
		}
		Thread.sleep(1000);
			}
			
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
return null;
	}
	
}
