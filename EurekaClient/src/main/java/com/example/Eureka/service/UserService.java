package com.example.Eureka.service;

import java.util.Map;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.Eureka.pojo.UserPo;

@FeignClient("user")
public interface UserService {

	@GetMapping("/user/{id}")
	public UserPo getuserPro(@PathVariable("id") long id);
	
	@PutMapping("/user")
	public Map<String, Object> addUserPro(@RequestBody UserPo userPo);
	
	@PostMapping("/user/{userName}")
	public Map<String, Object> getUserProByuserName(@PathVariable("userName") String userName);
	
	@GetMapping("/timeOut")
	public String timeOut() ;
	
}
