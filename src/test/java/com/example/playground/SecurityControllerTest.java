package com.example.playground;

import io.restassured.RestAssured;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class SecurityControllerTest {

    @LocalServerPort
    private int port;

    @BeforeEach
    void beforeEach() {
        RestAssured.port = port;
    }

    @Test
    @DisplayName("preemptive()가 없는 요청. 요청과 응딥이 두 번 이루어진다.")
    void notPreemptive() {
        RestAssured
                .given()
                .auth().basic("user", "password")
                .when().log().headers()
                .get("/security")
                .then().log().all()
                .assertThat().statusCode(200);
    }

    @Test
    @DisplayName("preemptive()가 적용된 요청. 요청과 응답이 한 번만 이루어진다.")
    void preemptive() {
        RestAssured
                .given()
                .auth().preemptive().basic("user", "password")
                .when().log().headers()
                .get("/security")
                .then().log().all()
                .assertThat().statusCode(200);
    }
}