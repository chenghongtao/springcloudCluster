package com.cht.eurekaserver_one;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class EurekaserverOneApplication {

	public static void main(String[] args) {
		SpringApplication.run(EurekaserverOneApplication.class, args);
	}

}
