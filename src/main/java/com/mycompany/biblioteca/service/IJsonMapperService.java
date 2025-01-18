package com.mycompany.biblioteca.service;

public interface IJsonMapperService {

    <T> T getData(String json, Class<T> clazz);
}
