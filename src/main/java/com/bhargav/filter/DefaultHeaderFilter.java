package com.bhargav.filter;

import org.apache.camel.Exchange;
import org.apache.camel.spi.HeaderFilterStrategy;
import org.springframework.stereotype.Component;

/**
 * Class to filter the headers
 *
 * @author Bhargav M
 */

@Component
public class DefaultHeaderFilter implements HeaderFilterStrategy {


    /**
     * filters the headers fname, lname, email, phone from the response
     * @param headerName
     * @param headerValue
     * @param exchange
     * @return
     */
    @Override
    public boolean applyFilterToCamelHeaders(String headerName, Object headerValue, Exchange exchange) {

        if( headerName.equals("fname") ){

            return true;

        } else{

            return false;
        }


    }

    /**
     *  method to filter headers that are inbound
     * @param headerName
     * @param headerValue
     * @param exchange
     * @return
     */
    @Override
    public boolean applyFilterToExternalHeaders(String headerName, Object headerValue, Exchange exchange) {
        return false;
    }
}
