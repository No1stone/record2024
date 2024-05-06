package com.origemite.jdbcclinentexame.cont;

import com.origemite.jdbcclinentexame.service.Service1;
import com.origemite.jdbcclinentexame.vo.Mytest1;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@Slf4j
@RequestMapping("/api/v1/cont1")
public class Controller1 {

    private final Service1 service1;

    @GetMapping("/test1")
    public List<Mytest1> test1(){
        return service1.findAll();
    }




}
