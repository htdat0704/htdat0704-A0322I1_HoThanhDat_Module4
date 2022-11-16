package baitap.book.service;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface ICRUDService<T> {
    Page<T> findAll(Pageable pageable);
    Iterable<T> findAll();
    Optional<T> findById(long id);
    void save(T t);
    void delete(T t);
}
