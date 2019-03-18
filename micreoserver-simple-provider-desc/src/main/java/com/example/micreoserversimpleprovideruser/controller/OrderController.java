package com.example.micreoserversimpleprovideruser.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.example.micreoserversimpleprovideruser.bean.HygCart;




@RestController
public class OrderController {
  
	@Autowired
	RestTemplate restTemplate;
	
	@Autowired
	DiscoveryClient discoveryClient;
	
	@GetMapping("/order/{id}")
	public HygCart findByid(@PathVariable("id")Long id)
	{  ServiceInstance services=	discoveryClient.getInstances("user").get(0);
	 //log.info("["+services.getServiceId()+"]"+services.getHost()+":"+services.getPort());
	 long ms=(long)(3000L*Math.random());
	try {
		Thread.sleep(ms);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
		 HygCart cart=new HygCart();
		 cart.setId(id);
		 cart.setGoodsId(2L);
		 cart.setMpriceCount(1);
		 cart.setPriceCount(1);
		 cart.setSaleNum(2);
		 cart.setuId(2L);
		return cart; 
	}
	@GetMapping("/user-instance")
	public List<ServiceInstance> instance()
	{
		return this.discoveryClient.getInstances("microserver-simple-provider-user");
	}
	
}
