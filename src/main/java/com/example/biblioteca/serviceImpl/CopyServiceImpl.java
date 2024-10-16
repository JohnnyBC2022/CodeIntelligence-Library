package com.example.biblioteca.serviceImpl;

import com.example.biblioteca.models.CopyModel;
import com.example.biblioteca.repository.CopyRepository;
import com.example.biblioteca.services.CopyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CopyServiceImpl implements CopyService {
    @Autowired
    CopyRepository copyRepo;

    @Override
    public CopyModel saveCopy(CopyModel copy) {
        CopyModel result = new CopyModel();
        try{
            result = copyRepo.save(copy);
        } catch (Exception e) {
            System.out.println("[saveCopy] exception: " + e.getMessage());
        }

        return result;
    }

    @Override
    public CopyModel getCopyById(Integer id) {
        CopyModel result = new CopyModel();

        try {
            result = copyRepo.findById(id).get();
        } catch (Exception e) {
            System.out.println("[getCopyById] exception: " + e.getMessage());
        }

        return result;
    }

    @Override
    public List<CopyModel> getAllCopies() {
        List<CopyModel> copies = null;

        try {
            copies = copyRepo.findAll();
        } catch (Exception e){
            System.out.println("[getAllCopies] exception: " + e.getMessage());
        }

        return copies;
    }

    @Override
    public void deleteCopyById(Integer id) {
        try {
            copyRepo.deleteById(id);
        } catch (Exception e){
            System.out.println("[deleteCopyById] exception: " + e.getMessage());
        }
    }
}
