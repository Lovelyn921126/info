package com.example.demo.main;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.data.mongodb.core.ReactiveMongoTemplate;
import org.springframework.data.mongodb.repository.config.EnableReactiveMongoRepositories;

@SpringBootApplication(scanBasePackages="com.example.demo")
@EnableAutoConfiguration(exclude= {DataSourceAutoConfiguration.class})
@EnableReactiveMongoRepositories(basePackages="com.example.demo.main.repository")
public class Chapter3Application {
  

	
	public static void main(String[] args) {
		SpringApplication.run(Chapter3Application.class, args);
	}

}

