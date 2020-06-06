package com.example.validation.controller.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Collections;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CreateNewsDto {
    @NotBlank
    String title;
    @NotBlank
    String text;
    @Builder.Default
    @JsonProperty("authors")
    List<@NotNull AuthorInfoDto> authorInfoDto = Collections.emptyList();
}
