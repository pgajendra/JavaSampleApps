package com.aws;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Random;
import java.util.concurrent.atomic.AtomicLong;

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3Client;
import com.amazonaws.services.s3.model.CannedAccessControlList;
import com.amazonaws.services.s3.model.ObjectMetadata;
import com.amazonaws.services.s3.model.PutObjectRequest;

public class S3Uploader {

	public static void main(String[] args) {
		
		
		Random randomNumber=new Random();
		System.out.println(randomNumber.nextInt(Integer.MAX_VALUE));
		
		String path = "";
		String keyName =null;
		InputStream stream = null;
	//	keyName = "file-sample_150kB.pdf";
		try {
			AtomicLong atmLong = new AtomicLong(System.currentTimeMillis());
			System.out.println(atmLong.getAndIncrement());
			String existingBucketName = "bckname";

			 keyName = "example3.pdf";
	
			 
			 byte[] fileData = Files.readAllBytes(Paths.get("C:/Users/admin/Desktop/example.pdf"));
			
			String accesskey = "";
			String secretkey = "";
			String amazonFileUploadLocationOriginal = existingBucketName;
			AWSCredentials credentials = new BasicAWSCredentials(accesskey, secretkey);

			AmazonS3 s3Client = new AmazonS3Client(credentials);
			//byte[] fileData = "This is sample file content".getBytes();
			
			
			ObjectMetadata objectMetadata = new ObjectMetadata();
			//objectMetadata.setContentLength(fileData.length);
			objectMetadata.setContentType("application/pdf"); // Set the content type to PDF
			//objectMetadata.setContentDisposition("inline");
			
			
			
			stream = new ByteArrayInputStream(fileData);
			//ObjectMetadata objectMetadata = new ObjectMetadata();
			PutObjectRequest putObjectRequest = new PutObjectRequest(amazonFileUploadLocationOriginal, keyName, stream,objectMetadata
					).withCannedAcl(CannedAccessControlList.PublicRead);
			//putObjectRequest.setMetadata(objectMetadata);
			s3Client.putObject(putObjectRequest);
			path = "https://" + existingBucketName + ".s3.amazonaws.com/" + keyName;
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (stream != null) {
				try {
					stream.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}

	}

}
