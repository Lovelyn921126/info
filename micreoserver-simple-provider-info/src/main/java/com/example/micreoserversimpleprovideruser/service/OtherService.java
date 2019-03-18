package com.example.micreoserversimpleprovideruser.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;



@FeignClient(name="microserver-other")
public interface OtherService {
 
	@GetMapping("/Other/{ps3Id}/{brandId}")
    public String getOtherInfo(@PathVariable("ps3Id")String ps3Id,@PathVariable("brandId")String brandId) ;
	
}
