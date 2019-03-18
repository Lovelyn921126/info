package com.example.micreoserversimpleprovideruser.Fallback;

import org.springframework.stereotype.Component;

import com.example.micreoserversimpleprovideruser.service.BasicService;
import com.example.micreoserversimpleprovideruser.service.DescService;

import feign.hystrix.FallbackFactory;
import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class UserFeignClientFallBackFactory implements FallbackFactory<BasicService>   {@Override
	public BasicService create(Throwable arg0) {
		return new BasicService() {
			
			@Override
			public String getBasicInfo(String skuId) {
				log.info("fallback;reason was:"+arg0);
				return "UserFeignClientFallBackFactory error";
			}
		};
	}


	

}
