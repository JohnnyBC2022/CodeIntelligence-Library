package com.example.biblioteca.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "BOOK")
public class BookModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer idBook;

    private String title;

    private Integer publicationYear;

    private Integer idLanguage;


    public Integer getIdBook() {
        return idBook;
    }

    public void setIdBook(Integer idBook) {
        this.idBook = idBook;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getPublicationYear() {
        return publicationYear;
    }

    public void setPublicationYear(Integer publicationYear) {
        this.publicationYear = publicationYear;
    }

    public Integer getIdLanguage() {
        return idLanguage;
    }

    public void setIdLanguage(Integer idLanguage) {
        this.idLanguage = idLanguage;
    }

    public BookModel() {
    }

    public BookModel(Integer idBook, String title, Integer publicationYear, Integer idLanguage) {
        this.idBook = idBook;
        this.title = title;
        this.publicationYear = publicationYear;
        this.idLanguage = idLanguage;
    }
}
