package com.example.demo.error;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.example.demo.entity.ErrorEntity;

@RestControllerAdvice
@ResponseStatus
public class RestErrorExceptionController extends ResponseEntityExceptionHandler{
	
	@ExceptionHandler(ErrorException.class)
	@ResponseBody
	public ResponseEntity<ErrorEntity> DepartmentNotFound(ErrorException error,WebRequest request) {
		System.out.println("RestClass");
		ErrorEntity entity=new ErrorEntity(HttpStatus.NOT_FOUND,error.getMessage());
		
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(entity);
		
	}

}
