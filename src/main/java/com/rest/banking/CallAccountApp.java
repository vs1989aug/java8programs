package com.rest.banking;

import org.springframework.web.client.RestTemplate;

public class CallAccountApp {
	
	public static void main(String[] args){
		    final String uri = "http://localhost:8082/Account/myresource/getAccount";
		    RestTemplate restTemplate = new RestTemplate();
		     
		    AccountResource result = restTemplate.getForObject(uri, AccountResource.class);
		     
		    System.out.println(result.getAccountNumber()+" : "+result.getBalance());
			

		
	}

}
