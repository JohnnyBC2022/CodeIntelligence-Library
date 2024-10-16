package com.example.biblioteca.models;

import jakarta.persistence.*;

@Entity
@Table(name = "AUTHOR")
public class AuthorModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer idAuthor;

    private String authorName;

    public Integer getIdAuthor() {
        return idAuthor;
    }

    public void setIdAuthor(Integer idAuthor) {
        this.idAuthor = idAuthor;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public AuthorModel() {
    }

    public AuthorModel(Integer idAuthor, String authorName) {
        this.idAuthor = idAuthor;
        this.authorName = authorName;
    }
}
