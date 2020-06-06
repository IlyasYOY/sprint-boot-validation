package com.example.validation.domain.entity;

import com.example.validation.domain.service.AuthorDefaults;
import com.example.validation.domain.service.factory.AuthorFactory;
import com.example.validation.domain.value.Author;
import lombok.Builder;
import lombok.Value;
import lombok.With;

import java.util.Collections;
import java.util.List;

@With
@Value
@Builder
public class News {
    String id;
    String title;
    String text;
    List<Author> authors;

    public News applyDefaults(AuthorDefaults authorDefaults, AuthorFactory<AuthorDefaults> authorFactory) {
        if (!authors.isEmpty()) {
            return this;
        }

        Author author = authorFactory.provide(authorDefaults);
        List<Author> authorList = Collections.singletonList(author);

        return this.withAuthors(authorList);
    }
}
