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
    private double amount;

    @OneToMany(mappedBy = "order")
    private List<OrderedBook> books = new ArrayList<>();
}
