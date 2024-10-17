package com.example.biblioteca.models;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "COPY")
public class CopyModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer idCopy;

    // Relación ManyToOne con BookModel
    @ManyToOne
    @JoinColumn(name = "id_book", nullable = false)  // nullable por si quieres que sea requerido
    private BookModel book;

    // Relación OneToMany con LoanModel, mappedBy debe referirse a la propiedad 'copy' en LoanModel
    @OneToMany(mappedBy = "copy", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<LoanModel> loans;

    public Integer getIdCopy() {
        return idCopy;
    }

    public void setIdCopy(Integer idCopy) {
        this.idCopy = idCopy;
    }

    public BookModel getBook() {
        return book;
    }

    public void setBook(BookModel book) {
        this.book = book;
    }

    public List<LoanModel> getLoans() {
        return loans;
    }

    public void setLoans(List<LoanModel> loans) {
        this.loans = loans;
    }

    public CopyModel() {
    }

    public CopyModel(Integer idCopy, BookModel book, List<LoanModel> loans) {
        this.idCopy = idCopy;
        this.book = book;
        this.loans = loans;
    }
}
