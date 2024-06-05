package com.library.app.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table (name = "book")
@Data
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long bookID;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String author;

    @Column(nullable = false)
    private String isbn;

    @Column(nullable = false)
    private String publisher;

    @Column(nullable = false)
    private int copies;

    public void decrementCopies() {
        if (copies > 0) {
            this.copies--;
        } else {
            throw new RuntimeException("No copies available");
        }
    }

}
