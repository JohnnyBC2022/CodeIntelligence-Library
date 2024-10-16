package com.example.biblioteca.serviceImpl;

import com.example.biblioteca.models.AuthorModel;
import com.example.biblioteca.repository.AuthorRepository;
import com.example.biblioteca.services.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorServiceImpl implements AuthorService {
    @Autowired
    AuthorRepository authorRepo;

    @Override
    public AuthorModel saveAuthor(AuthorModel author) {
        AuthorModel result = new AuthorModel();

        try {
            result = authorRepo.save(author);
        } catch (Exception e) {
            System.out.println("[saveAuthor] exception: " + e.getMessage());
        }
        return result;
    }

    @Override
    public AuthorModel getAuthorById(Integer id) {
        AuthorModel result = new AuthorModel();

        try {
            result = authorRepo.findById(id).get();
        } catch (Exception e) {
            System.out.println("[getAuthorById] exception: " + e.getMessage());
        }

        return result;
    }

    @Override
    public List<AuthorModel> getAllAuthors() {
        List<AuthorModel> authors = null;

        try {
            authors = authorRepo.findAll();
        } catch (Exception e) {
            System.out.println("[getAllAuthors] exception: " + e.getMessage());
        }

        return authors;
    }

    @Override
    public void deleteAuthorById(Integer id){
        try {
            authorRepo.deleteById(id);
        } catch (Exception e) {
            System.out.println("[deleteAuthorById] exception: " + e.getMessage());
        }
    }

}
