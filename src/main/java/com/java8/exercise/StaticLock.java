package com.java8.exercise;

import java.io.IOException;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;

public class StaticLock {
	static StaticLock sl = new StaticLock();

	public static void main(String[] args) {
		sl.sayHello();
	}

	public void sayHello() {
		String wbeServiceUrl = "http://localhost:8081/Account/restapi/myresource/say";
		String response = sl.getResultAsString(wbeServiceUrl);
		System.out.println(response);
	}

	public String getResultAsString(String url) {
		HttpClient client = HttpClientBuilder.create().build();
		String responseString = null;
		HttpGet getRequest = new HttpGet(url);
		try {
			HttpResponse response = client.execute(getRequest);
			HttpEntity entity = response.getEntity();
			responseString = EntityUtils.toString(entity, "UTF-8");
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return responseString;
	}
}
