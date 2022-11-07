package baitap.model;

import org.hibernate.annotations.Cascade;

import javax.persistence.*;

@Entity
public class Blog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String author;
    private String description;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "category_id",referencedColumnName ="id")
    private Category category;

    public Blog() {
    }

    public Blog(int id, String author, String description) {
        this.id = id;
        this.author = author;
        this.description = description;
    }

    public Blog(int id, String author, String description, Category category) {
        this.id = id;
        this.author = author;
        this.description = description;
        this.category = category;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }


}
