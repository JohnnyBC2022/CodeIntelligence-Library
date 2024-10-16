package com.example.biblioteca.serviceImpl;

import com.example.biblioteca.models.TopicModel;
import com.example.biblioteca.repository.TopicRepository;
import com.example.biblioteca.services.TopicService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class TopicServiceImpl implements TopicService {
    @Autowired
    TopicRepository topicRepo;

    @Override
    public TopicModel saveTopic(TopicModel topic) {
        TopicModel result = new TopicModel();

        try {
            result = topicRepo.save(topic);
        } catch (Exception e) {
            System.out.println("[saveTopic] exception: " + e.getMessage());
        }

        return result;
    }

    @Override
    public TopicModel getTopicById(Integer id) {
        TopicModel result = new TopicModel();

        try {
            result = topicRepo.findById(id).get();
        } catch (Exception e) {
            System.out.println("[getTopicById] exception: " + e.getMessage());
        }

        return result;
    }

    @Override
    public List<TopicModel> getAllTopics() {
        List<TopicModel> topics = null;

        try {
            topics = topicRepo.findAll();
        } catch (Exception e) {
            System.out.println("[getAllTopics] exception: " + e.getMessage());
        }

        return topics;
    }

    @Override
    public void deleteTopicById(Integer id) {
        try {
            topicRepo.deleteById(id);
        } catch (Exception e) {
            System.out.println("[deleteTopicById] exception: " + e.getMessage());
        }
    }
}
