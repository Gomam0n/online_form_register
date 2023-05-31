package com.example.spring_advaned_application.web;

import com.example.spring_advaned_application.domain.Book;
import com.example.spring_advaned_application.exception.BookNotFoundExCeption;
import com.example.spring_advaned_application.service.BookService;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.sql.SQLException;

@Controller
@RequestMapping("/books")
public class BookController {
    @Autowired
    private BookService bookService;
    @GetMapping("/{id}")
    public String getBook(@PathVariable Long id, Model model){
        Book book = bookService.getBookById(id);
        if(book == null){
            System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxxx");
            throw new BookNotFoundExCeption("The book does not exist");
        }
        model.addAttribute("book", book);
        return "book";
    }
}
