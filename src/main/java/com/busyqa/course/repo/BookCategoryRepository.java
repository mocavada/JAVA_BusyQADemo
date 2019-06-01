package com.busyqa.course.repo;

import com.busyqa.course.pojo.book.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookCategoryRepository extends JpaRepository<Category, Integer>{
}
