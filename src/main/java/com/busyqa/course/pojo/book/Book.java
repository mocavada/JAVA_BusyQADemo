package com.busyqa.course.pojo.book;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "Book")//, uniqueConstraints={@UniqueConstraint(columnNames={"name"})})
//@JsonIdentityInfo(generator=ObjectIdGenerators.IntSequenceGenerator.class,property="@id", scope = Category.class)
//@JsonIdentityInfo(generator=ObjectIdGenerators.IntSequenceGenerator.class,property="@id", scope = Publisher.class)
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

//    @Column(unique = true)
    private String name;


    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "publisher_id")
    @JsonManagedReference
    private Publisher publisher;


    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "book_category",
            joinColumns = @JoinColumn(name = "book_id"),
            inverseJoinColumns = @JoinColumn(name = "category_id"))
    @JsonManagedReference
    private Set<Category> categorySet;

    public Book() {

    }

    public Book(String name) {
        this.name = name;
    }

    public Book(String name, Publisher publisher) {
        this.name = name;
        this.publisher = publisher;
    }

    public Book(String name, Set<Category> categorySet) {
        this.name = name;
        this.categorySet = categorySet;
    }

    public Book(String name, Publisher publisher, Set<Category> categorySet) {
        this.name = name;
        this.publisher = publisher;
        this.categorySet = categorySet;
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


    public Publisher getPublisher() {
        return publisher;
    }

    public void setPublisher(Publisher publisher) {
        this.publisher = publisher;
    }

    public Set<Category> getCategorySet() {
        return categorySet;
    }

    public void setCategorySet(Set<Category> categorySet) {
        this.categorySet = categorySet;
    }

    @Override
    public String toString() {
        String result = String.format(
                "Book [id=%d, name='%s']%n",
                id, name);
        if (categorySet != null) {
            for (Category cate : categorySet) {
                result += String.format(
                        "Publisher[id=%d, name='%s']%n",
                        cate.getId(), cate.getName());
            }
        }

        return result;
    }
}
