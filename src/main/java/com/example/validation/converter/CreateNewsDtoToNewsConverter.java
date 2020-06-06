package com.example.validation.converter;

import com.example.validation.controller.dto.CreateNewsDto;
import com.example.validation.domain.entity.News;
import com.example.validation.domain.value.Author;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
public class CreateNewsDtoToNewsConverter implements Converter<CreateNewsDto, News> {
    @Override
    public News convert(CreateNewsDto source) {
        return News.builder()
                .title(source.getTitle())
                .text(source.getText())
                .authors(source.getAuthorInfoDto().stream()
                        .map(authorInfoDto -> Author.builder()
                                .name(authorInfoDto.getName())
                                .email(authorInfoDto.getEmail())
                                .build())
                        .collect(Collectors.toList()))
                .build();
    }
}
