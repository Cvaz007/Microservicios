package com.microservice.qualification;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class QualificationApplication {

	public static void main(String[] args) {
		SpringApplication.run(QualificationApplication.class, args);
	}

}
