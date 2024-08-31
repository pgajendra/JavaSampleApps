package com.firebase.firestore;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

import com.google.api.core.ApiFuture;
import com.google.auth.oauth2.GoogleCredentials;
import com.google.cloud.firestore.DocumentReference;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.FirestoreOptions;
import com.google.cloud.firestore.WriteResult;

public class DeleteDataInFireStore {

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

			// ApiFuture<DocumentSnapshot> future = docRef.get();
			ApiFuture<WriteResult> future = docRef.delete();

			// Wait for the operation to complete
			WriteResult writeResult = future.get();

			// Print the timestamp of when the document was deleted
			System.out.println("Document deleted at: " + writeResult.getUpdateTime());

			// Close the Firestore client
			firestore.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
