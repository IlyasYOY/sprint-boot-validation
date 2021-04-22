package com.example.validation;

import com.example.validation.repository.NewsRepository;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

@Slf4j
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ActiveProfiles("test")
@AutoConfigureMockMvc
public class BaseTest {
    @Autowired
    private NewsRepository newsRepository;

    @Autowired
    protected MockMvc mockMvc;

    @Autowired
    protected ResourceLoader resourceLoader;

    @BeforeEach
    void setUpEach() {
        newsRepository.deleteAll();
    }

    protected String loadFile(String filename) throws IOException {
        String location = String.format("classpath:files/%s", filename);
        log.info("Reading file from location: {}", location);
        Resource resource = resourceLoader.getResource(location);
        Path path = resource
                .getFile()
                .toPath();
        log.info("Path to resource was resolved: {}", path);
        String string = Files.readString(path);
        log.info("File content was read: {}", string);
        return string;
    }
}
