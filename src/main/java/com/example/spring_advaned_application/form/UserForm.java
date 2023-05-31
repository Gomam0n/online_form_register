package com.example.spring_advaned_application.form;

import com.example.spring_advaned_application.domain.Users;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import org.hibernate.validator.constraints.Length;

public class UserForm {
    /**
     * TODO:
     * 1. Add validation for phone.
     * 2. Check username and email duplication.
     */
    public static final String PHONE_REG = "";
    @NotBlank(message = "Please enter username!")
    private String username;
    @NotBlank
    @Length(min = 6)
    private String password;
    //@Pattern(regexp = "")
    //@NotBlank
    private int phone;
    @Email
    private String email;
    @NotBlank
    private String confirmPassword;

    public UserForm(){

    }

    public String getPassword() {
        return password;
    }

    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
    }

    public int getPhone() {
        return phone;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }

    public Users convertToUser(){
        Users user = new UserFormConvert().convert(this);
        return user;
    }

    public  boolean confirmPassword(){
        if(this.password.equals(this.confirmPassword)){
            return true;
        }
        return false;
    }
}
