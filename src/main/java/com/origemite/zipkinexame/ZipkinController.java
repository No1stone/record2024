package com.origemite.zipkinexame;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@RequiredArgsConstructor
public class ZipkinController {

    @GetMapping("/test1")
    public String test1(){
        log.info("test1 controller");
        return "test1";
    }

}
