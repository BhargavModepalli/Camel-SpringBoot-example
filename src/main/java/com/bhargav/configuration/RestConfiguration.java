package com.bhargav.configuration;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RestConfiguration extends RouteBuilder {
    @Override
    public void configure() throws Exception {
        restConfiguration()
                .component("servlet")
                .host("localhost")
                .contextPath("/camel")
                .port(System.getenv("server.port"))
                .apiContextPath("/apidocs")
                .apiProperty("api.title", "Idempotency")
                .apiProperty("api.version", "1.0.0");

    }
}
