package com.example.biblioteca.models;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "LANGUAGE")
public class LanguageModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer idLanguage;

    private String description;

    @OneToMany(mappedBy = "idLanguage")
    @JsonManagedReference("language-books")
    List<BookModel> books;

    public Integer getIdLanguage() {
        return idLanguage;
    }

    public void setIdLanguage(Integer idLanguage) {
        this.idLanguage = idLanguage;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<BookModel> getBooks() {
        return books;
    }

    public void setBooks(List<BookModel> books) {
        this.books = books;
    }

    public LanguageModel() {
    }

    public LanguageModel(Integer idLanguage, String description) {
        this.idLanguage = idLanguage;
        this.description = description;
    }
}
