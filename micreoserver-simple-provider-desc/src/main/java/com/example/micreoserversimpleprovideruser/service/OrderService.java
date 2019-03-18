package com.example.micreoserversimpleprovideruser.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.micreoserversimpleprovideruser.bean.HygCart;

@FeignClient(name="microserver-simple-provider-order")
public interface OrderService {
  
	@GetMapping(value="/{id}")
	public HygCart fingById(@PathVariable("id") Long id);
	
}
