package com.example.spring_advaned_application.service;

import com.example.spring_advaned_application.domain.Comment;
import com.example.spring_advaned_application.domain.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CommentServiceImpl implements CommentService{
    @Autowired
    private CommentRepository commentRepository;
    @Transactional
    @Override
    public Comment saveComment(Comment comment) {
        return commentRepository.save(comment);
    }
    @Transactional
    @Override
    public void deleteComment(Long id) {
        //commentRepository.deleteById(id);// can not delete directly because it has relationship with article


        // 1. commentRepository.deleteBy(id);
        // 2.
        Comment comment = commentRepository.findById(id).get();
        comment.clearComment();
        commentRepository.deleteById(id);

    }
}
