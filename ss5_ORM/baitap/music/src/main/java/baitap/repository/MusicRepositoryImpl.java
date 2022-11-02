package baitap.repository;

import baitap.model.Music;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Transactional
@Repository
public class MusicRepositoryImpl implements IMusicRepository{

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Music> findAll() {
        TypedQuery<Music> query=entityManager.createQuery("SELECT s from Music as s", Music.class);
        return query.getResultList();
    }

    @Override
    public void save(Music music) {
        entityManager.persist(music); //thêm mới
//        entityManager.merge(music); //cập nhật
//        entityManager.remove(music); //xóa
//        entityManager.find(Music.class, 5); //tìm kiếm với id = 5
    }

    @Override
    public Music findById(int id) {
        return entityManager.find(Music.class, id);
    }

    @Override
    public void update(Music music) {
        entityManager.merge(music);
    }

    @Override
    public void delete(Music music) {
        entityManager.remove(music);
    }
}
