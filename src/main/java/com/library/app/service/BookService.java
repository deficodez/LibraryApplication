package com.library.app.service;

import com.library.app.dao.BookRepository;
import com.library.app.model.Book;
import com.library.app.request.BookBorrowRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    public Optional<Book> getBookById(long id) {
        return Optional.of(bookRepository.findById(id).get());
    }

}
