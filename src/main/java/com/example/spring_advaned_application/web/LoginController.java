package com.example.spring_advaned_application.web;

import com.example.spring_advaned_application.domain.UserRepository;
import com.example.spring_advaned_application.domain.Users;
import com.example.spring_advaned_application.form.UserForm;
import com.example.spring_advaned_application.form.UserFormConvert;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import org.apache.catalina.User;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.servlet.http.Cookie;

import jakarta.servlet.http.HttpServletResponse;

@Controller
public class LoginController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/")
    public String index(){
        return "index";
    }

    @GetMapping("/register")
    public String register(Model model){
        model.addAttribute("userForm", new UserForm());
        return "register";
    }
    @GetMapping("/login")
    public String loginPage(){
        return "login";
    }

    @PostMapping("/login")
    public String loginPost(
            @RequestParam String username,
            @RequestParam String password,
            HttpSession session){
        Users user = userRepository.findByUsernameAndPassword(username, password);
        if(user != null){
            System.out.println("login successfully");
            session.setAttribute("user", user);
            return "index";
        }
        System.out.println("login failed");
        return "login";
    }
    @GetMapping("/logout")
    public String logout(HttpSession session){
        session.removeAttribute("user");
        return "login";
    }
    @PostMapping("/register")
    public String registerPost(@Valid UserForm userForm, BindingResult result, Model model){
        if(!userForm.confirmPassword()){
            result.rejectValue("confirmPassword", "confirmError", "Passwords do not equal");
        }
        if(result.hasErrors()){
            return "register";
        }

        Users user = userForm.convertToUser();
        //BeanUtils.copyProperties();
        //user.setEmail(email);
        //user.setPassword(password);
        //user.setPhone(phone);
        //user.setUsername(username);
        userRepository.save(user);
        return "redirect:/login";
    }

    @GetMapping("/exception")
    public String testException() throws Exception {

        throw new Exception("test");
    }




}
