package com.busyqa.course.repo;

import com.busyqa.course.pojo.book.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Integer> {
}
