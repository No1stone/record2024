package com.origemite.querytouble.data.jdbc.case2;

import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class Case2JdbcRepo {
    private final JdbcTemplate jdbcTemplate;

    public void drop(){
        jdbcTemplate.execute("drop table CASE2_END;" );
        jdbcTemplate.execute("drop table CASE2_AND1;" );
        jdbcTemplate.execute("drop table CASE2_AND2;" );
    }

    public void case1Table(){
        jdbcTemplate.execute("CREATE TABLE IF NOT EXISTS CASE2_END" +
                "(" +
                "  ID    VARCHAR(50) NOT NULL," +
                "  END_POINT  VARCHAR(50) NOT NULL," +
                "  PRIMARY KEY (ID)" +
                ") COMMENT 'endpoint' CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci" );

        jdbcTemplate.execute("CREATE TABLE IF NOT EXISTS CASE2_AND1" +
                "(" +
                "  AND1_ID  VARCHAR(50) NOT NULL," +
                "  ID    VARCHAR(50) NOT NULL," +
                "  AND1_STATUS  VARCHAR(50) NOT NULL," +
                "  PRIMARY KEY (AND1_ID)" +
                ") COMMENT 'and1' CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci" );

        jdbcTemplate.execute("CREATE TABLE IF NOT EXISTS CASE2_AND2" +
                "(" +
                "  AND2_ID  VARCHAR(50) NOT NULL," +
                "  ID    VARCHAR(50) NOT NULL," +
                "  AND2_STATUS  VARCHAR(50) NOT NULL," +
                "  PRIMARY KEY (AND2_ID)" +
                ") COMMENT 'and2' CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci" );
    }


}
