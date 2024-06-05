package com.library.app.dao;

import com.library.app.model.BookLogs;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BorrowRepository extends JpaRepository<BookLogs,Long> {
}
