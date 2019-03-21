package com.example.demo.main.pojo;

import static org.hamcrest.CoreMatchers.nullValue;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

@Component
public class BussinessPersion implements Person
//, BeanNameAware, BeanFactoryAware, ApplicationContextAware,
		//BeanPostProcessor, InitializingBean, DisposableBean
		{

	private Animal a = null;

	/*
	 * public BussinessPersion(@Autowired @Qualifier("dog") Animal a) { super();
	 * this.a = a; }
	 */

	@Override
	public void service() {
		this.a.use();

	}

	@Override
	@Autowired
	@Qualifier("dog")
	public void setAnamail(Animal animal) {
		System.out.println("依赖注入");
		this.a = animal;

	}

	/*@Override

	public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
		// TODO Auto-generated method stub\
		System.out.println("[" + this.getClass().getSimpleName() + "] 调用 @postProcessAfterInitialization");
		return BeanPostProcessor.super.postProcessAfterInitialization(bean, beanName);
	}

	@Override
	public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
		// TODO Auto-generated method stub
		System.out.println("[" + this.getClass().getSimpleName() + "] 调用 @postProcessBeforeInitialization");
		return BeanPostProcessor.super.postProcessBeforeInitialization(bean, beanName);
	}

	@PostConstruct
	public void PostConstruct() {
		System.out.println("[" + this.getClass().getSimpleName() + "] 调用 @PostConstruct");
	}

	@PreDestroy
	public void PreDestroy() {
		System.out.println("[" + this.getClass().getSimpleName() + "] 调用 @PreDestroy");
	}

	@Override
	public void destroy() throws Exception {
		// TODO Auto-generated method stub
		System.out.println("[" + this.getClass().getSimpleName() + "] 调用 DisposableBean 的   destroy");
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		// TODO Auto-generated method stub
		System.out.println("[" + this.getClass().getSimpleName() + "] 调用 InitializingBean 的   afterPropertiesSet");
	}

	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		// TODO Auto-generated method stub
		System.out.println(
				"[" + this.getClass().getSimpleName() + "] 调用 ApplicationContextAware 的   setApplicationContext");
	}

	@Override
	public void setBeanFactory(BeanFactory arg0) throws BeansException {
		// TODO Auto-generated method stub
		System.out.println("[" + this.getClass().getSimpleName() + "] 调用 BeanFactoryAware 的   setBeanFactory");
	}

	@Override
	public void setBeanName(String arg0) {
		System.out.println("[" + this.getClass().getSimpleName() + "] 调用 BeanNameAware 的   setBeanName");

	}
*/
}
