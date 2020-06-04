package com.example.validation;

import com.example.validation.repository.NewsRepository;
import org.junit.jupiter.api.BeforeEach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest
@ActiveProfiles("test")
@AutoConfigureMockMvc
public class BaseTest {
    @Autowired
    private NewsRepository newsRepository;

    @Autowired
    protected MockMvc mockMvc;

    @BeforeEach
    void setUpEach() {
        newsRepository.deleteAll();
    }
}
