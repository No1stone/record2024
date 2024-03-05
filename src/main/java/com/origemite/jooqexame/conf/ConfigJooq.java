package com.origemite.jooqexame.conf;

import lombok.RequiredArgsConstructor;
import org.jooq.DSLContext;
import org.jooq.SQLDialect;
import org.jooq.Source;
import org.jooq.codegen.GenerationTool;
import org.jooq.impl.DataSourceConnectionProvider;
import org.jooq.impl.DefaultConfiguration;
import org.jooq.impl.DefaultDSLContext;
import org.jooq.impl.DefaultExecuteListenerProvider;
import org.jooq.meta.jaxb.*;
import org.springframework.boot.autoconfigure.jooq.JooqExceptionTranslator;
import org.springframework.cglib.core.DefaultGeneratorStrategy;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.TransactionAwareDataSourceProxy;

@Configuration
@RequiredArgsConstructor
public class ConfigJooq {
    private final ConfigDatasource configDatasource;
//    private final DSLContext create;

    @Bean
    public DefaultConfiguration jooqConf() {
        DefaultConfiguration dc = new DefaultConfiguration();
        dc.set(configDatasource.dataSource());
        dc.set(new DefaultExecuteListenerProvider(new JooqExceptionTranslator()));
        SQLDialect dialect = SQLDialect.valueOf(String.valueOf(SQLDialect.MYSQL));
        dc.set(dialect);
        return dc;
    }

    @Bean
    public DefaultDSLContext dsl() {
        return new DefaultDSLContext(jooqConf());
    }

    @Bean
    public DataSourceConnectionProvider connectionProvider() {
        return new DataSourceConnectionProvider(new TransactionAwareDataSourceProxy(configDatasource.dataSource()));
    }

    @Bean
    public org.jooq.meta.jaxb.Configuration codeJenJooq() {
        org.jooq.meta.jaxb.Configuration configuration = new org.jooq.meta.jaxb.Configuration();
        configuration.withJdbc(new Jdbc()
                        .withDriver("net.sf.log4jdbc.DriverSpy")
                        .withUrl("jdbc:log4jdbc:mysql://localhost:3320/qtdb")
                        .withUser("root")
                        .withPassword("1234")
                        .withProperties(
                                new Property()
                                        .withKey("user")
                                        .withValue("root"),
                                new Property()
                                        .withKey("password")
                                        .withValue("1234")
                        )
                )
                .withGenerator(new Generator()
                        .withDatabase(new Database()
                                .withName("org.jooq.meta.mysql.MySQLDatabase")
                                .withIncludes(".*")
                        ).withGenerate(new Generate()
//                                .withGeneratedAnnotation(true)
//                                .withGeneratedAnnotationType(GeneratedAnnotationType.DETECT_FROM_JDK)
//                                .withGeneratedAnnotationDate(true)
//                                .withGeneratedAnnotationJooqVersion(true)
//                                .withPojosAsKotlinDataClasses(true)
//                                .withDeprecated(false)
//                                .withRecords(true)
//                                .withPojos(true)
//                                .withImmutablePojos(false)
//                                .withFluentSetters(true)
//                                .withDaos(true)
                        )
                        .withTarget(new Target()

                                // The destination package of your generated classes (within the
                                // destination directory)
                                //
                                // jOOQ may append the schema name to this package if generating multiple schemas,
                                // e.g. org.jooq.your.packagename.schema1
                                // org.jooq.your.packagename.schema2
                                .withPackageName("com.origemite.jooqexame")

                                // The destination directory of your generated classes
                                .withDirectory("build/jooq")
                                .withClean(true)
                        ));

        return configuration;
    }
}
