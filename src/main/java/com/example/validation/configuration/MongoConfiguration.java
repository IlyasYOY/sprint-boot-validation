package com.example.validation.configuration;

import com.example.validation.repository.MongoRepositoriesMark;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@EnableMongoRepositories(basePackageClasses = MongoRepositoriesMark.class)
public class MongoConfiguration {
}
