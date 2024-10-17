package com.example.biblioteca.serviceImpl;

import com.example.biblioteca.models.AuthorModel;
import com.example.biblioteca.models.BookModel;
import com.example.biblioteca.repository.AuthorRepository;
import com.example.biblioteca.repository.BookRepository;
import com.example.biblioteca.services.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AuthorServiceImpl implements AuthorService {
    @Autowired
    AuthorRepository authorRepo;

    @Autowired
    BookRepository bookRepo;

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
    public void deleteAuthorById(Integer id) {
        try {
            authorRepo.deleteById(id);
        } catch (Exception e) {
            System.out.println("[deleteAuthorById] exception: " + e.getMessage());
        }
    }

    @Override
    public AuthorModel updateAuthor(Integer id, AuthorModel authorToUpdate) {
        AuthorModel existingAuthor = new AuthorModel();

        try {
            existingAuthor = authorRepo.findById(id).get();
            existingAuthor.setAuthorName(authorToUpdate.getAuthorName());

            existingAuthor = authorRepo.save(existingAuthor);
        } catch (Exception e) {
            System.out.println("[updateAuthor] exception: " + e.getMessage());
        }

        return existingAuthor;
    }

    @Override
    public AuthorModel assignBooksToAuthor(Integer authorId, List<Integer> bookIds) {
        Optional<AuthorModel> optionalAuthor = authorRepo.findById(authorId);
        if (optionalAuthor.isPresent()) {
            AuthorModel author = optionalAuthor.get();
            List<BookModel> books = bookRepo.findAllById(bookIds);
            author.setBooks(books);
            return authorRepo.save(author);
        } else {
            System.out.println("[assignBooksToAuthor] Author not found with ID: " + authorId);
            return null;
        }
    }


}
