package com.example.demo.main.Interception;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.InitBinder;

@ControllerAdvice(basePackages="com.example.demo.mian.demo.*")
public class MyControllerAdvice {
  
	
	@InitBinder
	public void initBidner(WebDataBinder binder)
	{
		CustomDateEditor dateEditor=new CustomDateEditor(new SimpleDateFormat("yyyy-MM-dd"), false);
		binder.registerCustomEditor(Date.class, dateEditor);
	}
	@ExceptionHandler(value=Exception.class)
	public void exceptionHandle(Model model,Exception exception)
	{
		
	}
}
