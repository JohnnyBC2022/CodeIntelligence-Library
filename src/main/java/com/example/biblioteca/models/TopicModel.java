package com.example.biblioteca.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name="topic")
public class TopicModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer idTopic;

    private String topicDescription;

    @ManyToMany
    @JsonIgnore
    private List<BookModel> books;

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

    public List<BookModel> getBooks() {
        return books;
    }

    public void setBooks(List<BookModel> books) {
        this.books = books;
    }

    public TopicModel() {
    }

    public TopicModel(Integer idTopic, String topicDescription) {
        this.idTopic = idTopic;
        this.topicDescription = topicDescription;
    }
}
