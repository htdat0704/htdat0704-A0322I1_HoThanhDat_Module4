package baitap.blog.repository;

import baitap.blog.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ICategoryRepository extends JpaRepository<Category,Integer> {
    Optional<Category> findByName(String name);
}
