package com.example.spring_advaned_application.service;

import com.example.spring_advaned_application.domain.Article;

public interface ArticleService {
    Article saveArticle(Article article);
    Article updateArticle(Article article);

    Article findArticle(Long id);

    void deleteArticle(Long id);
}
