package baitap.music.repository;

import baitap.music.model.Music;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IRepositoryMusic extends JpaRepository<Music,Long> {
}
