package com.example.validation.service;

import com.example.validation.controller.dto.CreateNewsDto;
import com.example.validation.domain.entity.News;

import java.util.List;
import java.util.Optional;

public interface NewsService {
    Optional<News> findById(String id);

    List<News> findAll();

    News save(CreateNewsDto createNewsDto);

    Optional<News> delete(String id);
}
