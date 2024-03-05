package com.origemite.jooqexame.biz;

import com.origemite.jooqexame.data.db.entity.case2.Case2End;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.jooq.DSLContext;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequiredArgsConstructor
@Slf4j
public class JooqController {

//    private final DSLContext dslContext;

    @GetMapping("")
    public void test(){
//        dslContext.selectFrom(Case2End)
    }

}
