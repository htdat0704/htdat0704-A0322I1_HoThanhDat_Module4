package baitap.cart.service;

import java.util.Optional;

public interface CRUDService<T> {
    Iterable<T> findAll();
    Optional<T> findById(Long id);
    void save(T t);
    void delete(T t);
}
