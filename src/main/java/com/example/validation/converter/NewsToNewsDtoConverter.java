package com.example.validation.converter;

import com.example.validation.controller.dto.AuthorInfoDto;
import com.example.validation.controller.dto.NewsDto;
import com.example.validation.domain.entity.News;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
public class NewsToNewsDtoConverter implements Converter<News, NewsDto> {
    @Override
    public NewsDto convert(News source) {
        return NewsDto.builder()
                .id(source.getId())
                .text(source.getText())
                .title(source.getTitle())
                .authorInfoDtos(source.getAuthors().stream()
                        .map(author -> AuthorInfoDto.builder()
                                .email(author.getEmail())
                                .name(author.getName())
                                .build())
                        .collect(Collectors.toList()))
                .build();
    }
}
