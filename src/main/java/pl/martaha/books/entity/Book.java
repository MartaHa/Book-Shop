package pl.martaha.books.entity;

import javax.persistence.*;
import java.util.List;

@Entity
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String title;
    private String dateOfPublishing;

    @ManyToMany
    private List<Author> authors;

    @ManyToMany
    private List <Category> categories;
    private int price;



    /*Getters & Constructor*/

    public long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getDateOfPublishing() {
        return dateOfPublishing;
    }

    public List<Author> getAuthors() {
        return authors;
    }

    public List<Category> getCategories() {
        return categories;
    }

    public int getPrice() {
        return price;
    }

    public Book() {
    }
}
