package baitap.service;

import baitap.model.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface IBlogService {
    Optional<Blog> findById(int id);
    void save(Blog blog);
    void delete(Blog blog);
    List<Blog> findByAuthor(String author);

    Page<Blog> findAll(Pageable pageable);
}
