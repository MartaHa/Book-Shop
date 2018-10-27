package pl.martaha.books.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private int quantity;
    private int amount;

    @OneToMany(mappedBy = "order")
    private List<OrderBook> orderBook = new ArrayList<>();

    /* Getters & Setters & Constructor */

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public List<OrderBook> getBooks() {
        return orderBook;
    }

    public void setBooks(List<OrderBook> orderBook) {
        this.orderBook = orderBook;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public Order() {
    }
}
