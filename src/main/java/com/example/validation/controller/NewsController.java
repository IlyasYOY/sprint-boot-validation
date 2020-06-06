package com.example.validation.controller;

import com.example.validation.controller.dto.CreateNewsDto;
import com.example.validation.controller.dto.ListNewsDto;
import com.example.validation.controller.dto.NewsDto;
import com.example.validation.domain.entity.News;
import com.example.validation.service.NewsService;
import lombok.RequiredArgsConstructor;
import org.springframework.core.convert.ConversionService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
@RequestMapping(NewsController.ROOT_URL)
public class NewsController {
    public static final String ROOT_URL = "/news";
    public static final String ID = "/{id}";

    private final NewsService newsService;
    private final ConversionService conversionService;

    @GetMapping(ID)
    public ResponseEntity<NewsDto> findById(@PathVariable String id) {
        Optional<NewsDto> newsDto = newsService.findById(id)
                .map(this::convertNews);

        return ResponseEntity.of(newsDto);

    }

    @DeleteMapping(ID)
    public ResponseEntity<NewsDto> delete(@PathVariable String id) {
        Optional<NewsDto> newsDto = newsService.delete(id)
                .map(this::convertNews);

        return ResponseEntity.of(newsDto);
    }

    @GetMapping
    public ResponseEntity<ListNewsDto> findAll() {
        List<NewsDto> newsDtos = newsService.findAll().stream()
                .map(this::convertNews)
                .collect(Collectors.toList());

        return ResponseEntity.ok(ListNewsDto.builder()
                .newsDtos(newsDtos)
                .build());
    }

    @PostMapping
    public ResponseEntity<NewsDto> save(@Valid @RequestBody CreateNewsDto createNewsDto) {
        News news = newsService.save(createNewsDto);
        NewsDto newsDto = convertNews(news);

        return ResponseEntity.ok(newsDto);
    }

    private NewsDto convertNews(News news) {
        return conversionService.convert(news, NewsDto.class);
    }
}
