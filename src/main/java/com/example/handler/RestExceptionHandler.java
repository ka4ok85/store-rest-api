package com.example.handler;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
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
	
	@ExceptionHandler(HttpRequestMethodNotSupportedException.class)
	public ResponseEntity<?> handleHttpRequestMethodNotSupportedException(HttpRequestMethodNotSupportedException httpRequestMethodNotSupportedException, HttpServletRequest request) {
		
		ErrorDetail errorDetail = new ErrorDetail();
		errorDetail.setDetail(httpRequestMethodNotSupportedException.getMessage());
		errorDetail.setDeveloperMessage(httpRequestMethodNotSupportedException.getClass().getName());
		errorDetail.setStatus(HttpStatus.NOT_FOUND.value());
		errorDetail.setTimestamp(new Date().getTime());
		errorDetail.setTitle("Resource not found");

		return new ResponseEntity<>(errorDetail, HttpStatus.NOT_FOUND);
	} 
	
	@ExceptionHandler(AccessDeniedException.class)
	public ResponseEntity<?> handleAccessDeniedException(AccessDeniedException accessDeniedException, HttpServletRequest request) {
		
		ErrorDetail errorDetail = new ErrorDetail();
		errorDetail.setDetail(accessDeniedException.getMessage());
		errorDetail.setDeveloperMessage(accessDeniedException.getClass().getName());
		errorDetail.setStatus(HttpStatus.FORBIDDEN.value());
		errorDetail.setTimestamp(new Date().getTime());
		errorDetail.setTitle("Forbidden");

		return new ResponseEntity<>(errorDetail, HttpStatus.FORBIDDEN);
	}
}
