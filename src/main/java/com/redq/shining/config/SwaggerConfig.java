package com.redq.shining.config;

import com.google.common.base.Predicate;
import com.google.common.base.Predicates;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
 
/**
 * api doc -- springfox swagger configuration
 */
@Profile({"dev", "test"})
@Configuration
@EnableSwagger2
public class SwaggerConfig {

	// org.springframework.boot.autoconfigure.web.servlet.error
	// org.springframework.boot.actuate.endpoint.web.servlet;

	private static final String ACTUATE_CONTROLLER_PACKAGE = "org.springframework.boot.actuate.endpoint.mvc";
	
	private static final String APPLICATION_CONTROLLER_PACKAGE = "com.redq.shining.controller";

	@Bean
	public Docket applicationApi() {
		return new Docket(DocumentationType.SWAGGER_2)
				.groupName("1.app-api")
				.apiInfo(apiInfo())
				.select()
				.apis(RequestHandlerSelectors.basePackage(APPLICATION_CONTROLLER_PACKAGE))
				.paths(PathSelectors.any())
				.build();
	}

	@Bean
    public Docket adminApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("2.admin-api")
                .apiInfo(apiInfo())
                .forCodeGeneration(true)
                .pathMapping("/acurator")
                .select()
//                .apis(RequestHandlerSelectors.basePackage(ACTUATE_CONTROLLER_PACKAGE))
                .paths(paths())
                .build()
                .useDefaultResponseMessages(false);
    }
	
	private Predicate<String> paths() {
        return Predicates.and(PathSelectors.regex("/.*"), Predicates.not(PathSelectors.regex("/error")));  
    }

	private ApiInfo apiInfo() {
		Contact contact = new Contact("ahlon", "https://github.com/ahlon", "ahlon2002@gmail.com");  
        return new ApiInfoBuilder()  
               .title("Shining Api Documentation")
                // .description("latte")
                // .license("Apache License Version 2.0")
                // .contact(contact)
                .version("1.0")  
                .build();  
    }  
}
