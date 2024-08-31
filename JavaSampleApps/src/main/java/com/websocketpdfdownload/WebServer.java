package com.websocketpdfdownload;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Properties;

import org.glassfish.tyrus.server.Server;

public class WebServer {
	public static void main(String a[]) {

		FileInputStream fis = null;
		Properties prop = null;

		try {
			fis = new FileInputStream(
					System.getProperty("user.dir") + "\\src\\main\\resources\\pdfdownload.properties");
			prop = new Properties();
			prop.load(fis);
		} catch (FileNotFoundException fnfe) {

			fnfe.printStackTrace();

		} catch (IOException ioe) {
			ioe.printStackTrace();

		} finally {
			try {
				fis.close();
			} catch (IOException e) {
				e.printStackTrace();

			}
		}
		int port = Integer.parseInt(prop.getProperty("port"));
		Server server;
		server = new Server("localhost", port, "/dsc", WebServerApi.class);
		try {
			server.start();
			BufferedReader bufferRead = new BufferedReader(new InputStreamReader(System.in));
			bufferRead.readLine();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			server.stop();
		}
	}
}