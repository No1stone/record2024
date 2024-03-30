package com.origemite.logbacklogstash.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@Slf4j
public class LogstashController {

    @GetMapping("/test1")
    public String test1(){
        log.info("test11111 logstash test!!");
        return "test1";
    }

}
