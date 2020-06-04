package com.example.validation;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import static org.assertj.core.api.Assertions.assertThat;


class ValidationApplicationTests {

    @Test
    @DisplayName("Context loads fine.")
    void contextLoads() {
        assertThat(true).isTrue();
    }
}
