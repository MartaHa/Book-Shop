package pl.martaha.books.entity;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "order_book")
public class OrderedBook {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String title;
    private String description;
    private String dateOfPublishing;


    @ManyToMany(cascade = {CascadeType.PERSIST,
            CascadeType.MERGE}, fetch = FetchType.EAGER)
    @JoinTable(
            name = "Book_Author",
            joinColumns = {@JoinColumn(name = "book_id")},
            inverseJoinColumns = {@JoinColumn(name = "author_id")}
    )
    private Set<Author> authors = new HashSet<>();


    @ManyToMany(cascade = {CascadeType.PERSIST,
            CascadeType.MERGE}, fetch = FetchType.EAGER)
    @JoinTable(
            name = "Book_Category",
            joinColumns = {@JoinColumn(name = "book_id")},
            inverseJoinColumns = {@JoinColumn(name = "category_id")}
    )
    private Set<Category> categories = new HashSet<>();

    @OneToMany
    private Set<Publisher> publishers = new HashSet<>();

    private double price;
    private int quantity;

    /* Getters & Setters & Cosntructior  */

    
}
