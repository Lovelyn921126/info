package com.example.micreoserversimpleprovideruser.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.example.micreoserversimpleprovideruser.bean.HygCart;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

import lombok.extern.slf4j.Slf4j;




@RestController
@Slf4j
public class OrderController {
  
	@Autowired
	RestTemplate restTemplate;
	
	@Autowired
	DiscoveryClient discoveryClient;
	
	@GetMapping("/order/{id}")
	@HystrixCommand(fallbackMethod="error")
	public String findByid(@PathVariable("id")Long id)
	{ 
		return restTemplate.getForObject("http://microserver-basic/Basic/"+id, String.class);
	}
	@GetMapping("/user-instance")
	public List<ServiceInstance> instance()
	{
		return this.discoveryClient.getInstances("microserver-basic");
	}
	public String error(Long id,Throwable throwable) {
		log.info("进入回退方法，异常:"+throwable);
		return "error";
	}
	
}
