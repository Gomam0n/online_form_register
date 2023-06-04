package com.example.spring_advaned_application.service;

import com.example.spring_advaned_application.domain.Author;
import com.example.spring_advaned_application.domain.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

@Service
public class AuthorServiceImpl implements AuthorService{
    @Autowired
    private AuthorRepository authorRepository;

    @Transactional
    @Override
    public Author updateAuthor(){
        Author author = new Author();
        author.setPhone("111111111");
        author.setNickName("nick");
        author.setSignDate(new Date());

        Author author1 = authorRepository.save(author);
        author1.setPhone("999999999");
        Author author2 = authorRepository.save(author1);
        return author2;
    }

    @Override
    public Author saveAuthor(Author author) {
        return authorRepository.save(author);
    }

    @Override
    public Author updateAuthor(Author author) {
        return authorRepository.save(author);
    }

    @Override
    public Author findAuthor(Long id) {
        return authorRepository.findById(id).get();
    }

    @Override
    public void deleteAuthor(Long id) {
        authorRepository.deleteById(id);
    }
}
