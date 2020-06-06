package com.example.validation.domain.service.factory;

import com.example.validation.domain.value.Author;

public interface AuthorFactory<T> {
    Author provide(T source);
}
