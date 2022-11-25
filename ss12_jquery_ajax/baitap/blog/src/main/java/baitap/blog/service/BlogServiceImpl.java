package baitap.blog.service;


import baitap.blog.model.Blog;
import baitap.blog.repository.IBlogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BlogServiceImpl implements IBlogService{

    @Autowired
    IBlogRepository blogRepository;

    public Page<Blog> findAll(Pageable pageable){
        return blogRepository.findAll(pageable);
    }

    @Override
    public List<Blog> findByCategory(int id) {
        return blogRepository.findByCategory(id);
    }

    @Override
    public Optional<Blog> findById(int id) {
        return blogRepository.findById(id);
    }

    @Override
    public void save(Blog blog) {
        blogRepository.save(blog);
    }

    @Override
    public void delete(Blog blog) {
        blogRepository.delete(blog);
    }

    @Override
    public List<Blog> findByAuthorContaining(String kq) {
        return blogRepository.findByAuthorContaining(kq);
    }

    @Override
    public Iterable<Blog> findALl() {
        return blogRepository.findAll();
    }
}
