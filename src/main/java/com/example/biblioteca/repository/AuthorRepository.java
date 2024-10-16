package com.example.biblioteca.repository;

import com.example.biblioteca.models.AuthorModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRepository extends JpaRepository<AuthorModel, Integer> {

}
