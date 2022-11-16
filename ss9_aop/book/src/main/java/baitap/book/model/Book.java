package baitap.book.model;


import javax.persistence.*;
import java.util.Set;

@Entity
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private int quantity;
    private String name;

    @OneToMany(mappedBy = "book")
    private Set<CTOrder> ctOrder;

    public Book() {
    }

    public Book(long id, int quantity, String name) {
        this.id = id;
        this.quantity = quantity;
        this.name = name;
    }

    public Book(long id, int quantity, String name, Set<CTOrder> ctOrder) {
        this.id = id;
        this.quantity = quantity;
        this.name = name;
        this.ctOrder = ctOrder;
    }

    public Set<CTOrder> getCtOrder() {
        return ctOrder;
    }

    public void setCtOrder(Set<CTOrder> ctOrder) {
        this.ctOrder = ctOrder;
    }

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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
