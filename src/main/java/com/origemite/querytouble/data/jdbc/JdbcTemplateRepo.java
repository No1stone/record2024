package com.origemite.querytouble.data.jdbc;

import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class JdbcTemplateRepo {
    private final JdbcTemplate jdbcTemplate;

    public void dropCase1(){
        jdbcTemplate.execute("drop view CASE1_VIEW;" );
        jdbcTemplate.execute("drop table CASE1_USER;" );
        jdbcTemplate.execute("drop table CASE1_COSTOMER;" );
        jdbcTemplate.execute("drop table CASE1_GROUP;" );
    }

    public void case1Table(){
        jdbcTemplate.execute("CREATE TABLE IF NOT EXISTS CASE1_USER" +
                "(" +
                "  USER_ID    VARCHAR(50) NOT NULL," +
                "  USER_NAME  VARCHAR(50) NOT NULL," +
                "  CREATE_AT DATETIME    NOT NULL," +
                "  UPDATE_AT DATETIME    NULL    ," +
                "  PRIMARY KEY (USER_ID)" +
                ") COMMENT '유저' CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci" );

        jdbcTemplate.execute("CREATE TABLE IF NOT EXISTS CASE1_COSTOMER" +
                "(" +
                "  CTM_ID    VARCHAR(50) NOT NULL," +
                "  CTM_NAME  VARCHAR(50) NOT NULL," +
                "  CREATE_AT DATETIME    NOT NULL," +
                "  UPDATE_AT DATETIME    NULL    ," +
                "  PRIMARY KEY (CTM_ID)" +
                ") COMMENT '고객사' CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci" );

        jdbcTemplate.execute("CREATE TABLE IF NOT EXISTS CASE1_GROUP" +
                "(" +
                "  GRP_ID    VARCHAR(50) NOT NULL," +
                "  GRP_NAME  VARCHAR(50) NOT NULL," +
                "  CREATE_AT DATETIME    NOT NULL," +
                "  UPDATE_AT DATETIME    NULL    ," +
                "  PRIMARY KEY (GRP_ID)" +
                ") COMMENT '그룹' CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci" );
    }

    public void case1ViewTable(){
        jdbcTemplate.execute("create view CASE1_VIEW AS " +
                "SELECT 'user'       AS 'profile_type'" +
                "     , us.USER_ID   AS 'profile_id'" +
                "     , us.USER_NAME AS 'profile_name'" +
                " FROM CASE1_USER us" +
                " UNION ALL" +
                " SELECT 'COSTOMER'       AS 'profile_type'" +
                "     , ctm.CTM_ID   AS 'profile_id'" +
                "     , ctm.CTM_NAME AS 'profile_name'" +
                " FROM qtdb.CASE1_COSTOMER ctm" +
                " UNION ALL" +
                " SELECT 'GROUP'       AS 'profile_type'" +
                "     , grp.GRP_ID   AS 'profile_id'" +
                "     , grp.GRP_NAME AS 'profile_name'" +
                " FROM qtdb.CASE1_GROUP grp;");
    }
}
