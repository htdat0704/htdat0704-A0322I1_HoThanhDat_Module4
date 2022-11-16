package baitap.picture.service;


import baitap.picture.model.Comment;
import baitap.picture.repository.ICommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class CommentService implements ICommentService {

    @Autowired
    private ICommentRepository repository;

    @Override
    public Page<Comment> findAll(Pageable pageable) {
        return repository.findAll(pageable);
    }

    @Override
    public void save(Comment comment) {
        repository.save(comment);
    }
}
