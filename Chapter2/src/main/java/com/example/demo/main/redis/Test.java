package com.example.demo.main.redis;


import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.data.redis.core.RedisTemplate;

public class Test {
  public static void main(String[] args) {
	ApplicationContext aContext=new AnnotationConfigApplicationContext(RedisConfig.class);
	RedisTemplate redisTemplate= aContext.getBean(RedisTemplate.class);
	redisTemplate.opsForValue().set("key1","value1");
	redisTemplate.opsForHash().put("hash", "field", "havlue");
}
}
