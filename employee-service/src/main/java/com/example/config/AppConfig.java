package com.example.config;

import org.dozer.DozerBeanMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    DozerBeanMapper dozerBeanMapper() {
        return new DozerBeanMapper();
    }
}
