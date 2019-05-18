package com.bhargav.webclient;

import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.model.rest.RestBindingMode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Time  Route
 *
 * @author Bhargav Modepalli
 */
@Component
public class TimeRoute extends RouteBuilder {

    @Autowired
    TimeRetriever timeRetriever;

    private  String ROUTE_ID = this.getClass().getCanonicalName();
    @Override
    public void configure() throws Exception {

        rest("/weather")
                .get()
                .bindingMode(RestBindingMode.off)
                .route()
                .routeId(ROUTE_ID)
                .bean(timeRetriever,"getEasternTime")
                .end();
    }
}
