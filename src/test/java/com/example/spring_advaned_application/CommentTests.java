package com.example.spring_advaned_application;

import com.example.spring_advaned_application.domain.Article;
import com.example.spring_advaned_application.domain.Comment;
import com.example.spring_advaned_application.service.ArticleService;
import com.example.spring_advaned_application.service.CommentService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class CommentTests {
    @Autowired
    private CommentService commentService;

    @Autowired
    private ArticleService articleService;

    @Test
    public void saveCommentTest(){
        Article article = articleService.findArticle(1L);

        Comment comment = new Comment();
        comment.setContent("about");
        comment.setArticle(article);

        commentService.saveComment(comment);
    }

    @Test
    public void deleteCommentTest(){
        commentService.deleteComment(2L);
    }
}
