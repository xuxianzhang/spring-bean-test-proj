package com.example.demo.component;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.demo.bean.UserFunctionBean;

@Component
public class UserFunctionBeanComponent {
	
	@Autowired
	UserFunctionBean userFunction;
	
	@PostConstruct
	public void runFunc() {
		userFunction.funcRun("component run func!");
	}
}
