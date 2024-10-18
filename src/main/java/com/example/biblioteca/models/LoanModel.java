package com.example.biblioteca.models;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "LOANS")
public class LoanModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer idLoan;

    @ManyToOne
    @JoinColumn(name = "id_copy", nullable = false)
    private CopyModel copy;

    @ManyToOne
    @JoinColumn(name = "id_member", nullable = false)
    private MemberModel member;

    private LocalDate loanDate;

    private LocalDate returnDate;

    public Integer getIdLoan() {
        return idLoan;
    }

    public void setIdLoan(Integer idLoan) {
        this.idLoan = idLoan;
    }

    public CopyModel getCopy() {
        return copy;
    }

    public void setCopy(CopyModel copy) {
        this.copy = copy;
    }

    public MemberModel getMember() {
        return member;
    }

    public void setMember(MemberModel member) {
        this.member = member;
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

    public LoanModel(Integer idLoan, CopyModel copy, MemberModel member, LocalDate loanDate, LocalDate returnDate) {
        this.idLoan = idLoan;
        this.copy = copy;
        this.member = member;
        this.loanDate = loanDate;
        this.returnDate = returnDate;
    }
}
