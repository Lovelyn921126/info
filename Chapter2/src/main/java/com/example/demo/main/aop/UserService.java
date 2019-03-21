package com.example.demo.main.aop;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.main.bean.User;
import com.mongodb.bulk.DeleteRequest;
import com.mongodb.client.result.DeleteResult;
import com.mongodb.client.result.UpdateResult;

@Service
public interface UserService {
  
	public void printUser(User user);
	
	public void generateReport();
	public User getUser(Long id);
	public List<User> findUser(String userName,String note,Integer limit,Integer skip);
	public User save(User user) ;
	public UpdateResult update(String userName,String note,Integer id) ;
	public DeleteResult delete(Integer id) ;
}
