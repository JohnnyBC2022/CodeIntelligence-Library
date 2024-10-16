package com.example.biblioteca.models;

import jakarta.persistence.*;

@Entity
@Table
public class TopicModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer idTopic;

    private String topicDescription;

    public Integer getIdTopic() {
        return idTopic;
    }

    public void setIdTopic(Integer idTopic) {
        this.idTopic = idTopic;
    }

    public String getTopicDescription() {
        return topicDescription;
    }

    public void setTopicDescription(String topicDescription) {
        this.topicDescription = topicDescription;
    }

    public TopicModel() {
    }

    public TopicModel(Integer idTopic, String topicDescription) {
        this.idTopic = idTopic;
        this.topicDescription = topicDescription;
    }
}
