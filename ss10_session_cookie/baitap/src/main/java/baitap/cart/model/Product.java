package baitap.cart.model;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private String image;
    private double price;
    private String description;

    @OneToMany(mappedBy = "product")
    private Set<CTOrder> ctOrderSet;

    public Product() {
    }

    public Product(long id, String name, String image, double price, String description) {
        this.id = id;
        this.name = name;
        this.image = image;
        this.price = price;
        this.description = description;
    }

    public Product(long id, String name, String image, double price, String description, Set<CTOrder> ctOrderSet) {
        this.id = id;
        this.name = name;
        this.image = image;
        this.price = price;
        this.description = description;
        this.ctOrderSet = ctOrderSet;
    }

    public Set<CTOrder> getCtOrderSet() {
        return ctOrderSet;
    }

    public void setCtOrderSet(Set<CTOrder> ctOrderSet) {
        this.ctOrderSet = ctOrderSet;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
