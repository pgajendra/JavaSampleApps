package com.websocketpdfdownload;

public class PdfBean {

	String copies;
	String pdfData;
	String endPoint;
	String password;

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEndPoint() {
		return endPoint;
	}

	public void setEndPoint(String endPoint) {
		this.endPoint = endPoint;
	}

	public String getPdfData() {
		return pdfData;
	}

	public String getCopies() {
		return copies;
	}

	public void setCopies(String copies) {
		this.copies = copies;
	}

	public void setPdfData(String pdfData) {
		this.pdfData = pdfData;
	}
}
