package com.origemite.authserver.annotation;

import com.origemite.authserver.biz.service.JwtService;
import com.origemite.authserver.biz.service.UserService;
import org.mockito.Mockito;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcBuilder;

@TestConfiguration
public class FilterMvcConfiguration {

    @Bean
    public JwtService jwtService() {
        return Mockito.mock(JwtService.class);
    }

    @Bean
    public UserService userService() {
        return Mockito.mock(UserService.class);
    }

}
