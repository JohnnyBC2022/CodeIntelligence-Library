package com.example.biblioteca.controllers;

import com.example.biblioteca.models.LoanModel;
import com.example.biblioteca.services.LoanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/loans")
public class LoanController {

    @Autowired
    LoanService loanService;

    @PostMapping(value = "/save")
    public LoanModel saveLoan(@RequestBody LoanModel loan) {
        LoanModel result = new LoanModel();

        result = loanService.saveLoan(loan);

        return result;
    }

    @GetMapping(value = "/get/{id}")
    public LoanModel getLoanById(@PathVariable(value = "id") Integer id) {
        LoanModel result = new LoanModel();

        result = loanService.getLoanById(id);

        return result;
    }

    @GetMapping
    public List<LoanModel> getAllLoans() {
        return loanService.getAllLoans();
    }

    @DeleteMapping(value = "/delete/{id}")
    public ResponseEntity<Void> deleteLoanById(@PathVariable(value = "id") Integer id) {
        loanService.deleteLoanById(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping(value = "/update/{id}")
    public LoanModel updateLoan(@PathVariable(value = "id") Integer id, @RequestBody LoanModel loanToUpdate) {
        return loanService.updateLoan(id, loanToUpdate);
    }
}
