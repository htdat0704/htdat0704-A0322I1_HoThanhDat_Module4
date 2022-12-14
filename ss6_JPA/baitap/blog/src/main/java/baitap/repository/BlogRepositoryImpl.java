package baitap.repository;

import baitap.model.Blog;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Transactional
@Repository
public class BlogRepositoryImpl implements IBlogRepository{

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Blog> findAll() {
        TypedQuery<Blog> query=entityManager.createQuery("SELECT s from Blog as s", Blog.class);
        return query.getResultList();
    }

    @Override
    public void save(Blog blog) {
        entityManager.persist(blog);
    }

    @Override
    public Blog findById(int id) {
        return entityManager.find(Blog.class,id);
    }

    @Override
    public void update(Blog blog) {
        entityManager.merge(blog);
    }

    @Override
    public void delete(Blog blog) {
        entityManager.remove(entityManager.find(Blog.class,blog.getId()));
    }
}
