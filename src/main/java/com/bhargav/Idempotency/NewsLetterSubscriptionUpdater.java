package com.bhargav.Idempotency;

import org.apache.camel.Exchange;
import org.springframework.stereotype.Component;

/**
 * Check if the subscription email is already subscribed or not based on camel DUPLICATE_MESSAGE flag
 *
 * @author Bhargav Modepalli
 */
@Component
public class NewsLetterSubscriptionUpdater {

    public String update(Exchange exchange) {



        if (exchange.getProperties().containsKey(Exchange.DUPLICATE_MESSAGE)) {

            return " email already subsribed please use another email"+exchange.getIn().getHeader("email");
        } else {

            return " You are successfully subscribed with email "+exchange.getIn().getHeader("email") ;
        }


    }
}
