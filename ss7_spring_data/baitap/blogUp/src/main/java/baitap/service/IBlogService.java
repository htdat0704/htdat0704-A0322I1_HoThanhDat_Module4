package baitap.service;

import baitap.model.Blog;
import baitap.model.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface IBlogService {
    Optional<Blog> findById(int id);
    void save(Blog blog);
    void delete(Blog blog);
    Iterable<Blog> findAll();
    Page<Blog> findAll(Pageable pageable);
    List<Blog> findByDescriptionContaining(String description);
    List<Blog> findAllByCategory(Category category);
}
