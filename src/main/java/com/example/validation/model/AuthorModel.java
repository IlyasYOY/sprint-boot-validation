package com.example.validation.model;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class AuthorModel {
    String name;
    String email;
}
