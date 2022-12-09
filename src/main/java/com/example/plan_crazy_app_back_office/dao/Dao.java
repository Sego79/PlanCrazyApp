package com.example.plan_crazy_app_back_office.dao;

import java.util.List;
import java.util.Optional;

public interface Dao<T> {
    List<T> findAll();

    Optional<T> findById(Long id);

    void create(T t);

    void update(T t);

    void delete(Long t);
}
