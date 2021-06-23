package com.purplecow.security;


//검증여부와 날짜 저장
public interface AuthToken<T> {
    boolean validate();
    T getData();
}