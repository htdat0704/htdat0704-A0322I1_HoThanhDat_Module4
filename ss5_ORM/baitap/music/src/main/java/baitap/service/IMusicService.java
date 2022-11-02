package baitap.service;

import baitap.model.Music;

import java.util.List;

public interface IMusicService {
    List<Music> findAll();
    void save(Music music);
    Music findById(int id);
    void update(Music music);
    void delete(Music music);
}
