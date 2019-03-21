package com.example.demo.main.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.example.demo.main.pojo.User;
import com.example.demo.main.repository.UserRepository;
import com.example.demo.main.service.UserService;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserRepository userRepository;

	@Override
	public Mono<User> getUser(Long id) {
		// TODO Auto-generated method stub
		return userRepository.findById(id);
	}

	@Override
	public Mono<User> insertUser(User user) {
		// TODO Auto-generated method stub
		return userRepository.save(user);
	}

	@Override
	public Mono<Void> deleteUser(User user) {
		// TODO Auto-generated method stub
		return userRepository.delete(user);
	}

	@Override
	public Mono<User> updateUser(User user) {
		// TODO Auto-generated method stub
		return userRepository.save(user);
	}

	@Override
	public Flux<User> findUser(String userName, String note) {
		// TODO Auto-generated method stub
		return userRepository.findByUserNameLikeAndNoteLike(userName, note);
	}

}
