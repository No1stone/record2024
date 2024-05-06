package com.origemite.jdbcclinentexame.service;

import com.origemite.jdbcclinentexame.config.ConfDatabase;
import com.origemite.jdbcclinentexame.vo.Mytest2;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.simple.JdbcClient;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class Service2 {

    private final JdbcClient jdbcClient;
    Service2(@Qualifier("jdbcClient2") JdbcClient jdbcClient){
    this.jdbcClient = jdbcClient;
    }

    public List<Mytest2> findAll() {
        return jdbcClient.sql("select id,name,email from mytest2")
                .query(Mytest2.class)
                .list();
    }

}
