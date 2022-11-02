package baitap.service;

import baitap.model.Music;
import baitap.repository.IMusicRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class MusicServiceImpl implements IMusicService{

    @Autowired
    private IMusicRepository musicRepository;
    @Override
    public List<Music> findAll() {
        return musicRepository.findAll();
    }

    @Override
    public void save(Music music) {
        musicRepository.save(music);
    }

    @Override
    public Music findById(int id) {
        return musicRepository.findById(id);
    }

    @Override
    public void update(Music music) {
        musicRepository.update(music);
    }

    @Override
    public void delete(Music music) {
        musicRepository.delete(music);
    }
}
