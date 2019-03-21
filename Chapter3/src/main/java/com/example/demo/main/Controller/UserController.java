package com.example.demo.main.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.main.pojo.User;
import com.example.demo.main.service.UserService;
import com.example.demo.main.vo.UserVo;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
public class UserController {

	@Autowired
	private UserService userService;
	
	@GetMapping("/user/{id}")
	public Mono<UserVo> getUser(@PathVariable("id") long id)
	{
		return userService.getUser(id).map(u->translate(u));
	}
	@GetMapping("/user/{userName}/{note}")
	public Flux<UserVo> getUser(@PathVariable("userName") String userName,@PathVariable("note") String note)
	{
		return userService.findUser(userName, note).map(u->translate(u));
	}
	
	@PostMapping("/user")
	public Mono<UserVo> addUser(@RequestBody User user)
	{
		return userService.insertUser(user).map(u->translate(u));
	}
	@PutMapping("/user")
	public Mono<UserVo> updateUser(@RequestBody User user)
	{
		return userService.insertUser(user).map(u->translate(u));
	}
	@DeleteMapping("/user")
	public Mono<Void> deleteUser(@RequestBody User user)
	{
		return userService.deleteUser(user);
	}
	
	public UserVo translate(User user) {
		UserVo vo=new UserVo();
		vo.setId(user.getId());
		vo.setNote(user.getNote());
		vo.setSexCode(user.getSex().getCode());
		vo.setSexName(user.getSex().getName());
		vo.setUserName(user.getUserName());
		return vo;
	}
}
