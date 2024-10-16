package com.example.biblioteca.controller;

import com.example.biblioteca.models.LanguageModel;
import com.example.biblioteca.services.LanguageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/languages")
public class LanguageController {
    @Autowired
    LanguageService languageService;

    @PostMapping(value = "/save")
    public LanguageModel saveLanguage(@RequestBody LanguageModel language) {
        LanguageModel result = new LanguageModel();

        result = languageService.saveLanguage(language);

        return result;
    }

    @GetMapping(value = "/get/{id}")
    public LanguageModel getLanguageById(@PathVariable(value = "id") Integer id) {
        LanguageModel result = new LanguageModel();

        result = languageService.getLanguageById(id);

        return result;
    }

    @GetMapping
    public List<LanguageModel> getAllLanguages() {
        return languageService.getAllLanguages();
    }

    @DeleteMapping(value = "/delete/{id}")
    public ResponseEntity<Void> deleteLanguageById(@PathVariable(value = "id") Integer id) {
        languageService.deleteLanguageById(id);
        return ResponseEntity.noContent().build();
    }


}
