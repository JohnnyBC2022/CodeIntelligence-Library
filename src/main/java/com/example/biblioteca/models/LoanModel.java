package com.example.biblioteca.models;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "LOANS")
public class LoanModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer idLoan;

    private Integer idBook;

    private Integer idCopy;

    private Integer idMember;

    private LocalDate loanDate;

    private LocalDate returnDate;

    public Integer getIdLoan() {
        return idLoan;
    }

    public void setIdLoan(Integer idLoan) {
        this.idLoan = idLoan;
    }

    public Integer getIdBook() {
        return idBook;
    }

    public void setIdBook(Integer idBook) {
        this.idBook = idBook;
    }

    public Integer getIdCopy() {
        return idCopy;
    }

    public void setIdCopy(Integer idCopy) {
        this.idCopy = idCopy;
    }

    public Integer getIdMember() {
        return idMember;
    }

    public void setIdMember(Integer idMember) {
        this.idMember = idMember;
    }

    public LocalDate getLoanDate() {
        return loanDate;
    }

    public void setLoanDate(LocalDate loanDate) {
        this.loanDate = loanDate;
    }

    public LocalDate getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(LocalDate returnDate) {
        this.returnDate = returnDate;
    }

    public LoanModel() {
    }

    public LoanModel(Integer idLoan, Integer idBook, Integer idCopy, Integer idMember, LocalDate loanDate, LocalDate returnDate) {
        this.idLoan = idLoan;
        this.idBook = idBook;
        this.idCopy = idCopy;
        this.idMember = idMember;
        this.loanDate = loanDate;
        this.returnDate = returnDate;
    }
}
