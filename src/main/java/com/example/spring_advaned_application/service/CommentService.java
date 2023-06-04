package com.example.spring_advaned_application.service;

import com.example.spring_advaned_application.domain.Comment;

public interface CommentService {
    Comment saveComment(Comment comment);
    void deleteComment(Long id);
}
