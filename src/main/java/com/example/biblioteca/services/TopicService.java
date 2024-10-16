package com.example.biblioteca.services;

import com.example.biblioteca.models.TopicModel;

import java.util.List;

public interface TopicService {

    public TopicModel saveTopic (TopicModel topic);

    public TopicModel getTopicById (Integer id);

    public List<TopicModel> getAllTopics();

    public void deleteTopicById(Integer id);

    public TopicModel updateTopic(Integer id, TopicModel topicToUpdate);
}
