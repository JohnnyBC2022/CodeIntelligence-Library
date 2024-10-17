package com.example.biblioteca.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "BOOK")
public class BookModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer idBook;

    private String title;

    private Integer publicationYear;

    private Integer idLanguage;

    @ManyToMany(targetEntity = AuthorModel.class, fetch = FetchType.LAZY)
    @JoinTable(name = "author_book", joinColumns = @JoinColumn(name = "id_book"), inverseJoinColumns = @JoinColumn(name = "id_author"))
    @JsonIgnore
    private List<AuthorModel> authors;

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
