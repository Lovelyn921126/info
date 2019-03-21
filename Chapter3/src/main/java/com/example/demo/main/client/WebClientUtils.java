package com.example.demo.main.client;

import static org.assertj.core.api.Assertions.failBecauseExceptionWasNotThrown;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.client.WebClient;

import com.example.demo.main.menu.SexEnum;
import com.example.demo.main.pojo.User;
import com.example.demo.main.vo.UserVo;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public class WebClientUtils {
	public static void main(String[] args) {
		WebClient webClient = WebClient.create("localhost:8080");
		User newUser = new User();
		newUser.setId(2L);
		newUser.setNote("note_new");
		newUser.setUserName("user_name_new");
		newUser.setSex(SexEnum.MALE);

	}
  public static void insertUser(WebClient client,User user) {
	Mono<UserVo> userMono=client.post().uri("/user").contentType(MediaType.APPLICATION_STREAM_JSON).body(Mono.just(user),User.class)
			.accept(MediaType.APPLICATION_STREAM_JSON).retrieve().bodyToMono(UserVo.class);
	UserVo userVo=userMono.block();
	System.out.println("[yonghumingc]"+userVo.getUserName());
}
  public static void updatetUser(WebClient client,User user) {
		Mono<UserVo> userMono=client.put().uri("/user").contentType(MediaType.APPLICATION_STREAM_JSON).body(Mono.just(user),User.class)
				.accept(MediaType.APPLICATION_STREAM_JSON).retrieve().bodyToMono(UserVo.class);
		UserVo userVo=userMono.block();
		System.out.println("[yonghumingc]"+userVo.getUserName());
	}
  
  public static void getUser(WebClient client,Long id) {
	Mono<UserVo> userMono=client.get().uri("/user/{id}",id)
			.accept(MediaType.APPLICATION_STREAM_JSON).retrieve().bodyToMono(UserVo.class);
	UserVo userVo=userMono.block();
	System.out.println("[yonghumingc]"+userVo.getUserName());
}
  public static void deleteUser(WebClient client,Long id) {
		Mono<Void> userMono=client.delete().uri("/user/{id}",id)
				.accept(MediaType.APPLICATION_STREAM_JSON).retrieve().bodyToMono(Void.class);
		Void userVo=userMono.block();
		System.out.println(userVo);
	}
  public static void findUser(WebClient client,String userName,String note) {
	  Map<String, Object> parame=new HashMap<>();
	  parame.put("userName", userName);
	  parame.put("note", note);
		Flux<UserVo> userMono=client.get().uri("/user/{id}/{note}",userName,note)
				.accept(MediaType.APPLICATION_STREAM_JSON).retrieve().bodyToFlux(UserVo.class);
		Iterator<UserVo> userVo=userMono.toIterable().iterator();
		while (userVo.hasNext()) {
			UserVo vo = (UserVo) userVo.next();
			System.out.println("[yonghumingc]"+vo.getUserName());
			
		}
		
	}
}
