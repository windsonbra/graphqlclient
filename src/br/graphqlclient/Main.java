package br.graphqlclient;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

public class Main {
	public static void main(String[] args) {
		String url="http://localhost:8000/graphql";
		String query="{\n"
				+ "	\"query\": \"query { emails {title body } }\"\n"
				+ "}";
		RestTemplate restTemplate=new RestTemplate();
		
		HttpHeaders headers=new HttpHeaders();
		headers.add("Authorization","Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJzdWIiOiIxMjM0NTY3ODkwIiwibmFtZSI6IkpvaG4gRG9lIiwiaWF0IjoxNTE2MjM5MDIyLCJyb2xlcyI6ImFkbWluLGEsYiJ9.M6-2eMXB7IUhZOVJUBfobAOwX0j7Zf99I3ltvsvo2tM");
		headers.add("content-type","application/json");
		
		ResponseEntity<String> response = 
				restTemplate.postForEntity(url, new HttpEntity<>(query,headers), String.class);
		System.out.println(response.getBody());
	}
}
