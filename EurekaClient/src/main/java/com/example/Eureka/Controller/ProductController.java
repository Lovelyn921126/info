package com.example.Eureka.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.example.Eureka.pojo.UserPo;
import com.example.Eureka.service.UserService;
import com.github.andrewoma.dexx.collection.HashMap;
import com.github.andrewoma.dexx.collection.Map;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.ribbon.proxy.annotation.Hystrix;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/product")
@Slf4j
public class ProductController {

	@Autowired
	private RestTemplate restTemplate;
	@Autowired
	private UserService userService;
	
	@GetMapping("ribbo")
	public  UserPo testRibbo()
	{
		UserPo userPo=null;
		for (int i = 0; i < 10; i++) {
			userPo=restTemplate.getForObject("http://USER/user/"+(i+1), UserPo.class);
			ResponseEntity<UserPo> uEntity=	restTemplate.getForEntity("http://USER/user/"+(i+1), UserPo.class);
		}
		return userPo;
	}
	@GetMapping("/timeOut1")
	@HystrixCommand(fallbackMethod="error")
	public String timeOut1() 
	{
		return restTemplate.getForObject("http://USER/timeOut/", String.class);
	}
	@GetMapping("/timeOut2")
	@HystrixCommand(fallbackMethod="error")
	public String timeOut2() 
	{
		return userService.timeOut();
	}
	
	@PutMapping("/user")
	@HystrixCommand(fallbackMethod="error")
	public Map<String, Object> addUserPro() {
		for (int i = 0; i < 10; i++) {
			UserPo userPo = new UserPo();
			userPo.setId((long)i);
			int level = (int) (i % 3 + 1);
			userPo.setLevel(level);
			userPo.setUserName("userName_" + i);
			userPo.setNote("note_" + i);
			userService.addUserPro(userPo);
		}
		
		return	null;
		
	}
	@PostMapping("/user/{userName}")
	public Map<String, Object> getUserProByuserName() {
		for (int i = 0; i < 10; i++) {

			String userName="userName_" + i;

			userService.getUserProByuserName(userName);
		}
		return null;
	}
	@GetMapping("test")
	public  UserPo test()
	{
		UserPo userPo=null;
		
		return userPo;
	}
	public String error() {
		return "超时错误";
	}
}
