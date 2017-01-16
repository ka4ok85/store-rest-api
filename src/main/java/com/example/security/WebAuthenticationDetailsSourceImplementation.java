package com.example.security;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.authentication.AuthenticationDetailsSource;
import org.springframework.stereotype.Component;

import com.example.StoreRestApiApplication;
import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;

@Component
public class WebAuthenticationDetailsSourceImplementation implements AuthenticationDetailsSource<HttpServletRequest, JwtAuthenticationRequest> {

	private static final Logger log = LoggerFactory.getLogger(StoreRestApiApplication.class);
	
	@Override
	public JwtAuthenticationRequest buildDetails(HttpServletRequest context) {
		JwtAuthenticationRequest jwtAuthenticationRequest = new JwtAuthenticationRequest();
		Gson gson = new Gson();
    	String json = new String();
    	String output = new String();
    	BufferedReader br;
    	StringBuffer buffer = new StringBuffer(16384);

    	// reading raw JSON Authentication Request into JwtAuthenticationRequest instance
    	try {
			br = new BufferedReader(new InputStreamReader(context.getInputStream()));
	        while ((output = br.readLine()) != null) {
	            buffer.append(output);
	        }			

	        json = buffer.toString();
			jwtAuthenticationRequest = gson.fromJson(json, JwtAuthenticationRequest.class);
			log.info("Authentication Request is {}.", jwtAuthenticationRequest);
    	} catch (IllegalStateException | JsonSyntaxException exception) {
			log.info("Authentication Request is not a valid JSON.");
    		return null;
    	} catch (IOException iOException) {
			log.info("Can not parse Authentication Request.");
			return null;
		} catch (NumberFormatException numberFormatException) {
			log.info("Can not map Authentication Request.");
    		return null;
		}
    	

    	return jwtAuthenticationRequest;
	}
}
