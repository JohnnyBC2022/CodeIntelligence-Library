package com.example.biblioteca.controllers;

import com.example.biblioteca.models.TopicModel;
import com.example.biblioteca.services.TopicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/topics")
public class TopicController {
    @Autowired
    TopicService topicService;

    @PostMapping(value = "/save")
    public TopicModel saveTopic(@RequestBody TopicModel topic) {
        TopicModel result = new TopicModel();

        result = topicService.saveTopic(topic);

        return result;
    }

    @GetMapping(value = "/get/{id}")
    public TopicModel getTopicById(@PathVariable(value = "id") Integer id) {
        TopicModel result = new TopicModel();

        result = topicService.getTopicById(id);

        return result;
    }

    @GetMapping
    public List<TopicModel> getAllTopics() {
        return topicService.getAllTopics();
    }

    @DeleteMapping(value = "/delete/{id}")
    public ResponseEntity<Void>
    deleteTopicById(@PathVariable(value = "id") Integer id) {
        topicService.deleteTopicById(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping(value = "/update/{id}")
    public TopicModel updateTopic(@PathVariable(value = "id") Integer id, @RequestBody TopicModel topicToUpdate) {
        return topicService.updateTopic(id, topicToUpdate);
    }

}
