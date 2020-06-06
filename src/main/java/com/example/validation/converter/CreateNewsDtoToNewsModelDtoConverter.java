package com.example.validation.converter;

import com.example.validation.controller.dto.CreateNewsDto;
import com.example.validation.model.AuthorModel;
import com.example.validation.model.NewsModel;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
public class CreateNewsDtoToNewsModelDtoConverter implements Converter<CreateNewsDto, NewsModel> {
    @Override
    public NewsModel convert(CreateNewsDto source) {
        return NewsModel.builder()
                .text(source.getText())
                .title(source.getTitle())
                .author(source.getAuthorInfoDto().stream()
                        .map(authorInfoDto -> AuthorModel.builder()
                                .email(authorInfoDto.getEmail())
                                .name(authorInfoDto.getName())
                                .build())
                        .collect(Collectors.toList()))
                .build();
    }
}
