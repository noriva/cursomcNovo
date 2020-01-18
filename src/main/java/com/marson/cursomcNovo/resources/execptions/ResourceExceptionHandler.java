package com.marson.cursomcNovo.resources.execptions;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.client.HttpServerErrorException;

import com.marson.cursomcNovo.servicies.exceptions.ObjectNotFoudException;

@ControllerAdvice
public class ResourceExceptionHandler {
	
	@ExceptionHandler(ObjectNotFoudException.class)
	public ResponseEntity<StandarErro> objectNotFound(ObjectNotFoudException e , HttpServletRequest request){
		StandarErro err = new StandarErro(HttpStatus.NOT_FOUND.value(), e.getMessage(), System.currentTimeMillis());
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(err);
	}
	
}
