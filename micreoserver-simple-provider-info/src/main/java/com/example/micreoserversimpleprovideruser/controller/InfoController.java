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
import com.example.micreoserversimpleprovideruser.service.BasicService;
import com.example.micreoserversimpleprovideruser.service.DescService;
import com.example.micreoserversimpleprovideruser.service.OtherService;




@RestController
public class InfoController {
  
  @Autowired
  private BasicService basicService;

  @Autowired
  private DescService descService;
  @Autowired
  private OtherService otherService;
	
	@GetMapping("/info/{type}/{skuId}/{ps3Id}/{brandId}")
	public String findByid(@PathVariable("type")String type,@PathVariable("skuId")String skuId,@PathVariable("ps3Id")String ps3Id,@PathVariable("brandId")String brandId)
	{ 

	    String content = null;  
	    try {  
	        if("basic".equals(type)) {  
	            content = basicService.getBasicInfo(skuId);  
	        } else if("desc".equals(type)) {  
	            content = descService.getBasicInfo(skuId);  
	        } else if("other".equals(type)) {  
	            content = otherService.getOtherInfo(ps3Id, brandId);  
	        }  
	    } catch (Exception e) {  
	        e.printStackTrace();  
	       
	       
	    }  
	    if(content != null) {  
	      return content;
	    } else {  
	       return null;
	    }  
	}
	@GetMapping("/findByid/{skuId}}")
	public String findByid(@PathVariable("skuId")String skuId)
	{ 
		String content = null; 
for (int i = 0; i < 100; i++) {
	   
	  
      content = basicService.getBasicInfo(skuId);  
	  
      content = basicService.getBasicInfo(skuId);  
}
	  
	      return content;
	}
	
	
}
