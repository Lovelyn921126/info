package com.example.micreoserversimpleprovideruser;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;


@SpringBootApplication
@EnableConfigServer
public class MicreoserverSimpleProviderUserApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicreoserverSimpleProviderUserApplication.class, args);
	}
	

}

