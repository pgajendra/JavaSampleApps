package com.firebase.firestore;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

import com.google.api.core.ApiFuture;
import com.google.auth.oauth2.GoogleCredentials;
import com.google.cloud.firestore.DocumentReference;
import com.google.cloud.firestore.DocumentSnapshot;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.FirestoreOptions;

public class ReadDataFromFireStore {

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
			// asynchronously retrieve the document
			
			ApiFuture<DocumentSnapshot> future = docRef.get();
			// ...
			// future.get() blocks on response
			DocumentSnapshot document = future.get();
			
			
			
			
			
			if (document.exists()) {
				System.out.println("Document data: " + document.getData());
			} else {
				System.out.println("No such document!");
			}
			
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
