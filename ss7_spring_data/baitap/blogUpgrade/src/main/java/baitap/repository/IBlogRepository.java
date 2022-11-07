package baitap.repository;

import baitap.model.Blog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public interface IBlogRepository extends JpaRepository<Blog, Integer> {
    List<Blog> findByAuthor(String author);
}
