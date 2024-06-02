package com.library.app.dao;

import com.library.app.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.nio.ByteBuffer;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {

}
