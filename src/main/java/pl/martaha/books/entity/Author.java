package pl.martaha.books.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String firstName;
    private String lastName;

    private String fullName;

    public String getFullName() {
        return firstName + " " + lastName;
    }

    @ManyToMany(mappedBy = "authors")
    private Set<Book> books = new HashSet<>();

    @ManyToMany(mappedBy = "authors2")
    private Set<OrderBook> orderBooks = new HashSet<>();

    /*Getters & Setters & Constructor*/

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Set<Book> getBooks() {
        return books;
    }

    public void setBooks(Set<Book> books) {
        this.books = books;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public Set<OrderBook> getOrderBooks() {
        return orderBooks;
    }

    public void setOrderBooks(Set<OrderBook> orderBooks) {
        this.orderBooks = orderBooks;
    }

    public Author() {
    }
}
