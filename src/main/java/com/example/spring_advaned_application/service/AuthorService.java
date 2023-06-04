package com.example.spring_advaned_application.service;

import com.example.spring_advaned_application.domain.Author;

public interface AuthorService {
    Author updateAuthor();

    Author saveAuthor(Author author);

    Author updateAuthor(Author author);

    Author findAuthor(Long id);

    void deleteAuthor(Long id);

}
