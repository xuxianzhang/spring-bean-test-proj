package com.example.demo.controller;

import javax.annotation.PostConstruct;
import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.bean.UserFunctionBean;
import com.example.demo.component.UserFunctionBeanComponent;

@RestController
@Validated
public class TestController {
	@Autowired
	UserFunctionBean userFunctionBean;
	
	@Autowired
	UserFunctionBeanComponent userFucntionBeanComponent;
	
	@PostConstruct
	public void runFunc() {
		userFunctionBean.funcRun("test test test...");
	}
	
	@GetMapping("/hello")
	public String hello(@RequestParam("word") @NotNull(message="不能为空！") String str) {
		userFucntionBeanComponent.runFunc();
		return str;
	}
}
