package com.example.validation.configuration;

import com.example.validation.repository.MongoRepositoriesMark;
import org.springframework.data.mongodb.config.EnableMongoAuditing;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@EnableMongoAuditing
@EnableMongoRepositories(basePackageClasses = MongoRepositoriesMark.class)
public class MongoConfiguration {
}
