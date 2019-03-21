package com.example.demo.main.demo;

import java.util.concurrent.Executor;

import org.springframework.aop.interceptor.AsyncUncaughtExceptionHandler;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.scheduling.annotation.AsyncConfigurer;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

@Configurable
@EnableAsync
public class AsynConfig implements AsyncConfigurer{
  @Override
public Executor getAsyncExecutor() {
	ThreadPoolTaskExecutor taskExecutor=new ThreadPoolTaskExecutor();
	taskExecutor.setCorePoolSize(10);
	taskExecutor.setMaxPoolSize(30);
	taskExecutor.setQueueCapacity(3000);
	taskExecutor.initialize();
	return taskExecutor;
}
  @Override
	public AsyncUncaughtExceptionHandler getAsyncUncaughtExceptionHandler() {
		// TODO Auto-generated method stub
		return AsyncConfigurer.super.getAsyncUncaughtExceptionHandler();
	}
}
