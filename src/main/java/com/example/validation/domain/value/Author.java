package com.example.validation.domain.value;

import lombok.Builder;
import lombok.Value;
import lombok.With;

@With
@Value
@Builder
public class Author {
    String name;
    String email;
}
