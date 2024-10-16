package com.example.biblioteca.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.biblioteca.models.BookModel;
import com.example.biblioteca.repository.BookRepository;
import com.example.biblioteca.services.BookService;

import java.util.List;

@Service
public class BookServiceImpl implements BookService {

    @Autowired
    BookRepository bookRepo;

    @Override
    public BookModel saveBook(BookModel book) {
        BookModel result = new BookModel();

        try {
            result = bookRepo.save(book);
        } catch (Exception e) {
            System.out.println("[saveBook] exception: " + e.getMessage());
        }

        return result;
    }

    @Override
    public BookModel getBookById(Integer id) {
        BookModel result = new BookModel();

        try {
            result = bookRepo.findById(id).get();
        } catch (Exception e) {
            System.out.println("[getBookById] exception: " + e.getMessage());
        }

        return result;
    }

    @Override
    public List<BookModel> getAllBooks() {
        List<BookModel> books = null;

        try {
            books = bookRepo.findAll();
        } catch (Exception e) {
            System.out.println("[getAllBooks] exception: " + e.getMessage());
        }

        return books;
    }

    @Override
    public void deleteBookById(Integer id) {
        try {
            bookRepo.deleteById(id);
        } catch (Exception e) {
            System.out.println("[deleteBookById] exception: " + e.getMessage());
        }
    }

    @Override
    public BookModel updateBook(Integer id, BookModel bookToUpdate) {
        BookModel existingBook = new BookModel();

        try {
            existingBook = bookRepo.findById(id).get();
            existingBook.setIdLanguage(bookToUpdate.getIdLanguage());
            existingBook.setPublicationYear(bookToUpdate.getPublicationYear());
            existingBook.setTitle(bookToUpdate.getTitle());
        } catch (Exception e) {
            System.out.println("[updateBook] exception: " + e.getMessage());
        }

        return existingBook;
    }


}
