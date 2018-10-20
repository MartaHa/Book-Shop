package pl.martaha.books.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;


    /*Getters & Constructor*/

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Category() {
    }
}
