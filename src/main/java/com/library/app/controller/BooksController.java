package com.library.app.controller;

import com.library.app.model.Book;
import com.library.app.request.BookBorrowRequest;
import com.library.app.service.BookService;
import com.library.app.service.BorrowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/v1/library")
public class BooksController {

    @Autowired
    private BookService bookService;

    @Autowired
    private BorrowService  borrowService;

    @GetMapping("/allBooks")
    public List<Book> getAllBooks(){
        return bookService.getAllBooks();
    }

    @GetMapping("/getBookById/{id}")
    public Optional<Book> getBookById(@PathVariable long id){
        return bookService.getBookById(id);
    }

    @PostMapping("/issueBook")
    public void issueBook(@RequestBody BookBorrowRequest bookBorrowRequest){
            borrowService.issueBook(bookBorrowRequest);
    }
}
