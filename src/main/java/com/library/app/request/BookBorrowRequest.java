package com.library.app.request;

import lombok.Data;

import java.util.Date;

@Data
public class BookBorrowRequest {

    private Long bookID;

    private Long userID;

    private String bookName;

    private Date borrowDate;

    private String status;

}
