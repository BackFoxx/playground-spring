package com.example.playground.repository;

import com.example.playground.exception.CustomCuteException;
import org.springframework.stereotype.Repository;

//@Component
@Repository
public class PlayRepository {
    public void findSomething() {
        throw new CustomCuteException();
    }
}
