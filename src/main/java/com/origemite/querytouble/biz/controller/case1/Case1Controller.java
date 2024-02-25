package com.origemite.querytouble.biz.controller.case1;

import com.origemite.querytouble.biz.service.case1.Case1Service;
import com.origemite.querytouble.data.jdbc.JdbcTemplateRepo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/case1")
public class Case1Controller {

    private final Case1Service case1Service;
    private final JdbcTemplateRepo jdbcTemplateRepo;

    @PostMapping("")
    public void Case1TableCreate(){
        jdbcTemplateRepo.case1Table();
        jdbcTemplateRepo.case1ViewTable();
    }
    @DeleteMapping("")
    public void Case1TableDelete(){
        jdbcTemplateRepo.dropCase1();
    }

    @GetMapping("/create-data")
    public void CreateData(){
        case1Service.CreateData();
    }
}
