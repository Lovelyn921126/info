package com.example.demo.main.redis;



import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;

import redis.clients.jedis.JedisPoolConfig;

@Configuration
public class RedisConfig {
  
	public static RedisConnectionFactory redisConnectionFactory=null;
	
	@Bean(name="RedisConnectionFactory")
	public static RedisConnectionFactory getInstance() {
		if (redisConnectionFactory==null) {
			synchronized (RedisConfig.class) {
				if (redisConnectionFactory==null) {
					JedisPoolConfig config=new JedisPoolConfig();
					 config.setMaxTotal(60000);//设置最大连接数  
				       config.setMaxIdle(1000); //设置最大空闲数 
				       config.setMaxWaitMillis(3000);//设置超时时间  
				       config.setTestOnBorrow(true);
					JedisConnectionFactory factory=new JedisConnectionFactory(config);
					RedisStandaloneConfiguration redisStandaloneConfiguration=	factory.getStandaloneConfiguration();
					factory.setHostName("39.106.59.144");
					factory.setPort(6379);
					factory.setPassword("12345678");
					redisConnectionFactory=factory;
					return factory;
				}
				
				
			}
		}
		return redisConnectionFactory;
	}
	@Bean("RedisTemplate")
	public RedisTemplate<Object, Object> initRedisTemple()
	{
		RedisTemplate<Object, Object> redisTemplate=new RedisTemplate<>();
		redisTemplate.setConnectionFactory(getInstance());
		return redisTemplate;
	}
}
