package com.example.micreoserversimpleprovideruser;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableFeignClients
public class MicreoserverSimpleProviderUserApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicreoserverSimpleProviderUserApplication.class, args);
	}
	
	@Bean
	public RestTemplate geRestTemplate()
	{
		return new RestTemplate();
	}
	@Autowired
	private RedisTemplate redisTemplate;
	
	@PostConstruct
	public void redisInit()
	{
		redisTemplateInit();
	}
	public void redisTemplateInit() {
		RedisSerializer stringSerializer=redisTemplate.getStringSerializer();
		redisTemplate.setKeySerializer(stringSerializer);
		redisTemplate.setValueSerializer(stringSerializer);
	}
 

}

