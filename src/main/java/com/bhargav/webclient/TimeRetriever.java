package com.bhargav.webclient;

import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

@Component
public class TimeRetriever {

    /**
     * gets eastern time
     * @return
     */
    public String getEasternTime(){

        WebClient webClient = WebClient.create();

       String  response = webClient
                            .get()
                            .uri("http://worldclockapi.com/api/json/est/now")
                            .retrieve()
                            .bodyToMono(String.class)
                            .block() ;


        return response;
    }

}
