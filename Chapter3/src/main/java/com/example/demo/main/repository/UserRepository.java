package com.example.demo.main.repository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.main.pojo.User;

import reactor.core.publisher.Flux;

@Repository
public interface UserRepository extends ReactiveMongoRepository<User, Long> {

	
	public Flux<User> findByUserNameLikeAndNoteLike(String userName,String note);
}
