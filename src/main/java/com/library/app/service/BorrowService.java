package com.library.app.service;

import com.library.app.dao.BookRepository;
import com.library.app.dao.BorrowRepository;
import com.library.app.model.Book;
import com.library.app.model.BookLogs;
import com.library.app.request.BookBorrowRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.Date;

@Service
public class BorrowService {
    @Autowired
    private BookRepository bookRepository;
    @Autowired
    private BorrowRepository BorrowRepository;

    @Transactional
    public void issueBook(BookBorrowRequest bookBorrowRequest) {

        Book book = bookRepository.findById(bookBorrowRequest.getBookID())
                .orElseThrow(() -> new IllegalArgumentException("Book not found"));

        book.decrementCopies();
        bookRepository.save(book);

        BookLogs bookLogs = new BookLogs();
        bookLogs.setBookId(book.getBookID());
        bookLogs.setUserId(bookBorrowRequest.getUserID());
        bookLogs.setBorrowDate(LocalDate.now());
        bookLogs.setStatus("borrowed");

        BorrowRepository.save(bookLogs);

    }

}
