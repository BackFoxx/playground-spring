package com.example.playground.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.dao.annotation.PersistenceExceptionTranslationAdvisor;
import org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor;
import org.springframework.dao.support.PersistenceExceptionTranslator;
import org.springframework.stereotype.Repository;

@Configuration
public class AppConfig {

    @Bean
    public PersistenceExceptionTranslationPostProcessor postProcessor() {
        return new CustomPersistenceExceptionTranslationPostProcessor(persistenceExceptionTranslationAdvisor());
    }

    @Bean
    PersistenceExceptionTranslationAdvisor persistenceExceptionTranslationAdvisor() {
        return new PersistenceExceptionTranslationAdvisor(persistenceExceptionTranslator(), Repository.class);
    }

    @Bean
    PersistenceExceptionTranslator persistenceExceptionTranslator() {
        return new CustomCuteExceptionTranslator();
    }
}
