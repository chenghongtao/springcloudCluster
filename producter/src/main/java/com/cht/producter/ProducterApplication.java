package com.cht.producter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class ProducterApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProducterApplication.class, args);
	}

}
