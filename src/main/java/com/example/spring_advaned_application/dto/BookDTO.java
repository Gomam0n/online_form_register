package com.example.spring_advaned_application.dto;

import com.example.spring_advaned_application.domain.Book;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;
import org.springframework.beans.BeanUtils;

import static util.CustomBeanUtils.getNullPropertyNames;

public class BookDTO {
    @NotBlank
    private String author;
    @Length(max=50)
    private String description;
    @NotBlank
    private String name;
    @NotNull
    private Integer status;

    public BookDTO() {
    }

    public String getAuthor() {
        return author;
    }

    public String getDescription() {
        return description;
    }

    public String getName() {
        return name;
    }

    public Integer getStatus() {
        return status;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
    public void convertToBook(Book book){
        new BookConvert().convert(this, book);
    }
    public Book convertToBook(){
        return new BookConvert().convert(this);
    }
    private class BookConvert implements Convert<BookDTO, Book>{
        @Override
        public Book convert(BookDTO bookDTO, Book book) {
            String [] nullPropertyNames = getNullPropertyNames(bookDTO);
            BeanUtils.copyProperties(bookDTO, book, nullPropertyNames);
            return book;
        }

        @Override
        public Book convert(BookDTO bookDTO) {
            Book book = new Book();
            BeanUtils.copyProperties(bookDTO, book);
            return book;
        }
    }
}
