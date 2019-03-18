package com.example.micreoserversimpleprovideruser.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.micreoserversimpleprovideruser.Fallback.UserFeignClientFallBackFactory;
import com.example.micreoserversimpleprovideruser.bean.HygCart;

@FeignClient(name="microserver-desc")
public interface DescService {
  
	@GetMapping("/Desc/{skuId}")
    public String getBasicInfo(@PathVariable("skuId")String skuId);
	
}
