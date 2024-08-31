package com.websocketpdfdownload;

import javax.websocket.Encoder;

public class MessageEncoder implements Encoder.Text<PdfBean> {

	final static Object SYNCHRONIZEDOBJ = new Object();

	@Override
	public String encode(PdfBean message) {


				return new DscSignDocument().GetSignedPdf(message);
			

		
		

	}

	@Override
	public void destroy() {
		System.out.println("Destroying encoder...");
	}

	@Override
	public void init(javax.websocket.EndpointConfig config) {

		System.out.println("Initializing message encoder");
	}

}