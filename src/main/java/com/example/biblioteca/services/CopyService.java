package com.example.biblioteca.services;

import com.example.biblioteca.models.CopyModel;

import java.util.List;

public interface CopyService {

    public CopyModel saveCopy(CopyModel copy);

    public CopyModel getCopyById(Integer id);

    public List<CopyModel> getAllCopies();

    public void deleteCopyById(Integer id);
}
