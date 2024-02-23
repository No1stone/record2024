package com.origemite.gateway.conf;

import com.origemite.gateway.filter.JwtAuthenticationFilter;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConfigFilter {

    private final JwtAuthenticationFilter jwtAuthenticationFilter;

    public ConfigFilter(JwtAuthenticationFilter jwtAuthenticationFilter) {
        this.jwtAuthenticationFilter = jwtAuthenticationFilter;
    }
    //https://spring.io/projects/spring-cloud-gateway
    @Bean
    public RouteLocator gatewayRoutes(RouteLocatorBuilder builder) {
        return builder.routes()
                .route("authserver", r -> r.path("/authserver/**")
                        .filters(
                                f   -> f
                                        .filter(jwtAuthenticationFilter.apply(new JwtAuthenticationFilter.Config()))
                                        .rewritePath("/authserver/(?<segment>.*)", "/${segment}")
                        )
                        .uri("lb://authserver"))
                .build();
    }

}
