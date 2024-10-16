package com.example.biblioteca.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.biblioteca.models.BookModel;

@Repository
public interface BookRepository extends JpaRepository<BookModel, Integer> {

}
