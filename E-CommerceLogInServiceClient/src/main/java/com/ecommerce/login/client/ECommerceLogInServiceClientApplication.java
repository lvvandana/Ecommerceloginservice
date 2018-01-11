package com.ecommerce.login.client;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.ecommerce.login.client.model.User;

@SpringBootApplication
public class ECommerceLogInServiceClientApplication {

	public static void main(String[] args) {
		SpringApplication.run(ECommerceLogInServiceClientApplication.class, args);
	}
}

	