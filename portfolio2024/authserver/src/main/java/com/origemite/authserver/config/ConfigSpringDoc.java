package com.origemite.authserver.config;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.security.SecurityScheme;
import io.swagger.v3.oas.models.servers.Server;
import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConfigSpringDoc {

    @Bean
    public OpenAPI springShopOpenAPI() {
        return new OpenAPI()
                .addServersItem(new Server().url("/"))
                .components(new Components().addSecuritySchemes("basicSchema", new SecurityScheme().type(SecurityScheme.Type.HTTP).scheme("basic")))
                .info(new Info().title("Origemite Authserver")
                        .description("Origemite Authserver API")
                        .version("v0.0.1")
                        .license(new License().name("ORIGEMITE").url("http://www.origemite.com/"))
                )
                .externalDocs(new ExternalDocumentation()
                        .description("JangWonSeok Developer")
                        .url("https://git.origemite.com")
                )
                ;
    }



//    @Bean
    public GroupedOpenApi publicApi() {
        return GroupedOpenApi.builder()
                .group("analysis-public")
                .pathsToMatch("/api/v1/**")
                .build();
    }


//    @Bean
//    public GroupedOpenApi publicApi() {
//        return GroupedOpenApi.builder()
//                .group("test")
////                .pathsToMatch("/acs/api/v1/**")
//                .pathsToMatch("/**")
//                .build();
//    }

}
