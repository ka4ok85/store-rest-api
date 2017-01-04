package com.example.rest.v2;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController("TestControllerV2")
@RequestMapping("/v2/")
@io.swagger.annotations.Api(value = "tests", description = "Tests API")
public class TestController {

	@RequestMapping(value = "/tests", method = RequestMethod.GET, produces = "application/json")
	@io.swagger.annotations.ApiOperation(value = "Test Method", notes = "Just test method", response = String.class)
	public String tests() {
		return "test";
	}
}