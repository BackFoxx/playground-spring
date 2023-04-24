package com.example.playground.config;

import com.example.playground.exception.CustomTranslatedException;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.support.PersistenceExceptionTranslator;
import org.springframework.stereotype.Component;

@Component
public class CustomCuteExceptionTranslator implements PersistenceExceptionTranslator {
    @Override
    public DataAccessException translateExceptionIfPossible(RuntimeException ex) {
        return new CustomTranslatedException("변환 완료된 예외");
    }
}
