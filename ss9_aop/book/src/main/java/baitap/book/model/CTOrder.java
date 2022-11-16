package baitap.book.model;

import javax.persistence.*;

@Entity
public class CTOrder {

    @Id
    private long id;

    private int quantity;

    @ManyToOne
    @JoinColumn(name = "book_id",referencedColumnName = "id")
    private Book book;

    public CTOrder() {
    }

    public CTOrder(long id, int quantity) {
        this.id = id;
        this.quantity = quantity;
    }

    public CTOrder(long id, int quantity, Book book) {
        this.id = id;
        this.quantity = quantity;
        this.book = book;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
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
}
