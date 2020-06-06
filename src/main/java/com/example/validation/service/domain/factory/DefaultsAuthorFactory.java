package com.example.validation.service.domain.factory;

import com.example.validation.domain.service.AuthorDefaults;
import com.example.validation.domain.service.factory.AuthorFactory;
import com.example.validation.domain.value.Author;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class DefaultsAuthorFactory implements AuthorFactory<AuthorDefaults> {
    @Override
    public Author provide(AuthorDefaults authorDefaults) {
        return Author.builder()
                .name(authorDefaults.getName())
                .email(authorDefaults.getEmail())
                .build();
    }
}
