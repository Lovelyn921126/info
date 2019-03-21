package com.example.Eureka.Controller;



import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.Eureka.pojo.UserPo;


import lombok.extern.slf4j.Slf4j;


@RestController
@Slf4j
public class UserController {

	@Autowired
	private DiscoveryClient discoveryClient;

	@GetMapping("/user/{id}")
	public UserPo getUserPro(@PathVariable("id") long id) {
		ServiceInstance services=	discoveryClient.getInstances("user").get(0);
		 log.info("["+services.getServiceId()+"]"+services.getHost()+":"+services.getPort());
		UserPo userPo = new UserPo();
		userPo.setId(id);
		int level = (int) (id % 3 + 1);
		userPo.setLevel(level);
		userPo.setUserName("userName_" + id);
		userPo.setNote("note_" + id);
		return userPo;
	}
	@GetMapping("/timeOut")
	public String timeOut() {
		ServiceInstance services=	discoveryClient.getInstances("user").get(0);
		 log.info("["+services.getServiceId()+"]"+services.getHost()+":"+services.getPort());
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "熔断测试";
	}
	@PutMapping("/user")
	public Map<String, Object> addUserPro(@RequestBody UserPo userPo) {
		ServiceInstance services=	discoveryClient.getInstances("user").get(0);
		 log.info("["+services.getServiceId()+"]"+services.getHost()+":"+services.getPort());
		Map<String, Object> map=new HashMap<>();
		map.put("success", true);
		map.put("message", userPo.getUserName());
		return map;
	}
	@PostMapping("/user/{userName}")
	public Map<String, Object> getUserProByuserName(@PathVariable("userName") String userName) {
		ServiceInstance services=	discoveryClient.getInstances("user").get(0);
		log.info("["+services.getServiceId()+"]"+services.getHost()+":"+services.getPort());
		Map<String, Object> map=new HashMap<>();
		map.put("success", true);
		map.put("message","[更新用户姓名成功;更新为"+ userName+"]");
		return map;
	}
}
