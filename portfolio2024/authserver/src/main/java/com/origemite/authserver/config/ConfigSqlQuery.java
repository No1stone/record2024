package com.origemite.authserver.config;

import com.querydsl.jpa.impl.JPAQueryFactory;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class ConfigSqlQuery {

    @PersistenceContext
    private EntityManager entityManager;

    @Bean
    public JPAQueryFactory jpaQueryFactory() {
        return new JPAQueryFactory(entityManager);
    }

    /*
    @Bean
    public JPASQLQuery jpasqlQuery(){
//        SQLTemplates templates = PostgreSQLTemplates.builder()
        SQLTemplates templates = MySQLTemplates.builder()
//        SQLTemplates templates = OracleTemplates.builder()
                .printSchema()
                .quote()
                .newLineToSingleSpace()
                .build(); //change to your Templates
        com.querydsl.sql.Configuration configuration = new com.querydsl.sql.Configuration(templates);
        SpringExceptionTranslator springExceptionTranslator = new SpringExceptionTranslator();
        configuration.setExceptionTranslator(springExceptionTranslator);
        return new JPASQLQuery(entityManager,configuration);
    }
*/
}
