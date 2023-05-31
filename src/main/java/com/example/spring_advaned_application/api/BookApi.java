package com.example.spring_advaned_application.api;

import com.example.spring_advaned_application.domain.Book;
import com.example.spring_advaned_application.dto.BookDTO;
import com.example.spring_advaned_application.exception.BookNotFoundException;
import com.example.spring_advaned_application.exception.InvalidRequestException;
import com.example.spring_advaned_application.service.BookService;
import com.example.spring_advaned_application.service.BookServiceImpl;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.beans.PropertyDescriptor;
import java.util.ArrayList;
import java.util.List;

import static util.CustomBeanUtils.getNullPropertyNames;

@RestController
@RequestMapping("/api/v1")
public class BookApi {
    @Autowired
    private BookServiceImpl bookService;

    @GetMapping("/books")
    public ResponseEntity<?> listAllBooks(){
        List<Book> books = bookService.findAllBooks();
        if(books.isEmpty()){
            throw new BookNotFoundException("Books Not Found");
        }
        return new ResponseEntity<List<Book>>(books, HttpStatus.OK);
    }

    @GetMapping("/books/{id}")
    public ResponseEntity<?> getBook(@PathVariable Long id){
        Book book = bookService.getBookById(id);
        if(book == null){
            System.out.println("error");
            throw new BookNotFoundException(String.format("book by id %s not found", id));
        }
        return new ResponseEntity<Object>(book, HttpStatus.OK);
    }
    @PostMapping ("/books")
    public ResponseEntity<?> saveBook(@Valid @RequestBody BookDTO bookDTO, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            System.out.println("post binding result has errors");
            throw new InvalidRequestException("Invalid parameter", bindingResult);
        }

        Book book1 = bookService.saveBook(bookDTO.convertToBook());

        return new ResponseEntity<Object>(book1, HttpStatus.CREATED);
    }

    @PutMapping("/books/{id}")
    public ResponseEntity<?> updateBook(@PathVariable Long id, @Valid @RequestBody BookDTO bookDTO, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            throw new InvalidRequestException("Invalid parameter", bindingResult);
        }

        Book currentBook = bookService.getBookById(id);

        if(currentBook == null){
            throw new BookNotFoundException(String.format("book by id %s not found", id));

        }
        //BeanUtils.copyProperties(bookDTO, currentBook);
        bookDTO.convertToBook(currentBook);
        Book book1 = bookService.updateBook(currentBook);
        return new ResponseEntity<Object>(book1, HttpStatus.OK);

    }
    @DeleteMapping("/books/{id}")
    public ResponseEntity<?> deleteBook(@PathVariable Long id){
        bookService.deleteBookById(id);
        return new ResponseEntity<Object>(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("/books")
    public ResponseEntity<?> deleteAllBooks(){
        bookService.deleteAllBooks();
        return new ResponseEntity<Object>(HttpStatus.NO_CONTENT);
    }

}
