package com.example.biblioteca.services;

import com.example.biblioteca.models.LanguageModel;

import java.util.List;

public interface LanguageService {

    public LanguageModel saveLanguage(LanguageModel language);

    public LanguageModel getLanguageById(Integer id);

    public List<LanguageModel> getAllLanguages();

    public void deleteLanguageById(Integer id);
}
