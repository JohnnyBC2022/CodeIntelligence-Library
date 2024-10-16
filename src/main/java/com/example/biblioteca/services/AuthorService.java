package com.example.biblioteca.services;

import com.example.biblioteca.models.AuthorModel;

import java.util.List;

public interface AuthorService {

    public AuthorModel saveAuthor(AuthorModel author);

    public  AuthorModel getAuthorById(Integer id);

    public List<AuthorModel> getAllAuthors();

    public void deleteAuthorById(Integer id);

    public AuthorModel updateAuthor(Integer id, AuthorModel authorToUpdate);

    public AuthorModel assignBooksToAuthor(Integer authorId, List<Integer> bookIds);

}
