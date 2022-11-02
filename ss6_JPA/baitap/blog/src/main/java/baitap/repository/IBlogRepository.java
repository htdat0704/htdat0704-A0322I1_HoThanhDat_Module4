package baitap.repository;

import baitap.model.Blog;

import java.util.List;

public interface IBlogRepository {
    List<Blog> findAll();
    void save(Blog blog);
    Blog findById(int id);
    void update(Blog blog);
    void delete(Blog blog);
}
