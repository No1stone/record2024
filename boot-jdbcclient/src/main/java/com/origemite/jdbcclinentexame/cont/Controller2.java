package com.origemite.jdbcclinentexame.cont;

import com.origemite.jdbcclinentexame.service.Service2;
import com.origemite.jdbcclinentexame.vo.Mytest2;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@Slf4j
@RequestMapping("/api/v1/cont2")
public class Controller2 {

    private final Service2 service2;

    @GetMapping("/test1")
    public List<Mytest2> test1() {
        return service2.findAll();
    }


}
