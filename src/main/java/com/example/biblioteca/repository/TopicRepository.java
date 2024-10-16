package com.example.biblioteca.repository;

import com.example.biblioteca.models.TopicModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TopicRepository extends JpaRepository<TopicModel, Integer> {

}
