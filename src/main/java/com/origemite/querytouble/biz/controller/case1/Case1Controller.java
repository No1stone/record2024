package com.origemite.querytouble.biz.controller.case1;

import com.origemite.querytouble.biz.service.case1.Case1Service;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@RequiredArgsConstructor
public class Case1Controller {

    private final Case1Service case1Service;


}
