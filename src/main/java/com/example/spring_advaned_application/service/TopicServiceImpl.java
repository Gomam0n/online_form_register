package com.example.spring_advaned_application.service;

import com.example.spring_advaned_application.domain.Article;
import com.example.spring_advaned_application.domain.ArticleRepository;
import com.example.spring_advaned_application.domain.Topic;
import com.example.spring_advaned_application.domain.TopicRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class TopicServiceImpl implements TopicService{
    @Autowired
    private TopicRepository topicRepository;
    @Autowired
    private ArticleRepository articleRepository;

    @Transactional
    @Override
    public Topic saveTopic(Topic topic) {
        return topicRepository.save(topic);
    }
    @Transactional
    @Override
    public Topic findTopic(Long id) {
        return topicRepository.findById(id).get();
    }
    @Transactional
    @Override
    public Topic updateTopic(Topic topic) {
        return topicRepository.save(topic);
    }
    @Transactional
    @Override
    public Topic includeArticle(Long topicId, Long articleId) {
        Topic topic = topicRepository.findById(topicId).get();
        Article article = articleRepository.findById(articleId).get();
        topic.getArticles().add(article);

        return topicRepository.save(topic);
    }
    @Transactional
    @Override
    public Topic unIncludeArticle(Long topicId, Long articleId) {
        Topic topic = topicRepository.findById(topicId).get();
        Article article = articleRepository.findById(articleId).get();
        topic.getArticles().remove(article);

        return topicRepository.save(topic);
    }
    @Transactional
    @Override
    public void deleteTopic(Long id) {
        topicRepository.deleteById(id);
    }
}
