package com.example.spring_advaned_application.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Comment {

    @Id
    @GeneratedValue
    private Long id;
    private String content;
    @ManyToOne
    private Article article;

    public void clearComment(){
        this.getArticle().getComments().remove(this);
    }
    public Comment(){

    }
    public Comment(String content){
        this.content = content;
    }
    public Long getId(){
        return id;
    }
    public void setId(Long id){
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public Article getArticle() {
        return article;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setArticle(Article article) {
        this.article = article;
    }
}
