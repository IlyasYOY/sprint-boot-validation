package com.example.validation.repository;

import com.example.validation.model.NewsModel;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface NewsRepository extends MongoRepository<NewsModel, String> {
}
