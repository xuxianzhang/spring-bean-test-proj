package com.example.demo.advice;

import java.io.PrintWriter;
import java.io.StringWriter;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import lombok.Data;

@RestControllerAdvice
public class ExceptionAdvice {
	@Data
	private class ExceptionData{
		private String errorCode;
		private String errorMsg;
		private String cause;
	}
	
	public static String printStackTraceToString(Throwable t) {
		StringWriter sw = new StringWriter();
		t.printStackTrace(new PrintWriter(sw, true));
		return sw.getBuffer().toString();
	}
	
	@ExceptionHandler({ MissingServletRequestParameterException.class })
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public ExceptionData accessDeniedExceptionHandler(MissingServletRequestParameterException exception) {
		ExceptionData rep = new ExceptionData();
		rep.setErrorCode(HttpStatus.BAD_REQUEST.name());
		rep.setErrorMsg(exception.getMessage());
		rep.setCause(printStackTraceToString(exception));
		return rep;
	}
}
