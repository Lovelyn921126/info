package com.example.micreoserversimpleprovideruser.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.alibaba.fastjson.JSON;
import com.example.micreoserversimpleprovideruser.bean.HygCart;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;




@RestController
public class DescController {
  
	@Autowired
	RestTemplate restTemplate;
	@Autowired
	RedisTemplate redisTemplate;
	
	@Autowired
	DiscoveryClient discoveryClient;
	
	@GetMapping("/Desc/{skuId}")
    public String getBasicInfo(@PathVariable("skuId")String skuId) {
	    	  Map<String, Object> map = new HashMap<String, Object>();  
	    	    map.put("content", "<div><img data-lazyload='http://img30.360buyimg.com/jgsq-productsoa/jfs/t448/127/574781110/103911/b3c80634/5472ba22N45400f4e.jpg' alt='' /><img data-lazyload='http://img30.360buyimg.com/jgsq-productsoa/jfs/t802/133/19465528/162152/e463e43/54e2b34aN11bceb70.jpg' alt='' height='386' width='750' /></div>");  
	    	    map.put("date", System.currentTimeMillis());  
	    	    String content = JSON.toJSONString(map);  
	    	    //实际应用应该是发送MQ  
	    	    asyncSetToRedis( "d:" + skuId + ":", content);  
	    	    return JSON.toJSONString(map);  
		
	}  
		private void asyncSetToRedis(String string, String content) {
			redisTemplate.opsForHash().put("desc",string,content);
			
		}
	
}
