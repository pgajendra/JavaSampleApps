package com.urlcalling;

import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class OkHttp {

	public static void main(String[] args) {
		OkHttpClient client = new OkHttpClient();
		MediaType mediaType = MediaType.parse("application/json");

		RequestBody body = RequestBody.create(mediaType, "");
		Request request = new Request.Builder()
				.url("http://192.xx.xxx.xx:xxxx/hello").get()

				 .addHeader("accept", "application/json")
				// .addHeader("Authorization", "Basic "
				// + RestApiKey)
				.addHeader("content-type", "application/json").build();
		
		try (Response response = client.newCall(request).execute()) {
			if(response.code()==200) {
			String responseBody = response.body().string();
			System.out.println("Response body: " + responseBody);
			}
		}

		catch (Exception e) {

//	// TODO: handle exception
//	}}
		}
		
	}

}
