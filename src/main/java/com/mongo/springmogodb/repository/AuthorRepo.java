package com.mongo.springmogodb.repository;

import com.mongo.springmogodb.entity.Author;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorRepo extends MongoRepository<Author,String>{
    @Query(value="{email: ?0}", fields="{'name': 1, 'email': 1}")
    Author findByEmail(String email);
}
