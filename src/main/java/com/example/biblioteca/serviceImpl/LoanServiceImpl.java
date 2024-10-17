package com.example.biblioteca.serviceImpl;

import com.example.biblioteca.models.LoanModel;
import com.example.biblioteca.repository.LoanRepository;
import com.example.biblioteca.services.LoanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LoanServiceImpl implements LoanService {

    @Autowired
    LoanRepository loanRepo;

    @Override
    public LoanModel saveLoan(LoanModel loan) {
        LoanModel result = new LoanModel();

        try{
            result = loanRepo.save(loan);
        } catch (Exception e) {
            System.out.println("[saveLoan] exception: " + e.getMessage());
        }

        return result;
    }

    @Override
    public LoanModel getLoanById(Integer id) {
        LoanModel result = new LoanModel();

        try{
            result = loanRepo.findById(id).get();
        } catch (Exception e) {
            System.out.println("[getLoanById] exception: " + e.getMessage());
        }

        return result;
    }

    @Override
    public List<LoanModel> getAllLoans() {
        List<LoanModel> loans = null;

        try{
            loans = loanRepo.findAll();
        } catch (Exception e) {
            System.out.println("[getAllLoans] exception: " + e.getMessage());
        }

        return loans;
    }

    @Override
    public void deleteLoanById(Integer id) {
        try{
            loanRepo.deleteById(id);
        } catch (Exception e) {
            System.out.println("[deleteLoanById] exception: " + e.getMessage());
        }
    }

    @Override
    public LoanModel updateLoan(Integer id, LoanModel loanToUpdate) {
        LoanModel existingLoan = new LoanModel();

        try{
            existingLoan = loanRepo.findById(id).get();
            existingLoan.setIdCopy(loanToUpdate.getIdCopy());
            existingLoan.setIdBook(loanToUpdate.getIdBook());
            existingLoan.setIdMember(loanToUpdate.getIdMember());
            existingLoan.setLoanDate(loanToUpdate.getLoanDate());
            existingLoan.setReturnDate(loanToUpdate.getReturnDate());

            existingLoan = loanRepo.save(existingLoan);

        } catch (Exception e) {
            System.out.println("[updateLoan] exception: " + e.getMessage());
        }

        return existingLoan;
    }
}
