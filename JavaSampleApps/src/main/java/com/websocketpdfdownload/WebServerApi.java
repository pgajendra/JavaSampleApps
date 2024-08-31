package com.websocketpdfdownload;

import java.io.IOException;
import java.util.Set;

import javax.websocket.CloseReason;
import javax.websocket.EncodeException;
import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

@ServerEndpoint(value = "/app", encoders = MessageEncoder.class, decoders = MessageDecoder.class)

public class WebServerApi {

	@OnOpen
	public void onOpen(Session session) {

		System.out.println("Connected, sessionID = " + session.getId());
	}

	@OnMessage
	public void onMessage(PdfBean message, Session session) throws EncodeException {

		try {
			session.getBasicRemote().sendObject(message);
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	}

	@OnClose
	public void onClose(Session session, CloseReason closeReason) {
		System.out.println("Session " + session.getId() + " closed because " + closeReason);
	}

}
