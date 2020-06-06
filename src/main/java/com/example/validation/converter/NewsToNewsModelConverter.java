package com.example.validation.converter;

import com.example.validation.domain.entity.News;
import com.example.validation.model.AuthorModel;
import com.example.validation.model.NewsModel;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
public class NewsToNewsModelConverter implements Converter<News, NewsModel> {
    @Override
    public NewsModel convert(News source) {
        return NewsModel.builder()
                .title(source.getTitle())
                .text(source.getText())
                .author(source.getAuthors().stream()
                        .map(author -> AuthorModel.builder()
                                .email(author.getEmail())
                                .name(author.getName())
                                .build())
                        .collect(Collectors.toList()))
                .build();
    }
}
