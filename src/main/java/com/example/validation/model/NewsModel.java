package com.example.validation.model;

import lombok.Builder;
import lombok.Value;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Value
@Builder
@Document(collection = NewsModel.NEWS_COLLECTION_NAME)
public class NewsModel {
    public static final String NEWS_COLLECTION_NAME = "news";

    @Id
    String id;
    String title;
    String text;

    List<AuthorModel> author;
}
