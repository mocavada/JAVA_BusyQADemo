package com.busyqa.course.pojo.book;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "category")//,uniqueConstraints={@UniqueConstraint(columnNames={"name"})})
//@JsonIdentityInfo(generator=ObjectIdGenerators.IntSequenceGenerator.class,property="@id", scope = Book.class)
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

//    @Column(unique = true)
    private String name;


    @ManyToMany(mappedBy = "categorySet")
    @JsonBackReference
    private Set<Book> books;

    public Category() {

    }

    public Category(String name) {
        this.name = name;
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

    @Override
    public String toString() {
        String result = String.format(
                "Category[id=%d, name='%s']%n",
                id, name);
        if (books != null) {
            for (Book book : books) {
                result += String.format(
                        "Book[id=%d, name='%s']%n",
                        book.getId(), book.getName());
            }
        }

        return result;
    }
}
