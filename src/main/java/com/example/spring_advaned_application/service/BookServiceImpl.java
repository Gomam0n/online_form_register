package com.example.spring_advaned_application.service;

import com.example.spring_advaned_application.domain.Book;
import com.example.spring_advaned_application.domain.BookRepository;
import com.example.spring_advaned_application.exception.BookNotFoundExCeption;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookServiceImpl implements  BookService{
    @Autowired
    private BookRepository bookRepository;
    @Override
    public Book getBookById(long id) {
        Optional<Book> book= bookRepository.findById(id);
        if(book.isEmpty()){
            System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxxx");
            throw new BookNotFoundExCeption("The book does not exist");
        }
        return book.get();
        //return bookRepository.findById(id).get();
    }

    @Override
    public List<Book> findAllBooks() {
        return bookRepository.findAll();
    }

    @Override
    public Book saveBook(Book book) {
        return bookRepository.save(book);
    }

    @Override
    public Book updateBook(Book book) {
        return bookRepository.save(book);
    }

    @Override
    public void deleteBookById(Long id) {
        bookRepository.deleteById(id);
    }

    @Override
    public void deleteAllBooks() {
        bookRepository.deleteAll();
    }
}
