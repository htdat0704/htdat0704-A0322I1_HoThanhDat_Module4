package baitap.service;

import baitap.model.Blog;
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
    public List<Blog> findByAuthor(String kq) {
        return blogRepository.findByAuthor(kq);
    }
}
