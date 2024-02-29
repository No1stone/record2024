package com.icom.naswebhook.icomnaswebhook.biz.conf;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class ConfRestTemplate {

    public RestTemplate restTemplate(){
        return new RestTemplateBuilder()
                .build();
    }

}
