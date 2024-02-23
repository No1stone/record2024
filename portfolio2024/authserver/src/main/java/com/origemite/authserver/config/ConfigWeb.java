package com.origemite.authserver.config;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@RequiredArgsConstructor
public class ConfigWeb implements WebMvcConfigurer {

    private final ConfigIntercepter configIntercepter;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry
                .addInterceptor(configIntercepter)
                .excludePathPatterns("/swagger-ui/**")
                .excludePathPatterns("/test")
                .addPathPatterns("/api/**")
                ;
    }

    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
//                .allowedOrigins("https://admin.icomsys.co.kr")
//                .allowedOrigins("https://admindev.icomsys.co.kr")
//                .allowedOrigins("https://admindemo.icomsys.co.kr")
                .allowedMethods(
                        HttpMethod.GET.name()
                        , HttpMethod.PUT.name()
                        , HttpMethod.POST.name()
                        ,HttpMethod.PATCH.name()
                        ,HttpMethod.DELETE.name()
                );
    }
}
