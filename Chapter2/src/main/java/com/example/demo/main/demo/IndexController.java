package com.example.demo.main.demo;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.demo.main.aop.UserService;
import com.example.demo.main.bean.User;
import com.example.demo.main.intercept.HellowService;
import com.example.demo.main.validate.UserValidate;

@Controller
public class IndexController {
	
	@Autowired
	@Qualifier("myHellowServiceImpl")
	private HellowService hellowService;
	
	@Autowired
	private UserService userService;
      
	@InitBinder
public void name(WebDataBinder binder) {
		binder.setValidator(new  UserValidate()
				);
		binder.registerCustomEditor(Date.class, new CustomDateEditor(new SimpleDateFormat("yyyy-MM-dd"), false));
}	
	@RequestMapping("/index")
	
	public String index() {
		User user=new User();
	//UserValidate userValidate=	(UserValidate) hellowService;
	//if (userValidate.validate(user)) {
		hellowService.sayHellow("lyn");
	//}
		
		return "index";
	}
@RequestMapping("/test")
	@Async
	public void test() {
	System.out.println("請求縣城"+Thread.currentThread().getName());
	}
	
	
	
	
	@RequestMapping("/user")
	public String user(Integer id,String note,String userName) {
		User user=new User();
		user.setId(id);
		user.setNote(note);
		user.setUserName(userName);
	//UserValidate userValidate=	(UserValidate) userService;
	//if (userValidate.validate(user)) {
		userService.printUser(user);
	//}
		
		return "index";
	}
	
	@RequestMapping("/add")
	public String add(Integer id,String note,String userName) {
		User user=new User();
		user.setId(id);
		user.setNote(note);
		user.setUserName(userName);
	//UserValidate userValidate=	(UserValidate) userService;
	//if (userValidate.validate(user)) {
		userService.save(user);
	//}
		
		return "index";
	}
	@RequestMapping("/index1")
	public String index1(RedirectAttributes rAttributes) {
		User user=new User();
	//UserValidate userValidate=	(UserValidate) hellowService;
	//if (userValidate.validate(user)) {
		hellowService.sayHellow("lyn");
	//}
		rAttributes.addFlashAttribute("user",user);
		return "redirect:/index";
	}
}
