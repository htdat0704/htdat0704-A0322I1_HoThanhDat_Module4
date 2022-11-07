package baitap.service;

import baitap.model.Blog;
import baitap.model.Category;
import baitap.repository.IBlogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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
    public List<Blog> findByDescriptionContaining(String description) {
        return blogRepository.findByDescriptionContaining(description);
    }

    @Override
    public List<Blog> findAllByCategory(Category category) {
        return blogRepository.findAllByCategory(category);
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
    public Iterable<Blog> findAll() {
        return blogRepository.findAll();
    }
}
