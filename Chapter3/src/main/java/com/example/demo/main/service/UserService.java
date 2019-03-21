package com.example.demo.main.service;

import com.example.demo.main.pojo.User;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


public interface UserService {
  
	Mono<User> getUser(Long id);
	
	Mono<User> insertUser(User user);
	
	Mono<Void> deleteUser(User user);
	
	Mono<User> updateUser(User user);
	
	Flux<User> findUser(String userName,String note);
}
