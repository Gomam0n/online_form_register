package com.example.spring_advaned_application.dto;

public interface Convert <S,T>{
    T convert(S s, T t);
    T convert(S s);
}
