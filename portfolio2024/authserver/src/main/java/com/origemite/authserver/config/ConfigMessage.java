package com.origemite.authserver.config;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.validation.Validator;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.Locale;

@Configuration
public class ConfigMessage implements WebMvcConfigurer {


    @Bean
    public MessageSource messageSource(){
        ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();
//        messageSource.setBasenames("classpath:/message/messages","classpath:/message/validation");
        messageSource.setBasenames("classpath:/message/validation");
        messageSource.setDefaultEncoding("UTF-8");
        messageSource.setCacheSeconds(10);
        messageSource.setDefaultLocale(Locale.getDefault());
        return messageSource;
    }

    @Override
    public Validator getValidator() {
        LocalValidatorFactoryBean lvfb = new LocalValidatorFactoryBean();
        lvfb.setValidationMessageSource(messageSource());
        return lvfb;
    }

}
