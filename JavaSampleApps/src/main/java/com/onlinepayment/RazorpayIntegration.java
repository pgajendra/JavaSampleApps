package com.onlinepayment;


import java.util.Date;

//import com.razorpay.RazorpayClient;
//import com.razorpay.RazorpayException;
//import com.razorpay.Order;

import java.util.HashMap;
import java.util.Map;

//import org.codehaus.jackson.map.ObjectMapper;
import org.json.JSONObject;

import com.google.gson.JsonObject;
import com.razorpay.Order;
import com.razorpay.OrderClient;
import com.razorpay.RazorpayClient;

import com.razorpay.Payment;
import com.razorpay.PaymentLink;
import com.razorpay.RazorpayException;

public class RazorpayIntegration {

	private static final String API_KEY = "";
	private static final String API_SECRET = "";

	public static void main(String[] args) throws Exception {

		 new RazorpayIntegration().generatePAyLink();
		
		System.out.println(new RazorpayIntegration().fetchPayLinkIdDetails("54gfhgfhjfgh"));

	}

	void generatePAyLink() throws Exception {

		RazorpayClient razorpay = new RazorpayClient(API_KEY, API_SECRET);
		JSONObject paymentLinkRequest = new JSONObject();
		paymentLinkRequest.put("amount", 1000);
		paymentLinkRequest.put("currency", "INR");
		paymentLinkRequest.put("accept_partial", false);
		paymentLinkRequest.put("first_min_partial_amount", 100);
		paymentLinkRequest.put("expire_by", 1691097057);
		paymentLinkRequest.put("reference_id", String.valueOf(new Date().getTime()));
		paymentLinkRequest.put("description", "Payment for policy no #23456"); //description
		JSONObject customer = new JSONObject();
		customer.put("name", "Shubham");  //owner company name
		customer.put("contact", "+56464");
		customer.put("email", "gajendra@gmail.com");
		paymentLinkRequest.put("customer", customer);
		JSONObject notify = new JSONObject();
		notify.put("sms", true);
		notify.put("email", true);
		paymentLinkRequest.put("notify", notify);
		paymentLinkRequest.put("reminder_enable", true);
		JSONObject notes = new JSONObject();
		notes.put("policy_name", "Jeevan Bima");
		paymentLinkRequest.put("notes", notes);
		paymentLinkRequest.put("callback_url", "https://example-callback-url.com/");
		paymentLinkRequest.put("callback_method", "get");

		PaymentLink payment = razorpay.paymentLink.create(paymentLinkRequest);

		JSONObject paymentyData = payment.toJson();

		System.out.println(paymentyData);

//		String d = payment.get("short_url");

	}
	
	boolean listenPayment(String plId) {
		
		return false;
		
	}

	Order fetchOrderDetails(String orderId) throws Exception {

		JSONObject details = new JSONObject();

		RazorpayClient razorpay = new RazorpayClient(API_KEY, API_SECRET);

		Order order = razorpay.orders.fetch(orderId);

		return order;

	}

	PaymentLink fetchPayLinkIdDetails(String plId) throws Exception {

		JSONObject details = new JSONObject();

		RazorpayClient razorpay = new RazorpayClient(API_KEY, API_SECRET);

		PaymentLink payment = razorpay.paymentLink.fetch(plId);

		return payment;

	}

}
