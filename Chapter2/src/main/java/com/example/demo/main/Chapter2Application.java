package com.example.demo.main;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configurers.provisioning.InMemoryUserDetailsManagerConfigurer;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.web.servlet.config.annotation.InterceptorRegistration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.example.demo.main.Interception.MyInterception;
import com.example.demo.main.Interception.MyInterception2;
import com.example.demo.main.Interception.MyInterception3;
import com.example.demo.main.aop.MyAspect;
import com.example.demo.main.aop.MyAspect2;
import com.example.demo.main.aop.MyAspect3;
import com.example.demo.main.security.BCryctPasswordEncoder;

@SpringBootApplication(scanBasePackages=("com.example.demo.main.*"))
@PropertySource(value= {"classpath:jdbc.properties"},ignoreResourceNotFound=true)
@MapperScan(basePackages="com.example.demo.main.*")
@EnableMongoRepositories(basePackages="com.example.demo.main")
public class Chapter2Application  implements WebMvcConfigurer{
     /* @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
    	BCryctPasswordEncoder bCryctPasswordEncoder=new BCryctPasswordEncoder();
    	InMemoryUserDetailsManagerConfigurer<AuthenticationManagerBuilder>  configurer=auth.inMemoryAuthentication().passwordEncoder(bCryctPasswordEncoder);
    	configurer.withUser("admin").password(bCryctPasswordEncoder.encode("abc")).authorities("ROLE_USER","ROLE_ADMIN");
    	configurer.withUser("user").password(bCryctPasswordEncoder.encode("123")).authorities("ROLE_ADMIN");
    	//super.configure(auth);
    }*/
	@Bean(name="myAspect")
	public MyAspect initAspect() {
		return new MyAspect();
	}
	@Bean(name="myAspect2")
	public MyAspect2 initAspect2() {
		return new MyAspect2();
	}
	@Bean(name="myAspect3")
	public MyAspect3 initAspect3() {
		return new MyAspect3();
	}
	public static void main(String[] args) {
		SpringApplication.run(Chapter2Application.class, args);
	}
	//拦截器
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		InterceptorRegistration ir=	registry.addInterceptor(new MyInterception());
		ir.addPathPatterns("/interception/");
		InterceptorRegistration ir2=	registry.addInterceptor(new MyInterception2());
		ir2.addPathPatterns("/interception/");
		InterceptorRegistration ir3=	registry.addInterceptor(new MyInterception3());
		ir3.addPathPatterns("/interception/");
		WebMvcConfigurer.super.addInterceptors(registry);
	}
}
