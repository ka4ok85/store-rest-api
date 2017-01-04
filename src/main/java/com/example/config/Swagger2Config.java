package com.example.config;

import com.fasterxml.classmate.TypeResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.PathSelectors;
import static springfox.documentation.builders.PathSelectors.*;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.ApiKey;
import springfox.documentation.service.AuthorizationScope;
import springfox.documentation.service.SecurityReference;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.service.contexts.SecurityContext;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger.web.ApiKeyVehicle;
import springfox.documentation.swagger.web.SecurityConfiguration;
import springfox.documentation.swagger.web.UiConfiguration;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.List;

import static com.google.common.collect.Lists.*;
import static com.google.common.base.Predicates.*;

@Configuration
@EnableSwagger2
public class Swagger2Config {

	private ApiKey apiKey() {
		return new ApiKey("mykey", "api_key", "header");
	}

	private SecurityContext securityContext() {
		return SecurityContext.builder().securityReferences(defaultAuth()).forPaths(PathSelectors.regex("/anyPath.*")).build();
	}

	List<SecurityReference> defaultAuth() {
		AuthorizationScope authorizationScope = new AuthorizationScope("global", "accessEverything");
		AuthorizationScope[] authorizationScopes = new AuthorizationScope[1];
		authorizationScopes[0] = authorizationScope;
		return newArrayList(new SecurityReference("mykey", authorizationScopes));
	}

	@Bean
	SecurityConfiguration security() {
		return new SecurityConfiguration("test-app-client-id", "test-app-client-secret", "test-app-realm", "test-app",
				"apiKey", ApiKeyVehicle.HEADER, "api_key", "," /* scope separator */);
	}

	@Bean
	UiConfiguration uiConfig() {
		return new UiConfiguration("validatorUrl", // url
				"none", // docExpansion => none | list
				"alpha", // apiSorter => alpha
				"schema", // defaultModelRendering => schema
				UiConfiguration.Constants.DEFAULT_SUBMIT_METHODS, false, // enableJsonEditor
																			// =>
																			// true
																			// |
																			// false
				true, // showRequestHeaders => true | false
				60000L); // requestTimeout => in milliseconds, defaults to null
							// (uses jquery xh timeout)
	}

	@Bean
	public Docket v1Api() {
		return new Docket(DocumentationType.SWAGGER_2)
				.groupName("v1-api")
	            .select()
	            .paths(or(regex(".*v1.*")))
	            .build()
	            .apiInfo(apiInfo())
	            .securitySchemes(newArrayList(apiKey()))
	            .securityContexts(newArrayList(securityContext()));
	}
	
	@Bean
	public Docket v2Api() {
		return new Docket(DocumentationType.SWAGGER_2)
				.groupName("v2-api")
	            .select()
	            .paths(or(regex(".*v2.*")))
	            .build()
	            .apiInfo(apiInfo())
	            .securitySchemes(newArrayList(apiKey()))
	            .securityContexts(newArrayList(securityContext()));
	}
	
	private ApiInfo apiInfo() {
	    return new ApiInfoBuilder()
	            .title("Store REST API")
	            .description("Store REST API for CRUD operations")
	            .termsOfServiceUrl("http://springfox.io")
	            .license("MIT License")
	            .licenseUrl("http://opensource.org/licenses/MIT")
	            .version("1.0")
	            .build();
	}
	

}
