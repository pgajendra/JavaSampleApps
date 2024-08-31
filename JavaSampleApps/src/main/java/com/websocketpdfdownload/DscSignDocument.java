package com.websocketpdfdownload;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Base64;
import java.util.Properties;

import org.json.JSONObject;

import sun.misc.BASE64Decoder;


public class DscSignDocument extends Thread {
	public static int count = 0;

	

	public String GetSignedPdf(PdfBean message) {

	
		String pdfData = message.getPdfData();

		JSONObject obj = new JSONObject();
		FileInputStream fis = null;
		Properties prop = null;
		

		
	
		System.out.println("Successfully Signed .");

		String base64 = null;
		FileOutputStream fos = null;
		File signedDocumentFile = null;
		String pdfFileName = "digipdf";
		FileOutputStream fos1 = null;
		File tempFile = null;
		try {
			String encodedBytes = pdfData;
			BASE64Decoder decoder = new BASE64Decoder();
			byte[] decodedBytes = decoder.decodeBuffer(encodedBytes);
			tempFile = File.createTempFile(pdfFileName, ".pdf");
			fos1 = new FileOutputStream(tempFile);
			fos1.write(decodedBytes);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (fos1 != null) {
					fos1.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		
		String base641 = null;
		FileOutputStream fos11 = null;
		File signedDocumentFile1 = null;
		try {
			byte[] bytes = Files.readAllBytes(tempFile.toPath());

			base641 = Base64.getEncoder().encodeToString(bytes);

			String name = tempFile.getName();
			String substring = name.substring(0, name.lastIndexOf('.'));
	
			String fileName = null;
			BASE64Decoder decoder = new BASE64Decoder();
			byte[] decodedBytes = decoder.decodeBuffer(base641);

		

			obj.put("pdfdata", base641);
			obj.put("pdffilename", fileName);
			obj.put("status", "Success");
			obj.put("count", count);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (fos11 != null) {
					fos11.close();
				}

			} catch (IOException e) {

				e.printStackTrace();
			}
		}

		return obj.toString();
	

	
	}

}
