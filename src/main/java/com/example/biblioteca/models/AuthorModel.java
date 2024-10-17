package com.example.biblioteca.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "AUTHOR")
public class AuthorModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer idAuthor;

    private String authorName;

    @ManyToMany(mappedBy = "authors", fetch = FetchType.LAZY)
    @JsonIgnore
    private List<BookModel> books;


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
