package com.bhargav;

import org.apache.camel.component.servlet.CamelHttpTransportServlet;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Set up the spring boot application using servlet container
 *
 * @author Bhargav Modepalli
 */
@Configuration
@SpringBootApplication
public class IdempotencyApplication {

	public static void main(String[] args) {
		SpringApplication.run(IdempotencyApplication.class, args);

	}

	@Bean()
	public ServletRegistrationBean camelServletRegistrationBean() {
		ServletRegistrationBean registration = new ServletRegistrationBean(new CamelHttpTransportServlet(), "/camel/*");
		registration.setName("CamelServlet");
		return registration;
	}

}
