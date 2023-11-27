package com.icom.naswebhook.icomnaswebhook.biz.conf;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestClient;

@Configuration
public class ConfRestCilent {

    public RestClient confRestCilent(){
        RestClient restClient = RestClient.create();
        return restClient;
    }

}
