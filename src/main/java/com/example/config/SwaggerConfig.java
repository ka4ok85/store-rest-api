package com.example.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.mangofactory.swagger.configuration.SpringSwaggerConfig;
import com.mangofactory.swagger.models.dto.ApiInfo;
import com.mangofactory.swagger.models.dto.builder.ApiInfoBuilder;
import com.mangofactory.swagger.plugin.EnableSwagger;
import com.mangofactory.swagger.plugin.SwaggerSpringMvcPlugin;

@Configuration
@EnableSwagger
public class SwaggerConfig {

	@Autowired
	private SpringSwaggerConfig springSwaggerConfig;
	
	private ApiInfo getApiInfo() {
		ApiInfo apiInfo = new ApiInfoBuilder()
				.title("Store REST API")
				.description("Store REST API for CRUD operations")
				.contact("admin@localhost.com")
				.license("MIT License")
				.licenseUrl("http://opensource.org/licenses/MIT")
				.build();
		
		return apiInfo;
	}
	
	@Bean
	public SwaggerSpringMvcPlugin v1APIconfiguration() {
		SwaggerSpringMvcPlugin swaggerSpringMvcPlugin = new SwaggerSpringMvcPlugin(this.springSwaggerConfig);

		
		swaggerSpringMvcPlugin.apiInfo(getApiInfo()).apiVersion("1.0").includePatterns("/v1/*.*").swaggerGroup("v1");
		swaggerSpringMvcPlugin.useDefaultResponseMessages(false);
		
		return swaggerSpringMvcPlugin;
	}
	
	@Bean
	public SwaggerSpringMvcPlugin v2APIconfiguration() {
		SwaggerSpringMvcPlugin swaggerSpringMvcPlugin = new SwaggerSpringMvcPlugin(this.springSwaggerConfig);

		
		swaggerSpringMvcPlugin.apiInfo(getApiInfo()).apiVersion("2.0").includePatterns("/v2/*.*").swaggerGroup("v2");
		swaggerSpringMvcPlugin.useDefaultResponseMessages(false);
		
		return swaggerSpringMvcPlugin;
	}
}
