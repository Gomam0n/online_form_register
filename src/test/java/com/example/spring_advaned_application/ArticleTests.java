package com.example.spring_advaned_application;

import com.example.spring_advaned_application.domain.Article;
import com.example.spring_advaned_application.domain.Comment;
import com.example.spring_advaned_application.service.ArticleService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
public class ArticleTests {
    @Autowired
    private ArticleService articleService;
    @Test
    public void saveArticle(){
        Article article = new Article();
        article.setTitle("start-up");
        article.setContent("some thoughts");

        Comment comment1 = new Comment("one");             // important
        Comment comment2 = new Comment("two");


        article.addComment(comment1);
        article.addComment(comment2);
        articleService.saveArticle(article);
    }

    @Test
    public void updateArticle(){
        Article article = articleService.findArticle(3L);
    }

    @Test
    public void findArticle(){
        Article article = articleService.findArticle(3L);

    }

    public void deleteArticle(){
        articleService.deleteArticle(3L);
    }

}
