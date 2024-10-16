package com.example.biblioteca.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.biblioteca.models.BookModel;
import com.example.biblioteca.services.BookService;

import java.util.List;


@RestController
@RequestMapping(value = "/books")
public class BookController {

    @Autowired
    BookService bookService;


    @PostMapping(value = "/save")
    public BookModel saveBook(@RequestBody BookModel book) {
        BookModel result = new BookModel();

        result = bookService.saveBook(book);

        return result;
    }

    @GetMapping(value = "/get/{id}")
    public BookModel getBookById(@PathVariable(value = "id") Integer id) {
        BookModel result = new BookModel();

        result = bookService.getBookById(id);

        return result;
    }

    @GetMapping
    public List<BookModel> getAllBooks() {
        return bookService.getAllBooks();
    }

    @DeleteMapping(value = "/delete/{id}")
    public ResponseEntity<Void> deleteBookById(@PathVariable(value = "id") Integer id) {
        bookService.deleteBookById(id);

        return ResponseEntity.noContent().build();
    }


}
