package com.example.security;

import java.io.IOException;
import java.io.Serializable;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import com.example.dto.error.ErrorDetail;
import com.fasterxml.jackson.databind.ObjectMapper;

@Component
public class JwtAuthenticationEntryPoint implements AuthenticationEntryPoint, Serializable {
	private static final long serialVersionUID = -7532616439711137745L;

	@Override
    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException authException) throws IOException {
        // This is invoked when user tries to access a secured REST resource without supplying any credentials
        //response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Unauthorized");
		
		// The @ExceptionHandler will only work if the request is handled by the DispatcherServlet. However this exception occurs before that as it is thrown by a Filter
		// that's why we return message here :(
		ErrorDetail errorDetail = new ErrorDetail();
		errorDetail.setDetail("Unauthorized");
		errorDetail.setDeveloperMessage(this.getClass().getName());
		errorDetail.setStatus(HttpStatus.UNAUTHORIZED.value());
		errorDetail.setTimestamp(new Date().getTime());
		errorDetail.setTitle("Unauthorized");

		response.setContentType("application/json");
	    response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
		ObjectMapper mapper = new ObjectMapper();
		mapper.writeValue(response.getOutputStream(), errorDetail);
	}

}
