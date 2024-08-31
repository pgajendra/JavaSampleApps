package com.websocketpdfdownload;

import java.io.StringReader;

import javax.json.Json;
import javax.json.JsonObject;
import javax.websocket.Decoder;
import javax.websocket.EndpointConfig;

public class MessageDecoder implements Decoder.Text<PdfBean> {

	@Override
	public PdfBean decode(String jsonMessage) {
		PdfBean message = new PdfBean();

		try {
			JsonObject jsonObject = Json.createReader(new StringReader(jsonMessage)).readObject();

			
			if (jsonObject.containsKey("pdfdata")) {
				message.setPdfData(jsonObject.getString("pdfdata"));
			}
			
		} catch (Exception ex) {
			ex.printStackTrace();
		}

		return message;
	}

	@Override
	public boolean willDecode(String jsonMessage) {
		try {
			Json.createReader(new StringReader(jsonMessage)).readObject();
			return true;

		} catch (Exception e) {
			return false;
		}
	}

	public void init(EndpointConfig ec) {
		System.out.println("Initializing message decoder");
	}

	@Override
	public void destroy() {
		System.out.println("Destroyed message decoder");
	}
}