package com.origemite.querytouble.biz.controller.case1;

import com.origemite.querytouble.biz.service.case1.Case1Service;
import com.origemite.querytouble.data.jdbc.JdbcTemplateRepo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@RequiredArgsConstructor
public class Case1Controller {

    private final Case1Service case1Service;
    private final JdbcTemplateRepo jdbcTemplateRepo;

    @GetMapping("/test1")
    public void TestTableCreate(){
        jdbcTemplateRepo.case1Table();
        jdbcTemplateRepo.case1ViewTable();
    }

}
