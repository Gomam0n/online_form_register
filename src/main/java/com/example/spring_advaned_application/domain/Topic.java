package com.example.spring_advaned_application.domain;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;
@Entity
public class Topic {
    @Id
    @GeneratedValue
    private Long id;

    private String name;
    @ManyToMany(fetch = FetchType.EAGER)
    //@JoinTable(
    //        name = "t_topic_article",
    //        joinColumns = @JoinColumn(name = "topic_id", referencedColumnName = "id"),
    //        inverseJoinColumns = @JoinColumn(name = "article_id")
    //)
    private List<Article> articles = new ArrayList<>();
    public Topic(){

    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Article> getArticles() {
        return articles;
    }

    public void setArticles(List<Article> articles) {
        this.articles = articles;
    }
}
