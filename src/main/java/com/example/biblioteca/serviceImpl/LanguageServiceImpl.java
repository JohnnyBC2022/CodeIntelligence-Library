package com.example.biblioteca.serviceImpl;

import com.example.biblioteca.models.LanguageModel;
import com.example.biblioteca.repository.LanguageRepository;
import com.example.biblioteca.services.LanguageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LanguageServiceImpl implements LanguageService {
    @Autowired
    LanguageRepository languageRepo;

    @Override
    public LanguageModel saveLanguage(LanguageModel language) {
        LanguageModel result = new LanguageModel();

        try {
            result = languageRepo.save(language);
        } catch (Exception e) {
            System.out.println("[saveLanguage] exception: " + e.getMessage());
        }

        return result;
    }

    @Override
    public LanguageModel getLanguageById(Integer id) {
        LanguageModel result = new LanguageModel();

        try {
            result = languageRepo.findById(id).get();
        } catch (Exception e) {
            System.out.println("[getLanguageById] exception: " + e.getMessage());
        }

        return result;
    }

    @Override
    public List<LanguageModel> getAllLanguages() {
        List<LanguageModel> languages = null;

        try {
            languages = languageRepo.findAll();
        } catch (Exception e) {
            System.out.println("[getAllLanguages] exception: " + e.getMessage());
        }

        return languages;
    }

    @Override
    public void deleteLanguageById(Integer id) {
        try {
            languageRepo.deleteById(id);
        } catch (Exception e) {
            System.out.println("[deleteLanguageById] exception: " + e.getMessage());
        }
    }


}
