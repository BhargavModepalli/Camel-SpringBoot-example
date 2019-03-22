package com.bhargav.ping;

import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.model.rest.RestBindingMode;
import org.springframework.stereotype.Component;

/**
 * Ping Controller
 *
 * @author Bhargav Modepalli
 */
@Component
public class PingController extends RouteBuilder {

    private  String ROUTE_ID = this.getClass().getCanonicalName();
    @Override
    public void configure() throws Exception {

        rest("/ping")
                .get()
                .bindingMode(RestBindingMode.off)
                .route()
                .routeId(ROUTE_ID)
                .transform(constant("PONG"))
                .end();
    }
}
