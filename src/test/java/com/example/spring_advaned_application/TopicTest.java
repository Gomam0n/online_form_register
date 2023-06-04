package com.example.spring_advaned_application;

import com.example.spring_advaned_application.domain.Topic;
import com.example.spring_advaned_application.service.TopicService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class TopicTest {
    @Autowired
    private TopicService topicService;
    @Test
    public void saveTopic(){
        Topic topic = new Topic();
        topic.setName("art");
        topicService.saveTopic(topic);
    }
    @Test
    public void updateTopic(){
        Topic topic = topicService.findTopic(1L);
        topic.setName("lib");
        topicService.saveTopic(topic);
    }

    @Test
    public void includeArticle(){
        topicService.includeArticle(1L, 1L);
    }

    @Test
    public void findTopic(){
        Topic topic = topicService.findTopic(1L);

    }
    @Test
    public void unIncludeArticle(){
        topicService.unIncludeArticle(1L, 1L);
    }
    @Test
    public void deleteTopic(){
        topicService.deleteTopic(1L);
    }
}
