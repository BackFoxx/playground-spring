package com.example.playground.exception;

import org.springframework.dao.DataAccessException;

public class CustomTranslatedException extends DataAccessException {

    public CustomTranslatedException(String msg) {
        super(msg);
    }
}
