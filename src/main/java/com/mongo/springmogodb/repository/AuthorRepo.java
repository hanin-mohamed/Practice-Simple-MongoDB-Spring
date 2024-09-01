package com.mongo.springmogodb.repository;

import com.mongo.springmogodb.entity.Author;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorRepo extends MongoRepository<Author,String> {

}
