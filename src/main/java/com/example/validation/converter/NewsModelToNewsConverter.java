package com.example.validation.converter;

import com.example.validation.domain.entity.News;
import com.example.validation.domain.value.Author;
import com.example.validation.model.NewsModel;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
public class NewsModelToNewsConverter implements Converter<NewsModel, News> {
    @Override
    public News convert(NewsModel source) {
        return News.builder()
                .id(source.getId())
                .text(source.getText())
                .title(source.getTitle())
                .authors(source.getAuthor().stream()
                        .map(authorModel -> Author.builder()
                                .email(authorModel.getEmail())
                                .name(authorModel.getName())
                                .build())
                        .collect(Collectors.toList()))
                .build();
    }
}
