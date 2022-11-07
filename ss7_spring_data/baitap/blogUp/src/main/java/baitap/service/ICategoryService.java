package baitap.service;

import baitap.model.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface ICategoryService {
    Optional<Category> findById(int id);
    void save(Category category);
    void delete(Category category);
    Iterable<Category> findAll();
    Page<Category> findAll(Pageable pageable);
}
