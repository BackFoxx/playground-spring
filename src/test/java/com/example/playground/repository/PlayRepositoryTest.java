package com.example.playground.repository;

import com.example.playground.exception.CustomCuteException;
import com.example.playground.exception.CustomTranslatedException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

@SpringBootTest
class PlayRepositoryTest {
    @Autowired
    private PlayRepository playRepository;

    @Test
    @DisplayName("@Repository가 적용되지 않은 리포지토리의 예외는 변환되지 않는다.")
    void noTranslate() {
        assertThatThrownBy(() -> playRepository.findSomething())
                .isInstanceOf(CustomCuteException.class);
    }

    @Test
    @DisplayName("@Component가 적용된 리포지토리의 예외는 변환되지 않는다.")
    void componentTranslate() {
        assertThatThrownBy(() -> playRepository.findSomething())
                .isInstanceOf(CustomCuteException.class);
    }

    @Test
    @DisplayName("@Repository가 적용된 예외는 변환한다.")
    void repositoryTranslate() {
        assertThatThrownBy(() -> playRepository.findSomething())
                .isInstanceOf(CustomTranslatedException.class);
    }
}