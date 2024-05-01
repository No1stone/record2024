package com.origemite.jdbcclinentexame.config;

import com.zaxxer.hikari.HikariDataSource;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.boot.jdbc.init.DataSourceScriptDatabaseInitializer;
import org.springframework.boot.sql.init.DatabaseInitializationMode;
import org.springframework.boot.sql.init.DatabaseInitializationSettings;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.simple.JdbcClient;

import javax.sql.DataSource;
import java.util.List;

@Configuration(proxyBeanMethods = false)
public class ConfDatabase {

    @Value("${spring.datasource1.url}")
    private String url1;
    @Value("${spring.datasource1.username}")
    private String user1;
    @Value("${spring.datasource1.password}")
    private String pass1;
    @Value("${spring.datasource2.url}")
    private String url2;
    @Value("${spring.datasource2.username}")
    private String user2;
    @Value("${spring.datasource2.password}")
    private String pass2;
    @Value("${spring.datasource1.driver-class-name}")
    private String driver;


    // db1  ===========================================================================================================

    @Bean
    @Primary
    public DataSourceProperties DataSourceProperties1() {
        DataSourceProperties dsp = new DataSourceProperties();
        dsp.setUrl(url1);
        dsp.setPassword(pass1);
        dsp.setUsername(user1);
        dsp.setDriverClassName(driver);
        return dsp;
    }

    @Bean
    @Primary
    public HikariDataSource DataSource1(DataSourceProperties DataSourceProperties1) {
        return DataSourceProperties1.initializeDataSourceBuilder()
                .type(HikariDataSource.class)
                .build();
    }

    @Bean
    DataSourceScriptDatabaseInitializer DataSourceScriptDatabaseInitializer1(@Qualifier("DataSource1") DataSource dataSource) {
        var settings = new DatabaseInitializationSettings();
        settings.setSchemaLocations(List.of("classpath:db1.sql"));
        settings.setMode(DatabaseInitializationMode.ALWAYS);
//        settings.setMode(DatabaseInitializationMode.EMBEDDED);
        return new DataSourceScriptDatabaseInitializer(dataSource,settings);
    }

    // db2 ====================================================================================================

    @Bean
    public DataSourceProperties DataSourceProperties2() {
        DataSourceProperties dsp = new DataSourceProperties();
        dsp.setUrl(url2);
        dsp.setPassword(pass2);
        dsp.setUsername(user2);
        dsp.setDriverClassName(driver);
        return dsp;
    }

    @Bean
    public DataSource DataSource2(@Qualifier("DataSourceProperties2") DataSourceProperties DataSourceProperties2) {
        return DataSourceBuilder
                .create()
                .driverClassName(driver)
                .url(DataSourceProperties2.getUrl())
                .username(DataSourceProperties2.getUsername())
                .password(DataSourceProperties2.getPassword())
                .build();
    }

    @Bean
    DataSourceScriptDatabaseInitializer DataSourceScriptDatabaseInitializer2(@Qualifier("DataSource2") DataSource dataSource) {
        var settings = new DatabaseInitializationSettings();
        settings.setSchemaLocations(List.of("classpath:db2.sql"));
        settings.setMode(DatabaseInitializationMode.ALWAYS);
//        settings.setMode(DatabaseInitializationMode.EMBEDDED);
        return new DataSourceScriptDatabaseInitializer(dataSource,settings);
    }

    @Bean
    JdbcClient jdbcClient1(@Qualifier("DataSource1") DataSource dataSource) {
        return JdbcClient.create(dataSource);
    }
    @Bean
    JdbcClient jdbcClient2(@Qualifier("DataSource2") DataSource dataSource) {
        return JdbcClient.create(dataSource);
    }

}
