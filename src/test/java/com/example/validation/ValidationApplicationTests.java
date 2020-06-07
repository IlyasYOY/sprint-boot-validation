package com.example.validation;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.http.MediaType;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


class ValidationApplicationTests extends BaseTest {

    @Test
    @DisplayName("Context loads fine.")
    void contextLoads() {
        assertThat(true).isTrue();
    }

    @Test
    @DisplayName("Test news creation without authors")
    void createWithoutAuthor() throws Exception {
        String file = loadFile("create_news_without_author.json");
        mockMvc.perform(post("/news")
                .contentType(MediaType.APPLICATION_JSON)
                .content(file)
        ).andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    @DisplayName("Test news creation with authors")
    void createWithAuthor() throws Exception {
        String file = loadFile("create_news_with_author.json");
        mockMvc.perform(post("/news")
                .contentType(MediaType.APPLICATION_JSON)
                .content(file)
        ).andDo(print())
                .andExpect(status().isOk());
    }
}
