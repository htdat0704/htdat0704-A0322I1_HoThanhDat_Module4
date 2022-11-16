package baitap.picture.service;


import baitap.picture.model.Comment;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ICommentService {
    Page<Comment> findAll(Pageable pageable);
    void save(Comment comment);
}
