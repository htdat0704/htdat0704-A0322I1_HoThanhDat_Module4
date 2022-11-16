package baitap.book.service.book;

import baitap.book.model.Book;
import baitap.book.service.ICRUDService;

public interface IBookService extends ICRUDService<Book> {
    void rentalBook(int quantity, long id);
}
