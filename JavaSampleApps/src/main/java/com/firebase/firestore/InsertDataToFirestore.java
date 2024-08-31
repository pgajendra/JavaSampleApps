package com.firebase.firestore;

import java.io.ByteArrayInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import com.google.api.core.ApiFuture;
import com.google.auth.oauth2.GoogleCredentials;
import com.google.cloud.firestore.CollectionReference;
import com.google.cloud.firestore.DocumentReference;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.FirestoreOptions;
import com.google.cloud.firestore.WriteResult;

public class InsertDataToFirestore {
	public static void main(String[] args) {
		
		
		FileInputStream fis=null;
		Properties prop = null;
		//JSONObject obj = new JSONObject();
		try {
			System.out.println(System.getProperty("user.dir") );
			fis = new FileInputStream(
					System.getProperty("user.dir") + "\\src\\main\\resources\\firestore.properties");
			prop = new Properties();
			prop.load(fis);
		}catch (Exception e) {
			// TODO: handle exception
		}
		
		System.out.println(prop.get("key"));
		
		String mydata1 = "paste your key ";

		// Initialize Firebase SDK with the provided credentials
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

// Define data to be stored
		Map<String, Object> user = new HashMap<String, Object>();
		user.put("name", "fgfdh Doe");
		user.put("email", "johndoe@example.com");
		user.put("sname", "j12313gh.com");
		String collection = "UserData";
		String documentId = "1";

		String mail = "gajgmail.com";
		String password = "123456";

		DocumentReference docRef = firestore.collection(collection).document(documentId);
		ApiFuture<WriteResult> future = docRef.set(user);
		
		
		//anotherway to write  //also if collection and document is not created manually this will creates automatically
		CollectionReference cities = firestore.collection("cities");
		List<ApiFuture<WriteResult>> futures = new ArrayList<ApiFuture<WriteResult>>();
		futures.add(
		    cities
		        .document("SF")
		        .set(user));
		
		
		try {
			// Wait for the write operation to complete
			WriteResult writeResult = future.get();
			System.out.println(writeResult);
			System.out.println("Data stored successfully. Document ID: " + documentId);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
