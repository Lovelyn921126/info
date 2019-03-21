package com.example.micreoserversimpleeurekaserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class MicreoserverSimpleEurekaServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicreoserverSimpleEurekaServerApplication.class, args);
	}

}

