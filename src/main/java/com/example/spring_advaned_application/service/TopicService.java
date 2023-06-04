package com.example.spring_advaned_application.service;

import com.example.spring_advaned_application.domain.Topic;

public interface TopicService {
    Topic saveTopic(Topic topic);
    Topic findTopic(Long id);

    Topic updateTopic(Topic topic);

    Topic includeArticle(Long topicId, Long articleId);

    Topic unIncludeArticle(Long topicId, Long articleId);

    void deleteTopic(Long id);
}
