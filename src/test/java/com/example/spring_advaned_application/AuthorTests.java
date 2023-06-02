package com.example.spring_advaned_application;

import com.example.spring_advaned_application.domain.Author;
import com.example.spring_advaned_application.domain.AuthorRepository;
import net.minidev.json.JSONArray;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;
import java.util.List;

@SpringBootTest
public class AuthorTests {
    @Autowired
    private AuthorRepository authorRepository;
    @Test
    public void saveAuthorTest(){
        Author author = new Author();
        author.setNickName("Arvin");
        author.setPhone("123123123");
        author.setSignDate(new Date());
        authorRepository.save(author);
    }

    @Test
    public void findAuthorTest(){

        //List<Author> authors = authorRepository.findByPhoneAndNickName("123123123", "Arvin");
        List<Author> authors = authorRepository.findBySql("vi");
        System.out.println(JSONArray.toJSONString(authors));
    }
}
