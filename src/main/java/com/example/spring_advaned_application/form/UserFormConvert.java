package com.example.spring_advaned_application.form;

import com.example.spring_advaned_application.domain.Users;
import org.springframework.beans.BeanUtils;

public class UserFormConvert implements FormConvert<UserForm, Users>{
    public Users convert(UserForm userForm){
        Users user = new Users();
        BeanUtils.copyProperties(userForm, user);
        return user;
    }
}
