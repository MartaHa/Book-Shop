package pl.martaha.books.entity;

import pl.martaha.books.entity.Order;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "orderbook")
public class OrderBook {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String title;
    private String description;
    private String dateOfPublishing;


    @ManyToMany(cascade = {CascadeType.PERSIST,
            CascadeType.MERGE}, fetch = FetchType.EAGER)
    @JoinTable(
            name = "OrderBook_Author",
            joinColumns = {@JoinColumn(name = "orderbook_id")},
            inverseJoinColumns = {@JoinColumn(name = "author_id")}
    )
    private Set<Author> authors2 = new HashSet<>();


    @ManyToMany(cascade = {CascadeType.PERSIST,
            CascadeType.MERGE}, fetch = FetchType.EAGER)
    @JoinTable(
            name = "OrderBook_Category",
            joinColumns = {@JoinColumn(name = "orderbook_id")},
            inverseJoinColumns = {@JoinColumn(name = "category_id")}
    )
    private Set<Category> categories2 = new HashSet<>();

    @OneToMany
    private Set<Publisher> publishers = new HashSet<>();

    private double price;
    private int quantity;

    @ManyToOne
    private Order order;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDateOfPublishing() {
        return dateOfPublishing;
    }

    public void setDateOfPublishing(String dateOfPublishing) {
        this.dateOfPublishing = dateOfPublishing;
    }

    public Set<Author> getAuthors() {
        return authors2;
    }

    public void setAuthors(Set<Author> authors) {
        this.authors2 = authors;
    }

    public Set<Category> getCategories() {
        return categories2;
    }

    public void setCategories(Set<Category> categories) {
        this.categories2 = categories;
    }

    public Set<Publisher> getPublishers() {
        return publishers;
    }

    public void setPublishers(Set<Publisher> publishers) {
        this.publishers = publishers;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public OrderBook() {
    }
}
