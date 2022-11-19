package baitap.cart.model;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private double total;

    @OneToMany(mappedBy = "order")
    private Set<CTOrder> ctOrderSet;

    public Order() {
    }

    public Order(long id, double total, Set<CTOrder> ctOrderSet) {
        this.id = id;
        this.total = total;
        this.ctOrderSet = ctOrderSet;
    }

    public Order(double total) {
        this.total = total;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public Set<CTOrder> getCtOrderSet() {
        return ctOrderSet;
    }

    public void setCtOrderSet(Set<CTOrder> ctOrderSet) {
        this.ctOrderSet = ctOrderSet;
    }


}
