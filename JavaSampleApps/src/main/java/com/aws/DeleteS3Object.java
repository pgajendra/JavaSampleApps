package com.aws;

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3Client;
import com.amazonaws.services.s3.model.DeleteObjectRequest;

public class DeleteS3Object {
    public static void main(String[] args) {
        String bucketName = "bucketname";
        String objectKey = "opening_stock_register_833152676.pdf";  // e.g., "foldername/filename.ext"
        String accessKey = "your-access-key";
        String secretKey = "your-secret-key";
        
       
        

    	AWSCredentials credentials = new BasicAWSCredentials(accessKey, secretKey);

    	AmazonS3 s3Client = new AmazonS3Client(credentials);

  
        DeleteObjectRequest deleteObjectRequest2=new DeleteObjectRequest(bucketName,objectKey);

        // Delete the object
        s3Client.deleteObject(deleteObjectRequest2);

        System.out.println("Object " + objectKey + " deleted from bucket " + bucketName);

    }
}


