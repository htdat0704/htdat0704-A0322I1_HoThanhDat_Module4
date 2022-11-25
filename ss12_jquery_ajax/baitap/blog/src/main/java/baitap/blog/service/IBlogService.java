package baitap.blog.service;


import baitap.blog.model.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface IBlogService {
    Optional<Blog> findById(int id);
    void save(Blog blog);
    void delete(Blog blog);
    List<Blog> findByAuthorContaining(String author);
    Iterable<Blog> findALl();

    Page<Blog> findAll(Pageable pageable);
    List<Blog> findByCategory(int id);
}
