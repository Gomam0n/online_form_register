package com.example.spring_advaned_application.form;

public interface FormConvert <S,T> {
    T convert(S s);
}
