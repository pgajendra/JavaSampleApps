package com.firebase.firestore;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;

import com.google.api.core.ApiFuture;
import com.google.auth.oauth2.GoogleCredentials;
import com.google.cloud.firestore.DocumentReference;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.FirestoreOptions;
import com.google.cloud.firestore.WriteResult;

public class UpdateContentInFireStore {
	public static void main(String[] args) {
		try {
		String mydata1 = "paste your key ";

		GoogleCredentials credentials = null;
		try {
			credentials = GoogleCredentials
					.fromStream(new ByteArrayInputStream(mydata1.getBytes(StandardCharsets.UTF_8)));
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		// Initialize Firestore with the loaded credentials
		FirestoreOptions firestoreOptions = FirestoreOptions.newBuilder().setCredentials(credentials).build();

		Firestore firestore = firestoreOptions.getService();
		
		DocumentReference docRef = firestore.collection("cities").document("SF");
		 Map<String, Object> updates = new HashMap<String, Object>();
	       // Replace with your field and value  if  not there key this will insert new key value in that object
		 updates.put("population", 1000000); // Replace with your field and value

	        // Update the document
	        ApiFuture<WriteResult> future = docRef.update(updates);

	        // Wait for the operation to complete
	        try {
	            WriteResult writeResult = future.get();
	            System.out.println("Document updated at: " + writeResult.getUpdateTime());
	        } catch (Exception e) {
	            e.printStackTrace();
	        }

	        // Close the Firestore client
	        firestore.close();
		
		
		
		}catch (Exception e) {
			e.printStackTrace();
		}
	}

}
