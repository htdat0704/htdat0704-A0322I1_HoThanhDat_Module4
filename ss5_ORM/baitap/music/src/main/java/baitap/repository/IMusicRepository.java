package baitap.repository;

import baitap.model.Music;

import java.util.*;

public interface IMusicRepository {
    List<Music> findAll();
    void save(Music music);
    Music findById(int id);
    void update(Music music);
    void delete(Music music);
}
