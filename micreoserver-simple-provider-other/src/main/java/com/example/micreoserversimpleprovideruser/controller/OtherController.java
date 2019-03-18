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
public class OtherController {
  
	@Autowired
	RestTemplate restTemplate;
	@Autowired
	RedisTemplate redisTemplate;
	
	@Autowired
	DiscoveryClient discoveryClient;
	
	@GetMapping("/Other/{ps3Id}/{brandId}")
    public String getOtherInfo(@PathVariable("ps3Id")String ps3Id,@PathVariable("brandId")String brandId) {
		  Map<String, Object> map = new HashMap<String, Object>();  
		    //面包屑  
		    List<List<?>> breadcrumb = Lists.newArrayList();  
		    breadcrumb.add(Lists.newArrayList(9987, "手机"));  
		    breadcrumb.add(Lists.newArrayList(653, "手机通讯"));  
		    breadcrumb.add(Lists.newArrayList(655, "手机"));  
		    //品牌  
		    Map<String, Object> brand = Maps.newHashMap();  
		    brand.put("name", "苹果（Apple）");  
		    brand.put("logo", "BrandLogo/g14/M09/09/10/rBEhVlK6vdkIAAAAAAAFLXzp-lIAAHWawP_QjwAAAVF472.png");  
		    map.put("breadcrumb", breadcrumb);  
		    map.put("brand", brand);  
		    //实际应用应该是发送MQ  
		    asyncSetToRedis( "s:" + ps3Id + ":", JSON.toJSONString(breadcrumb));  
		    asyncSetToRedis( "b:" + brandId + ":", JSON.toJSONString(brand));  
  
	    	    return JSON.toJSONString(map);  
		
	}  
		private void asyncSetToRedis(String string, String content) {
			redisTemplate.opsForHash().put("other",string,content);
			
		}
	
}
