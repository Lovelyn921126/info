package com.example.micreoserversimpleprovideruser.Fallback;

import org.springframework.stereotype.Component;

import com.example.micreoserversimpleprovideruser.service.BasicService;

@Component
public class UserFeignClientFallBack implements BasicService  {

	@Override
	public String getBasicInfo(String skuId) {
		return "UserFeignClientFallBack error";
	}

}
