package com.example.biblioteca.models;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "COPY")
public class CopyModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer idCopy;

    @OneToMany(mappedBy = "copy")
    @JsonManagedReference("copy-books")
    private List<BookModel> books;

    public Integer getIdCopy() {
        return idCopy;
    }

    public void setIdCopy(Integer idCopy) {
        this.idCopy = idCopy;
    }

    public CopyModel(List<BookModel> books) {
        this.books = books;
    }



    public CopyModel() {
    }

    public CopyModel(Integer idCopy, List<BookModel> books) {
        this.idCopy = idCopy;
        this.books = books;
    }
}
