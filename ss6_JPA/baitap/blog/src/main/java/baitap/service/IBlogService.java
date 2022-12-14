package baitap.service;

import baitap.model.Blog;

import java.util.List;

public interface IBlogService {
    List<Blog> findAll();
    void save(Blog blog);
    Blog findById(int id);
    void update(Blog blog);
    void delete(Blog blog);
}
