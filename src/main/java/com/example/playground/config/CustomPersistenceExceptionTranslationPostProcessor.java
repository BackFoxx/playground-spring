package com.example.playground.config;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.ListableBeanFactory;
import org.springframework.dao.annotation.PersistenceExceptionTranslationAdvisor;
import org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor;
import org.springframework.stereotype.Repository;
import org.springframework.util.Assert;

import java.lang.annotation.Annotation;

public class CustomPersistenceExceptionTranslationPostProcessor extends PersistenceExceptionTranslationPostProcessor {

    private Class<? extends Annotation> repositoryAnnotationType = Repository.class;

    public CustomPersistenceExceptionTranslationPostProcessor(PersistenceExceptionTranslationAdvisor advisor) {
        this.advisor = advisor;
    }

    public void setRepositoryAnnotationType(Class<? extends Annotation> repositoryAnnotationType) {
        Assert.notNull(repositoryAnnotationType, "'repositoryAnnotationType' must not be null");
        this.repositoryAnnotationType = repositoryAnnotationType;
    }

    @Override
    public void setBeanFactory(BeanFactory beanFactory) {
        super.setBeanFactory(beanFactory);

        if (!(beanFactory instanceof ListableBeanFactory)) {
            throw new IllegalArgumentException(
                    "Cannot use PersistenceExceptionTranslator autodetection without ListableBeanFactory");
        }
    }
}
