package com.example.validation.controller.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Singular;
import lombok.Value;

import java.util.List;

@Value
@Builder
public class ListNewsDto {
    @Singular
    @JsonProperty("news")
    List<NewsDto> newsDtos;
}
