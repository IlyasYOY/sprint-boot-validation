package com.example.validation.service.domain;

import com.example.validation.configuration.properties.DefaultsProperties;
import com.example.validation.domain.service.AuthorDefaults;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
@RequiredArgsConstructor
public class PropertiesAuthorDefaults implements AuthorDefaults {
    private final DefaultsProperties defaultsProperties;

    private DefaultsProperties.Author author;

    @PostConstruct
    public void init() {
        author = defaultsProperties.getAuthor();
    }

    @Override
    public String getName() {
        return author.getName();
    }

    @Override
    public String getEmail() {
        return author.getEmail();
    }
}
