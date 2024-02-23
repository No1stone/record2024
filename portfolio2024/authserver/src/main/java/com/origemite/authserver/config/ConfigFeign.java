package com.origemite.authserver.config;

import feign.Logger;
import feign.RequestInterceptor;
import feign.Retryer;
import feign.codec.ErrorDecoder;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@Slf4j
public class ConfigFeign {

    @Bean
    public Logger.Level FeignLevel() {
        return Logger.Level.FULL;
    }

    @Bean
    public RequestInterceptor requestInterceptor() {
        return requestTemplate -> {
            requestTemplate.header("Content-Type", "application/json");
            requestTemplate.header("accept", "application/json");
        };
    }

    //커스터마이징 필요
    @Bean
    public ErrorDecoder errorDecoder() {
        return new ConfigErrorDecoder();
    }

    //요청 실패시 재시도를 한다. 1초간격 5번
    @Bean
    public Retryer retryer() {
        return new Retryer.Default();
    }


}
