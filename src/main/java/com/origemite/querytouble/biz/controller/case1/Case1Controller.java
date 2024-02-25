package com.origemite.querytouble.biz.controller.case1;

import com.origemite.querytouble.biz.controller.case1.vo.ReqCase1;
import com.origemite.querytouble.biz.service.case1.Case1Service;
import com.origemite.querytouble.data.db.entity.case1.Case1View;
import com.origemite.querytouble.data.jdbc.case1.Case1JdbcRepo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/case1")
public class Case1Controller {

    private final Case1Service case1Service;
    private final Case1JdbcRepo case1JdbcRepo;

    @PostMapping("")
    public void Case1TableCreate() {
        case1JdbcRepo.case1Table();
        case1JdbcRepo.case1ViewTable();
    }

    @DeleteMapping("")
    public void Case1TableDelete() {
        case1JdbcRepo.dropCase1();
    }

    @GetMapping("/create-data")
    public void CreateData() {
        case1Service.CreateData();
    }

    @GetMapping("")
    public List<Case1View> select(@ModelAttribute ReqCase1 dto) {
        return case1Service.select(dto);
    }


}
