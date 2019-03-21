package com.bhargav.Idempotency;

import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.model.rest.RestBindingMode;
import org.apache.camel.model.rest.RestParamType;
import org.apache.camel.processor.idempotent.MemoryIdempotentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


/**
 * NewsLetter rest route which in take the params
 *
 * @author Bhargav Modepalli
 */
@Component
public class NewsLetterSubscriberRoute extends RouteBuilder {

    @Autowired
    NewsLetterSubscriptionUpdater newsLetterSubscriptionUpdater;

    private  String ROUTE_ID =this.getClass().getCanonicalName();

    @Override
    public void configure() throws Exception {
            rest("/subscribe")
                    .post()
                    .bindingMode(RestBindingMode.off)
                    .param().name("fname").type(RestParamType.query).description("FirstName").required(true).endParam()
                    .param().name("lname").type(RestParamType.query).description("LastName").required(true).endParam()
                    .param().name("email").type(RestParamType.query).description("Email").required(true).endParam()
                    .param().name("phone").type(RestParamType.query).description("Phone").required(true).endParam()
                    .route()
                    .routeId(ROUTE_ID)
                    .idempotentConsumer(header("email"), MemoryIdempotentRepository.memoryIdempotentRepository(200))
                    .skipDuplicate(false)
                    .removeOnFailure(true)
                    .bean(newsLetterSubscriptionUpdater,"update")
                    .end();
    }
}
