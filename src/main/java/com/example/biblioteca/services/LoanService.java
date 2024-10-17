package com.example.biblioteca.services;

import com.example.biblioteca.models.LoanModel;

import java.util.List;

public interface LoanService {
    public LoanModel saveLoan(LoanModel loan);

    public LoanModel getLoanById(Integer id);

    public List<LoanModel> getAllLoans();

    public void deleteLoanById(Integer id);

    public LoanModel updateLoan(Integer id, LoanModel loanToUpdate);
}
