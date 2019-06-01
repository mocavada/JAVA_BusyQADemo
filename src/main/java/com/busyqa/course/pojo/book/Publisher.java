package com.busyqa.course.pojo.book;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "publisher")//, uniqueConstraints={@UniqueConstraint(columnNames={"name"})})
//@JsonIdentityInfo(generator=ObjectIdGenerators.IntSequenceGenerator.class,property="@id", scope = Book.class)
public class Publisher {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

//    @Column(unique = true)
    private String name;

    @OneToMany(mappedBy = "publisher", cascade = CascadeType.ALL)
    @JsonBackReference
    private Set<Book> books;

    public Publisher() {

    }

    public Publisher(String name) {
        this.name = name;
    }

    public Publisher(String name, Set<Book> books) {
        this.name = name;
        this.books = books;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Book> getBooks() {
        return books;
    }

    public void setBooks(Set<Book> books) {
        this.books = books;
    }
}
