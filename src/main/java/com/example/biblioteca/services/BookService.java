package com.example.biblioteca.services;

import com.example.biblioteca.models.BookModel;

import java.util.List;

public interface BookService {

    public BookModel saveBook(BookModel book);

    public BookModel getBookById(Integer id);

    public List<BookModel> getAllBooks();

    public void deleteBookById(Integer id);
}
