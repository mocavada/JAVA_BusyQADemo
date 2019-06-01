package com.busyqa.course.service;

import com.busyqa.course.pojo.book.Book;
import com.busyqa.course.pojo.book.Category;
import com.busyqa.course.pojo.book.Publisher;
import com.busyqa.course.repo.BookCategoryRepository;
import com.busyqa.course.repo.BookRepository;
import com.busyqa.course.repo.PublisherRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;

@Service("BookDataService")
public class BookDataService {

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private PublisherRepository publisherRepository;

    @Autowired
    private BookCategoryRepository bookCategoryRepository;

    private static final Logger logger = LoggerFactory.getLogger(BookDataService.class);

    //Double brace initialization
    @SuppressWarnings("unchecked")
    public void addDumyData(){
        // save a couple of books
        Publisher publisherA = new Publisher("Publisher A");
        Publisher publisherB = new Publisher("Publisher B");
        Publisher publisherC = new Publisher("Publisher C");

        Category categoryX = new Category("Category X");
        Category categoryY = new Category("Category Y");
        Category categoryZ = new Category("Category Z");

        //========
        Book bookI = new Book("Book I", publisherA, new HashSet<Category>() {{
            add(categoryX);
            add(categoryY);
            add(categoryZ);
        }});

        Book bookJ = new Book("Book J", publisherB, new HashSet<Category>() {{
            add(categoryX);
            add(categoryY);
        }});

        Book bookK = new Book("Book K", publisherC, new HashSet<Category>() {{
            add(categoryY);
            add(categoryZ);
        }});

        HashSet<Book> booksInCateX = new HashSet<Book>() {{
            add(bookI);
            add(bookJ);
        }};
        HashSet<Book> booksInCateY = new HashSet<Book>() {{
            add(bookJ);
            add(bookK);
        }};
        HashSet<Book> booksInCateZ = new HashSet<Book>() {{
            add(bookI);
            add(bookK);
        }};
        //========
//        categoryX.setBooks(booksInCateX);
//        categoryY.setBooks(booksInCateY);
//        categoryZ.setBooks(booksInCateZ);

        //========
//        publisherA.getBooks().add(bookI);
//        publisherB.getBooks().add(bookJ);
//        publisherC.getBooks().add(bookK);

        //========
        bookRepository.saveAll(new HashSet<Book>() {{
            add(bookI);
            add(bookJ);
            add(bookK);
        }});

//        publisherRepository.saveAll(new HashSet<Publisher>() {{
//            add(publisherA);
//            add(publisherB);
//            add(publisherC);
//        }});
//
//        bookCategoryRepository.saveAll(new HashSet<Category>() {{
//            add(categoryX);
//            add(categoryY);
//            add(categoryZ);
//        }});


        //Double curly bracess => ananimous class init
        //https://blog.jooq.org/2014/12/08/dont-be-clever-the-double-curly-braces-anti-pattern/
    }

    public List<Book> findAllBooks() {
        return bookRepository.findAll();
    }

    public List<Category> findAllCates() {
        return bookCategoryRepository.findAll();
    }


    public List<Publisher> findAllPublishers() {
        return publisherRepository.findAll();
    }


}
