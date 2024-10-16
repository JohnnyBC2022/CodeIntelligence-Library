package com.example.biblioteca.models;

import jakarta.persistence.*;

@Entity
@Table(name = "COPY")
public class CopyModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer idCopy;

    private Integer idBook;

    public Integer getIdCopy() {
        return idCopy;
    }

    public void setIdCopy(Integer idCopy) {
        this.idCopy = idCopy;
    }

    public Integer getIdBook() {
        return idBook;
    }

    public void setIdBook(Integer idBook) {
        this.idBook = idBook;
    }

    public CopyModel() {
    }

    public CopyModel(Integer idCopy, Integer idBook) {
        this.idCopy = idCopy;
        this.idBook = idBook;
    }
}
