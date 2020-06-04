package com.example.validation.controller.dto;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class AuthorInfoDto {
    String name;
    String email;
}
