package com.origemite.jdbcclinentexame.service;

import com.origemite.jdbcclinentexame.vo.Mytest1;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.simple.JdbcClient;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class Service1 {
    private final JdbcClient jdbcClient;
    Service1(@Qualifier("jdbcClient1") JdbcClient jdbcClient){
        this.jdbcClient = jdbcClient;
    }


    public List<Mytest1> findAll() {
        return jdbcClient.sql("SELECT id,title,slug,date,time_to_read,tags FROM mytest1")
                .query(Mytest1.class)
                .list();
    }

    public Optional<Mytest1> findById(String id) {
        return jdbcClient.sql("SELECT id,title,slug,date,time_to_read,tags FROM mytest1 WHERE id = :id")
                .param("id", id)
                .query(Mytest1.class)
                .optional();
    }

    public int create(Mytest1 mytest1) {
        return jdbcClient.sql("INSERT INTO mytest1(id,title,slug,date,time_to_read,tags) values(?,?,?,?,?,?)")
                .params(List.of(mytest1.id(),mytest1.title(),mytest1.slug(),mytest1.date(),mytest1.timeToRead(),mytest1.tags()))
                .update();
    }

    public int update(Mytest1 mytest1, String id) {
        return jdbcClient.sql("update mytest1 set title = ?, slug = ?, date = ?, time_to_read = ?, tags = ? where id = ?")
                .params(List.of(mytest1.title(), mytest1.slug(), mytest1.date(), mytest1.timeToRead(), mytest1.tags(), id))
                .update();
    }

    public int delete(String id) {
        return jdbcClient.sql("delete from mytest1 where id = :id")
                .param("id", id)
                .update();
    }

}
