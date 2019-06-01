package com.busyqa.course.repo;

import com.busyqa.course.pojo.book.Publisher;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PublisherRepository extends JpaRepository<Publisher, Long> {
}
