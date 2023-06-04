package com.example.spring_advaned_application;

import com.example.spring_advaned_application.domain.Author;
import com.example.spring_advaned_application.domain.AuthorRepository;
import com.example.spring_advaned_application.domain.Wallet;
import com.example.spring_advaned_application.domain.WalletRepository;
import com.example.spring_advaned_application.service.AuthorService;
import net.bytebuddy.description.annotation.AnnotationValue;
import net.minidev.json.JSONArray;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@SpringBootTest
public class AuthorTests {
    @Autowired
    private AuthorRepository authorRepository;
    @Autowired
    private WalletRepository walletRepository;


    @Autowired
    private AuthorService authorService;
    @Test
    public void saveAuthorTest(){
        Author author = new Author();
        author.setNickName("Arvin");
        author.setPhone("123123123");
        author.setSignDate(new Date());
        author.setWallet(new Wallet(new BigDecimal(118)));
        authorRepository.save(author);
    }

    @Test
    public void findAuthorTest(){

        //List<Author> authors = authorRepository.findByPhoneAndNickName("123123123", "Arvin");
        List<Author> authors = authorRepository.findBySql("vi");
        System.out.println(JSONArray.toJSONString(authors));
    }
    public void findAuthorForPageTest(){
        Sort sort = Sort.by(Sort.Direction.DESC, "id");
        Pageable pageable = PageRequest.of(1, 5, sort);
        Page<Author> page = authorRepository.findAll(pageable);
        //System.out.println(JSONArray.toJSONString(page));
    }

    @Test
    public void transactionalTest(){
        authorService.updateAuthor();
    }
    @Test
    public void updateAuthor(){
        Author author = authorService.findAuthor(52L);
        author.setPhone("15999999999");

        Wallet wallet = author.getWallet();
        wallet.setBalance(new BigDecimal(288.88));
        author.setWallet(wallet);

        authorService.updateAuthor(author);
    }
    @Test
    public void deleteAuthor(){
        authorService.deleteAuthor(52L);
    }

    public void findWalletTest(){
        Wallet wallet = walletRepository.findById(1L).get();

    }
}
