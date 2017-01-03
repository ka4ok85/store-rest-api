package com.example.rest.v1;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;

@RestController("TestControllerV1")
@RequestMapping("/v1/")
@Api(value = "tests", description = "Tests API")
public class TestController {

	@RequestMapping(value = "/tests", method = RequestMethod.GET, produces = "application/json")
	@ApiOperation(value = "Test Method", notes = "Just test method", response = String.class)
	public String tests() {
		return "test";
	}
}
