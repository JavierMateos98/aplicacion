package com.cliente.cliente;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableEurekaClient
@EnableScheduling
@SpringBootApplication
public class ClienteApplication {

	//@Scheduled(initialDelay = 60000 ,fixedDelay = 60000)

	public static void main(String[] args) {
		SpringApplication.run(ClienteApplication.class, args);
	}

}
