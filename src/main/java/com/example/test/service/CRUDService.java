package com.example.test.service;

public interface CRUDService<T, R> {

    T create(T t);

    T update(T t);

    T read(R t, String userId);

    void delete(R r, String userId);
}
