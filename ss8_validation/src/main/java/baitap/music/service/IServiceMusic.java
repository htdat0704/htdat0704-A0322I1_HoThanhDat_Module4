package baitap.music.service;

import baitap.music.model.Music;

import java.util.Optional;

public interface IServiceMusic {
    void save(Music music);
    Optional<Music> findById(long id);
    void update(Music music);
}
