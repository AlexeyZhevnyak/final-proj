package com.example.finalproj.model;

import java.util.List;

public interface IDao<T> {
    T get(int id);
    List<T> getAll();
    void save(T t);
    void update(T t);
    void delete(T t);
}
