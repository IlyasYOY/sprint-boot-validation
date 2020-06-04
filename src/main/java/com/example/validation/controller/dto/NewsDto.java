package com.example.validation.controller.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Value;

import java.util.List;

@Value
@Builder
public class NewsDto {
    String id;
    String title;
    String text;
    @JsonProperty("authors")
    List<AuthorInfoDto> authorInfoDtos;
}
