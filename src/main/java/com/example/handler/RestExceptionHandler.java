package com.example.handler;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.example.dto.error.ErrorDetail;
import com.example.exception.ResourceNotFoundException;

@ControllerAdvice
public class RestExceptionHandler {

	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<?> handleResouceNotFoundException(ResourceNotFoundException resourceNotFoundException, HttpServletRequest request) {
		
		ErrorDetail errorDetail = new ErrorDetail();
		errorDetail.setDetail(resourceNotFoundException.getMessage());
		errorDetail.setDeveloperMessage(resourceNotFoundException.getClass().getName());
		errorDetail.setStatus(HttpStatus.NOT_FOUND.value());
		errorDetail.setTimestamp(new Date().getTime());
		errorDetail.setTitle("Resource not found");
		
		return new ResponseEntity<>(errorDetail, HttpStatus.NOT_FOUND);
	} 
}
