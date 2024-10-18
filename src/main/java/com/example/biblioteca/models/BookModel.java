package com.example.biblioteca.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
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

    @ManyToOne
    @JoinColumn(name = "language_id")
    @JsonBackReference("language-books")
    private LanguageModel idLanguage;

    @ManyToMany(targetEntity = AuthorModel.class, fetch = FetchType.LAZY, cascade = { CascadeType.PERSIST, CascadeType.MERGE })
    @JoinTable(name = "author_book", joinColumns = @JoinColumn(name = "id_book"), inverseJoinColumns = @JoinColumn(name = "id_author"))
    private List<AuthorModel> authors;

    @ManyToOne
    @JoinColumn(name = "copy_id")
    @JsonBackReference("copy-books")
    private CopyModel copy;

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

    public LanguageModel getIdLanguage() {
        return idLanguage;
    }

    public void setIdLanguage(LanguageModel idLanguage) {
        this.idLanguage = idLanguage;
    }

    public List<AuthorModel> getAuthors() {
        return authors;
    }

    public void setAuthors(List<AuthorModel> authors) {
        this.authors = authors;
    }

    public CopyModel getCopy() {
        return copy;
    }

    public void setCopy(CopyModel copy) {
        this.copy = copy;
    }

    public BookModel() {
    }

    public BookModel(Integer idBook, String title, Integer publicationYear, LanguageModel idLanguage, List<AuthorModel> authors, CopyModel copy) {
        this.idBook = idBook;
        this.title = title;
        this.publicationYear = publicationYear;
        this.idLanguage = idLanguage;
        this.authors = authors;
        this.copy = copy;
    }
}
