package com.example.validation.service;

import com.example.validation.controller.dto.CreateNewsDto;
import com.example.validation.domain.entity.News;
import com.example.validation.model.NewsModel;
import com.example.validation.repository.NewsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CrudNewsService implements NewsService {
    private final NewsRepository newsRepository;
    private final ConversionService conversionService;

    @Override
    public Optional<News> findById(String id) {
        return newsRepository.findById(id)
                .map(this::convertNewsModel);
    }

    @Override
    public List<News> findAll() {
        return newsRepository.findAll()
                .stream()
                .map(this::convertNewsModel)
                .collect(Collectors.toList());
    }

    @Override
    public News save(CreateNewsDto createNewsDto) {
        NewsModel newsModel = conversionService.convert(createNewsDto, NewsModel.class);
        NewsModel savedModel = newsRepository.save(newsModel);
        return convertNewsModel(savedModel);
    }

    @Override
    public Optional<News> delete(String id) {
        Optional<News> news = newsRepository.findById(id).map(this::convertNewsModel);
        news.ifPresent(newsModel -> newsRepository.deleteById(newsModel.getId()));
        return news;
    }

    private News convertNewsModel(NewsModel newsModel) {
        return conversionService.convert(newsModel, News.class);
    }
}
