package com.example.validation.domain.entity;

import com.example.validation.domain.value.Author;
import lombok.Builder;
import lombok.Value;

import java.util.List;

@Value
@Builder
public class News {
    String id;
    String title;
    String text;
    List<Author> authors;
}
