package com.mongo.springmogodb.repository;

import com.mongo.springmogodb.entity.Author;

public interface CustomAuthorRepo {
    void updateByEmail(String email,String name,String phone);
}
