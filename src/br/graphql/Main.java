package br.graphql;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

public class Main {
	public static void main(String[] args) {
		String uri="http://localhost:8080/graphql";
		String query = "query{\n"
				+ "       estagiario(login:\"e706350\"){\n"
				+ "         id\n"
				+ "         login\n"
				+ "         nome\n"
				+ "      }\n"
				+ "}";
		
		RestTemplate restTemplate = new RestTemplate();
	    HttpHeaders headers = new HttpHeaders();
	    //headers.add("Authorization", "Bearer *************");
	    headers.add("content-type", "application/graphql");

	    ResponseEntity<String> response = 
	    		restTemplate.postForEntity(uri, new HttpEntity<>(query, headers), String.class);
	    System.out.println(response.getBody());
	}
}
