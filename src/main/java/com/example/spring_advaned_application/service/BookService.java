package com.example.spring_advaned_application.service;


import com.example.spring_advaned_application.domain.Book;

import java.util.List;

public interface BookService {
    List<Book> findAllBooks();
    Book getBookById(long id);
    Book saveBook(Book book);

    Book updateBook(Book book);

    void deleteBookById(Long id);
    void deleteAllBooks();
}
