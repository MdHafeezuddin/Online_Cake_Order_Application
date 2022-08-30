package com.onlinecakeshopping;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;



@SpringBootApplication
@EnableEurekaServer
@ComponentScan(basePackages = "com.onlinecakeshopping")
public class OnlineCakeShoppingApplication {

	public static void main(String[] args) {
		SpringApplication.run(OnlineCakeShoppingApplication.class, args);
		System.out.println("Online_Cake_Shopping is Application is Ready ");
	}
	
}

