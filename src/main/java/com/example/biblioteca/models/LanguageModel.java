package com.example.biblioteca.models;

import jakarta.persistence.*;

@Entity
@Table(name = "LANGUAGE")
public class LanguageModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer idLanguage;

    private String description;

    public Integer getIdLanguage() {
        return idLanguage;
    }

    public void setIdLanguage(Integer idLanguage) {
        this.idLanguage = idLanguage;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LanguageModel() {
    }

    public LanguageModel(Integer idLanguage, String description) {
        this.idLanguage = idLanguage;
        this.description = description;
    }
}
