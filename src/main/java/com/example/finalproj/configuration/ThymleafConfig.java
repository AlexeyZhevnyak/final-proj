package com.example.finalproj.configuration;

import org.springframework.context.annotation.Bean;
import org.thymeleaf.extras.springsecurity5.dialect.SpringSecurityDialect;
import org.thymeleaf.spring5.SpringTemplateEngine;

public class ThymleafConfig extends SpringTemplateEngine {
    @Bean
    public SpringTemplateEngine templateEngine() {
        SpringTemplateEngine templateEngine = new SpringTemplateEngine();
        templateEngine.addDialect(new SpringSecurityDialect());
        return templateEngine;
    }
}
