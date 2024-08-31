package com.filescreator;


import java.io.FileOutputStream;

import com.itextpdf.text.Document;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

public class PDFCreator {
  public static void main(String[] args) {
    Document document = new Document(PageSize.A4,0,0,80,50);
    try {
      PdfWriter.getInstance(document, new FileOutputStream("D://test2.pdf")); //here you can specify the path where you want to create
      document.open();
      document.add(new Paragraph("Hello, world!Vapp solutions  here is your text"));
      System.out.println("ok");
      
     
       
    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      document.close();
    }
  }
}
