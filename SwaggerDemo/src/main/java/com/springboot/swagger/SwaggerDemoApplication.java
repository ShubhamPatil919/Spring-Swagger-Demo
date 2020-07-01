package com.springboot.swagger;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestMethod;import org.springframework.web.servlet.mvc.method.annotation.RequestResponseBodyMethodProcessor;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.builders.ResponseMessageBuilder;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.ResponseMessage;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
public class SwaggerDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(SwaggerDemoApplication.class, args);
	}

	@Bean
	public Docket swaggerConfiguration() {
		// @formatter:off
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
				//.paths(PathSelectors.ant("/api/*"))
				.paths(PathSelectors.any())
				.apis(RequestHandlerSelectors.basePackage("com.springboot.swagger"))
				.build()
				.apiInfo(apiDetails())
				.useDefaultResponseMessages(false)
				.globalResponseMessage(RequestMethod.GET, getCustomizedResponseMessage());
		// @formatter:on

	}


	private ApiInfo apiDetails() {
		return new ApiInfo("Employee Swagger API","1.0.0"
				,"Demo Related Swagger using employee and employer apis"
				,"Clover Infotech Pvt Ltd",
				new springfox.documentation.service.Contact("Shubham Patil", "www.xyz.com", "shubhams.patil@cloverinfotech.com"),"API Info","www.xyz.com",
				Collections.emptyList());
				

	}
	
	private List<ResponseMessage> getCustomizedResponseMessage() {
		List<ResponseMessage> responseMessage=new ArrayList<>();
		responseMessage.add(new ResponseMessageBuilder()
								.code(200)
								.message("Api Worked Successfully!!")
								.responseModel(new ModelRef("Success"))
								.build());
		return responseMessage;
	}


}