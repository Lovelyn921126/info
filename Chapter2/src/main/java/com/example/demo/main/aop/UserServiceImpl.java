package com.example.demo.main.aop;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import com.example.demo.main.bean.User;
import com.mongodb.bulk.DeleteRequest;
import com.mongodb.client.result.DeleteResult;
import com.mongodb.client.result.UpdateResult;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private MongoTemplate mongoTemplate;
	
	
	@Override
	public User getUser(Long id) {
		Criteria criteria=Criteria.where("id").is(id);
		Query queryId=	Query.query(criteria);
		return mongoTemplate.findOne(queryId, User.class);
	//	return mongoTemplate.findById(id, User.class);
	}
	@Override
	public List<User> findUser(String userName,String note,Integer limit,Integer skip) {
		Criteria criteria=Criteria.where("userName").regex(userName).and("note").regex(note);
		Query queryId=	Query.query(criteria).limit(limit).skip(skip);
		return mongoTemplate.find(queryId, User.class);
	//	return mongoTemplate.findById(id, User.class);
	}
	@Override
	public User save(User user) {
	
		return mongoTemplate.save(user, "user");
	//	return mongoTemplate.findById(id, User.class);
	}
	@Override
	public void printUser(User user) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public UpdateResult update(String userName, String note, Integer id) {
		Criteria criteria=Criteria.where("id").is(id);
		Query query=	Query.query(criteria);
		Update update=Update.update("userName", userName);
		update.update("note", note);
		 mongoTemplate.updateFirst(query, update, User.class);
	 UpdateResult result=	mongoTemplate.updateMulti(query, update, User.class);
		return result;
	}
	@Override
	public DeleteResult delete(Integer id) {
		Criteria criteria=Criteria.where("id").is(id);
	Query query=	Query.query(criteria);
	DeleteResult result= mongoTemplate.remove(query, User.class);
		return result;
	}
	@Override
	public void generateReport() {
		System.out.println("报表县城"+Thread.currentThread().getName());
		
	}

}
