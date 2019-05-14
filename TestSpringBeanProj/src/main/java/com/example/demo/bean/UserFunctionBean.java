package com.example.demo.bean;

public class UserFunctionBean {
	FunctionBean funcBean;
	
	public void setFunc(FunctionBean bean) {
		this.funcBean = bean;
	}
	
	public void funcRun(String words) {
		funcBean.say(words);
	}
}
