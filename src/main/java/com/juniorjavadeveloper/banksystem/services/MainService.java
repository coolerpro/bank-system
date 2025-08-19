package com.juniorjavadeveloper.banksystem.services;

import java.util.List;
import java.util.UUID;

public interface MainService<T> {

    List<T> findAll();

    T findById(UUID id);

    void save(T elem) throws Exception;

    void delete(UUID id);
}
