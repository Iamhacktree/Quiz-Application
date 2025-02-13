package com.Project.api_gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class ApiGatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiGatewayApplication.class, args);
	}

}

//After adding API gateway we will send every request using API gateway port like this 
//localhost:8555/quiz-service/quiz/get/67ab31f30ab43b4ebc29c14e
//above we want to use quiz-service that's why we have use quiz-service name else we would have used another name 
