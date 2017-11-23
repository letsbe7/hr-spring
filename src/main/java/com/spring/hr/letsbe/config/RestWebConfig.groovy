package com.spring.hr.letsbe.config

import org.springframework.context.annotation.Configuration
import org.springframework.web.servlet.config.annotation.CorsRegistry
import org.springframework.web.servlet.config.annotation.EnableWebMvc
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter

@Configuration
@EnableWebMvc
class RestWebConfig extends WebMvcConfigurerAdapter {

    @Override
    void addCorsMappings(CorsRegistry registry) {
        registry.addMapping('/**')
    }
}
