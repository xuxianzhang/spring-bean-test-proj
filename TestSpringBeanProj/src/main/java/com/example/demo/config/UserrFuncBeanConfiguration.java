package com.example.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.demo.bean.FunctionBean;
import com.example.demo.bean.UserFunctionBean;

@Configuration
public class UserrFuncBeanConfiguration {
	@Bean
	FunctionBean functionBean() {
		return new FunctionBean();
	}
	@Bean
	UserFunctionBean userFunctionBean() {
		UserFunctionBean userFunctionBean = new UserFunctionBean();
		userFunctionBean.setFunc(functionBean());
		return userFunctionBean;
	}
}
