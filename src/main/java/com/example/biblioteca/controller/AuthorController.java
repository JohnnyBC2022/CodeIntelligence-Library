package com.example.biblioteca.controller;

import com.example.biblioteca.models.AuthorModel;
import com.example.biblioteca.services.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/authors")
public class AuthorController {

    @Autowired
    AuthorService authorService;

    @PostMapping(value = "/save")
    public AuthorModel saveAuthor(@RequestBody AuthorModel author) {
        AuthorModel result = new AuthorModel();

        result = authorService.saveAuthor(author);

        return result;
    }

    @GetMapping(value = "/get/{id}")
    public AuthorModel getAuthorById(@PathVariable(value = "id") Integer id) {
        AuthorModel result = new AuthorModel();

        result = authorService.getAuthorById(id);

        return result;
    }

    @GetMapping
    public List<AuthorModel> getAllAuthors() {
        return authorService.getAllAuthors();
    }

    @DeleteMapping(value = "/delete/{id}")
    public ResponseEntity<Void> deleteAuthorById(@PathVariable(value = "id") Integer id){
        authorService.deleteAuthorById(id);
        return ResponseEntity.noContent().build();
    }

}
