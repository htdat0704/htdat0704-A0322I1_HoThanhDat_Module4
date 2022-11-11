package baitap.music.service;

import baitap.music.model.Music;
import baitap.music.repository.IRepositoryMusic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ServiceMusic implements IServiceMusic{

    @Autowired
    IRepositoryMusic repositoryMusic;

    @Override
    public void save(Music music) {
        repositoryMusic.save(music);
    }

    @Override
    public Optional<Music> findById(long id) {
        return repositoryMusic.findById(id);
    }

    @Override
    public void update(Music music) {
        repositoryMusic.save(music);
    }
}
