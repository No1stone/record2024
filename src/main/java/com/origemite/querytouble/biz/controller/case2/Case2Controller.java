package com.origemite.querytouble.biz.controller.case2;

import com.origemite.querytouble.biz.controller.case2.vo.Case2SelectAll;
import com.origemite.querytouble.biz.service.case2.Case2Service;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/case2")
public class Case2Controller {

    private final Case2Service case2Service;

    @PostMapping("")
    public void DataSetting(){
        case2Service.DataSetting();
    }

    @GetMapping("")
    public List<Case2SelectAll> dataCheck(){
        return case2Service.dataCheck();
    }

    @GetMapping("/create-table")
    public void createTable(){
        case2Service.createTable();
    }

    @GetMapping("/drop-table")
    public void dropTable(){
        case2Service.dropTable();
    }
    @GetMapping("/up")
    public void dynamicBulkUpdate(){
        case2Service.dynamicBulkUpdate();
    }
}
