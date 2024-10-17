package com.example.biblioteca.serviceImpl;

import com.example.biblioteca.models.AuthorModel;
import com.example.biblioteca.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.biblioteca.models.BookModel;
import com.example.biblioteca.repository.BookRepository;
import com.example.biblioteca.services.BookService;

import java.util.List;
import java.util.Optional;

@Service
public class BookServiceImpl implements BookService {

    @Autowired
    BookRepository bookRepo;

    @Autowired
    AuthorRepository authorRepo;

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

            existingBook = bookRepo.save(existingBook);
        } catch (Exception e) {
            System.out.println("[updateBook] exception: " + e.getMessage());
        }

        return existingBook;
    }

    @Override
    public BookModel assignAuthorsToBook(Integer bookId, List<Integer> authorIds) {
        Optional<BookModel> optionalBook = bookRepo.findById(bookId);
        if (optionalBook.isPresent()) {
            BookModel book = optionalBook.get();
            List<AuthorModel> authors = authorRepo.findAllById(authorIds);
            book.setAuthors(authors);
            return bookRepo.save(book);
        } else {
            System.out.println("[assignAuthorsToBook] Book not found with ID: " + bookId);
            return null;
        }
    }


}
